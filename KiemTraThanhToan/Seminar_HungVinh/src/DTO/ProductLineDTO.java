package DTO;

public class ProductLineDTO {
    
    public String ProductLineID;
    public String Name;
    public double Price;
    public int Stock;
    
    public ProductLineDTO(String ProductLineID, String Name, double Price, int Stock){
        this.ProductLineID = ProductLineID;
        this.Name = Name;
        this.Price = Price;
        this.Stock = Stock;
    }
    
    public ProductLineDTO(){
        ProductLineID = null;
        Name = null;
        Price = 0.0;
        Stock= 0;
    }

    public String getProductLineID() {
        return ProductLineID;
    }
    public void setProductLineID(String ProductLineID) {
        this.ProductLineID = ProductLineID;
    }

    public String getName() {
        return Name;
    }
    public void setName(String Name) {
        this.Name = Name;
    }

    public double getPrice() {
        return Price;
    }
    public void setPrice(double Price) {
        this.Price = Price;
    }

    public int getStock() {
        return Stock;
    }
    public void setStock(int Stock) {
        this.Stock = Stock;
    }
    
}
