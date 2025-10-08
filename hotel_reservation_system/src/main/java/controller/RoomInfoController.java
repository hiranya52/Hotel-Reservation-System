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
import model.dto.RoomInfoDTO;

import java.net.URL;
import java.util.ResourceBundle;

public class RoomInfoController implements Initializable {

    ObservableList<RoomInfoDTO> roomInfoDTOS = FXCollections.observableArrayList(
            new RoomInfoDTO("R001", "Single Bedroom", "Cozy room for one person.", 5000),
            new RoomInfoDTO("R002", "Double Bedroom", "Comfortable room for two guests.", 7500),
            new RoomInfoDTO("R003", "Deluxe Room", "Spacious room with balcony view.", 9500),
            new RoomInfoDTO("R004", "Family Suite", "Large suite for families.", 12000)
    );

    @FXML
    private TableColumn<?, ?> colDescription;

    @FXML
    private TableColumn<?, ?> colPrice;

    @FXML
    private TableColumn<?, ?> colRoomID;

    @FXML
    private TableColumn<?, ?> colType;

    @FXML
    private TableView<RoomInfoDTO> tblRoomInfo;

    @FXML
    private TextField txtDescription;

    @FXML
    private TextField txtPrice;

    @FXML
    private TextField txtRoomID;

    @FXML
    private TextField txtType;

    @FXML
    void btnAddOnAction(ActionEvent event) {
        String roomId = txtRoomID.getText();
        String type = txtType.getText();
        String description = txtDescription.getText();
        double price = Double.parseDouble(txtPrice.getText());

        RoomInfoDTO roomInfoDTO = new RoomInfoDTO(roomId,type,description,price);

        roomInfoDTOS.add(roomInfoDTO);
        tblRoomInfo.refresh();

        txtRoomID.setText("");
        txtType.setText("");
        txtDescription.setText("");
        txtPrice.setText("");

    }

    @FXML
    void btnClearOnAction(ActionEvent event) {
        txtRoomID.setText("");
        txtType.setText("");
        txtDescription.setText("");
        txtPrice.setText("");
    }

    @FXML
    void btnDeleteOnAction(ActionEvent event) {
        RoomInfoDTO selectedRoom = tblRoomInfo.getSelectionModel().getSelectedItem();
        if (selectedRoom != null){
            roomInfoDTOS.remove(selectedRoom);
            tblRoomInfo.refresh();
        }
    }

    @FXML
    void btnUpdateOnAction(ActionEvent event) {

    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        colRoomID.setCellValueFactory(new PropertyValueFactory<>("id"));
        colType.setCellValueFactory(new PropertyValueFactory<>("type"));
        colDescription.setCellValueFactory(new PropertyValueFactory<>("description"));
        colPrice.setCellValueFactory(new PropertyValueFactory<>("price"));

        tblRoomInfo.setItems(roomInfoDTOS);

        tblRoomInfo.getSelectionModel().selectedItemProperty().addListener((observable ,oldValue , newValue ) -> {
            if (newValue != null){
                txtRoomID.setText(newValue.getId());
                txtType.setText(newValue.getType());
                txtDescription.setText(newValue.getDescription());
                txtPrice.setText(String.valueOf(newValue.getPrice()));
            }
        });
    }
}
