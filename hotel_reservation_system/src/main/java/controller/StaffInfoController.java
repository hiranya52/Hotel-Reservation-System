package controller;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import model.dto.StaffInfoDTO;

import java.net.URL;
import java.util.ResourceBundle;

public class StaffInfoController implements Initializable {

    ObservableList<StaffInfoDTO> staffInfoDTOS = FXCollections.observableArrayList(
            new StaffInfoDTO("S001","Hiranya","Manager","hiranya@gmail.com","0774528910",54000),
            new StaffInfoDTO("S002", "Amaya", "Receptionist", "amaya@gmail.com", "0712345678", 35000),
            new StaffInfoDTO("S003", "Kasun", "Chef", "kasun@gmail.com", "0723456789", 45000),
            new StaffInfoDTO("S004", "Nadeesha", "Housekeeping", "nadeesha@gmail.com", "0709876543", 30000),
            new StaffInfoDTO("S005", "Tharindu", "Security", "tharindu@gmail.com", "0765432198", 32000),
            new StaffInfoDTO("S006", "Dilani", "Waiter", "dilani@gmail.com", "0756781234", 28000)
    );

    @FXML
    private TableColumn<?, ?> colEmail;

    @FXML
    private TableColumn<?, ?> colName;

    @FXML
    private TableColumn<?, ?> colPhoneNo;

    @FXML
    private TableColumn<?, ?> colRole;

    @FXML
    private TableColumn<?, ?> colSalary;

    @FXML
    private TableColumn<?, ?> colStaffID;

    @FXML
    private TableView<StaffInfoDTO> tblStaffInfo;

    @FXML
    private TextField txtEmail;

    @FXML
    private TextField txtName;

    @FXML
    private TextField txtPhoneNo;

    @FXML
    private TextField txtRole;

    @FXML
    private TextField txtSalary;

    @FXML
    private TextField txtStaffID;

    @FXML
    void btnAddOnAction(ActionEvent event) {

    }

    @FXML
    void btnClearOnAction(ActionEvent event) {

    }

    @FXML
    void btnDeleteOnAction(ActionEvent event) {

    }

    @FXML
    void btnUpdateOnAction(ActionEvent event) {

    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

        colStaffID.setCellValueFactory(new PropertyValueFactory<>("id"));
        colName.setCellValueFactory(new PropertyValueFactory<>("name"));
        colRole.setCellValueFactory(new PropertyValueFactory<>("role"));
        colEmail.setCellValueFactory(new PropertyValueFactory<>("email"));
        colPhoneNo.setCellValueFactory(new PropertyValueFactory<>("phoneNo"));
        colSalary.setCellValueFactory(new PropertyValueFactory<>("salary"));

        tblStaffInfo.setItems(staffInfoDTOS);

        tblStaffInfo.getSelectionModel().selectedItemProperty().addListener((observable, oldValue, newValue )-> {
            txtStaffID.setText(newValue.getId());
            txtName.setText(newValue.getName());
            txtRole.setText(newValue.getRole());
            txtEmail.setText(newValue.getEmail());
            txtPhoneNo.setText(newValue.getPhoneNo());
            txtSalary.setText(String.valueOf(newValue.getSalary()));
        });


    }
}
