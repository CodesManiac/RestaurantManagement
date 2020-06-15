/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package restaurantmanagement.database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JOptionPane;

/**
 *
 * @author toshiba
 */
public class RestaurantDatabase {
     public static Connection ConnectDatabase() throws ClassNotFoundException, SQLException {
        Connection connection = null;
        Class.forName("org.sqlite.JDBC");
        connection = DriverManager.getConnection("jdbc:sqlite:RestaurantDB.db");
        if (connection != null) {
            System.out.println("Connected Successfully");
            JOptionPane.showMessageDialog(null, "Connected Sucessfully");

        } else {
            JOptionPane.showMessageDialog(null, " Could not Connect");
        }

        return connection;
    }

    public static void createTables() throws ClassNotFoundException, SQLException {
        ConnectDatabase();
        String url = "jdbc:sqlite:RestaurantDB.db";
        String usersTable="CREATE TABLE IF NOT EXISTS Users(userId INTEGER PRIMARY KEY AUTOINCREMENT,name TEXT NOT NULL,userName TEXT NOT NULL,userPassword TEXT NOT NULL,designation TEXT NOT NULL,date TEXT,time TEXT,userImage BLOB)";
        String receiptTable = "CREATE TABLE IF NOT EXISTS Receipt(receiptId INTEGER PRIMARY KEY AUTOINCREMENT,salesAttendant TEXT NOT NULL,"
                + "itemsBought TEXT, date TEXT,time TEXT,"
                + "totalCost INTEGER NOT NULL,cashPaid INTEGER NOT NULL,balance INTEGER NOT NULL )";
        String stockTable = "CREATE TABLE IF NOT EXISTS Stock(itemId INTEGER PRIMARY KEY AUTOINCREMENT,itemName TEXT NOT NULL,type TEXT NOT NULL,"
                + "price INTEGER NOT NULL,quantity INTEGER NOT NULL,unit TEXT NOT NULL,date TEXT,time TEXT, itemImage BLOB);";
        String employeesTable = "CREATE TABLE IF NOT EXISTS Employees(employeeId INTEGER PRIMARY KEY AUTOINCREMENT,firstName TEXT NOT NULL,lastName TEXT NOT NULL,"
                + "gender TEXT NOT NULL,homeAddress TEXT NOT NULL,maritalStatus TEXT,dateOfBirth TEXT,phoneNumber TEXT NOT NULL,"
                + "designation TEXT NOT NULL,employeeImage BLOB);";
        try {
            Connection conn = DriverManager.getConnection(url);
            Statement statement = conn.createStatement();
            statement.execute(usersTable);
            statement.execute(receiptTable);
            statement.execute(stockTable);
            statement.execute(employeesTable);
            JOptionPane.showMessageDialog(null, "Tables Created Successfully");

        } catch (Exception e) {
            e.getMessage();
            JOptionPane.showMessageDialog(null, e);
            e.printStackTrace();
        }

    }
     public static void main(String[] args) throws ClassNotFoundException, SQLException {
                createTables();
    }
    
}
