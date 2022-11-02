package Test;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

public class test {
    
    public static void main(String[] args) throws InterruptedException {
        
        Scanner inp = new Scanner(System.in);
        
        //Test thread sleep
//        for(int i = 0; i <= 50; i++){
//            System.out.println(i + " DENF-1482-FJEI-1102");
//            Thread.sleep(1000);
//        }
        

        //Test read tag
//        HashMap<String, Integer> tagMap = new HashMap<>();
//        tagMap.put("00A1 7A14 2C2B 2848", 0); 
//        tagMap.put("00B1 7A14 2C2B 2848", 1);
//        
//        System.out.println("Input tag: ");
//        String idtag = inp.nextLine();
//        for (String key : tagMap.keySet()) {
//            if (idtag.equals(key)) {
//                if (tagMap.get(key) == 0) {
//                    System.out.println(idtag + " Chua thanh toan !");
//                } else if (tagMap.get(key) == 1){
//                    System.out.println(idtag + " Thanh toan roi !");
//                }
//            }else{
//                System.out.println("Khong tim thay tag");
//                break;
//            }
//        }

        //test timestamp
        LocalDateTime dtime = LocalDateTime.now();
        DateTimeFormatter myFormatObj = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        System.out.println("Time: " + dtime.format(myFormatObj));
        
    }
    
}
