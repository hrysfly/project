package sample;


import javafx.scene.control.Label;

import java.sql.ResultSet;
import java.sql.SQLException;

public  class Display {
    protected static void  display(Label label) throws SQLException {
        JDBCdemo1.login("sa","lj000000","HotelDataBase");
        ResultSet resultSet1=JDBCdemo1.select(0,"Rstate","Room","Rstate","占","0","0");
        int num1=0;
        while (resultSet1.next()){
            num1=num1+1;
        }
        ResultSet resultSet2=JDBCdemo1.select(0,"Rstate","Room","Rstate","空","0","0");
        int num2=0;
        while (resultSet2.next()){
            num2=num2+1;
        }
        label.setText("当前房间已使用："+num1+" 间，空余: "+num2+" 间");
        JDBCdemo1.close();
    }
}
