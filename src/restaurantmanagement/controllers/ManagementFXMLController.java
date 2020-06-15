/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package restaurantmanagement.controllers;

import com.gn.GNAvatarView;
import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXComboBox;
import com.jfoenix.controls.JFXDatePicker;
import com.jfoenix.controls.JFXListView;
import com.jfoenix.controls.JFXTextField;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.text.Text;

/**
 * FXML Controller class
 *
 * @author toshiba
 */
public class ManagementFXMLController implements Initializable {

    @FXML
    private AnchorPane dashboard;
    @FXML
    private JFXButton dashboardBtn;
    @FXML
    private JFXButton dailySalesBtn;
    @FXML
    private JFXButton employeesBtn;
    @FXML
    private JFXButton stockItemsBtn;
    @FXML
    private JFXButton todayStockBtn;
    @FXML
    private JFXButton totalSalesBtn;
    @FXML
    private JFXButton settingsBtn;
    @FXML
    private AnchorPane dashboardPane;
    @FXML
    private JFXListView<?> leaderList;
    @FXML
    private JFXListView<?> view;
    @FXML
    private AnchorPane settingsPane;
    @FXML
    private TextField OldPasswordTxtF;
    @FXML
    private TextField NewPasswordTxtF;
    @FXML
    private TextField ConfirmPasswordTxtF;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    


    @FXML
    private void changePanes(ActionEvent event) {
    }

    @FXML
    private void logOut(ActionEvent event) {
    }

    @FXML
    private void saveAction(ActionEvent event) {
    }
    
}
