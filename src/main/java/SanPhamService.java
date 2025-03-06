import java.util.*;

public class SanPhamService {
    private List<SanPham> danhSach = new ArrayList<>();

    public boolean them(SanPham sp) {
        if (sp.getSoLuong() <= 0 || sp.getSoLuong() >= 100) throw new IllegalArgumentException("Số lượng 1-99");
        return danhSach.add(sp);
    }

    public boolean sua(String id, SanPham spMoi) {
        for (SanPham sp : danhSach) {
            if (sp.getId().equals(id)) {
                if (!spMoi.getMaSanPham().startsWith("SP")) throw new IllegalArgumentException("Mã phải bắt đầu 'SP'");
                if (danhSach.stream().anyMatch(p -> p.getMaSanPham().equals(spMoi.getMaSanPham()) && !p.getId().equals(id)))
                    throw new IllegalArgumentException("Mã sản phẩm trùng");
                sp.setMaSanPham(spMoi.getMaSanPham()); sp.setSoLuong(spMoi.getSoLuong());
                return true;
            }
        }
        return false;
    }

    public boolean xoa(String id) { return danhSach.removeIf(sp -> sp.getId().equals(id)); }
}
