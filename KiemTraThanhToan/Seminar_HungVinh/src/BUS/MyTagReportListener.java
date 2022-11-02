package BUS;

import DTO.*;
import DAO.*;
import BUS.*;
import GUI.GUIapp;
import static GUI.GUIapp.arrRep;
import static GUI.GUIapp.tb1Model;
import static GUI.GUIapp.tb2Model;
import com.impinj.octane.ImpinjReader;
import com.impinj.octane.Tag;
import com.impinj.octane.TagReport;
import com.impinj.octane.TagReportListener;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Scanner;
import java.util.Set;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFrame;

public class MyTagReportListener implements TagReportListener {

    Scanner inp = new Scanner(System.in);
    public static ArrayList<ReportDTO> list = new ArrayList<>();
    public HashMap<String, ReportDTO> mapArr = new HashMap<>();
    public static String portNumber;
    
    public MyTagReportListener() {
        GUIapp app = new GUIapp();
        app.setVisible(true);
        app.setLocationRelativeTo(null);
        app.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    @Override
    public void onTagReported(ImpinjReader reader, TagReport tagR) {

        //Lay thoi gian thuc
        LocalDateTime dateTime = LocalDateTime.now();
        DateTimeFormatter myFormatObj = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        
        TagReadDAO tagR_Dao = new TagReadDAO();
        ProductInstanceDAO prodIns_Dao = new ProductInstanceDAO();
        List<Tag> tags = tagR.getTags();
        
        //Chay dong for de quet
        for (Tag t : tags) {
            String idSPIns;
            try {
                idSPIns = tagR_Dao.queryPosition(t.getEpc().toString());
                if (idSPIns != null) {
                    int checkPur = prodIns_Dao.checkProd(idSPIns);
                    ReportDTO rp = new ReportDTO();
                    rp.setTagReadID(t.getEpc().toString());
                    rp.setProductInstanceID(idSPIns);
                    rp.setTrangThai(checkPur);
                    arrRep.add(rp);
                } else {
                    System.out.println("Khong tim thay id tag");
                }
            } catch (Exception ex) {
                System.out.println("Loi Exception !");
                Logger.getLogger(MyTagReportListener.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        //Output console
        System.out.println("Arr Rep: " + arrRep.get(0).getTagReadID());
        System.out.println("map size: " + mapArr.size());
        System.out.println("Antenna Port Number: " + String.valueOf(tags.get(0).getAntennaPortNumber()));
        
        
        //hien thi len giao dien
        for (ReportDTO dto : arrRep) {
            if (!mapArr.containsKey(dto.getTagReadID())) {
                mapArr.put(dto.getTagReadID(), dto);
                
                switch (dto.getTrangThai()) {
                    case 1:
                        tb1Model.addRow(new Object[]{
                            dto.getTagReadID(),
                            dto.getProductInstanceID(),
                            dateTime.format(myFormatObj),
                            String.valueOf(tags.get(0).getAntennaPortNumber()),
                            "Đã thanh toán"
                        });
                        GUIapp.jTable1.setModel(tb1Model);
                        break;
                        
                    case 0:
                        tb2Model.addRow(new Object[]{
                            dto.getTagReadID(), 
                            dto.getProductInstanceID(), 
                            dateTime.format(myFormatObj), 
                            String.valueOf(tags.get(0).getAntennaPortNumber()),
                            "Chưa thanh toán"
                            //mapArr.get(i).getTrangThai()
                        });
                        GUIapp.jTable2.setModel(tb2Model);
                        break;
                        
                    default:
                        System.out.println("Không tìm thấy tag !");
                        break;
                }
            }
        }
    }
}
