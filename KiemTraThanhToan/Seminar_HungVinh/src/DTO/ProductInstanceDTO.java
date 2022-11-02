package DTO;

public class ProductInstanceDTO {
    
    public String ProductInstanceID;
    public String ProductLineID;
    public int IsPurchased;
    
    public ProductInstanceDTO(String ProductInstanceID, String ProductLineID, int IsPurchased){
        this.ProductInstanceID = ProductInstanceID;
        this.ProductLineID = ProductLineID;
        this.IsPurchased = IsPurchased;
    }
    
    public ProductInstanceDTO(){
        ProductInstanceID = null;
        ProductLineID = null;
        IsPurchased = 0;
    }

    public String getProductInstanceID() {
        return ProductInstanceID;
    }
    public void setProductInstanceID(String ProductInstanceID) {
        this.ProductInstanceID = ProductInstanceID;
    }

    public String getProductLineID() {
        return ProductLineID;
    }
    public void setProductLineID(String ProductLineID) {
        this.ProductLineID = ProductLineID;
    }

    public int getIsPurchased() {
        return IsPurchased;
    }
    public void setIsPurchased(int IsPurchased) {
        this.IsPurchased = IsPurchased;
    }
    
}
