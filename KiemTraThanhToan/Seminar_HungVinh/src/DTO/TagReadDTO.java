package DTO;

public class TagReadDTO {
 
    public String TagReadID;
    public String ProductInstanceID;
    public String Time;
    
    public TagReadDTO(String TagReadID, String ProductInstanceID, String Time){
        this.TagReadID = TagReadID;
        this.ProductInstanceID = ProductInstanceID;
        this.Time = Time;
    }

    public TagReadDTO(){
        TagReadID = null;
        ProductInstanceID = null;
        Time = null;
    }
    
    public String getTagReadID() {
        return TagReadID;
    }
    public void setTagReadID(String TagReadID) {
        this.TagReadID = TagReadID;
    }

    public String getProductInstanceID() {
        return ProductInstanceID;
    }
    public void setProductInstanceID(String ProductInstanceID) {
        this.ProductInstanceID = ProductInstanceID;
    }

    public String getTime() {
        return Time;
    }
    public void setTime(String Time) {
        this.Time = Time;
    }
    
}
