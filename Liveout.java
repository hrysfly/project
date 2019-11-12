package JDBCdemo1;

import java.sql.SQLException;
import java.util.Scanner;

public class Liveout {
    public Liveout liveout() throws SQLException {
        JDBCdemo1.login("sa", "lj000000", "HotelDataBase");
        Scanner sc=new Scanner(System.in);
        System.out.println("请输入房间号");
        String rnum=sc.next();
        JDBCdemo1.delete("Register","Rnum",rnum);
        JDBCdemo1.delete("Client","Rnum",rnum);
        JDBCdemo1.update("Rstate","空","Room","Rnum",rnum);
        System.out.println("退房成功！");
        JDBCdemo1.close();
        return null;
    }
}
