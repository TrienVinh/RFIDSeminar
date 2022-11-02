package DAO;

import BUS.TagReadBUS;
import DTO.TagReadDTO;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.swing.JOptionPane;

public class TagReadDAO {
    
    ResultSet rs = null;
    Connection connect = new Connection();
    ArrayList<TagReadDTO> danhsach_tag = null;
    
    public TagReadDAO() {
        connect = new Connection("localhost", "root", "", "seminarv2");       
    }
    
    public ArrayList<TagReadDTO> docDSSP() throws Exception {      
        
        danhsach_tag = new ArrayList<>();
        try {
            String qry = "Select * from tagread"; //Select * from tagread
            rs = connect.excuteQuery(qry);
            while(rs.next())
            {
                TagReadDTO tagR_dto = new TagReadDTO();
                tagR_dto.setTagReadID(rs.getString(1));
                tagR_dto.setProductInstanceID(rs.getString(2));
                tagR_dto.setTime(rs.getString(3));
                danhsach_tag.add(tagR_dto); 
            }
            connect.Close();
            return danhsach_tag;
        }
        catch(SQLException ex) {
            JOptionPane.showMessageDialog(null, "Lỗi đọc thông tin tag !");
        }
        return danhsach_tag;
    }
    
    
    public String queryPosition (String id) throws Exception{
        
        String query = "Select productinstanceid from tagread";
        //String query = "Select productinstanceid from tagread where tagreadid =?";
        //String query = "Select * From tagread Where TagReadID="+id+"";
        rs = connect.excuteQuery(query);
        int i = 0;
        while (rs.next()) {
            TagReadBUS tagR_Bus = new TagReadBUS();
            ArrayList<TagReadDTO> tagR_Arr = tagR_Bus.getDSTagdaydu();
            if(id.equals(tagR_Arr.get(i).getTagReadID())){
                return tagR_Arr.get(i).getProductInstanceID();
            }
            i++;
        }
        connect.Close();
        return null;
    }
    
    public String queryPositionExcel (String id) throws Exception{
        
        String query = "Select tagreadid from tagread";
        rs = connect.excuteQuery(query);
        int i = 0;
        while (rs.next()) {
            TagReadBUS tagR_Bus = new TagReadBUS();
            ArrayList<TagReadDTO> tagR_Arr = tagR_Bus.getDSTagdaydu();
            if( id.equals(tagR_Arr.get(i).getProductInstanceID()) ) {
                return tagR_Arr.get(i).getTagReadID();
            }
            i++;
        }
        connect.Close();
        return null;
    }
}
