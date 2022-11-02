package DAO;

import BUS.*;
import DTO.*;
import DTO.*;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.swing.JOptionPane;

public class ProductInstanceDAO {
    
    ResultSet rs = null;
    Connection connect = new Connection();
    ArrayList<ProductInstanceDTO> danhsach_sp = null;
    
    public ProductInstanceDAO() {
        connect = new Connection("localhost", "root", "", "seminarv2");       
    }
    
    public ArrayList<ProductInstanceDTO> docDSSP() throws Exception {      
        
        danhsach_sp = new ArrayList<>();
        try {
            String qry = "Select * from productinstance";
            rs = connect.excuteQuery(qry);
            while(rs.next())
            {
                ProductInstanceDTO prodIns_dto = new ProductInstanceDTO();
                prodIns_dto.setProductInstanceID(rs.getString(1));
                prodIns_dto.setProductLineID(rs.getString(2));
                prodIns_dto.setIsPurchased(rs.getInt(3));
                danhsach_sp.add(prodIns_dto); 
            }
            connect.Close();
            //JOptionPane.showMessageDialog(null,"Đọc dữ liệu thành công!");
            return danhsach_sp;
        }
        catch(SQLException ex)
        {
            JOptionPane.showMessageDialog(null, "Lỗi đọc thông tin sản phẩm");
        }
        return danhsach_sp;
    }
    
    public int checkProd (String prodIns_id) throws Exception{
        
        //String query = "Select ispurchased from productinstance where productinstanceid = tagread.productinstanceid";
        //String query = "Select ispurchased from productinstance where productinstanceid="+prodIns_id+"";
        String query = "SELECT IsPurchased "
                + "FROM productinstance "
                + "WHERE productinstance.ProductInstanceID='"+prodIns_id+"'";
        rs = connect.excuteQuery(query);
        int i = 0;
        
        ProductInstanceBUS prodIns_Bus = new ProductInstanceBUS();
        ArrayList<ProductInstanceDTO> prodIns_Arr = prodIns_Bus.getDSSanphamdaydu();
        
        while (i <= prodIns_Arr.size()) {
            String prodID = prodIns_Arr.get(i).getProductInstanceID();
            //prodIns_Arr.get(i).getIsPurchased();
            if(prodIns_id.equals(prodID)){
                return prodIns_Arr.get(i).getIsPurchased();
            }
            //continue;
            i++;
        }
        connect.Close();
        return -1;
    }
}
