package BUS;

import DAO.*;
import DTO.*;
import DTO.*;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import org.apache.poi.ss.usermodel.BorderStyle;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFCellStyle;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExportExcel {

    public static void mainExcel() throws Exception {

        ProductInstanceBUS prodIns_bus = new ProductInstanceBUS();
        TagReadBUS tagR_bus = new TagReadBUS();
        TagReadDAO tagR_Dao = new TagReadDAO();

        LocalDateTime dateTime = LocalDateTime.now();
        DateTimeFormatter myFormatObj = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");

        XSSFWorkbook workbook = new XSSFWorkbook();
        XSSFSheet sheet = workbook.createSheet("Reader Report");
        XSSFCellStyle style = workbook.createCellStyle();
        XSSFRow row = null;
        XSSFRow row_2 = null;
        XSSFCell cell = null;
        row = sheet.createRow(0);

        for (int col = 0; col < 4; col++) {
            sheet.setColumnWidth(col, 25 * 230);
        }
        sheet.setColumnWidth(8, 25 * 200);
        sheet.setColumnWidth(9, 25 * 200);

        style.setBorderTop(BorderStyle.MEDIUM);
        style.setBorderBottom(BorderStyle.MEDIUM);
        style.setBorderLeft(BorderStyle.MEDIUM);
        style.setBorderRight(BorderStyle.MEDIUM);
        
        cell = row.createCell(0);
        cell.setCellValue("Mã Tag");
        cell.setCellStyle(style);
        cell = row.createCell(1);
        cell.setCellValue("Mã ProductInstance");
        cell.setCellStyle(style);
        cell = row.createCell(2);
        cell.setCellValue("Mã ProductLine");
        cell.setCellStyle(style);
        cell = row.createCell(3);
        cell.setCellValue("Trạng thái");
        cell.setCellStyle(style);
        
        cell = row.createCell(7);
        cell.setCellValue("Báo cáo Read Tag");
        cell.setCellStyle(style);
        cell = row.createCell(8);
        cell.setCellValue("Thời gian");
        cell.setCellStyle(style);
        cell = row.createCell(9);
        cell.setCellValue("Người Report");
        cell.setCellStyle(style);

        row_2 = sheet.createRow(1);
        cell = row_2.createCell(8, CellType.STRING);
        cell.setCellValue(dateTime.format(myFormatObj));
        cell.setCellStyle(style);
        cell = row_2.createCell(9, CellType.STRING);
        cell.setCellValue("Quốc Hùng");
        cell.setCellStyle(style);
        
        int x = prodIns_bus.getDSSanphamdaydu().size();

        for (int i = 0; i < x; i++) {
            ProductInstanceDTO dto = prodIns_bus.getDSSanphamdaydu().get(i);
            row = sheet.createRow(2 + i);

            String queryPosTagID;
            queryPosTagID = tagR_Dao.queryPositionExcel(dto.getProductInstanceID());

            cell = row.createCell(0, CellType.STRING);
            cell.setCellValue(queryPosTagID);
            cell.setCellStyle(style);
            
            cell = row.createCell(1, CellType.STRING);
            cell.setCellValue(dto.getProductInstanceID());
            cell.setCellStyle(style);
            
            cell = row.createCell(2, CellType.STRING);
            cell.setCellValue(dto.getProductLineID());
            cell.setCellStyle(style);
            
            cell = row.createCell(3, CellType.STRING);
            if (dto.getIsPurchased() == 1) {
                cell.setCellValue("Đã thanh toán");
            } else if (dto.getIsPurchased() == 0) {
                cell.setCellValue("Chưa thanh toán");
            }
            cell.setCellStyle(style);
        }

        File f = new File("../Seminar_HungVinh/file/ExportReport.xlsx");
        FileOutputStream fos = null;
        try {
            fos = new FileOutputStream(f);
            workbook.write(fos);
            System.out.println("In danh sách nhà cung cấp thành công !");
            fos.close();
        } catch (IOException ex) {
        }
    }
}
