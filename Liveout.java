package sample;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

public class Liveout {

    @FXML
    private Button buttonout;

    @FXML
    private Button buttonpast;

    @FXML
    private TextField textnum;
    @FXML
    private Label label;

    @FXML
    private void initialize() throws SQLException {
        Display.display(label);
    }

    @FXML
    void clickout(ActionEvent event) throws SQLException {
        JDBCdemo1.login("sa", "lj000000", "HotelDataBase");
        String num=textnum.getText();
        ResultSet resultSet= JDBCdemo1.select(0,"Rnum","Register","Rnum",num,"0","0");
        if(resultSet.next()){
        JDBCdemo1.delete("Register","Rnum",num);
        JDBCdemo1.delete("Client","Rnum",num);
        JDBCdemo1.update("Rstate","空","Room","Rnum",num);
        Alert alert1=new Alert(Alert.AlertType.INFORMATION);
        alert1.headerTextProperty().set("退房成功");
        alert1.showAndWait();
        Display.display(label);
        }
        else{
            Alert alert2=new Alert(Alert.AlertType.INFORMATION);
            alert2.headerTextProperty().set("退房失败");
            alert2.showAndWait();
            Display.display(label);
        }
        JDBCdemo1.close();
    }

    @FXML
    void clickpast(ActionEvent event) throws IOException {
        Main.stage.setScene(new Scene(FXMLLoader.load(getClass().getResource("Theme.fxml")),800,600));
    }

}
