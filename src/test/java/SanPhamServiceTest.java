import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class SanPhamServiceTest {
    private SanPhamService service;

    @BeforeEach
    public void setUp() {
        service = new SanPhamService();
    }
    //Ap dung ky thuat bien cho chuc nang them so luong
@Test
public void  them_soluongvoigiatribienla1(){
        SanPham sp = new SanPham("1","SP001","SanPham1", 100.0f,"Do","M",1);
    assertTrue(service.them(sp));
    }
    @Test
    public void  them_soluongvoigiatribienla99(){
        SanPham sp = new SanPham("1","SP001","SanPham1", 100.0f,"Do","M",99);
        assertTrue(service.them(sp));
    }
    @Test
    public void  them_soluongvoigiatribienla0(){
        SanPham sp = new SanPham("1","SP001","SanPham1", 100.0f,"Do","M",0);
        assertThrows(IllegalArgumentException.class,()->service.them(sp));

    }
    @Test
    public void  them_soluongvoigiatribienla100(){
        SanPham sp = new SanPham("1","SP001","SanPham1", 100.0f,"Do","M",100);
        assertThrows(IllegalArgumentException.class,()->service.them(sp));

    }
    // kỹ thuật đoán lỗi cho chức năng "Sửa"
    @Test
    public void sua_MaSanPhamHopLe() {
        SanPham sp = new SanPham("5", "SP005", "Sanpham1", 250.0f, "Nau", "M", 10);
        service.them(sp);
        SanPham spMoi = new SanPham("5", "SP999", "Sanpham2", 260.0f, "Den", "M", 15);
        assertTrue(service.sua("5", spMoi));
    }
    @Test
    public void sua_MaSanPhamkhongdungdinhdang() {
        SanPham sp = new SanPham("5", "SP005", "Sanpham1", 250.0f, "Nau", "M", 10);
        service.them(sp);
        SanPham spMoi = new SanPham("5", "XX999", "Sanpham2", 260.0f, "Den", "M", 15);
        assertThrows(IllegalArgumentException.class,() -> service.sua("5", spMoi));
    }


}

