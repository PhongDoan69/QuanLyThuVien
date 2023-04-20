/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Test;
import com.btl.pojo.CallCard;
import com.btl.pojo.CallCardDetail;
import com.btl.services.AccountServices;
import com.btl.services.CallCardDetailServices;
import com.btl.services.DatSachServices;
import java.math.BigDecimal;
import java.sql.Date;
import java.sql.SQLException;
import java.time.LocalDate;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
/**
 *
 * @author Admin
 */
public class DatSachTest {
    DatSachServices DSSV;

    int acc = 20;
    
    
    @Test
    //Test đặt sách
    public void testDatSach() throws SQLException{
//        datTiecSV = new DatTiecServices();
//        hoaDonSV = new HoaDonServices();
//        DatTiec d = new DatTiec();
//        d.setMaTiec(maTiec);
//        d.setMaKH(2);
//        d.setNgayToChuc(java.sql.Date.valueOf(LocalDate.now()));
//        d.setNgayDat(java.sql.Date.valueOf(LocalDate.now()));
//        d.setSoLuongBan(10);
//        d.setSoLuongKhach(100);
//        d.setTenTiec("Tiệc cưới");
//        d.setMaSanh(1);
//        d.setBuoi("Sáng");
//        int a = datTiecSV.getListDatTiec(null).size();
//        datTiecSV.addDatTiec(d);
//        HoaDon h = new HoaDon();
//        h.setMaTiec(maTiec);
//        hoaDonSV.addHoaDon(h);
//        Assertions.assertEquals(a + 1, datTiecSV.getListDatTiec(null).size());
    }
}
