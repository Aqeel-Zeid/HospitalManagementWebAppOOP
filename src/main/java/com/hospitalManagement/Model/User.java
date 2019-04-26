package com.hospitalManagement.Model;

import com.hospitalManagement.util.DB.DatabaseConnector;

import javax.crypto.Cipher;
import javax.crypto.spec.SecretKeySpec;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;

public class User {
    //        out.println(request.getParameter("Name"));
    static final String key = "Jumanji";
    String Name;


    String Email;
    String Address;
    String Password1;
    String Password2;
    String Phone;
    String RecoveryEmail;
    String NIC;

    public String getType() {
        return Type;
    }

    String Type;
    int ID;

    public User(String name, String email, String address, String password1, String password2, String phone, String recoveryEmail, String NIC, String type) {
        Name = name;
        Email = email;
        Address = address;
        try {
            Password1 = encrypt(password1, key);
            Password2 = encrypt(password2, key);
        } catch (Exception e) {
            e.printStackTrace();
        }
        Phone = phone;
        RecoveryEmail = recoveryEmail;
        this.NIC = NIC;
        Type = type;
    }

    public void setEmail(String email) {
        Email = email;
    }

    public void addToDB() {
        String sql = "INSERT INTO user (firstName, NIC, Address, password , type , email, phone, recoveryEmail ) " +
                "VALUES ('" +
                Name + "','" + NIC + "','" + Address + "','" + this.Password1 + "','" + Type + "','" + Email + "','" + Phone + "','" + RecoveryEmail + "');";
        DatabaseConnector.insertQuery(sql);
        System.out.println("User Added");
    }

    public int validate() {
        return 0;
    }

    public User(String emailz) {
        //System.out.println("parameter : " + emailz);

        //System.out.println("Inside Constructor of User with email : " + emailz);

        this.Email = emailz;
        //System.out.println("set the email of User Method to  : " + this.Email);
        getUserFromDB(this.Email);
        // System.out.println("Attributes of The User After Fetching  : " + this.getEmail() + " " + this.Password1 + " " + this.Name);


    }

    public boolean login(String password) {
        System.out.println("Login Method With Password as Parameter :  " + password);
        try {
            String encryptedPassword = encrypt(password, key);
            // System.out.println("Encrypted Version of Password : " + encryptedPassword);
            // System.out.println("Encrypted Version of Password  from User : " + this.Password1);
            // System.out.println(" if( this.Password1.equals(encryptedPassword)) : " + this.Password1.equals(encryptedPassword));
            if (this.Password1.equals(encryptedPassword)) return true;
            else return false;
        } catch (Exception e) {
            e.printStackTrace();
        }

        return false;
    }

    public static String encrypt(String strClearText, String strKey) throws Exception {
        String strData = "";

        try {
            SecretKeySpec skeyspec = new SecretKeySpec(strKey.getBytes(), "Blowfish");
            Cipher cipher = Cipher.getInstance("Blowfish");
            cipher.init(Cipher.ENCRYPT_MODE, skeyspec);
            byte[] encrypted = cipher.doFinal(strClearText.getBytes());
            strData = new String(encrypted);

        } catch (Exception e) {
            e.printStackTrace();
            throw new Exception(e);
        }
        return strData;
    }

    public static String decrypt(String strEncrypted, String strKey) throws Exception {
        String strData = "";

        try {
            SecretKeySpec skeyspec = new SecretKeySpec(strKey.getBytes(), "Blowfish");
            Cipher cipher = Cipher.getInstance("Blowfish");
            cipher.init(Cipher.DECRYPT_MODE, skeyspec);
            byte[] decrypted = cipher.doFinal(strEncrypted.getBytes());
            strData = new String(decrypted);

        } catch (Exception e) {
            e.printStackTrace();
            throw new Exception(e);
        }
        return strData;
    }

    public String getEmail() {
        return Email;
    }

    public String getPassword1() {
        return Password1;
    }

    public void getUserFromDB(String email2) {
        String sql = "SELECT * FROM user WHERE email = '" + email2 + "';";
        ResultSet rs = DatabaseConnector.selectQueryDB(sql);
        try {
            while (rs.next()) {
                this.Name = rs.getString("FirstName");
                this.Email = rs.getString("email");
                this.Password1 = rs.getString("Password");
                this.RecoveryEmail = rs.getString("recoveryEmail");
                this.Phone = rs.getString("phone");
                this.Type = rs.getString("type");
                this.Address = rs.getString("Address");
                this.ID = rs.getInt("ID");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
