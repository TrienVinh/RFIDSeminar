package DAO;

import BUS.ProductLineBUS;
import DTO.ProductLineDTO;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.swing.JOptionPane;

public class ProductLineDAO {
    
    ResultSet rs = null;
    Connection connect = new Connection();
    ArrayList<ProductLineDTO> danhsach_prod = null;
    
    public ProductLineDAO() {
        connect = new Connection("localhost", "root", "", "seminarv2");       
    }
    
    public ArrayList<ProductLineDTO> docDSSP() throws Exception {      
        
        danhsach_prod = new ArrayList<>();
        try {
            String qry = "Select * from productline"; 
            rs = connect.excuteQuery(qry);
            while(rs.next())
            {
                ProductLineDTO prodL_dto = new ProductLineDTO();
                prodL_dto.setProductLineID(rs.getString(1));
                prodL_dto.setName(rs.getString(2));
                prodL_dto.setPrice(rs.getInt(3));
                prodL_dto.setStock(rs.getInt(4));
                danhsach_prod.add(prodL_dto); 
            }
            connect.Close();
            return danhsach_prod;
        }
        catch(SQLException ex) {
            JOptionPane.showMessageDialog(null, "Lỗi đọc thông tin tag !");
        }
        return danhsach_prod;
    }
    
    public String queryPositionProd (String id) throws Exception{
        
        String query = "Select productlinename from productline";
        rs = connect.excuteQuery(query);
        int i = 0;
        while (rs.next()) {
            ProductLineBUS prodL_Bus = new ProductLineBUS();
            ArrayList<ProductLineDTO> prodL_Arr = prodL_Bus.getDS();
            if(id.equals(prodL_Arr.get(i).getProductLineID())){
                return prodL_Arr.get(i).getName();
            }
            i++;
        }
        connect.Close();
        return null;
    }
    
//    public String queryPositionProd_2 (String id) throws Exception{
//        
//        String query = "Select productlinename from productline";
//        rs = connect.excuteQuery(query);
//        int i = 0;
//        while (rs.next()) {
//            ProductLineBUS prodL_Bus = new ProductLineBUS();
//            ArrayList<ProductLineDTO> prodL_Arr = prodL_Bus.getDS();
//            if(id.equals(prodL_Arr.get(i).getProductLineID())){
//                return prodL_Arr.get(i).getName();
//            }
//            i++;
//        }
//        connect.Close();
//        return null;
//    }
}
