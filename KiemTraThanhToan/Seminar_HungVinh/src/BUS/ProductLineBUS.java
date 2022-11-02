package BUS;
import DAO.ProductLineDAO;
import DTO.ProductLineDTO;
import java.util.ArrayList;

public class ProductLineBUS {
    public static ArrayList<ProductLineDTO> dsdaydu;
    public static ArrayList<ProductLineDTO> ds_sp;
    
    public ProductLineBUS(){}
    
    public ArrayList<ProductLineDTO> getDS() {
        if( dsdaydu == null){
            dsdaydu = new ArrayList<>();
        }
        try{
            ProductLineDAO prodL_dao = new ProductLineDAO();
            dsdaydu = prodL_dao.docDSSP();
        }catch(Exception e){ }
        
        return dsdaydu;
    }
}
