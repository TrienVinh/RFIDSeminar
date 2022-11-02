package DTO;

public class BillDetailsDTO {
    
    public String BillID;
    public String ProductInstanceID;
    
    public BillDetailsDTO(String BillID, String ProductInstanceID){
        this.BillID = BillID;
        this.ProductInstanceID = ProductInstanceID;
    }
    
    public BillDetailsDTO(){
        BillID = null;
        ProductInstanceID = null;
    }

    public String getBillID() {
        return BillID;
    }
    public void setBillID(String BillID) {
        this.BillID = BillID;
    }

    public String getProductInstanceID() {
        return ProductInstanceID;
    }
    public void setProductInstanceID(String ProductInstanceID) {
        this.ProductInstanceID = ProductInstanceID;
    }
    
}
