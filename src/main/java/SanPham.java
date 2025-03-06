public class SanPham {
    private String id, maSanPham, tenSanPham, mauSac, kichThuoc;
    private float gia;
    private int soLuong;

    public SanPham(String id, String maSanPham, String tenSanPham, float gia, String mauSac, String kichThuoc, int soLuong) {
        this.id = id; this.maSanPham = maSanPham; this.tenSanPham = tenSanPham;
        this.gia = gia; this.mauSac = mauSac; this.kichThuoc = kichThuoc; this.soLuong = soLuong;
    }

    public String getId() { return id; } public String getMaSanPham() { return maSanPham; }
    public void setMaSanPham(String maSanPham) { this.maSanPham = maSanPham; }
    public int getSoLuong() { return soLuong; } public void setSoLuong(int soLuong) { this.soLuong = soLuong; }
}
