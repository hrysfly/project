package sample;

import com.sun.javafx.robot.impl.FXRobotHelper;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Login {
    static String ltype="0";
    @FXML
    private AnchorPane login;
    @FXML
    private Button button;
    @FXML
    private TextField text;
    @FXML
    private PasswordField password;
    @FXML
    void login(ActionEvent event) throws SQLException, IOException {


        JDBCdemo1.login("sa","lj000000","HotelDataBase");
        ResultSet resultSet=JDBCdemo1.select(1,"Ltype","Login","Lname",text.getText(),"Lnum",password.getText());
        if(resultSet.next()){
            Alert alert1=new Alert(Alert.AlertType.INFORMATION);
            alert1.headerTextProperty().set("登录成功，你的身份为："+resultSet.getNString("Ltype"));
            ltype= resultSet.getNString("Ltype");
            alert1.showAndWait();
            Main.stage.setScene(new Scene(FXMLLoader.load(getClass().getResource("Theme.fxml")),800,600));
        }else{
            Alert alert2=new Alert(Alert.AlertType.WARNING);
            alert2.headerTextProperty().set("登录失败,请重新登录");
            alert2.showAndWait();

        }

    }

    public void log() throws SQLException, IOException {




    }



}
