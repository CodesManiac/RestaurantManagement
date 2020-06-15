/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package restaurantmanagement.controllers;

import com.gn.GNAvatarView;
import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXPasswordField;
import com.jfoenix.controls.JFXTextArea;
import com.jfoenix.controls.JFXTextField;
import de.jensd.fx.glyphs.fontawesome.FontAwesomeIconView;
import de.jensd.fx.glyphs.materialdesignicons.MaterialDesignIconView;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.animation.FadeTransition;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.geometry.Rectangle2D;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.StackPane;
import javafx.scene.text.Text;
import javafx.stage.Screen;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import javafx.util.Duration;

/**
 * FXML Controller class
 *
 * @author toshiba
 */
public class FoodController implements Initializable {

    @FXML
    private AnchorPane dashboard;
    @FXML
    private AnchorPane othersPane;
    @FXML
    private Text maleEmployeeText;
    @FXML
    private Text femaleEmployeeText;
    @FXML
    private Text totalEmployeeText;
    @FXML
    private AnchorPane intercontinentalPane;
    @FXML
    private Text maleEmployeeText1;
    @FXML
    private Text femaleEmployeeText1;
    @FXML
    private Text totalDayStock;
    @FXML
    private AnchorPane africanDishPane;
    @FXML
    private Text totalNumDrinks;
    @FXML
    private Text totalNumFood;
    @FXML
    private Text totalNumStock;
    @FXML
    private AnchorPane drinksPane;
    @FXML
    private Text totalNumDrinks1;
    @FXML
    private Text totalNumFood1;
    @FXML
    private Text totalNumStock1;
    @FXML
    private AnchorPane sandwichesPane;
    @FXML
    private Text totalNumDrinks11;
    @FXML
    private Text totalNumFood11;
    @FXML
    private Text totalNumStock11;
    @FXML
    private AnchorPane settingsPane;
    @FXML
    private TextField OldPasswordTxtF;
    @FXML
    private TextField NewPasswordTxtF;
    @FXML
    private TextField ConfirmPasswordTxtF;
    @FXML
    private JFXButton dashboardBtn;
    @FXML
    private MaterialDesignIconView dashBoardIcon;
    @FXML
    private JFXButton sandwichesBtn;
    @FXML
    private MaterialDesignIconView sandwichesIcon;
    @FXML
    private JFXButton africanDishBtn;
    @FXML
    private FontAwesomeIconView africanDishIcon;
    @FXML
    private JFXButton drinksBtn;
    @FXML
    private FontAwesomeIconView drinksIcon;
    @FXML
    private JFXButton intercontinentalBtn;
    @FXML
    private MaterialDesignIconView intercontinentalcon;
    @FXML
    private JFXButton othersBtn;
    @FXML
    private JFXButton settingsBtn;
    @FXML
    private MaterialDesignIconView settingsIcon;
    @FXML
    private AnchorPane dashboardPane;
    @FXML
    private MaterialDesignIconView othersIcon;
    @FXML
    private AnchorPane ordersPane;
    @FXML
    private JFXButton removeItems;
    @FXML
    private JFXButton checkOut;
    @FXML
    private GNAvatarView orderedImage;
    @FXML
    private JFXButton removeItem;
    @FXML
    private JFXButton continueShop;
    @FXML
    private TableView<?> ordersTable;
    @FXML
    private TableColumn<?, ?> tOrderID;
    @FXML
    private TableColumn<?, ?> tItemOrderedName;
    @FXML
    private TableColumn<?, ?> tItemOrderedPrice;
    @FXML
    private TableColumn<?, ?> tItemOrderedQuantity;
    @FXML
    private TableColumn<?, ?> tItemOrderedAmount;
    @FXML
    private StackPane receiptModal;
    @FXML
    private JFXTextField receiptCash;
    @FXML
    private JFXTextField receiptCost;
    @FXML
    private JFXPasswordField receiptBalance;
    @FXML
    private JFXTextField receiptSalesAttendant;
    @FXML
    private JFXTextArea billTextArea;
    @FXML
    private JFXTextField cakeQuantity;
    @FXML
    private Text cakePrice;
    @FXML
    private Text cakeName;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }

    @FXML
    private void saveAction(ActionEvent event) {
    }

    @FXML
    private void openDashBoard(ActionEvent event) {
        if (africanDishBtn.getStyleClass().size() == 2 && africanDishIcon.getStyleClass().size() == 2) {

        } else if (africanDishBtn.getStyleClass().size() == 3 && africanDishIcon.getStyleClass().size() == 3) {
            africanDishBtn.getStyleClass().remove(2);
            africanDishIcon.getStyleClass().remove(2);
        }
        if (sandwichesBtn.getStyleClass().size() == 2 && sandwichesIcon.getStyleClass().size() == 2) {

        } else if (sandwichesBtn.getStyleClass().size() == 3 && sandwichesIcon.getStyleClass().size() == 3) {
            sandwichesBtn.getStyleClass().remove(2);
            sandwichesIcon.getStyleClass().remove(2);
        }
        if (intercontinentalBtn.getStyleClass().size() == 2 && intercontinentalcon.getStyleClass().size() == 2) {

        } else if (intercontinentalBtn.getStyleClass().size() == 3 && intercontinentalcon.getStyleClass().size() == 3) {
            intercontinentalBtn.getStyleClass().remove(2);
            intercontinentalcon.getStyleClass().remove(2);
        }
        if (drinksBtn.getStyleClass().size() == 2 && drinksIcon.getStyleClass().size() == 2) {

        } else if (drinksBtn.getStyleClass().size() == 3 && drinksIcon.getStyleClass().size() == 3) {
            drinksBtn.getStyleClass().remove(2);
            drinksIcon.getStyleClass().remove(2);
        }
        if (othersBtn.getStyleClass().size() == 2 && othersIcon.getStyleClass().size() == 2) {

        } else if (othersBtn.getStyleClass().size() == 3 && othersIcon.getStyleClass().size() == 3) {
            othersBtn.getStyleClass().remove(2);
            othersIcon.getStyleClass().remove(2);
        }
        if (settingsBtn.getStyleClass().size() == 2 && settingsIcon.getStyleClass().size() == 2) {

        } else if (settingsBtn.getStyleClass().size() == 3 && settingsIcon.getStyleClass().size() == 3) {
            settingsBtn.getStyleClass().remove(2);
            settingsIcon.getStyleClass().remove(2);
        }
        if (dashboardBtn.getStyleClass().toString().contains("active") && dashBoardIcon.getStyleClass().toString().contains("iconActive")) {

        } else {
            dashboardBtn.getStyleClass().add("active");
            dashBoardIcon.getStyleClass().add("iconActive");
            dashboardPane.setVisible(true);
            FadeTransition fade = new FadeTransition();
            fade.setDuration(Duration.millis(300));
            fade.setNode(dashboardPane);
            fade.setFromValue(0);
            fade.setToValue(1);
            fade.play();
        }

        africanDishPane.setVisible(false);
        sandwichesPane.setVisible(false);
        intercontinentalPane.setVisible(false);
        drinksPane.setVisible(false);
        othersPane.setVisible(false);
        settingsPane.setVisible(false);

    }

    @FXML
    private void openSandwichesPane(ActionEvent event) {
        if (africanDishBtn.getStyleClass().size() == 2 && africanDishIcon.getStyleClass().size() == 2) {

        } else if (africanDishBtn.getStyleClass().size() == 3 && africanDishIcon.getStyleClass().size() == 3) {
            africanDishBtn.getStyleClass().remove(2);
            africanDishIcon.getStyleClass().remove(2);
        }
        if (dashboardBtn.getStyleClass().size() == 2 && dashBoardIcon.getStyleClass().size() == 2) {

        } else if (dashboardBtn.getStyleClass().size() == 3 && dashBoardIcon.getStyleClass().size() == 3) {
            dashboardBtn.getStyleClass().remove(2);
            dashBoardIcon.getStyleClass().remove(2);
        }
        if (intercontinentalBtn.getStyleClass().size() == 2 && intercontinentalcon.getStyleClass().size() == 2) {

        } else if (intercontinentalBtn.getStyleClass().size() == 3 && intercontinentalcon.getStyleClass().size() == 3) {
            intercontinentalBtn.getStyleClass().remove(2);
            intercontinentalcon.getStyleClass().remove(2);
        }
        if (drinksBtn.getStyleClass().size() == 2 && drinksIcon.getStyleClass().size() == 2) {

        } else if (drinksBtn.getStyleClass().size() == 3 && drinksIcon.getStyleClass().size() == 3) {
            drinksBtn.getStyleClass().remove(2);
            drinksIcon.getStyleClass().remove(2);
        }
        if (othersBtn.getStyleClass().size() == 2 && othersIcon.getStyleClass().size() == 2) {

        } else if (othersBtn.getStyleClass().size() == 3 && othersIcon.getStyleClass().size() == 3) {
            othersBtn.getStyleClass().remove(2);
            othersIcon.getStyleClass().remove(2);
        }
        if (settingsBtn.getStyleClass().size() == 2 && settingsIcon.getStyleClass().size() == 2) {

        } else if (settingsBtn.getStyleClass().size() == 3 && settingsIcon.getStyleClass().size() == 3) {
            settingsBtn.getStyleClass().remove(2);
            settingsIcon.getStyleClass().remove(2);
        }
        if (sandwichesBtn.getStyleClass().toString().contains("active") && sandwichesIcon.getStyleClass().toString().contains("iconActive")) {

        } else {
            sandwichesBtn.getStyleClass().add("active");
            sandwichesIcon.getStyleClass().add("iconActive");
            sandwichesPane.setVisible(true);
            FadeTransition fade = new FadeTransition();
            fade.setDuration(Duration.millis(300));
            fade.setNode(sandwichesPane);
            fade.setFromValue(0);
            fade.setToValue(1);
            fade.play();
        }

        africanDishPane.setVisible(false);
        dashboardPane.setVisible(false);
        intercontinentalPane.setVisible(false);
        drinksPane.setVisible(false);
        othersPane.setVisible(false);
        settingsPane.setVisible(false);
    }

    @FXML
    private void openAfricanDishPane(ActionEvent event) {
        if (dashboardBtn.getStyleClass().size() == 2 && dashBoardIcon.getStyleClass().size() == 2) {

        } else if (dashboardBtn.getStyleClass().size() == 3 && dashBoardIcon.getStyleClass().size() == 3) {
            dashboardBtn.getStyleClass().remove(2);
            dashBoardIcon.getStyleClass().remove(2);
        }
        if (sandwichesBtn.getStyleClass().size() == 2 && sandwichesIcon.getStyleClass().size() == 2) {

        } else if (sandwichesBtn.getStyleClass().size() == 3 && sandwichesIcon.getStyleClass().size() == 3) {
            sandwichesBtn.getStyleClass().remove(2);
            sandwichesIcon.getStyleClass().remove(2);
        }
        if (intercontinentalBtn.getStyleClass().size() == 2 && intercontinentalcon.getStyleClass().size() == 2) {

        } else if (intercontinentalBtn.getStyleClass().size() == 3 && intercontinentalcon.getStyleClass().size() == 3) {
            intercontinentalBtn.getStyleClass().remove(2);
            intercontinentalcon.getStyleClass().remove(2);
        }
        if (drinksBtn.getStyleClass().size() == 2 && drinksIcon.getStyleClass().size() == 2) {

        } else if (drinksBtn.getStyleClass().size() == 3 && drinksIcon.getStyleClass().size() == 3) {
            drinksBtn.getStyleClass().remove(2);
            drinksIcon.getStyleClass().remove(2);
        }
        if (othersBtn.getStyleClass().size() == 2 && othersIcon.getStyleClass().size() == 2) {

        } else if (othersBtn.getStyleClass().size() == 3 && othersIcon.getStyleClass().size() == 3) {
            othersBtn.getStyleClass().remove(2);
            othersIcon.getStyleClass().remove(2);
        }
        if (settingsBtn.getStyleClass().size() == 2 && settingsIcon.getStyleClass().size() == 2) {

        } else if (settingsBtn.getStyleClass().size() == 3 && settingsIcon.getStyleClass().size() == 3) {
            settingsBtn.getStyleClass().remove(2);
            settingsIcon.getStyleClass().remove(2);
        }
        if (africanDishBtn.getStyleClass().toString().contains("active") && africanDishIcon.getStyleClass().toString().contains("iconActive")) {

        } else {
            africanDishBtn.getStyleClass().add("active");
            africanDishIcon.getStyleClass().add("iconActive");
            africanDishPane.setVisible(true);
            FadeTransition fade = new FadeTransition();
            fade.setDuration(Duration.millis(300));
            fade.setNode(africanDishPane);
            fade.setFromValue(0);
            fade.setToValue(1);
            fade.play();
        }

        dashboardPane.setVisible(false);
        sandwichesPane.setVisible(false);
        intercontinentalPane.setVisible(false);
        drinksPane.setVisible(false);
        othersPane.setVisible(false);
        settingsPane.setVisible(false);
    }

    @FXML
    private void openDrinksPane(ActionEvent event) {
        if (africanDishBtn.getStyleClass().size() == 2 && africanDishIcon.getStyleClass().size() == 2) {

        } else if (africanDishBtn.getStyleClass().size() == 3 && africanDishIcon.getStyleClass().size() == 3) {
            africanDishBtn.getStyleClass().remove(2);
            africanDishIcon.getStyleClass().remove(2);
        }
        if (sandwichesBtn.getStyleClass().size() == 2 && sandwichesIcon.getStyleClass().size() == 2) {

        } else if (sandwichesBtn.getStyleClass().size() == 3 && sandwichesIcon.getStyleClass().size() == 3) {
            sandwichesBtn.getStyleClass().remove(2);
            sandwichesIcon.getStyleClass().remove(2);
        }
        if (intercontinentalBtn.getStyleClass().size() == 2 && intercontinentalcon.getStyleClass().size() == 2) {

        } else if (intercontinentalBtn.getStyleClass().size() == 3 && intercontinentalcon.getStyleClass().size() == 3) {
            intercontinentalBtn.getStyleClass().remove(2);
            intercontinentalcon.getStyleClass().remove(2);
        }
        if (dashboardBtn.getStyleClass().size() == 2 && dashBoardIcon.getStyleClass().size() == 2) {

        } else if (dashboardBtn.getStyleClass().size() == 3 && dashBoardIcon.getStyleClass().size() == 3) {
            dashboardBtn.getStyleClass().remove(2);
            dashBoardIcon.getStyleClass().remove(2);
        }
        if (othersBtn.getStyleClass().size() == 2 && othersIcon.getStyleClass().size() == 2) {

        } else if (othersBtn.getStyleClass().size() == 3 && othersIcon.getStyleClass().size() == 3) {
            othersBtn.getStyleClass().remove(2);
            othersIcon.getStyleClass().remove(2);
        }
        if (settingsBtn.getStyleClass().size() == 2 && settingsIcon.getStyleClass().size() == 2) {

        } else if (settingsBtn.getStyleClass().size() == 3 && settingsIcon.getStyleClass().size() == 3) {
            settingsBtn.getStyleClass().remove(2);
            settingsIcon.getStyleClass().remove(2);
        }
        if (drinksBtn.getStyleClass().toString().contains("active") && drinksIcon.getStyleClass().toString().contains("iconActive")) {

        } else {
            drinksBtn.getStyleClass().add("active");
            drinksIcon.getStyleClass().add("iconActive");
            drinksPane.setVisible(true);
            FadeTransition fade = new FadeTransition();
            fade.setDuration(Duration.millis(300));
            fade.setNode(drinksPane);
            fade.setFromValue(0);
            fade.setToValue(1);
            fade.play();
        }

        africanDishPane.setVisible(false);
        sandwichesPane.setVisible(false);
        intercontinentalPane.setVisible(false);
        dashboardPane.setVisible(false);
        othersPane.setVisible(false);
        settingsPane.setVisible(false);
    }

    @FXML
    private void openIntercontinentalPane(ActionEvent event) {
        if (africanDishBtn.getStyleClass().size() == 2 && africanDishIcon.getStyleClass().size() == 2) {

        } else if (africanDishBtn.getStyleClass().size() == 3 && africanDishIcon.getStyleClass().size() == 3) {
            africanDishBtn.getStyleClass().remove(2);
            africanDishIcon.getStyleClass().remove(2);
        }
        if (sandwichesBtn.getStyleClass().size() == 2 && sandwichesIcon.getStyleClass().size() == 2) {

        } else if (sandwichesBtn.getStyleClass().size() == 3 && sandwichesIcon.getStyleClass().size() == 3) {
            sandwichesBtn.getStyleClass().remove(2);
            sandwichesIcon.getStyleClass().remove(2);
        }
        if (dashboardBtn.getStyleClass().size() == 2 && dashBoardIcon.getStyleClass().size() == 2) {

        } else if (dashboardBtn.getStyleClass().size() == 3 && dashBoardIcon.getStyleClass().size() == 3) {
            dashboardBtn.getStyleClass().remove(2);
            dashBoardIcon.getStyleClass().remove(2);
        }
        if (drinksBtn.getStyleClass().size() == 2 && drinksIcon.getStyleClass().size() == 2) {

        } else if (drinksBtn.getStyleClass().size() == 3 && drinksIcon.getStyleClass().size() == 3) {
            drinksBtn.getStyleClass().remove(2);
            drinksIcon.getStyleClass().remove(2);
        }
        if (othersBtn.getStyleClass().size() == 2 && othersIcon.getStyleClass().size() == 2) {

        } else if (othersBtn.getStyleClass().size() == 3 && othersIcon.getStyleClass().size() == 3) {
            othersBtn.getStyleClass().remove(2);
            othersIcon.getStyleClass().remove(2);
        }
        if (settingsBtn.getStyleClass().size() == 2 && settingsIcon.getStyleClass().size() == 2) {

        } else if (settingsBtn.getStyleClass().size() == 3 && settingsIcon.getStyleClass().size() == 3) {
            settingsBtn.getStyleClass().remove(2);
            settingsIcon.getStyleClass().remove(2);
        }
        if (intercontinentalBtn.getStyleClass().toString().contains("active") && intercontinentalcon.getStyleClass().toString().contains("iconActive")) {

        } else {
            intercontinentalBtn.getStyleClass().add("active");
            intercontinentalcon.getStyleClass().add("iconActive");
            intercontinentalPane.setVisible(true);
            FadeTransition fade = new FadeTransition();
            fade.setDuration(Duration.millis(300));
            fade.setNode(intercontinentalPane);
            fade.setFromValue(0);
            fade.setToValue(1);
            fade.play();
        }

        africanDishPane.setVisible(false);
        sandwichesPane.setVisible(false);
        dashboardPane.setVisible(false);
        drinksPane.setVisible(false);
        othersPane.setVisible(false);
        settingsPane.setVisible(false);
    }

    @FXML
    private void openOthersPane(ActionEvent event) {
        if (africanDishBtn.getStyleClass().size() == 2 && africanDishIcon.getStyleClass().size() == 2) {

        } else if (africanDishBtn.getStyleClass().size() == 3 && africanDishIcon.getStyleClass().size() == 3) {
            africanDishBtn.getStyleClass().remove(2);
            africanDishIcon.getStyleClass().remove(2);
        }
        if (sandwichesBtn.getStyleClass().size() == 2 && sandwichesIcon.getStyleClass().size() == 2) {

        } else if (sandwichesBtn.getStyleClass().size() == 3 && sandwichesIcon.getStyleClass().size() == 3) {
            sandwichesBtn.getStyleClass().remove(2);
            sandwichesIcon.getStyleClass().remove(2);
        }
        if (intercontinentalBtn.getStyleClass().size() == 2 && intercontinentalcon.getStyleClass().size() == 2) {

        } else if (intercontinentalBtn.getStyleClass().size() == 3 && intercontinentalcon.getStyleClass().size() == 3) {
            intercontinentalBtn.getStyleClass().remove(2);
            intercontinentalcon.getStyleClass().remove(2);
        }
        if (drinksBtn.getStyleClass().size() == 2 && drinksIcon.getStyleClass().size() == 2) {

        } else if (drinksBtn.getStyleClass().size() == 3 && drinksIcon.getStyleClass().size() == 3) {
            drinksBtn.getStyleClass().remove(2);
            drinksIcon.getStyleClass().remove(2);
        }
        if (dashboardBtn.getStyleClass().size() == 2 && dashBoardIcon.getStyleClass().size() == 2) {

        } else if (dashboardBtn.getStyleClass().size() == 3 && dashBoardIcon.getStyleClass().size() == 3) {
            dashboardBtn.getStyleClass().remove(2);
            dashBoardIcon.getStyleClass().remove(2);
        }
        if (settingsBtn.getStyleClass().size() == 2 && settingsIcon.getStyleClass().size() == 2) {

        } else if (settingsBtn.getStyleClass().size() == 3 && settingsIcon.getStyleClass().size() == 3) {
            settingsBtn.getStyleClass().remove(2);
            settingsIcon.getStyleClass().remove(2);
        }
        if (othersBtn.getStyleClass().toString().contains("active") && othersIcon.getStyleClass().toString().contains("iconActive")) {

        } else {
            othersBtn.getStyleClass().add("active");
            othersIcon.getStyleClass().add("iconActive");
            othersPane.setVisible(true);
            FadeTransition fade = new FadeTransition();
            fade.setDuration(Duration.millis(300));
            fade.setNode(othersPane);
            fade.setFromValue(0);
            fade.setToValue(1);
            fade.play();
        }

        africanDishPane.setVisible(false);
        sandwichesPane.setVisible(false);
        intercontinentalPane.setVisible(false);
        drinksPane.setVisible(false);
        dashboardPane.setVisible(false);
        settingsPane.setVisible(false);
    }

    @FXML
    private void openSettingsPane(ActionEvent event) {
        if (africanDishBtn.getStyleClass().size() == 2 && africanDishIcon.getStyleClass().size() == 2) {

        } else if (africanDishBtn.getStyleClass().size() == 3 && africanDishIcon.getStyleClass().size() == 3) {
            africanDishBtn.getStyleClass().remove(2);
            africanDishIcon.getStyleClass().remove(2);
        }
        if (sandwichesBtn.getStyleClass().size() == 2 && sandwichesIcon.getStyleClass().size() == 2) {

        } else if (sandwichesBtn.getStyleClass().size() == 3 && sandwichesIcon.getStyleClass().size() == 3) {
            sandwichesBtn.getStyleClass().remove(2);
            sandwichesIcon.getStyleClass().remove(2);
        }
        if (intercontinentalBtn.getStyleClass().size() == 2 && intercontinentalcon.getStyleClass().size() == 2) {

        } else if (intercontinentalBtn.getStyleClass().size() == 3 && intercontinentalcon.getStyleClass().size() == 3) {
            intercontinentalBtn.getStyleClass().remove(2);
            intercontinentalcon.getStyleClass().remove(2);
        }
        if (drinksBtn.getStyleClass().size() == 2 && drinksIcon.getStyleClass().size() == 2) {

        } else if (drinksBtn.getStyleClass().size() == 3 && drinksIcon.getStyleClass().size() == 3) {
            drinksBtn.getStyleClass().remove(2);
            drinksIcon.getStyleClass().remove(2);
        }
        if (othersBtn.getStyleClass().size() == 2 && othersIcon.getStyleClass().size() == 2) {

        } else if (othersBtn.getStyleClass().size() == 3 && othersIcon.getStyleClass().size() == 3) {
            othersBtn.getStyleClass().remove(2);
            othersIcon.getStyleClass().remove(2);
        }
        if (dashboardBtn.getStyleClass().size() == 2 && dashBoardIcon.getStyleClass().size() == 2) {

        } else if (dashboardBtn.getStyleClass().size() == 3 && dashBoardIcon.getStyleClass().size() == 3) {
            dashboardBtn.getStyleClass().remove(2);
            dashBoardIcon.getStyleClass().remove(2);
        }
        if (settingsBtn.getStyleClass().toString().contains("active") && settingsIcon.getStyleClass().toString().contains("iconActive")) {

        } else {
            settingsBtn.getStyleClass().add("active");
            settingsIcon.getStyleClass().add("iconActive");
            settingsPane.setVisible(true);
            FadeTransition fade = new FadeTransition();
            fade.setDuration(Duration.millis(300));
            fade.setNode(settingsPane);
            fade.setFromValue(0);
            fade.setToValue(1);
            fade.play();
        }

        africanDishPane.setVisible(false);
        sandwichesPane.setVisible(false);
        intercontinentalPane.setVisible(false);
        drinksPane.setVisible(false);
        othersPane.setVisible(false);
        dashboardPane.setVisible(false);
    }

    @FXML
    private void logOut(ActionEvent event) throws IOException {
        ((Stage) dashboard.getScene().getWindow()).close();
        Parent parent = FXMLLoader.load(getClass().getResource("/restaurantmanagement/fxml/Login.fxml"));

        Scene scene = new Scene(parent);
        scene.setFill(javafx.scene.paint.Color.TRANSPARENT);
        Stage stage = new Stage(StageStyle.TRANSPARENT);
        stage.initOwner(((Stage) dashboard.getScene().getWindow()));
        stage.setScene(scene);
        stage.show();
        Rectangle2D primScreenBounds = Screen.getPrimary().getVisualBounds();
        stage.setX((primScreenBounds.getWidth() - stage.getWidth()) / 2);
        stage.setY((primScreenBounds.getHeight() - stage.getHeight()) / 2);
    }

    @FXML
    private void removeAllOrderedItems(ActionEvent event) {
        ordersTable.getItems().clear();
//        obs.removeAll(obs);

    }

    @FXML
    private void proceedToCheckOut(ActionEvent event) {
        receiptModal.setVisible(true);
        FadeTransition fade = new FadeTransition();
        fade.setDuration(Duration.millis(300));
        fade.setNode(receiptModal);
        fade.setFromValue(0);
        fade.setToValue(1);
        fade.play();
    }

    @FXML
    private void removeOrderedItem(ActionEvent event) {
//        DefaultTableModel model = (DefaultTableModel) cartTable.getModel();
//        model.removeRow(cartTable.getSelectedRow());
    }

    @FXML
    private void continueShopping(ActionEvent event) {
    }

    @FXML
    private void exitReceiptModal(MouseEvent event) {
        FadeTransition fade = new FadeTransition();
        fade.setDuration(Duration.millis(300));
        fade.setNode(receiptModal);
        fade.setFromValue(1);
        fade.setToValue(0);
        fade.play();
        fade.setOnFinished((ActionEvent events) -> {
            receiptModal.setVisible(false);
        });
    }

    @FXML
    private void printCustomerReceipt(ActionEvent event) {
    }

    @FXML
    private void calculateSale(ActionEvent event) {
    }

    @FXML
    private void orderCake(ActionEvent event) {
        ObservableList gendrs = FXCollections.observableArrayList(
               1,cakeName.getText(),cakePrice.getText(),cakeQuantity.getText(), "Female");
        ordersTable.setItems(gendrs);
//        double amount = Double.valueOf(strawberryMilkShakePrice.getText()) * Double.valueOf(strawberryMilkShakeQuantity.getSelectedItem().toString());
//        DefaultTableModel model = (DefaultTableModel) cartTable.getModel();
//        model.addRow(new Object[]{strawberryMilkshakeName.getText(), strawberryMilkShakePrice.getText(), strawberryMilkShakeQuantity.getSelectedItem(),
//            amount});
        openOrdersPane();
    }
    public void openOrdersPane(){
        if (africanDishBtn.getStyleClass().size() == 2 && africanDishIcon.getStyleClass().size() == 2) {

        } else if (africanDishBtn.getStyleClass().size() == 3 && africanDishIcon.getStyleClass().size() == 3) {
            africanDishBtn.getStyleClass().remove(2);
            africanDishIcon.getStyleClass().remove(2);
        }
        if (sandwichesBtn.getStyleClass().size() == 2 && sandwichesIcon.getStyleClass().size() == 2) {

        } else if (sandwichesBtn.getStyleClass().size() == 3 && sandwichesIcon.getStyleClass().size() == 3) {
            sandwichesBtn.getStyleClass().remove(2);
            sandwichesIcon.getStyleClass().remove(2);
        }
        if (intercontinentalBtn.getStyleClass().size() == 2 && intercontinentalcon.getStyleClass().size() == 2) {

        } else if (intercontinentalBtn.getStyleClass().size() == 3 && intercontinentalcon.getStyleClass().size() == 3) {
            intercontinentalBtn.getStyleClass().remove(2);
            intercontinentalcon.getStyleClass().remove(2);
        }
        if (drinksBtn.getStyleClass().size() == 2 && drinksIcon.getStyleClass().size() == 2) {

        } else if (drinksBtn.getStyleClass().size() == 3 && drinksIcon.getStyleClass().size() == 3) {
            drinksBtn.getStyleClass().remove(2);
            drinksIcon.getStyleClass().remove(2);
        }
        if (othersBtn.getStyleClass().size() == 2 && othersIcon.getStyleClass().size() == 2) {

        } else if (othersBtn.getStyleClass().size() == 3 && othersIcon.getStyleClass().size() == 3) {
            othersBtn.getStyleClass().remove(2);
            othersIcon.getStyleClass().remove(2);
        }
        if (dashboardBtn.getStyleClass().size() == 2 && dashBoardIcon.getStyleClass().size() == 2) {

        } else if (dashboardBtn.getStyleClass().size() == 3 && dashBoardIcon.getStyleClass().size() == 3) {
            dashboardBtn.getStyleClass().remove(2);
            dashBoardIcon.getStyleClass().remove(2);
        }else

        
            ordersPane.setVisible(true);
            FadeTransition fade = new FadeTransition();
            fade.setDuration(Duration.millis(300));
            fade.setNode(ordersPane);
            fade.setFromValue(0);
            fade.setToValue(1);
            fade.play();
        

        africanDishPane.setVisible(false);
        sandwichesPane.setVisible(false);
        intercontinentalPane.setVisible(false);
        drinksPane.setVisible(false);
        othersPane.setVisible(false);
        dashboardPane.setVisible(false);
        settingsPane.setVisible(false);
        ordersPane.setVisible(true);
        
    }

}
