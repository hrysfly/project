package sample;

import javafx.beans.property.SimpleSetProperty;
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

public class Formclient {

    @FXML
    private TableView<Formclientmodel> Formclient;

    @FXML
    private TableColumn<Formclientmodel,String> Cid;

    @FXML
    private TableColumn<Formclientmodel,String> Cname;

    @FXML
    private TableColumn<Formclientmodel,String> Rnum;

    @FXML
    private TableColumn<Formclientmodel,String> Rlevel;

    @FXML
    private TableColumn<Formclientmodel,String> Stime;

    @FXML
    private TableColumn<Formclientmodel,String> Etime;

    @FXML
    private TableColumn<Formclientmodel,String> Cost;
    private ObservableList<Formclientmodel>  formclientmodel= FXCollections.observableArrayList();
    @FXML
    private void initialize() throws SQLException {
        Cid.setCellValueFactory(new Callback<TableColumn.CellDataFeatures<Formclientmodel, String>, ObservableValue<String>>() {
            @Override
            public ObservableValue<String> call(TableColumn.CellDataFeatures<Formclientmodel, String> param) {
                SimpleStringProperty cid=new SimpleStringProperty(param.getValue().getCid());
                return cid;
            }
        });
        Cname.setCellValueFactory(new Callback<TableColumn.CellDataFeatures<Formclientmodel, String>, ObservableValue<String>>() {
            @Override
            public ObservableValue<String> call(TableColumn.CellDataFeatures<Formclientmodel, String> param) {
                SimpleStringProperty cname=new SimpleStringProperty(param.getValue().getCname());
                return cname;
            }
        });
        Rnum.setCellValueFactory(new Callback<TableColumn.CellDataFeatures<Formclientmodel, String>, ObservableValue<String>>() {
            @Override
            public ObservableValue<String> call(TableColumn.CellDataFeatures<Formclientmodel, String> param) {
                SimpleStringProperty rnum=new SimpleStringProperty(param.getValue().getRnum());
                return rnum;
            }
        });
        Rlevel.setCellValueFactory(new Callback<TableColumn.CellDataFeatures<Formclientmodel, String>, ObservableValue<String>>() {
            @Override
            public ObservableValue<String> call(TableColumn.CellDataFeatures<Formclientmodel, String> param) {
                SimpleStringProperty rlevel=new SimpleStringProperty(param.getValue().getRlevel());
                return rlevel;
            }
        });
        Stime.setCellValueFactory(new Callback<TableColumn.CellDataFeatures<Formclientmodel, String>, ObservableValue<String>>() {
            @Override
            public ObservableValue<String> call(TableColumn.CellDataFeatures<Formclientmodel, String> param) {
                SimpleStringProperty stime=new SimpleStringProperty(param.getValue().getStime());
                return stime;
            }
        });
        Stime.setCellValueFactory(new Callback<TableColumn.CellDataFeatures<Formclientmodel, String>, ObservableValue<String>>() {
            @Override
            public ObservableValue<String> call(TableColumn.CellDataFeatures<Formclientmodel, String> param) {
                SimpleStringProperty stime=new SimpleStringProperty(param.getValue().getStime());
                return stime;
            }
        });
        Etime.setCellValueFactory(new Callback<TableColumn.CellDataFeatures<Formclientmodel, String>, ObservableValue<String>>() {
            @Override
            public ObservableValue<String> call(TableColumn.CellDataFeatures<Formclientmodel, String> param) {
                SimpleStringProperty etime=new SimpleStringProperty(param.getValue().getEstime());
                return etime;
            }
        });
        Cost.setCellValueFactory(new Callback<TableColumn.CellDataFeatures<Formclientmodel, String>, ObservableValue<String>>() {
            @Override
            public ObservableValue<String> call(TableColumn.CellDataFeatures<Formclientmodel, String> param) {
                SimpleStringProperty cost=new SimpleStringProperty(param.getValue().getCost());
                return cost;
            }
        });
        Formclient.setItems(formclientmodel);

        JDBCdemo1.login("sa","lj000000","HotelDataBase");
        ResultSet resultSet=JDBCdemo1.select(3,"0","Inform","0","0","0","0");
        while (resultSet.next()){

            String cid=resultSet.getString("Cid");
            String cname=resultSet.getString("Cname");
            String rnum=resultSet.getString("Rnum");
            String rlevel=resultSet.getString("Rlevel");
            String stime=resultSet.getString("Stime");
            String etime=resultSet.getString("Etime");
            String cost=resultSet.getString("Cost");
            formclientmodel.add(new Formclientmodel(cid,cname,rnum,rlevel,stime,etime,cost));
        }
        JDBCdemo1.close();
    }
}
