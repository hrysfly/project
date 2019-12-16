package sample;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.util.Callback;

import java.sql.ResultSet;
import java.sql.SQLException;

public class Formroom {

    @FXML
    private TableView Formroom;

    @FXML
    private TableColumn<Formroommodel,String> Rnum;

    @FXML
    private TableColumn<Formroommodel,String> Rlevel;

    @FXML
    private TableColumn<Formroommodel,String> Rarea;

    @FXML
    private TableColumn<Formroommodel,String> Rprice;

    @FXML
    private TableColumn<Formroommodel,String> Rstate;
    private ObservableList<Formroommodel> formroommodel= FXCollections.observableArrayList();
    @FXML
    private void initialize() throws SQLException {
        Rnum.setCellValueFactory(new Callback<TableColumn.CellDataFeatures<Formroommodel, String>, ObservableValue<String>>() {
            @Override
            public ObservableValue<String> call(TableColumn.CellDataFeatures<Formroommodel, String> param) {
                SimpleStringProperty rnum=new SimpleStringProperty(param.getValue().getRnum());
                return rnum;
            }
        });
        Rlevel.setCellValueFactory(new Callback<TableColumn.CellDataFeatures<Formroommodel, String>, ObservableValue<String>>() {
            @Override
            public ObservableValue<String> call(TableColumn.CellDataFeatures<Formroommodel, String> param) {
                SimpleStringProperty rlevel=new SimpleStringProperty(param.getValue().getRlevel());
                return rlevel;
            }
        });

        Rarea.setCellValueFactory(new Callback<TableColumn.CellDataFeatures<Formroommodel, String>, ObservableValue<String>>() {
            @Override
            public ObservableValue<String> call(TableColumn.CellDataFeatures<Formroommodel, String> param) {
                SimpleStringProperty rarea=new SimpleStringProperty(param.getValue().getRarea());
                return rarea;
            }
        });
        Rprice.setCellValueFactory(new Callback<TableColumn.CellDataFeatures<Formroommodel, String>, ObservableValue<String>>() {
            @Override
            public ObservableValue<String> call(TableColumn.CellDataFeatures<Formroommodel, String> param) {
                SimpleStringProperty rprice=new SimpleStringProperty(param.getValue().getRprice());
                return rprice;
            }
        });
        Rstate.setCellValueFactory(new Callback<TableColumn.CellDataFeatures<Formroommodel, String>, ObservableValue<String>>() {
            @Override
            public ObservableValue<String> call(TableColumn.CellDataFeatures<Formroommodel, String> param) {
                SimpleStringProperty rstate=new SimpleStringProperty(param.getValue().getRstate());
                return rstate;
            }
        });

        Formroom.setItems(formroommodel);

        JDBCdemo1.login("sa","lj000000","HotelDataBase");
        ResultSet resultSet=JDBCdemo1.select(0,"Rnum,Rlevel,Rarea,Rprice,Rstate","Room","Rstate","空","0","0");
        while (resultSet.next()){

            String rnum=resultSet.getString("Rnum");
            String rlevel=resultSet.getString("Rlevel");
            String rarea=resultSet.getString("Rarea");
            String rprice=resultSet.getString("Rprice");
            String rstate=resultSet.getString("Rstate");
            formroommodel.add(new Formroommodel(rnum,rlevel,rarea,rprice,rstate));
        }
        JDBCdemo1.close();
    }
}
