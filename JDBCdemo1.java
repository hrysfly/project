package sample;
import java.sql.*;

public  class JDBCdemo1 {
    public static Connection connection;//定义静态链接
    //登录数据库
    public static void login(String user, String password, String DatabaseName) throws SQLException {
        String url="jdbc:sqlserver://localhost:1433;DatabaseName="+DatabaseName+"";
        connection=DriverManager.getConnection(url,user,password);
    }
    //删除（可以直接传入删除的定位数据）
    public static void delete(String tableName,String locatedName,String locateData) throws SQLException {
        String sql="DELETE FROM "+tableName+" WHERE "+locatedName+"='"+locateData+"'";
        Statement statement=connection.createStatement();
        statement.executeUpdate(sql);
    }
    //查找（可以直接传入查找的数据,judge进行判定，为了方便自己，当judge为1的时候需要两个判定条件，为0时需要一个判定条件，总而言之，如果judge为0，judge后面的数据可以随意输入，如果judge为1，则根据需求进行输入）
    public static ResultSet select(int judge,String selectName, String tableName, String locatedName, String locatedData, String locatedName2, String locatedData2) throws SQLException{
        if (judge==0){
            String sql="SELECT "+selectName+" FROM "+tableName+" WHERE "+locatedName+"='"+locatedData+"'";
            Statement statement=connection.createStatement();
            ResultSet resultSet=statement.executeQuery(sql);
            return resultSet;
        }else if (judge==1){
            String sql="SELECT "+selectName+" FROM "+tableName+" WHERE "+locatedName+"='"+locatedData+"' AND "+locatedName2+"='"+locatedData2+"'";
            Statement statement=connection.createStatement();
            ResultSet resultSet=statement.executeQuery(sql);
            return resultSet;
        }else{
            String sql="SELECT * FROM "+tableName+"";
            Statement statement=connection.createStatement();
            ResultSet resultSet=statement.executeQuery(sql);
            return resultSet;
        }
    }
    //修改（可以直接传入修改的数据）
    public static void update(String updateName,String updateData,String tableName,String locatedName,String locatedData) throws SQLException {
        String sql="UPDATE "+tableName+" SET "+updateName+" ='"+updateData+"' WHERE "+locatedName+" ='"+locatedData+"'";
        Statement statement=connection.createStatement();
        statement.executeUpdate(sql);
    }
    //添加(添加的语句因为需要动态所以直接放在外部，在使用此方法时进行调用)
    public static void add(String sql) throws SQLException {
        Statement statement=connection.createStatement();
        statement.executeUpdate(sql);
    }
    //关闭数据库连接
    public static void close() throws SQLException {
        connection.close();;
    }
}

