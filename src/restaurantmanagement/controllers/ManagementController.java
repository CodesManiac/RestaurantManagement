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
import com.jfoenix.controls.JFXPasswordField;
import com.jfoenix.controls.JFXTextField;
import de.jensd.fx.glyphs.fontawesome.FontAwesomeIconView;
import de.jensd.fx.glyphs.materialdesignicons.MaterialDesignIconView;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
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
import java.util.regex.Pattern;
import javafx.animation.FadeTransition;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.geometry.Pos;
import javafx.geometry.Rectangle2D;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Hyperlink;
import javafx.scene.control.Label;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuItem;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import javafx.scene.text.Text;
import javafx.stage.FileChooser;
import javafx.stage.Screen;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import javafx.util.Duration;
import javax.swing.JOptionPane;
import org.controlsfx.control.Notifications;
import org.controlsfx.glyphfont.FontAwesome;
import restaurantmanagement.database.RestaurantDatabase;
import restaurantmanagement.tables.EmployeesTable;
import restaurantmanagement.tables.StockTable;

/**
 *
 * @author toshiba
 */
public class ManagementController implements Initializable {

    FileChooser fileChooser = new FileChooser();
    File selectedFile;
    private File employeeFile, stockItemFile,userFile;
    String currentDate;
    String currentTime;
    public Image errorImg = new Image("/restaurantmanagement/images/cross.png");
    public Image successImg = new Image("/restaurantmanagement/images/checked.png");

    RestaurantDatabase database = new RestaurantDatabase();

    ObservableList<EmployeesTable> obs = FXCollections.observableArrayList();
    ObservableList<StockTable> obs1 = FXCollections.observableArrayList();

