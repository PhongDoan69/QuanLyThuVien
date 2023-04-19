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
import java.time.LocalDateTime;

/**
 *
 * @author Admin
 */
public class DatSachTest {

    DatSachServices DSSV;

    int acc = 16;

//    @Test
//    //Test đặt sách
//    public void testDatSach() throws SQLException {
//        DSSV = new DatSachServices();
//        CallCard cc = new CallCard();
//        cc.setCallCardId(5);
//
//        Date currentDate = new Date(System.currentTimeMillis());
//        LocalDate localDate = currentDate.toLocalDate().plusMonths(6);
//        Date next6MonthDate = Date.valueOf(localDate);
//        cc.setDateGetBook(currentDate);
//        cc.setReturnDate(next6MonthDate);
//        cc.setEmployeeId(1);
//        cc.setReaderId(3);
//
//        int a = DSSV.getListCallCard(acc).size();
//        DSSV.addCallCard(cc);
//
//        Assertions.assertNotNull( DSSV.getListCallCard(acc));
//    }
    
}
