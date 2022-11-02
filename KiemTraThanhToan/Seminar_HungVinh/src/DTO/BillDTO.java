package DTO;

public class BillDTO {
    
    public String BillID;
    public String Date;
    public double Total;
    
    public BillDTO(String BillID, String Date, double Total){
        this.BillID = BillID;
        this.Date = Date;
        this.Total = Total;
    }
    
    public BillDTO(){
        BillID = null;
        Date = null;
        Total = 0.0;
    }

    public String getBillID() {
        return BillID;
    }
    public void setBillID(String BillID) {
        this.BillID = BillID;
    }

    public String getDate() {
        return Date;
    }
    public void setDate(String Date) {
        this.Date = Date;
    }

    public double getTotal() {
        return Total;
    }
    public void setTotal(double Total) {
        this.Total = Total;
    }
    
    
}
