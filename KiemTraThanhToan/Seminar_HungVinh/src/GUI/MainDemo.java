package GUI;

import BUS.*;
import DAO.*;
import DTO.*;
import java.util.ArrayList;

public class MainDemo {

    public static void main(String[] args) throws Exception {

        //--- Giao dien ---
//        GUIapp app = new GUIapp();
//        app.mainAPP();

        //--- Console ---
        //Test 1: ket noi co so du lieu
        ProductInstanceBUS prodIns_Bus = new ProductInstanceBUS();
        
        ArrayList<ProductInstanceDTO> prodIns_Arr = prodIns_Bus.getDSSanphamdaydu();
        System.out.println("Test Data Connection: ");
        System.out.println(prodIns_Arr.get(0).getProductInstanceID() 
                + " " + prodIns_Arr.get(0).getProductLineID()
                + " " + prodIns_Arr.get(0).getIsPurchased());

        //Test 2: check query
//        TagReadDAO tagR_Dao = new TagReadDAO();
//        ProductInstanceDAO prodIns_Dao = new ProductInstanceDAO();
//        
//        String test = tagR_Dao.queryPosition("E200 1026 8110 0159 ");
//        int test2 = prodIns_Dao.checkProd("SP46565");
//        System.out.println("Test: " + test2);
        
    }

}
