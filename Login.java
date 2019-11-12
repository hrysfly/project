package JDBCdemo1;


import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;
public class Login {
    public String login() throws SQLException {
        JDBCdemo1.login("sa","lj000000","HotelDataBase");
        System.out.println("请输入用户名:");
        Scanner sc=new Scanner(System.in);
        String name=sc.next();
        System.out.println("请输入密码:");
        String num=sc.next();
        ResultSet resultSet=JDBCdemo1.select(1,"Ltype","Login","Lname",name,"Lnum",num);
        if(resultSet.next()){
            System.out.println("Login success");
            System.out.println("身份是："+resultSet.getNString("Ltype"));
        }else{
            System.out.println("Login lose");
        }
        return resultSet.getString("Ltype");
    }

}
