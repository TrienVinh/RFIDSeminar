package DTO;

public class ReportDTO {
    public String TagReadID;
    public String ProductInstanceID;
    public int TrangThai;
    
    public ReportDTO(String TagReadID, String ProductInstanceID, int TrangThai){
        this.TagReadID = TagReadID;
        this.ProductInstanceID = ProductInstanceID;
        this.TrangThai = TrangThai;
    }
    
    public ReportDTO(){
        TagReadID = null;
        ProductInstanceID = null;
        TrangThai = 0;
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

    public int getTrangThai() {
        return TrangThai;
    }

    public void setTrangThai(int TrangThai) {
        this.TrangThai = TrangThai;
    }
    
}