    private Image image;
    private Label label;
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
    private AnchorPane dashboardPane;
    @FXML
    private JFXButton settingsBtn;
    private StackPane display;
    @FXML
    private AnchorPane settingsPane;
    @FXML
    private TextField OldPasswordTxtF;
    @FXML
    private TextField NewPasswordTxtF;
    @FXML
    private TextField ConfirmPasswordTxtF;
    @FXML
    private AnchorPane employeesPane;
    @FXML
    private GNAvatarView employeeImage;
    @FXML
    private AnchorPane addEmployeePane;
    @FXML
    private Text employeeName;
    @FXML
    private Text maleEmployeeText;
    @FXML
    private Text femaleEmployeeText;
    @FXML
    private Text totalEmployeeText;
    @FXML
    private TableView<EmployeesTable> employeesTable;
    @FXML
    private JFXTextField employeeFirstName;
    @FXML
    private JFXTextField employeeLastName;
    @FXML
    private JFXTextField employeePhoneNumber;
    @FXML
    private JFXComboBox employeeMaritalStatus;
    @FXML
    private JFXComboBox employeeGender;
    @FXML
    private JFXTextField employeeAddress;
    @FXML
    private JFXDatePicker employeDOB;
    @FXML
    private JFXTextField employeeDesignation;
    @FXML
    private MaterialDesignIconView dashBoardIcon;
    @FXML
    private MaterialDesignIconView dailySalesIcon;
    @FXML
    private MaterialDesignIconView stockIcon;
    @FXML
    private MaterialDesignIconView settingsIcon;
    @FXML
    private FontAwesomeIconView employeesIcon;
    @FXML
    private GNAvatarView employeeEntryImage;
    @FXML
    private StackPane employeeModal;
    @FXML
    private AnchorPane stockPane;
    @FXML
    private Text maleEmployeeText1;
    @FXML
    private Text femaleEmployeeText1;
    @FXML
    private AnchorPane addStockPane;
    @FXML
    private GNAvatarView itemEntryImage;
    @FXML
    private JFXTextField itemName;
    @FXML
    private JFXTextField itemQuantity;
    @FXML
    private JFXTextField itemMeasuringUnit;
    @FXML
    private JFXComboBox itemType;
    @FXML
    private JFXTextField itemUnitPrice;
    @FXML
    private JFXTextField itemPrice;
    @FXML
    private StackPane stockModal;
    @FXML
    private TableColumn<EmployeesTable, String> tEmployeeId;
    @FXML
    private TableColumn<EmployeesTable, String> tFullName;
    @FXML
    private TableColumn<EmployeesTable, String> tGender;
    @FXML
    private TableColumn<EmployeesTable, String> tPhoneNumber;
    @FXML
    private TableColumn<EmployeesTable, String> tDOB;
    @FXML
    private TableColumn<EmployeesTable, String> tMaritalStatus;
    @FXML
    private TableColumn<EmployeesTable, String> tDesignation;
    @FXML
    private TableColumn<EmployeesTable, String> tResidentialAddress;
    @FXML
    private FontAwesomeIconView todayStockIcon;
    @FXML
    private AnchorPane todayStockPane;
    @FXML
    private Text totalDayStock;
    @FXML
    private Text totalNumDrinks;
    @FXML
    private Text totalNumFood;
    @FXML
    private Text totalNumStock;
    @FXML
    private AnchorPane totalSalesPane;
    @FXML
    private Text totalNumDrinks1;
    @FXML
    private Text totalNumFood1;
    @FXML
    private Text totalNumStock1;
    @FXML
    private AnchorPane dailySalesPane;
    @FXML
    private Text totalNumDrinks11;
    @FXML
    private Text totalNumFood11;
    @FXML
    private Text totalNumStock11;
    @FXML
    private MaterialDesignIconView totalSalesIcon;
    @FXML
    private TextField employeeSearch;
    @FXML
    private JFXButton resetEmployeeBtn;
    @FXML
    private JFXButton chooseEmployeePhoto;
    @FXML
    private Hyperlink viewEmployees;
    @FXML
    private FontAwesomeIconView staffIcon1;
    @FXML
    private JFXButton editEmpImage;
    @FXML
    private JFXTextField editEmpID;
    @FXML
    private JFXTextField editEmpFirstName;
    @FXML
    private JFXTextField editEmpLastName;
    @FXML
    private JFXComboBox editEmpMaritalStatus;
    @FXML
    private JFXComboBox editEmpGender;
    @FXML
    private JFXTextField editEmpPhoneNumber;
    @FXML
    private JFXDatePicker editEmpDOB;
    @FXML
    private JFXTextField editEmpAddress;
    @FXML
    private JFXTextField editEmpDesignation;
    @FXML
    private GNAvatarView stockImage;
    @FXML
    private Text itemDate;
    @FXML
    private Text itemTime;
    @FXML
    private TextField employeeSearch1;
    @FXML
    private TableView<StockTable> dayStockTable;
    @FXML
    private TableColumn<?, ?> tItemID;
    @FXML
    private TableColumn<?, ?> tItemName;
    @FXML
    private TableColumn<?, ?> tQuantity;
    @FXML
    private TableColumn<?, ?> tMUnit;
    @FXML
    private TableColumn<?, ?> tPrice;
    @FXML
    private TableColumn<?, ?> tType;
    @FXML
    private TableColumn<?, ?> tUnitPrice;
    @FXML
    private TableColumn<?, ?> tTime;
    @FXML
    private Hyperlink viewEmployees1;
    @FXML
    private FontAwesomeIconView staffIcon11;
    @FXML
    private GNAvatarView editItemImageDisplay;
    @FXML
    private JFXButton editItemImage;
    @FXML
    private JFXTextField editItemID;
    @FXML
    private JFXTextField editItemName;
    @FXML
    private JFXTextField editItemQuantity;
    @FXML
    private JFXComboBox editType;
    @FXML
    private JFXTextField editMeasuringUnit;
    @FXML
    private JFXTextField editPrice;
    @FXML
    private JFXTextField editUnitPrice;
    @FXML
    private GNAvatarView stockImage1;
    @FXML
    private TextField stockSearch;
    @FXML
    private TableView<?> stockTable;
    @FXML
    private TableColumn<?, ?> stItemID;
    @FXML
    private TableColumn<?, ?> stItemName;
    @FXML
    private TableColumn<?, ?> stQuantity;
    @FXML
    private TableColumn<?, ?> stMUnit;
    @FXML
    private TableColumn<?, ?> stPrice;
    @FXML
    private TableColumn<?, ?> stType;
    @FXML
    private TableColumn<?, ?> stUnitPrice;
    @FXML
    private TableColumn<?, ?> stDate;
    @FXML
    private TableColumn<?, ?> stTime;
    @FXML
    private GNAvatarView totalSalesImage;
    @FXML
    private JFXButton totalSalesExcel;
    @FXML
    private JFXButton toalSalesPdf;
    @FXML
    private TextField stockSearch1;
    @FXML
    private TableView<?> totalSalesTable;
    @FXML
    private TableColumn<?, ?> tTotalSalesID;
    @FXML
    private TableColumn<?, ?> tTotalSalesAttendant;
    @FXML
    private TableColumn<?, ?> tTotalSalesCost;
    @FXML
    private TableColumn<?, ?> tTotalSalesCash;
    @FXML
    private TableColumn<?, ?> tTotalSalesBal;
    @FXML
    private TableColumn<?, ?> tTotalSalesDate;
    @FXML
    private TableColumn<?, ?> tTotalSalesTime;
    @FXML
    private GNAvatarView dailySalesImage;
    @FXML
    private JFXButton dailySalesExcel;
    @FXML
    private JFXButton dailySalesPdf;
    @FXML
    private TextField dailySalesSearch;
    @FXML
    private TableView<?> dailySalesTable;
    @FXML
    private TableColumn<?, ?> tDailySalesID;
    @FXML
    private TableColumn<?, ?> tDailySalesAttendant;
    @FXML
    private TableColumn<?, ?> tDailySalesCost;
    @FXML
    private TableColumn<?, ?> tDailySalesCash;
    @FXML
    private TableColumn<?, ?> tDailySalesBal;
    @FXML
    private TableColumn<?, ?> tDailySalesTime;
    @FXML
    private JFXListView<?> leaderList;
    @FXML
    private JFXListView<?> view;
    @FXML
    private AnchorPane usersPane;
    @FXML
    private GNAvatarView userImage;
    @FXML
    private Text numMaleUsers;
    @FXML
    private Text numOfFemaleUsers;
    @FXML
    private Text totalNumUsers;
    @FXML
    private TextField usersSearch;
    @FXML
    private TableView<?> usersTable;
    @FXML
    private TableColumn<?, ?> tUserID;
    @FXML
    private TableColumn<?, ?> tUserName;
    @FXML
    private TableColumn<?, ?> tUserUsername;
    @FXML
    private TableColumn<?, ?> tUserPassword;
    @FXML
    private TableColumn<?, ?> tUserDesignation;
    @FXML
    private TableColumn<?, ?> tUserDate;
    @FXML
    private TableColumn<?, ?> tUserTime;
    @FXML
    private AnchorPane addUserPane;
    @FXML
    private GNAvatarView userEntryImage;
    @FXML
    private FontAwesomeIconView staffIcon111;
    @FXML
    private JFXTextField userName;
    @FXML
    private JFXTextField username;
    @FXML
    private JFXComboBox userDesignation;
    @FXML
    private JFXPasswordField userPassword;
    @FXML
    private StackPane usersModal;
    @FXML
    private GNAvatarView editUserImageDisplay;
    @FXML
    private JFXButton editUserImage;
    @FXML
    private JFXTextField editUserID;
    @FXML
    private JFXTextField editUserName;
    @FXML
    private JFXTextField editUserUsername;
    @FXML
    private JFXPasswordField editUserPassword;
    @FXML
    private JFXComboBox editUserDesignation;
    @FXML
    private MenuItem usersBtn;
    @FXML
    private MaterialDesignIconView usersIcon;
    @FXML
    private Hyperlink viewUsers;

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        populateComboBoxes();
        currentDate();
        refreshEmployeesTable();
    }

    public void populateComboBoxes() {
        ObservableList genders = FXCollections.observableArrayList(
                "Male", "Female");
        employeeGender.setItems(genders);
        editEmpGender.setItems(genders);
        ObservableList maritalStatus = FXCollections.observableArrayList(
                "Single", "Engaged", "Married", "Divorced");
        employeeMaritalStatus.setItems(maritalStatus);
        editEmpMaritalStatus.setItems(maritalStatus);
        ObservableList stockItemType = FXCollections.observableArrayList(
                "Drink", "Swallow", "Light", "Others");
        itemType.setItems(stockItemType);
        editType.setItems(stockItemType);
        ObservableList usersDesignation = FXCollections.observableArrayList("Administrator", "Manager", "Sales Attendant");
        userDesignation.setItems(usersDesignation);
        editUserDesignation.setItems(usersDesignation);
    }

    public void currentDate() {
//        GregorianCalendar gg = new GregorianCalendar();
        Date date = new Date();
        SimpleDateFormat dd = new SimpleDateFormat("dd/MM/YYYY");
        SimpleDateFormat ddd = new SimpleDateFormat("HH:mm");
//        date.setText(dd.format(gg.getTime()));
//        time.setText(ddd.format(gg.getTime()));
        currentDate = dd.format(date);
        currentTime = ddd.format(date);
    }

    private void refreshEmployeesTable() {
        employeesTable.getItems().clear();
        obs.removeAll(obs);
        populateEmployeeTable();
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

    private void changePanes(ActionEvent event) {
        if (event.getSource() == employeesBtn) {
            employeesPane.toFront();

        } else if (event.getSource() == settingsBtn) {
            settingsPane.toFront();
        } else if (event.getSource() == dashboardBtn) {
            dashboardPane.toFront();

        }
    }

    @FXML
    private void addEmployee(ActionEvent event) {
        addEmployeePane.setVisible(true);
        FadeTransition fade = new FadeTransition();
        fade.setDuration(Duration.millis(300));
        fade.setNode(addEmployeePane);
        fade.setFromValue(0);
        fade.setToValue(1);
        fade.play();
    }

    @FXML
    private void editEmployee(ActionEvent event) {
        employeeModal.setVisible(true);
        dashboardPane.setDisable(true);
        employeesPane.setDisable(true);
        settingsPane.setDisable(true);
        FadeTransition fade = new FadeTransition();
        fade.setDuration(Duration.millis(300));
        fade.setNode(employeeModal);
        fade.setFromValue(0);
        fade.setToValue(1);
        fade.play();

    }

    @FXML
    private void saveEmployeeDetails(ActionEvent event) {
        if (!employeeFirstName.getText().isEmpty() || !employeeLastName.getText().isEmpty() || !employeeAddress.getText().isEmpty() || employeDOB != null || employeeGender != null || employeeMaritalStatus != null || !employeeDesignation.getText().isEmpty() || employeeEntryImage != null) {
            String sql = "INSERT INTO Employees(firstName,lastName,gender,homeAddress,maritalStatus,dateOfBirth,phoneNumber,designation,employeeImage) "
                    + "VALUES(?,?,?,?,?,?,?,?,?)";
            try {
                String url = "jdbc:sqlite:RestaurantDB.db";
                Connection connection = DriverManager.getConnection(url);
                PreparedStatement ps = connection.prepareStatement(sql);
                FileInputStream fis = new FileInputStream(employeeFile);
                ps.setString(1, employeeFirstName.getText());
                ps.setString(2, employeeLastName.getText());
                ps.setString(3, employeeGender.getValue().toString());
                ps.setString(4, employeeAddress.getText());
                ps.setString(5, employeeMaritalStatus.getValue().toString());
                ps.setString(6, employeDOB.getValue().toString());
                ps.setString(7, employeePhoneNumber.getText());
                ps.setString(8, employeeDesignation.getText());
                ps.setBinaryStream(9, (InputStream) fis, (int) employeeFile.length());
                ps.execute();

                int s = ps.executeUpdate();
                if (s > 0) {
                    Notifications notify = Notifications.create()
                            .graphic(new ImageView(successImg))
                            .hideAfter(Duration.seconds(5))
                            .title("Success")
                            .text("Employee Details Uploaded Succesfully")
                            .position(Pos.TOP_CENTER);
                    notify.show();
                    resetStockEntry(event);
                } else {
                    Notifications notify = Notifications.create()
                            .graphic(new ImageView(errorImg))
                            .hideAfter(Duration.seconds(5))
                            .title("Failed")
                            .text("Employee Details Uploaded was Unsuccesfully")
                            .position(Pos.TOP_CENTER);
                    notify.show();
                }
            } catch (SQLException e) {
                JOptionPane.showMessageDialog(null, e.getMessage());
                e.getMessage();
                e.printStackTrace();
            } catch (FileNotFoundException ex) {
                JOptionPane.showMessageDialog(null, ex.getMessage());

                Logger.getLogger(ManagementController.class.getName()).log(Level.SEVERE, null, ex);
            }
        } else {
            Alert alert = new Alert(Alert.AlertType.CONFIRMATION, "Good", ButtonType.OK);
            alert.setTitle("Invalid");
            alert.showAndWait();
        }
        refreshEmployeesTable();
    }

    private void populateEmployeeTable() {
        try {
            String url = "jdbc:sqlite:RestaurantDB.db";
            Connection connection = DriverManager.getConnection(url);
            ResultSet res = connection.createStatement().executeQuery("SELECT employeeId,firstName,gender,phoneNumber,dateOfBirth,maritalStatus,designation,homeAddress FROM Employees;");
            while (res.next()) {
                obs.add(new EmployeesTable(res.getString("employeeId"), res.getString("firstName"),
                        res.getString("gender"), res.getString("phoneNumber"), res.getString("dateOfBirth"),
                        res.getString("maritalStatus"), res.getString("designation"), res.getString("homeAddress")));
            }
        } catch (SQLException ex) {
            Logger.getLogger(ManagementController.class.getName()).log(Level.SEVERE, null, ex);
        }
        tEmployeeId.setCellValueFactory(new PropertyValueFactory<>("employeeID"));
        tFullName.setCellValueFactory(new PropertyValueFactory<>("fullName"));
        tGender.setCellValueFactory(new PropertyValueFactory<>("gender"));
        tPhoneNumber.setCellValueFactory(new PropertyValueFactory<>("phoneNumber"));
        tDOB.setCellValueFactory(new PropertyValueFactory<>("dateOfBirth"));
        tMaritalStatus.setCellValueFactory(new PropertyValueFactory<>("maritalStatus"));
        tDesignation.setCellValueFactory(new PropertyValueFactory<>("designation"));

        tResidentialAddress.setCellValueFactory(new PropertyValueFactory<>("address"));
        employeesTable.setItems(obs);

        employeesTable.setOnMouseClicked((event) -> {
            String name = employeesTable.getSelectionModel().getSelectedItem().getFullName();
            employeeName.setText(name);

            try {
                String url = "jdbc:sqlite:RestaurantDB.db";
                Connection connection = DriverManager.getConnection(url);
                String id = employeesTable.getSelectionModel().getSelectedItem().getEmployeeID();
                PreparedStatement ps = connection.prepareStatement("Select employeeImage FROM Employees WHERE employeeId= ?");
                ps.setString(1, id);
                ResultSet rs = ps.executeQuery();
                if (rs.next()) {
                    InputStream ips = rs.getBinaryStream(1);
                    image = new Image(ips, employeeImage.getHeight(), employeeImage.getWidth(), true, true);
                    employeeImage.setImage(image);

                    if (employeeImage.isVisible()) {
                        System.out.println("Teacher's image is visible");
                    } else {
                        System.out.println("Teacher's image is not visible");
                    }
                }
            } catch (SQLException ex) {
                Logger.getLogger(ManagementController.class.getName()).log(Level.SEVERE, null, ex);
            }
        });
    }

    @FXML
    private void saveAction(ActionEvent event) {

    }

    @FXML
    private void chooseEmployeeImage(ActionEvent event) {
        fileChooser.setTitle("Open Image");

        //set extension filter
        try {
            fileChooser.getExtensionFilters().addAll(new FileChooser.ExtensionFilter("All images", "*.jpg", "*.jpeg", "*.png", "*.gif"));
        } catch (NullPointerException ex) {
            ex.printStackTrace();
        }

        //show open file dialog
        fileChooser.getInitialDirectory();
        selectedFile = fileChooser.showOpenDialog(null);

        try {
            if (selectedFile != null) {
                String path = selectedFile.getPath();
                selectedFile = new File(path);
                employeeFile = selectedFile;
                Image image = new Image(selectedFile.toURI().toString());
                employeeEntryImage.setImage(image);
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    @FXML
    private void backFromAddEmployee(ActionEvent event) {
        FadeTransition fade = new FadeTransition();
        fade.setDuration(Duration.millis(300));
        fade.setNode(addEmployeePane);
        fade.setFromValue(1);
        fade.setToValue(0);
        fade.play();
        fade.setOnFinished((ActionEvent events) -> {
            addEmployeePane.setVisible(false);
        });
    }

    @FXML
    private void openEmployeesPane(ActionEvent event) {
        if (dashboardBtn.getStyleClass().size() == 2 && dashBoardIcon.getStyleClass().size() == 2) {

        } else if (dashboardBtn.getStyleClass().size() == 3 && dashBoardIcon.getStyleClass().size() == 3) {
            dashboardBtn.getStyleClass().remove(2);
            dashBoardIcon.getStyleClass().remove(2);
        }
        if (stockItemsBtn.getStyleClass().size() == 2 && stockIcon.getStyleClass().size() == 2) {

        } else if (stockItemsBtn.getStyleClass().size() == 3 && stockIcon.getStyleClass().size() == 3) {
            stockItemsBtn.getStyleClass().remove(2);
            stockIcon.getStyleClass().remove(2);
        }
        if (todayStockBtn.getStyleClass().size() == 2 && todayStockIcon.getStyleClass().size() == 2) {

        } else if (todayStockBtn.getStyleClass().size() == 3 && todayStockIcon.getStyleClass().size() == 3) {
            todayStockBtn.getStyleClass().remove(2);
            todayStockIcon.getStyleClass().remove(2);
        }
        if (dailySalesBtn.getStyleClass().size() == 2 && dailySalesIcon.getStyleClass().size() == 2) {

        } else if (dailySalesBtn.getStyleClass().size() == 3 && dailySalesIcon.getStyleClass().size() == 3) {
            dailySalesBtn.getStyleClass().remove(2);
            dailySalesIcon.getStyleClass().remove(2);
        }
        if (totalSalesBtn.getStyleClass().size() == 2 && totalSalesIcon.getStyleClass().size() == 2) {

        } else if (totalSalesBtn.getStyleClass().size() == 3 && totalSalesIcon.getStyleClass().size() == 3) {
            totalSalesBtn.getStyleClass().remove(2);
            totalSalesIcon.getStyleClass().remove(2);
        }

        if (settingsBtn.getStyleClass().size() == 2 && settingsIcon.getStyleClass().size() == 2) {

        } else if (settingsBtn.getStyleClass().size() == 3 && settingsIcon.getStyleClass().size() == 3) {
            settingsBtn.getStyleClass().remove(2);
            settingsIcon.getStyleClass().remove(2);
        }

        if (employeesBtn.getStyleClass().toString().contains("active") && employeesIcon.getStyleClass().toString().contains("iconActive")) {

        } else {
            employeesBtn.getStyleClass().add("active");
            employeesIcon.getStyleClass().add("iconActive");
            employeesPane.setVisible(true);
            FadeTransition fade = new FadeTransition();
            fade.setDuration(Duration.millis(300));
            fade.setNode(employeesPane);
            fade.setFromValue(0);
            fade.setToValue(1);
            fade.play();
        }

        dashboardPane.setVisible(false);
        dailySalesPane.setVisible(false);
        todayStockPane.setVisible(false);
        stockPane.setVisible(false);
        totalSalesPane.setVisible(false);
        settingsPane.setVisible(false);
        usersPane.setVisible(false);

    }

    @FXML
    private void openSettingsPane(ActionEvent event) {
        if (dashboardBtn.getStyleClass().size() == 2 && dashBoardIcon.getStyleClass().size() == 2) {

        } else if (dashboardBtn.getStyleClass().size() == 3 && dashBoardIcon.getStyleClass().size() == 3) {
            dashboardBtn.getStyleClass().remove(2);
            dashBoardIcon.getStyleClass().remove(2);
        }
        if (stockItemsBtn.getStyleClass().size() == 2 && stockIcon.getStyleClass().size() == 2) {

        } else if (stockItemsBtn.getStyleClass().size() == 3 && stockIcon.getStyleClass().size() == 3) {
            stockItemsBtn.getStyleClass().remove(2);
            stockIcon.getStyleClass().remove(2);
        }
        if (todayStockBtn.getStyleClass().size() == 2 && todayStockIcon.getStyleClass().size() == 2) {

        } else if (todayStockBtn.getStyleClass().size() == 3 && todayStockIcon.getStyleClass().size() == 3) {
            todayStockBtn.getStyleClass().remove(2);
            todayStockIcon.getStyleClass().remove(2);
        }
        if (dailySalesBtn.getStyleClass().size() == 2 && dailySalesIcon.getStyleClass().size() == 2) {

        } else if (dailySalesBtn.getStyleClass().size() == 3 && dailySalesIcon.getStyleClass().size() == 3) {
            dailySalesBtn.getStyleClass().remove(2);
            dailySalesIcon.getStyleClass().remove(2);
        }
        if (totalSalesBtn.getStyleClass().size() == 2 && totalSalesIcon.getStyleClass().size() == 2) {

        } else if (totalSalesBtn.getStyleClass().size() == 3 && totalSalesIcon.getStyleClass().size() == 3) {
            totalSalesBtn.getStyleClass().remove(2);
            totalSalesIcon.getStyleClass().remove(2);
        }

        if (employeesBtn.getStyleClass().size() == 2 && employeesIcon.getStyleClass().size() == 2) {

        } else if (employeesBtn.getStyleClass().size() == 3 && employeesIcon.getStyleClass().size() == 3) {
            employeesBtn.getStyleClass().remove(2);
            employeesIcon.getStyleClass().remove(2);
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

        dashboardPane.setVisible(false);
        dailySalesPane.setVisible(false);
        todayStockPane.setVisible(false);
        stockPane.setVisible(false);
        totalSalesPane.setVisible(false);
        employeesPane.setVisible(false);
        usersPane.setVisible(false);
    }

    @FXML
    private void resetEmployeeEntry(ActionEvent event) {

        employeeFirstName.setText("");
        employeeLastName.setText("");
        employeeMaritalStatus.setValue(null);
        employeePhoneNumber.setText("");
        employeDOB.setValue(null);
        employeeGender.setValue(null);
        employeeAddress.setText("");
        employeeDesignation.setText("");

        File file = new File("src/restaurantmanagement/images/user.png");
        selectedFile = file;
        employeeFile = selectedFile;
        Image image = new Image(selectedFile.toURI().toString());
        employeeEntryImage.setImage(image);
    }

    @FXML
    private void exitEmployeeEditModal(MouseEvent event) {
        FadeTransition fade = new FadeTransition();
        fade.setDuration(Duration.millis(300));
        fade.setNode(employeeModal);
        fade.setFromValue(1);
        fade.setToValue(0);
        fade.play();
        fade.setOnFinished((ActionEvent events) -> {
            dashboardPane.setDisable(false);
            employeesPane.setDisable(false);
            settingsPane.setDisable(false);
            employeeModal.setVisible(false);
        });
    }

    @FXML
    private void openDashBoard(ActionEvent event) {

        if (employeesBtn.getStyleClass().size() == 2 && employeesIcon.getStyleClass().size() == 2) {

        } else if (employeesBtn.getStyleClass().size() == 3 && employeesIcon.getStyleClass().size() == 3) {
            employeesBtn.getStyleClass().remove(2);
            employeesIcon.getStyleClass().remove(2);
        }
        if (stockItemsBtn.getStyleClass().size() == 2 && stockIcon.getStyleClass().size() == 2) {

        } else if (stockItemsBtn.getStyleClass().size() == 3 && stockIcon.getStyleClass().size() == 3) {
            stockItemsBtn.getStyleClass().remove(2);
            stockIcon.getStyleClass().remove(2);
        }
        if (todayStockBtn.getStyleClass().size() == 2 && todayStockIcon.getStyleClass().size() == 2) {

        } else if (todayStockBtn.getStyleClass().size() == 3 && todayStockIcon.getStyleClass().size() == 3) {
            todayStockBtn.getStyleClass().remove(2);
            todayStockIcon.getStyleClass().remove(2);
        }
        if (dailySalesBtn.getStyleClass().size() == 2 && dailySalesIcon.getStyleClass().size() == 2) {

        } else if (dailySalesBtn.getStyleClass().size() == 3 && dailySalesIcon.getStyleClass().size() == 3) {
            dailySalesBtn.getStyleClass().remove(2);
            dailySalesIcon.getStyleClass().remove(2);
        }
        if (totalSalesBtn.getStyleClass().size() == 2 && totalSalesIcon.getStyleClass().size() == 2) {

        } else if (totalSalesBtn.getStyleClass().size() == 3 && totalSalesIcon.getStyleClass().size() == 3) {
            totalSalesBtn.getStyleClass().remove(2);
            totalSalesIcon.getStyleClass().remove(2);
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

        employeesPane.setVisible(false);
        dailySalesPane.setVisible(false);
        todayStockPane.setVisible(false);
        stockPane.setVisible(false);
        totalSalesPane.setVisible(false);
        settingsPane.setVisible(false);
        usersPane.setVisible(false);
    }

    @FXML
    private void addStock(ActionEvent event) {
        addStockPane.setVisible(true);
        FadeTransition fade = new FadeTransition();
        fade.setDuration(Duration.millis(300));
        fade.setNode(addStockPane);
        fade.setFromValue(0);
        fade.setToValue(1);
        fade.play();
    }

    @FXML
    private void editStock(ActionEvent event) {
        stockModal.setVisible(true);
        dashboardPane.setDisable(true);
        employeesPane.setDisable(true);
        stockPane.setDisable(true);
        settingsPane.setDisable(true);
        FadeTransition fade = new FadeTransition();
        fade.setDuration(Duration.millis(300));
        fade.setNode(stockModal);
        fade.setFromValue(0);
        fade.setToValue(1);
        fade.play();
    }

    @FXML
    private void saveStockDetails(ActionEvent event) {
        if (!itemName.getText().isEmpty() || !itemPrice.getText().isEmpty() || !itemMeasuringUnit.getText().isEmpty() || itemType != null || !itemQuantity.getText().isEmpty() || !itemUnitPrice.getText().isEmpty() || itemEntryImage != null) {
            String sql = "INSERT INTO Stock(itemName,quantity,measuringUnit,price,type,unitPrice,date,time,itemImage) "
                    + "VALUES(?,?,?,?,?,?,?,?,?)";
            try {
                String url = "jdbc:sqlite:RestaurantDB.db";
                Connection connection = DriverManager.getConnection(url);
                PreparedStatement ps = connection.prepareStatement(sql);
                FileInputStream fis = new FileInputStream(stockItemFile);
                ps.setString(1, itemName.getText());
                ps.setString(2, itemQuantity.getText());
                ps.setString(3, itemMeasuringUnit.getText());
                ps.setString(4, itemPrice.getText());
                ps.setString(5, itemType.getValue().toString());
                ps.setString(6, itemUnitPrice.getText());
                ps.setString(7, currentDate);
                ps.setString(8, currentTime);
                ps.setBinaryStream(9, (InputStream) fis, (int) stockItemFile.length());
                ps.execute();

                int s = ps.executeUpdate();
                if (s > 0) {
                    Notifications notify = Notifications.create()
                            .graphic(new ImageView(successImg))
                            .hideAfter(Duration.seconds(5))
                            .title("Success")
                            .text("Uploaded Succesfully")
                            .position(Pos.TOP_CENTER);
                    notify.show();
                    resetStockEntry(event);
                } else {
                    Notifications notify = Notifications.create()
                            .graphic(new ImageView(errorImg))
                            .hideAfter(Duration.seconds(5))
                            .title("Failed")
                            .text("Uploaded Unsuccesfully")
                            .position(Pos.TOP_CENTER);
                    notify.show();
                }
            } catch (SQLException e) {
                JOptionPane.showMessageDialog(null, e.getMessage());
                e.getMessage();
                e.printStackTrace();
            } catch (FileNotFoundException ex) {
                JOptionPane.showMessageDialog(null, ex.getMessage());

                Logger.getLogger(ManagementController.class.getName()).log(Level.SEVERE, null, ex);
            }

        } else {
            Alert alert = new Alert(Alert.AlertType.ERROR, "Some Fields Are empty", ButtonType.OK);
            alert.setTitle("Invalid");
            alert.showAndWait();
        }
        resetStockEntry(event);
    }

    @FXML
    private void resetStockEntry(ActionEvent event) {
        itemName.setText("");
        itemQuantity.setText("");
        itemUnitPrice.setText("");
        itemPrice.setText("");
        itemType.setValue(null);
        itemMeasuringUnit.setText("");
        File file = new File("src/restaurantmanagement/images/user.png");
        selectedFile = file;
        stockItemFile = selectedFile;
        Image image = new Image(selectedFile.toURI().toString());
        itemEntryImage.setImage(image);
    }

    @FXML
    private void chooseItemImage(ActionEvent event) {
        fileChooser.setTitle("Open Image");

        //set extension filter
        try {
            fileChooser.getExtensionFilters().addAll(new FileChooser.ExtensionFilter("All images", "*.jpg", "*.jpeg", "*.png", "*.gif"));
        } catch (NullPointerException ex) {
            ex.printStackTrace();
        }

        //show open file dialog
        fileChooser.getInitialDirectory();
        selectedFile = fileChooser.showOpenDialog(null);

        try {
            if (selectedFile != null) {
                String path = selectedFile.getPath();
                selectedFile = new File(path);
                stockItemFile = selectedFile;
                Image image = new Image(selectedFile.toURI().toString());
                itemEntryImage.setImage(image);
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    @FXML
    private void openStockPane(ActionEvent event) {
        if (dashboardBtn.getStyleClass().size() == 2 && dashBoardIcon.getStyleClass().size() == 2) {

        } else if (dashboardBtn.getStyleClass().size() == 3 && dashBoardIcon.getStyleClass().size() == 3) {
            dashboardBtn.getStyleClass().remove(2);
            dashBoardIcon.getStyleClass().remove(2);
        }
        if (stockItemsBtn.getStyleClass().size() == 2 && stockIcon.getStyleClass().size() == 2) {

        } else if (stockItemsBtn.getStyleClass().size() == 3 && stockIcon.getStyleClass().size() == 3) {
            stockItemsBtn.getStyleClass().remove(2);
            stockIcon.getStyleClass().remove(2);
        }
        if (employeesBtn.getStyleClass().size() == 2 && employeesIcon.getStyleClass().size() == 2) {

        } else if (employeesBtn.getStyleClass().size() == 3 && employeesIcon.getStyleClass().size() == 3) {
            employeesBtn.getStyleClass().remove(2);
            employeesIcon.getStyleClass().remove(2);
        }
        if (dailySalesBtn.getStyleClass().size() == 2 && dailySalesIcon.getStyleClass().size() == 2) {

        } else if (dailySalesBtn.getStyleClass().size() == 3 && dailySalesIcon.getStyleClass().size() == 3) {
            dailySalesBtn.getStyleClass().remove(2);
            dailySalesIcon.getStyleClass().remove(2);
        }
        if (totalSalesBtn.getStyleClass().size() == 2 && totalSalesIcon.getStyleClass().size() == 2) {

        } else if (totalSalesBtn.getStyleClass().size() == 3 && totalSalesIcon.getStyleClass().size() == 3) {
            totalSalesBtn.getStyleClass().remove(2);
            totalSalesIcon.getStyleClass().remove(2);
        }

        if (settingsBtn.getStyleClass().size() == 2 && settingsIcon.getStyleClass().size() == 2) {

        } else if (settingsBtn.getStyleClass().size() == 3 && settingsIcon.getStyleClass().size() == 3) {
            settingsBtn.getStyleClass().remove(2);
            settingsIcon.getStyleClass().remove(2);
        }

        if (todayStockBtn.getStyleClass().toString().contains("active") && todayStockIcon.getStyleClass().toString().contains("iconActive")) {

        } else {
            todayStockBtn.getStyleClass().add("active");
            todayStockIcon.getStyleClass().add("iconActive");
            todayStockPane.setVisible(true);
            FadeTransition fade = new FadeTransition();
            fade.setDuration(Duration.millis(300));
            fade.setNode(todayStockPane);
            fade.setFromValue(0);
            fade.setToValue(1);
            fade.play();
        }

        dashboardPane.setVisible(false);
        dailySalesPane.setVisible(false);
        stockPane.setVisible(false);
        employeesPane.setVisible(false);
        totalSalesPane.setVisible(false);
        settingsPane.setVisible(false);
        usersPane.setVisible(false);
    }

    @FXML
    private void exitStockEditModal(MouseEvent event) {
        FadeTransition fade = new FadeTransition();
        fade.setDuration(Duration.millis(300));
        fade.setNode(stockModal);
        fade.setFromValue(1);
        fade.setToValue(0);
        fade.play();
        fade.setOnFinished((ActionEvent events) -> {
            dashboardPane.setDisable(false);
            employeesPane.setDisable(false);
            settingsPane.setDisable(false);
            stockPane.setDisable(false);
            stockModal.setVisible(false);
        });
    }

    @FXML
    private void backFromAddStock(ActionEvent event) {
        FadeTransition fade = new FadeTransition();
        fade.setDuration(Duration.millis(300));
        fade.setNode(addStockPane);
        fade.setFromValue(1);
        fade.setToValue(0);
        fade.play();
        fade.setOnFinished((ActionEvent events) -> {
            addStockPane.setVisible(false);
        });
    }

    @FXML
    private void openAllStockPane(ActionEvent event) {
        if (dashboardBtn.getStyleClass().size() == 2 && dashBoardIcon.getStyleClass().size() == 2) {

        } else if (dashboardBtn.getStyleClass().size() == 3 && dashBoardIcon.getStyleClass().size() == 3) {
            dashboardBtn.getStyleClass().remove(2);
            dashBoardIcon.getStyleClass().remove(2);
        }
        if (employeesBtn.getStyleClass().size() == 2 && employeesIcon.getStyleClass().size() == 2) {

        } else if (employeesBtn.getStyleClass().size() == 3 && employeesIcon.getStyleClass().size() == 3) {
            employeesBtn.getStyleClass().remove(2);
            employeesIcon.getStyleClass().remove(2);
        }
        if (todayStockBtn.getStyleClass().size() == 2 && todayStockIcon.getStyleClass().size() == 2) {

        } else if (todayStockBtn.getStyleClass().size() == 3 && todayStockIcon.getStyleClass().size() == 3) {
            todayStockBtn.getStyleClass().remove(2);
            todayStockIcon.getStyleClass().remove(2);
        }
        if (dailySalesBtn.getStyleClass().size() == 2 && dailySalesIcon.getStyleClass().size() == 2) {

        } else if (dailySalesBtn.getStyleClass().size() == 3 && dailySalesIcon.getStyleClass().size() == 3) {
            dailySalesBtn.getStyleClass().remove(2);
            dailySalesIcon.getStyleClass().remove(2);
        }
        if (totalSalesBtn.getStyleClass().size() == 2 && totalSalesIcon.getStyleClass().size() == 2) {

        } else if (totalSalesBtn.getStyleClass().size() == 3 && totalSalesIcon.getStyleClass().size() == 3) {
            totalSalesBtn.getStyleClass().remove(2);
            totalSalesIcon.getStyleClass().remove(2);
        }

        if (settingsBtn.getStyleClass().size() == 2 && settingsIcon.getStyleClass().size() == 2) {

        } else if (settingsBtn.getStyleClass().size() == 3 && settingsIcon.getStyleClass().size() == 3) {
            settingsBtn.getStyleClass().remove(2);
            settingsIcon.getStyleClass().remove(2);
        }

        if (stockItemsBtn.getStyleClass().toString().contains("active") && stockIcon.getStyleClass().toString().contains("iconActive")) {

        } else {
            stockItemsBtn.getStyleClass().add("active");
            stockIcon.getStyleClass().add("iconActive");
            stockPane.setVisible(true);
            FadeTransition fade = new FadeTransition();
            fade.setDuration(Duration.millis(300));
            fade.setNode(stockPane);
            fade.setFromValue(0);
            fade.setToValue(1);
            fade.play();
        }

        dashboardPane.setVisible(false);
        dailySalesPane.setVisible(false);
        todayStockPane.setVisible(false);
        employeesPane.setVisible(false);
        totalSalesPane.setVisible(false);
        settingsPane.setVisible(false);
        usersPane.setVisible(false);
        
    }

    @FXML
    private void openTodaySalesPane(ActionEvent event) {
        if (dashboardBtn.getStyleClass().size() == 2 && dashBoardIcon.getStyleClass().size() == 2) {

        } else if (dashboardBtn.getStyleClass().size() == 3 && dashBoardIcon.getStyleClass().size() == 3) {
            dashboardBtn.getStyleClass().remove(2);
            dashBoardIcon.getStyleClass().remove(2);
        }
        if (stockItemsBtn.getStyleClass().size() == 2 && stockIcon.getStyleClass().size() == 2) {

        } else if (stockItemsBtn.getStyleClass().size() == 3 && stockIcon.getStyleClass().size() == 3) {
            stockItemsBtn.getStyleClass().remove(2);
            stockIcon.getStyleClass().remove(2);
        }
        if (todayStockBtn.getStyleClass().size() == 2 && todayStockIcon.getStyleClass().size() == 2) {

        } else if (todayStockBtn.getStyleClass().size() == 3 && todayStockIcon.getStyleClass().size() == 3) {
            todayStockBtn.getStyleClass().remove(2);
            todayStockIcon.getStyleClass().remove(2);
        }
        if (employeesBtn.getStyleClass().size() == 2 && employeesIcon.getStyleClass().size() == 2) {

        } else if (employeesBtn.getStyleClass().size() == 3 && employeesIcon.getStyleClass().size() == 3) {
            employeesBtn.getStyleClass().remove(2);
            employeesIcon.getStyleClass().remove(2);
        }
        if (totalSalesBtn.getStyleClass().size() == 2 && totalSalesIcon.getStyleClass().size() == 2) {

        } else if (totalSalesBtn.getStyleClass().size() == 3 && totalSalesIcon.getStyleClass().size() == 3) {
            totalSalesBtn.getStyleClass().remove(2);
            totalSalesIcon.getStyleClass().remove(2);
        }

        if (settingsBtn.getStyleClass().size() == 2 && settingsIcon.getStyleClass().size() == 2) {

        } else if (settingsBtn.getStyleClass().size() == 3 && settingsIcon.getStyleClass().size() == 3) {
            settingsBtn.getStyleClass().remove(2);
            settingsIcon.getStyleClass().remove(2);
        }

        if (dailySalesBtn.getStyleClass().toString().contains("active") && dailySalesIcon.getStyleClass().toString().contains("iconActive")) {

        } else {
            dailySalesBtn.getStyleClass().add("active");
            dailySalesIcon.getStyleClass().add("iconActive");
            dailySalesPane.setVisible(true);
            FadeTransition fade = new FadeTransition();
            fade.setDuration(Duration.millis(300));
            fade.setNode(dailySalesPane);
            fade.setFromValue(0);
            fade.setToValue(1);
            fade.play();
        }

        dashboardPane.setVisible(false);
        employeesPane.setVisible(false);
        todayStockPane.setVisible(false);
        stockPane.setVisible(false);
        totalSalesPane.setVisible(false);
        settingsPane.setVisible(false);
    }

    @FXML
    private void openTotalSalesPane(ActionEvent event) {
        if (dashboardBtn.getStyleClass().size() == 2 && dashBoardIcon.getStyleClass().size() == 2) {

        } else if (dashboardBtn.getStyleClass().size() == 3 && dashBoardIcon.getStyleClass().size() == 3) {
            dashboardBtn.getStyleClass().remove(2);
            dashBoardIcon.getStyleClass().remove(2);
        }
        if (stockItemsBtn.getStyleClass().size() == 2 && stockIcon.getStyleClass().size() == 2) {

        } else if (stockItemsBtn.getStyleClass().size() == 3 && stockIcon.getStyleClass().size() == 3) {
            stockItemsBtn.getStyleClass().remove(2);
            stockIcon.getStyleClass().remove(2);
        }
        if (todayStockBtn.getStyleClass().size() == 2 && todayStockIcon.getStyleClass().size() == 2) {

        } else if (todayStockBtn.getStyleClass().size() == 3 && todayStockIcon.getStyleClass().size() == 3) {
            todayStockBtn.getStyleClass().remove(2);
            todayStockIcon.getStyleClass().remove(2);
        }
        if (employeesBtn.getStyleClass().size() == 2 && employeesIcon.getStyleClass().size() == 2) {

        } else if (employeesBtn.getStyleClass().size() == 3 && employeesIcon.getStyleClass().size() == 3) {
            employeesBtn.getStyleClass().remove(2);
            employeesIcon.getStyleClass().remove(2);
        }
        if (dailySalesBtn.getStyleClass().size() == 2 && dailySalesIcon.getStyleClass().size() == 2) {

        } else if (dailySalesBtn.getStyleClass().size() == 3 && dailySalesIcon.getStyleClass().size() == 3) {
            dailySalesBtn.getStyleClass().remove(2);
            dailySalesIcon.getStyleClass().remove(2);
        }

        if (settingsBtn.getStyleClass().size() == 2 && settingsIcon.getStyleClass().size() == 2) {

        } else if (settingsBtn.getStyleClass().size() == 3 && settingsIcon.getStyleClass().size() == 3) {
            settingsBtn.getStyleClass().remove(2);
            settingsIcon.getStyleClass().remove(2);
        }

        if (totalSalesBtn.getStyleClass().toString().contains("active") && totalSalesIcon.getStyleClass().toString().contains("iconActive")) {

        } else {
            totalSalesBtn.getStyleClass().add("active");
            totalSalesIcon.getStyleClass().add("iconActive");
            totalSalesPane.setVisible(true);
            FadeTransition fade = new FadeTransition();
            fade.setDuration(Duration.millis(300));
            fade.setNode(totalSalesPane);
            fade.setFromValue(0);
            fade.setToValue(1);
            fade.play();
        }

        dashboardPane.setVisible(false);
        employeesPane.setVisible(false);
        todayStockPane.setVisible(false);
        stockPane.setVisible(false);
        dailySalesPane.setVisible(false);
        settingsPane.setVisible(false);
        usersPane.setVisible(false);
    }

    @FXML
    private void deleteEmployee(ActionEvent event) {
    }

    @FXML
    private void searchEmployeeDetails(KeyEvent event) {
    }

    @FXML
    private void validateFirstName(KeyEvent event) {
    }

    @FXML
    private void validateLastName(KeyEvent event) {
    }

    @FXML
    private void validatePhoneNumber(KeyEvent event) {
    }

    @FXML
    private void validateResidentialAddress(KeyEvent event) {
    }

    @FXML
    private void validateDesignation(KeyEvent event) {
    }

    @FXML
    private void updateEmployeeDetails(ActionEvent event) {
    }

    @FXML
    private void clearEmployeeUpdate(ActionEvent event) {
    }

    @FXML
    private void deleteStock(ActionEvent event) {
    }

    @FXML
    private void updateItemDetails(ActionEvent event) {
    }

    @FXML
    private void clearItemUpdate(ActionEvent event) {
    }

    @FXML
    private void analyseInExcel(ActionEvent event) {
    }

    @FXML
    private void printAsPdf(ActionEvent event) {
    }

    @FXML
    private void addUser(ActionEvent event) {
         addUserPane.setVisible(true);
        FadeTransition fade = new FadeTransition();
        fade.setDuration(Duration.millis(300));
        fade.setNode(addUserPane);
        fade.setFromValue(0);
        fade.setToValue(1);
        fade.play();
    }

    @FXML
    private void editUser(ActionEvent event) {
         usersModal.setVisible(true);
//        dashboardPane.setDisable(true);
//        employeesPane.setDisable(true);
//        settingsPane.setDisable(true);
        FadeTransition fade = new FadeTransition();
        fade.setDuration(Duration.millis(300));
        fade.setNode(usersModal);
        fade.setFromValue(0);
        fade.setToValue(1);
        fade.play();
    }

    @FXML
    private void deleteUser(ActionEvent event) {
    }

    @FXML
    private void saveUserDetails(ActionEvent event) {
        if (!userName.getText().isEmpty() || !username.getText().isEmpty() || !userPassword.getText().isEmpty() || userDesignation != null || userEntryImage != null) {
            String sql = "INSERT INTO Users(name,userName,userPassword,designation,date,time,userImage) "
                    + "VALUES(?,?,?,?,?,?,?)";
            try {
                String url = "jdbc:sqlite:RestaurantDB.db";
                Connection connection = DriverManager.getConnection(url);
                PreparedStatement ps = connection.prepareStatement(sql);
                FileInputStream fis = new FileInputStream(userFile);
                ps.setString(1, userName.getText());
                ps.setString(2, username.getText());
                ps.setString(3, userPassword.getText());
                ps.setString(4, userDesignation.getValue().toString());
                ps.setString(5, currentDate);
                ps.setString(6, currentTime);
                ps.setBinaryStream(7, (InputStream) fis, (int) userFile.length());
                ps.execute();

                int s = ps.executeUpdate();
                if (s > 0) {
                    Notifications notify = Notifications.create()
                            .graphic(new ImageView(successImg))
                            .hideAfter(Duration.seconds(5))
                            .title("Success")
                            .text("Uploaded Succesfully")
                            .position(Pos.TOP_CENTER);
                    notify.show();
                    resetStockEntry(event);
                } else {
                    Notifications notify = Notifications.create()
                            .graphic(new ImageView(errorImg))
                            .hideAfter(Duration.seconds(5))
                            .title("Failed")
                            .text("Uploaded Unsuccesfully")
                            .position(Pos.TOP_CENTER);
                    notify.show();
                }
            } catch (SQLException e) {
                JOptionPane.showMessageDialog(null, e.getMessage());
                e.getMessage();
                e.printStackTrace();
            } catch (FileNotFoundException ex) {
                JOptionPane.showMessageDialog(null, ex.getMessage());

                Logger.getLogger(ManagementController.class.getName()).log(Level.SEVERE, null, ex);
            }

        } else {
            Alert alert = new Alert(Alert.AlertType.ERROR, "Some Fields Are empty", ButtonType.OK);
            alert.setTitle("Invalid");
            alert.showAndWait();
        }
    }

    @FXML
    private void resetUserEntry(ActionEvent event) {
        userName.setText("");
        username.setText("");
        userPassword.setText("");
        userDesignation.setValue(null);
        
         File file = new File("src/restaurantmanagement/images/user.png");
        selectedFile = file;
        userFile = selectedFile;
        Image image = new Image(selectedFile.toURI().toString());
        userEntryImage.setImage(image);
    }

    @FXML
    private void chooseUserImage(ActionEvent event) {
         fileChooser.setTitle("Open Image");

        //set extension filter
        try {
            fileChooser.getExtensionFilters().addAll(new FileChooser.ExtensionFilter("All images", "*.jpg", "*.jpeg", "*.png", "*.gif"));
        } catch (NullPointerException ex) {
            ex.printStackTrace();
        }

        //show open file dialog
        fileChooser.getInitialDirectory();
        selectedFile = fileChooser.showOpenDialog(null);

        try {
            if (selectedFile != null) {
                String path = selectedFile.getPath();
                selectedFile = new File(path);
                userFile = selectedFile;
                Image image = new Image(selectedFile.toURI().toString());
                userEntryImage.setImage(image);
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    @FXML
    private void exitUserEditModal(MouseEvent event) {
        FadeTransition fade = new FadeTransition();
        fade.setDuration(Duration.millis(300));
        fade.setNode(usersModal);
        fade.setFromValue(1);
        fade.setToValue(0);
        fade.play();
        fade.setOnFinished((ActionEvent events) -> {
            dashboardPane.setDisable(false);
            employeesPane.setDisable(false);
            settingsPane.setDisable(false);
            usersModal.setVisible(false);
        });
    }

    @FXML
    private void updateUserDetails(ActionEvent event) {
    }

    @FXML
    private void clearUserUpdate(ActionEvent event) {
    }

    @FXML
    private void openUsersPane(ActionEvent event) {
          if (dashboardBtn.getStyleClass().size() == 2 && dashBoardIcon.getStyleClass().size() == 2) {

        } else if (dashboardBtn.getStyleClass().size() == 3 && dashBoardIcon.getStyleClass().size() == 3) {
            dashboardBtn.getStyleClass().remove(2);
            dashBoardIcon.getStyleClass().remove(2);
        }
        if (stockItemsBtn.getStyleClass().size() == 2 && stockIcon.getStyleClass().size() == 2) {

        } else if (stockItemsBtn.getStyleClass().size() == 3 && stockIcon.getStyleClass().size() == 3) {
            stockItemsBtn.getStyleClass().remove(2);
            stockIcon.getStyleClass().remove(2);
        }
        if (todayStockBtn.getStyleClass().size() == 2 && todayStockIcon.getStyleClass().size() == 2) {

        } else if (todayStockBtn.getStyleClass().size() == 3 && todayStockIcon.getStyleClass().size() == 3) {
            todayStockBtn.getStyleClass().remove(2);
            todayStockIcon.getStyleClass().remove(2);
        }
        if (employeesBtn.getStyleClass().size() == 2 && employeesIcon.getStyleClass().size() == 2) {

        } else if (employeesBtn.getStyleClass().size() == 3 && employeesIcon.getStyleClass().size() == 3) {
            employeesBtn.getStyleClass().remove(2);
            employeesIcon.getStyleClass().remove(2);
        }
        if (dailySalesBtn.getStyleClass().size() == 2 && dailySalesIcon.getStyleClass().size() == 2) {

        } else if (dailySalesBtn.getStyleClass().size() == 3 && dailySalesIcon.getStyleClass().size() == 3) {
            dailySalesBtn.getStyleClass().remove(2);
            dailySalesIcon.getStyleClass().remove(2);
        }

        if (settingsBtn.getStyleClass().size() == 2 && settingsIcon.getStyleClass().size() == 2) {

        } else if (settingsBtn.getStyleClass().size() == 3 && settingsIcon.getStyleClass().size() == 3) {
            settingsBtn.getStyleClass().remove(2);
            settingsIcon.getStyleClass().remove(2);
        }

        if (event.getSource() == usersBtn) {
            usersPane.setVisible(true);
            FadeTransition fade = new FadeTransition();
            fade.setDuration(Duration.millis(300));
            fade.setNode(usersPane);
            fade.setFromValue(0);
            fade.setToValue(1);
            fade.play();
        }

        dashboardPane.setVisible(false);
        employeesPane.setVisible(false);
        todayStockPane.setVisible(false);
        totalSalesPane.setVisible(false);
        stockPane.setVisible(false);
        dailySalesPane.setVisible(false);
        settingsPane.setVisible(false);
    }

    @FXML
    private void backFromAddUsers(ActionEvent event) {
         FadeTransition fade = new FadeTransition();
        fade.setDuration(Duration.millis(300));
        fade.setNode(addUserPane);
        fade.setFromValue(1);
        fade.setToValue(0);
        fade.play();
        fade.setOnFinished((ActionEvent events) -> {
            addUserPane.setVisible(false);
        });
    }

}
