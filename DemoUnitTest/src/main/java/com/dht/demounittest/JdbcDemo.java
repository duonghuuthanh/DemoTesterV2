/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.dht.demounittest;

import com.dht.pojo.Question;
import com.dht.services.QuestionService;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @author admin
 */
public class JdbcDemo {
    public static void main(String[] args) throws ClassNotFoundException, SQLException {
           Question q = new Question("This is ... engineer!", 1);
           QuestionService s = new QuestionService();
           s.addQuestion(q, null);
        
//        Connection conn = JdbcUtils.getConn();
//        
//        // B3 Thuc thi truy van
//        Statement stm = conn.createStatement();
//        // Truy van du lieu --> select
//        ResultSet rs = stm.executeQuery("SELECT * FROM category");
//        while (rs.next()) {
//            int id = rs.getInt("id");
//            String name = rs.getString("name");
//            System.out.printf("%d - %s\n", id, name);
//        }
        
        // Truy van dinh nghia du lieu --> insert, update, delete
//        int r = stm.executeUpdate("INSERT INTO category(name) VALUES('Prep')");
//        System.out.println(r);
        
        // B4 Dong ket noi
//        conn.close();
    }
}
