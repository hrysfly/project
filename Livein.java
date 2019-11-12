package JDBCdemo1;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Scanner;

public class Livein {
    public Livein livein() throws SQLException {
        JDBCdemo1.login("sa", "lj000000", "HotelDataBase");

        Date date = new Date();

        Scanner sc = new Scanner(System.in);
        System.out.println("请输入身份证号码：");
        String cid = sc.next();
        System.out.println("请输入客户名字：");
        String cname = sc.next();
        System.out.println("请输入房间号：");
        String rnum = sc.next();
        System.out.println("请输入入住天数：");
        String day = sc.next();
        ResultSet resultSetrnum=JDBCdemo1.select(0,"Rnum","Client","Rnum",rnum,"0","0");
        ResultSet resultSetcid=JDBCdemo1.select(0,"Cid","Client","Cid",cid,"0","0");
        if(resultSetcid.next()||resultSetrnum.next()){
            System.out.println("身份证号已存在或该房间被使用，请重新输入");
            return livein();
        }else{
            SimpleDateFormat bartDateFormat = new SimpleDateFormat("yyyy-MM-dd");
            String stime = bartDateFormat.format(date);
            Calendar calendar = Calendar.getInstance();
            calendar.add(Calendar.DATE, Integer.parseInt(day));
            String etime = bartDateFormat.format(calendar.getTime());
            JDBCdemo1.add("insert into Client values('"+cid+"','"+cname+"','"+rnum+"','"+stime+"','"+etime+"')");
            ResultSet resultSet1=JDBCdemo1.select(0,"Rlevel,Rprice","Room","Rnum",rnum,"0","0");
            resultSet1.next();
            String rlevel=resultSet1.getString("Rlevel");
            String rprice = resultSet1.getString("Rprice");
            int result=Integer.parseInt(rprice.trim())*Integer.parseInt(day);
            String cost=result+"";
            JDBCdemo1.add("INSERT INTO Register VAlUES('"+cid+"','"+rnum+"','"+cname+"','"+rlevel+"','"+day+"', '"+cost+"')");

            JDBCdemo1.update("Rstate","占","Room","Rnum",rnum);
            System.out.println(cname+"欢迎入住，您"+day+"天的住宿费为："+cost+"元");
            JDBCdemo1.close();
        }
        return null;
    }
}
