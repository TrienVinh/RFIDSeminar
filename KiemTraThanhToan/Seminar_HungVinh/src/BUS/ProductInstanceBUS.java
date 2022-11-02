package BUS;

import DAO.ProductInstanceDAO;
import DTO.ProductInstanceDTO;
import java.util.ArrayList;

public class ProductInstanceBUS {
    
    public static ArrayList<ProductInstanceDTO> danhsachdaydu;
    public static ArrayList<ProductInstanceDTO> danhsach_sp;
    
    public ProductInstanceBUS(){}
    
    public ArrayList<ProductInstanceDTO> getDSSanphamdaydu() {
        if( danhsachdaydu == null){
            danhsachdaydu = new ArrayList<>();
        }
        try{
            ProductInstanceDAO prodIns_dao = new ProductInstanceDAO();
            danhsachdaydu = prodIns_dao.docDSSP();
        }catch(Exception e){ }
        
        return danhsachdaydu;
    }
    
//    public ArrayList<ProductInstanceDTO> getDSSanPham(int idSP)
//    {
//        if( danhsach_sp == null){
//            danhsach_sp = new ArrayList<>();
//        }
//        try{
//            ProductInstanceDAO prodIns_dao = new ProductInstanceDAO();
//            danhsach_sp = prodIns_dao.docDSSP(idSP);
//        }catch(Exception e){
//            e.printStackTrace();
//        }
//        return danhsach_sp;
//    }
    
}