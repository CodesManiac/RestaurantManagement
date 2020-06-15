/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package restaurantmanagement.controllers;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXPasswordField;
import com.jfoenix.controls.JFXProgressBar;
import com.jfoenix.controls.JFXTextField;
import de.jensd.fx.glyphs.octicons.OctIconView;
import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.animation.FadeTransition;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.geometry.Pos;
import javafx.geometry.Rectangle2D;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import javafx.stage.Screen;
import javafx.stage.Stage;
import javafx.util.Duration;
import javax.swing.JOptionPane;
import org.controlsfx.control.Notifications;
import restaurantmanagement.RestaurantManagement;

/**
 * FXML Controller class
 *
 * @author toshiba
 */
public class LoginController implements Initializable {

    String currentDate;
    String currentTime;

    public Image errorImg = new Image("/restaurantmanagement/images/cross.png");

    @FXML
    private JFXTextField username;
    @FXML
    private JFXPasswordField password;
    @FXML
    private JFXButton loginBtn;
    @FXML
    private JFXProgressBar progress;
    @FXML
    private AnchorPane adminPassword;
    @FXML
    private AnchorPane generatePassword;
    @FXML
    private AnchorPane loginPane;
    @FXML
    private Pane confirmExitPane;
    @FXML
    private AnchorPane forgotPasswordPane;
    @FXML
    private StackPane forgotPassword;
    @FXML
    private Pane loginPage;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        currentDate();
    }

    @FXML
    private void signIn(ActionEvent event) {
        next();
    }

    @FXML
    private void forgotPassword(ActionEvent event) {
        FadeTransition fade = new FadeTransition();
        fade.setDuration(Duration.millis(500));
        fade.setNode(forgotPassword);
        fade.setFromValue(0);
        fade.setToValue(1);
        fade.play();
        fade.setOnFinished((ActionEvent event1) -> {
            forgotPassword.setVisible(true);
            forgotPasswordPane.setVisible(true);
        });
    }

    @FXML
    private void exit_pass(ActionEvent event) {
        FadeTransition fade3 = new FadeTransition();
        fade3.setDuration(Duration.millis(500));
        fade3.setNode(forgotPassword);
        fade3.setFromValue(1);
        fade3.setToValue(0);
        fade3.play();
        fade3.setOnFinished((ActionEvent event1) -> {
            forgotPassword.setVisible(false);
        });
    }

    @FXML
    private void exitLogin(MouseEvent event) {
        confirmExitPane.setVisible(true);
        FadeTransition fade = new FadeTransition();
        fade.setDuration(Duration.millis(500));
        fade.setNode(confirmExitPane);
        fade.setFromValue(0);
        fade.setToValue(1);
        fade.play();
    }

    @FXML
    private void minimiseLogin(MouseEvent event) {
        Stage stage = (Stage) loginPane.getScene().getWindow();
        stage = (Stage) ((OctIconView) event.getSource()).getScene().getWindow();
        stage.setIconified(true);
    }

    @FXML
    private void resetPassword(ActionEvent event) {
    }

    @FXML
    private void forgotPasswordSubmitBtn(ActionEvent event) {
        generatePassword.setVisible(true);
        FadeTransition fade = new FadeTransition();
        fade.setDuration(Duration.millis(500));
        fade.setNode(generatePassword);
        fade.setFromValue(0);
        fade.setToValue(1);
        fade.play();
    }

    @FXML
    private void backToLoginPage(ActionEvent event) {
        FadeTransition fade = new FadeTransition();
        fade.setDuration(Duration.millis(500));
        fade.setNode(forgotPassword);
        fade.setFromValue(1);
        fade.setToValue(0);
        fade.play();
        fade.setOnFinished((ActionEvent event1) -> {
            forgotPassword.setVisible(false);
        });
    }

    @FXML
    private void exitYesAction(ActionEvent event) {
        System.exit(0);
    }

    @FXML
    private void exitNoAction(ActionEvent event) {
        FadeTransition fade3 = new FadeTransition();
        fade3.setDuration(Duration.millis(500));
        fade3.setNode(confirmExitPane);
        fade3.setFromValue(1);
        fade3.setToValue(0);
        fade3.play();
        fade3.setOnFinished((ActionEvent event1) -> {
            confirmExitPane.setVisible(false);
        });
    }

    @FXML
    private void backToLogin(MouseEvent event) {
        FadeTransition fade = new FadeTransition();
        fade.setDuration(Duration.millis(500));
        fade.setNode(forgotPasswordPane);
//        fade.setFromValue(1);
//        fade.setToValue(0);
        fade.play();
        fade.setOnFinished((ActionEvent event1) -> {
            forgotPasswordPane.setVisible(false);
            forgotPassword.setVisible(false);

        });
    }

    public void currentDate() {
        Date date = new Date();
        SimpleDateFormat dd = new SimpleDateFormat("dd/MM/YYYY");
        SimpleDateFormat ddd = new SimpleDateFormat("HH:mm");
        currentDate = dd.format(date);
        currentTime = ddd.format(date);
        System.out.println(currentDate);
        System.out.println(currentTime);
    }

    public void next() {
        String userName = username.getText();
        String passWord = password.getText();
        String adminU = "Joy";
        String adminP = "goodies";
        String salesU = "Jessy";
        String salesP = "greatness";
//        if (!userName.equals(adminU) && passWord.equals(adminP)) {
//            try {
//                Parent parent = FXMLLoader.load(getClass().getResource("/restaurantmanagement/fxml/Management.fxml"));
//
//                Image image = new Image(getClass().getResourceAsStream("/restaurantmanagement/images/Restaurant_96px.png"));
//                Stage stage = new Stage();
//                stage.setTitle("Admin | Amula Hut" + " " + currentDate + " " + currentTime);
//                stage.getIcons().add(0, image);
//
//                stage.setScene(new Scene(parent));
//                stage.initOwner(((Stage) loginPane.getScene().getWindow()));
//                stage.setMinWidth(1150);
//                stage.setMinHeight(600);
//                stage.setMaximized(true);
//                stage.show();
//                stage.centerOnScreen();
//                Rectangle2D primScreenBounds = Screen.getPrimary().getVisualBounds();
//                stage.setX((primScreenBounds.getWidth() - stage.getWidth()) / 2);
//                stage.setY((primScreenBounds.getHeight() - stage.getHeight()) / 2);
//            } catch (IOException ex) {
//                Logger.getLogger(LoginController.class.getName()).log(Level.SEVERE, null, ex);
//            }
//        } else if (userName.equals(salesU) && passWord.equals(salesP)) {
//            try {
//                Parent parent = FXMLLoader.load(getClass().getResource("/restaurantmanagement/fxml/Food.fxml"));
//
//                Image image = new Image(getClass().getResourceAsStream("/restaurantmanagement/images/Restaurant_96px.png"));
//                Stage stage = new Stage();
//                stage.setTitle("SalesAttendant | Amula Hut" + " " + currentDate + " " + currentTime);
//                stage.getIcons().add(0, image);
//
//                stage.setScene(new Scene(parent));
//                stage.initOwner(((Stage) loginPane.getScene().getWindow()));
//                stage.setMinWidth(1150);
//                stage.setMinHeight(600);
//                stage.setMaximized(true);
//                stage.show();
//                stage.centerOnScreen();
//                Rectangle2D primScreenBounds = Screen.getPrimary().getVisualBounds();
//                stage.setX((primScreenBounds.getWidth() - stage.getWidth()) / 2);
//                stage.setY((primScreenBounds.getHeight() - stage.getHeight()) / 2);
//            } catch (IOException ex) {
//                Logger.getLogger(LoginController.class.getName()).log(Level.SEVERE, null, ex);
//            }
//        } else {
//            System.out.println("Wrong Username or password");
//            Notifications notify = Notifications.create()
//                    .graphic(new ImageView(errorImg))
//                    .hideAfter(Duration.seconds(5))
//                    .title("Error")
//                    .text("Wrong Username or Password")
//                    .position(Pos.TOP_CENTER);
//            notify.show();
//        }
//        if (!username.getText().equals("") && !password.getText().equals("")) {
//            String query = "select * from Users where userName=? and Password=?";
//            String url = "jdbc:sqlite:RestaurantDB.db";
//            Connection connection;
//            try {
//                connection = DriverManager.getConnection(url);
//                PreparedStatement preparedStatement = connection.prepareStatement(query);
//                //Parameters
//                preparedStatement.setString(1, userName);
//                preparedStatement.setString(2, passWord);
//                //Execute
//                ResultSet resultSet = preparedStatement.executeQuery();
//
//                if (resultSet.next()) {
//                    //You dont need to find userName & passWord, are already exists
//                    String position = resultSet.getString("designation");
//                    switch (position) {
//                        case "Administrator":
//
//                            String user = userName;
////                        String pass = passwordF;
//                            try {
//                                Parent parent = FXMLLoader.load(getClass().getResource("/restaurantmanagement/fxml/Management.fxml"));
//
//                                Image image = new Image(getClass().getResourceAsStream("/restaurantmanagement/images/Restaurant_96px.png"));
//                                Stage stage = new Stage();
//                                stage.setTitle("Admin | Amula Hut" + " " + currentDate + " " + currentTime);
//                                stage.getIcons().add(0, image);
//
//                                stage.setScene(new Scene(parent));
//                                stage.initOwner(((Stage) loginPane.getScene().getWindow()));
//                                stage.setMinWidth(1150);
//                                stage.setMinHeight(600);
//                                stage.setMaximized(true);
//                                stage.show();
//                                stage.centerOnScreen();
//                                Rectangle2D primScreenBounds = Screen.getPrimary().getVisualBounds();
//                                stage.setX((primScreenBounds.getWidth() - stage.getWidth()) / 2);
//                                stage.setY((primScreenBounds.getHeight() - stage.getHeight()) / 2);
//                            } catch (IOException ex) {
//                                Logger.getLogger(LoginController.class.getName()).log(Level.SEVERE, null, ex);
//                            }
//                            break;
//                        case "Manager":
//                            user = userName;
////                        pass = passwordField.getText();
//                            try {
//                                Parent parent = FXMLLoader.load(getClass().getResource("/restaurantmanagement/fxml/Management.fxml"));
//
//                                Image image = new Image(getClass().getResourceAsStream("/restaurantmanagement/images/Restaurant_96px.png"));
//                                Stage stage = new Stage();
//                                stage.setTitle("Admin | Amula Hut" + " " + currentDate + " " + currentTime);
//                                stage.getIcons().add(0, image);
//
//                                stage.setScene(new Scene(parent));
//                                stage.initOwner(((Stage) loginPane.getScene().getWindow()));
//                                stage.setMinWidth(1150);
//                                stage.setMinHeight(600);
//                                stage.setMaximized(true);
//                                stage.show();
//                                stage.centerOnScreen();
//                                Rectangle2D primScreenBounds = Screen.getPrimary().getVisualBounds();
//                                stage.setX((primScreenBounds.getWidth() - stage.getWidth()) / 2);
//                                stage.setY((primScreenBounds.getHeight() - stage.getHeight()) / 2);
//                            } catch (IOException ex) {
//                                Logger.getLogger(LoginController.class.getName()).log(Level.SEVERE, null, ex);
//                            }
//                            break;
//                        case "Sales Attendant":
//                            user = userName;
////                        pass = passWord;
//                            try {
//                                Parent parent = FXMLLoader.load(getClass().getResource("/restaurantmanagement/fxml/Food.fxml"));
//
//                                Image image = new Image(getClass().getResourceAsStream("/restaurantmanagement/images/Restaurant_96px.png"));
//                                Stage stage = new Stage();
//                                stage.setTitle("SalesAttendant | Amula Hut" + " " + currentDate + " " + currentTime);
//                                stage.getIcons().add(0, image);
//
//                                stage.setScene(new Scene(parent));
//                                stage.initOwner(((Stage) loginPane.getScene().getWindow()));
//                                stage.setMinWidth(1150);
//                                stage.setMinHeight(600);
//                                stage.setMaximized(true);
//                                stage.show();
//                                stage.centerOnScreen();
//                                Rectangle2D primScreenBounds = Screen.getPrimary().getVisualBounds();
//                                stage.setX((primScreenBounds.getWidth() - stage.getWidth()) / 2);
//                                stage.setY((primScreenBounds.getHeight() - stage.getHeight()) / 2);
//                            } catch (IOException ex) {
//                                Logger.getLogger(LoginController.class.getName()).log(Level.SEVERE, null, ex);
//                            }
//                            break;
//                        default:
//                            System.out.println("Wrong Username or password");
//                            Notifications notify = Notifications.create()
//                                    .graphic(new ImageView(errorImg))
//                                    .hideAfter(Duration.seconds(5))
//                                    .title("Error")
//                                    .text("Wrong Username or Password")
//                                    .position(Pos.TOP_CENTER);
//                            notify.show();
//                            break;
//                    }
//                    JOptionPane.showMessageDialog(null, "Logged in successfully");
//                }
//            } catch (SQLException ex) {
//                JOptionPane.showMessageDialog(null, ex);
//
//                Logger.getLogger(LoginController.class.getName()).log(Level.SEVERE, null, ex);
//            }
//
//        }
        if (!username.getText().equals("") && !password.getText().equals("")) {
            if (userName.equals(adminU) && passWord.equals(adminP)) {
                try {
                    Parent parent = FXMLLoader.load(getClass().getResource("/restaurantmanagement/fxml/Management.fxml"));

                    Image image = new Image(getClass().getResourceAsStream("/restaurantmanagement/images/Restaurant_96px.png"));
                    Stage stage = new Stage();
                    stage.setTitle("Admin | Amula Hut" + " " + currentDate + " " + currentTime);
                    stage.getIcons().add(0, image);

                    stage.setScene(new Scene(parent));
                    stage.initOwner(((Stage) loginPane.getScene().getWindow()));
                    stage.setMinWidth(1150);
                    stage.setMinHeight(600);
                    stage.setMaximized(true);
                    stage.show();
                    stage.centerOnScreen();
                    Rectangle2D primScreenBounds = Screen.getPrimary().getVisualBounds();
                    stage.setX((primScreenBounds.getWidth() - stage.getWidth()) / 2);
                    stage.setY((primScreenBounds.getHeight() - stage.getHeight()) / 2);
                } catch (IOException ex) {
                    Logger.getLogger(LoginController.class.getName()).log(Level.SEVERE, null, ex);
                }
            } else {
                String query = "select * from Users where userName=? and userPassword=?";
                String url = "jdbc:sqlite:RestaurantDB.db";
                Connection connection;
                try {
                    connection = DriverManager.getConnection(url);
                    PreparedStatement preparedStatement = connection.prepareStatement(query);
                    //Parameters
                    preparedStatement.setString(1, userName);
                    preparedStatement.setString(2, passWord);
                    //Execute
                    ResultSet resultSet = preparedStatement.executeQuery();

                    if (resultSet.next()) {
                        //You dont need to find userName & passWord, are already exists
                        String position = resultSet.getString("designation");
                        switch (position) {
                            case "Administrator":

                                String user = userName;

                                try {
                                    Parent parent = FXMLLoader.load(getClass().getResource("/restaurantmanagement/fxml/Management.fxml"));

                                    Image image = new Image(getClass().getResourceAsStream("/restaurantmanagement/images/Restaurant_96px.png"));
                                    Stage stage = new Stage();
                                    stage.setTitle("Admin | Amula Hut" + " " + currentDate + " " + currentTime);
                                    stage.getIcons().add(0, image);

                                    stage.setScene(new Scene(parent));
                                    stage.initOwner(((Stage) loginPane.getScene().getWindow()));
                                    stage.setMinWidth(1150);
                                    stage.setMinHeight(600);
                                    stage.setMaximized(true);
                                    stage.show();
                                    stage.centerOnScreen();
                                    Rectangle2D primScreenBounds = Screen.getPrimary().getVisualBounds();
                                    stage.setX((primScreenBounds.getWidth() - stage.getWidth()) / 2);
                                    stage.setY((primScreenBounds.getHeight() - stage.getHeight()) / 2);
                                } catch (IOException ex) {
                                    Logger.getLogger(LoginController.class.getName()).log(Level.SEVERE, null, ex);
                                }
                                break;
                            case "Manager":
                                user = userName;
//                        pass = passwordField.getText();
                                try {
                                    Parent parent = FXMLLoader.load(getClass().getResource("/restaurantmanagement/fxml/Management.fxml"));

                                    Image image = new Image(getClass().getResourceAsStream("/restaurantmanagement/images/Restaurant_96px.png"));
                                    Stage stage = new Stage();
                                    stage.setTitle("Admin | Amula Hut" + " " + currentDate + " " + currentTime);
                                    stage.getIcons().add(0, image);

                                    stage.setScene(new Scene(parent));
                                    stage.initOwner(((Stage) loginPane.getScene().getWindow()));
                                    stage.setMinWidth(1150);
                                    stage.setMinHeight(600);
                                    stage.setMaximized(true);
                                    stage.show();
                                    stage.centerOnScreen();
                                    Rectangle2D primScreenBounds = Screen.getPrimary().getVisualBounds();
                                    stage.setX((primScreenBounds.getWidth() - stage.getWidth()) / 2);
                                    stage.setY((primScreenBounds.getHeight() - stage.getHeight()) / 2);
                                } catch (IOException ex) {
                                    Logger.getLogger(LoginController.class.getName()).log(Level.SEVERE, null, ex);
                                }
                                break;
                            case "Sales Attendant":
                                user = userName;
//                        pass = passWord;
                                try {
                                    Parent parent = FXMLLoader.load(getClass().getResource("/restaurantmanagement/fxml/Food.fxml"));

                                    Image image = new Image(getClass().getResourceAsStream("/restaurantmanagement/images/Restaurant_96px.png"));
                                    Stage stage = new Stage();
                                    stage.setTitle("SalesAttendant | Amula Hut" + " " + currentDate + " " + currentTime);
                                    stage.getIcons().add(0, image);

                                    stage.setScene(new Scene(parent));
                                    stage.initOwner(((Stage) loginPane.getScene().getWindow()));
                                    stage.setMinWidth(1150);
                                    stage.setMinHeight(600);
                                    stage.setMaximized(true);
                                    stage.show();
                                    stage.centerOnScreen();
                                    Rectangle2D primScreenBounds = Screen.getPrimary().getVisualBounds();
                                    stage.setX((primScreenBounds.getWidth() - stage.getWidth()) / 2);
                                    stage.setY((primScreenBounds.getHeight() - stage.getHeight()) / 2);
                                } catch (IOException ex) {
                                    Logger.getLogger(LoginController.class.getName()).log(Level.SEVERE, null, ex);
                                }
                                break;
                            default:
                                System.out.println("Wrong Username or password");
                                Notifications notify = Notifications.create()
                                        .graphic(new ImageView(errorImg))
                                        .hideAfter(Duration.seconds(5))
                                        .title("Error")
                                        .text("Wrong Username or Password")
                                        .position(Pos.TOP_CENTER);
                                notify.show();
                                break;
                        }
                        JOptionPane.showMessageDialog(null, "Logged in successfully");
                    }
                } catch (SQLException ex) {
                    JOptionPane.showMessageDialog(null, ex);

                    Logger.getLogger(LoginController.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
    }

}
