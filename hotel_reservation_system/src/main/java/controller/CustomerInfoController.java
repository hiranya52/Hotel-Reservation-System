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
import model.dto.CustomerInfoDTO;

import java.awt.*;
import java.net.URL;
import java.util.ResourceBundle;

public class CustomerInfoController implements Initializable {

    ObservableList<CustomerInfoDTO> customerInfoDTOS = FXCollections.observableArrayList(
            new CustomerInfoDTO("C001","Kamal",20,"0774937615","Panadura"),
            new CustomerInfoDTO("C002", "Nimal", 25, "0712345678", "Colombo"),
            new CustomerInfoDTO("C003", "Saman", 30, "0723456789", "Galle"),
            new CustomerInfoDTO("C004", "Amal", 28, "0709876543", "Kandy"),
            new CustomerInfoDTO("C005", "Sunil", 22, "0756789123", "Negombo")
    );

    @FXML
    private TableColumn<?, ?> colAge;

    @FXML
    private TableColumn<?, ?> colCity;

    @FXML
    private TableColumn<?, ?> colCusID;

    @FXML
    private TableColumn<?, ?> colName;

    @FXML
    private TableColumn<?, ?> colPhoneNo;

    @FXML
    private TableView<CustomerInfoDTO> tblCustomerInfo;

    @FXML
    private TextField txtAge;

    @FXML
    private TextField txtCity;

    @FXML
    private TextField txtCustomerID;

    @FXML
    private TextField txtName;

    @FXML
    private TextField txtPhoneNo;

    @FXML
    void btnAddOnAction(ActionEvent event) {

        String customerID = txtCustomerID.getText();
        String name = txtName.getText();
        int age = Integer.parseInt(txtAge.getText());
        String phoneNo = txtPhoneNo.getText();
        String city = txtCity.getText();

        CustomerInfoDTO customerInfoDTO = new CustomerInfoDTO(customerID,name,age,phoneNo,city);

        customerInfoDTOS.add(customerInfoDTO);
        tblCustomerInfo.refresh();

        txtCustomerID.setText("");
        txtName.setText("");
        txtAge.setText("");
        txtPhoneNo.setText("");
        txtCity.setText("");

    }

    @FXML
    void btnClearOnAction(ActionEvent event) {

        txtCustomerID.setText("");
        txtName.setText("");
        txtAge.setText("");
        txtPhoneNo.setText("");
        txtCity.setText("");

    }

    @FXML
    void btnDeleteOnAction(ActionEvent event) {

        CustomerInfoDTO selectedCustomer = tblCustomerInfo.getSelectionModel().getSelectedItem();

        if(selectedCustomer != null){
            customerInfoDTOS.remove(selectedCustomer);
            tblCustomerInfo.refresh();
        }

        txtCustomerID.setText("");
        txtName.setText("");
        txtAge.setText("");
        txtPhoneNo.setText("");
        txtCity.setText("");

    }

    @FXML
    void btnUpdateOnAction(ActionEvent event) {

        CustomerInfoDTO selectedCustomer = tblCustomerInfo.getSelectionModel().getSelectedItem();

        selectedCustomer.setId(txtCustomerID.getText());
        selectedCustomer.setName(txtName.getText());
        selectedCustomer.setAge(Integer.parseInt(txtAge.getText()));
        selectedCustomer.setPhoneNo(txtPhoneNo.getText());
        selectedCustomer.setCity(txtCity.getText());

        tblCustomerInfo.refresh();

        txtCustomerID.setText("");
        txtName.setText("");
        txtAge.setText("");
        txtPhoneNo.setText("");
        txtCity.setText("");

    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

        colCusID.setCellValueFactory(new PropertyValueFactory<>("id"));
        colName.setCellValueFactory(new PropertyValueFactory<>("name"));
        colAge.setCellValueFactory(new PropertyValueFactory<>("age"));
        colPhoneNo.setCellValueFactory(new PropertyValueFactory<>("phoneNo"));
        colCity.setCellValueFactory(new PropertyValueFactory<>("city"));

        tblCustomerInfo.setItems(customerInfoDTOS);


        tblCustomerInfo.getSelectionModel().selectedItemProperty().addListener((observable, oldValue, newValue) ->{
            txtCustomerID.setText(newValue.getId());
            txtName.setText(newValue.getName());
            txtAge.setText(String.valueOf(newValue.getAge()));
            txtPhoneNo.setText(newValue.getPhoneNo());
            txtCity.setText(newValue.getCity());
        });
    }
}
