package BUS;

import DAO.TagReadDAO;
import DTO.TagReadDTO;
import java.util.ArrayList;

public class TagReadBUS {
    
    public static ArrayList<TagReadDTO> danhsachdaydu;
    public static ArrayList<TagReadDTO> danhsach_sp;
    
    public TagReadBUS(){}
    
    public ArrayList<TagReadDTO> getDSTagdaydu()
    {
        if( danhsachdaydu == null){
            danhsachdaydu = new ArrayList<>();
        }
        try{
            TagReadDAO tagR_Dao = new TagReadDAO();
            danhsachdaydu = tagR_Dao.docDSSP();
        }catch(Exception e){ }
        
        return danhsachdaydu;
    }
    
}
