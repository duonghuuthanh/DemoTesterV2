/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.dht.services;

import com.dht.pojo.Choice;
import com.dht.pojo.Question;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author admin
 */
public class QuestionService {

    public boolean addQuestion(Question q, List<Choice> choices) throws SQLException {
        try ( Connection conn = JdbcUtils.getConn()) {
            conn.setAutoCommit(false);
            String sql = "INSERT INTO question(id, content, category_id) VALUES(?, ?, ?)"; // sql injection
            PreparedStatement stm = conn.prepareCall(sql);
            stm.setString(1, q.getId());
            stm.setString(2, q.getContent());
            stm.setInt(3, q.getCategoryId());
            int r = stm.executeUpdate();

            if (r > 0) {
                sql = "INSERT INTO choice(id, content, is_correct, question_id) VALUES(?, ?, ?, ?)";
                PreparedStatement stm1 = conn.prepareCall(sql);
                for (Choice c : choices) {
                    stm1.setString(1, c.getId());
                    stm1.setString(2, c.getContent());
                    stm1.setBoolean(3, c.isCorrect());
                    stm1.setString(4, q.getId());
                    stm1.executeUpdate();
                }
            }

            try {
                conn.commit();
                return true;
            } catch (SQLException ex) {
                System.err.println(ex.getMessage());
                return false;
            }
        }
    }
    
    public List<Question> getQuestions(String kw) throws SQLException {
        List<Question> questions = new ArrayList<>();
        try (Connection conn = JdbcUtils.getConn()) {
            String sql = "SELECT * FROM question";
            if (kw != null && !kw.isEmpty()) 
                sql += " WHERE content like concat('%', ?, '%')";
            PreparedStatement stm = conn.prepareCall(sql);
            if (kw != null && !kw.isEmpty()) 
                stm.setString(1, kw);
            
            ResultSet rs = stm.executeQuery();
            while (rs.next()) {
                Question q = new Question(rs.getString("id"), rs.getString("content"), rs.getInt("category_id"));
                questions.add(q);
            }
        }
        
        return questions;
    }
    
    public boolean deleteQuestion(String id) throws SQLException {
        try (Connection conn = JdbcUtils.getConn()) {
            String sql = "DELETE FROM question WHERE id=?";
            PreparedStatement stm = conn.prepareCall(sql);
            stm.setString(1, id);
            
            return stm.executeUpdate() > 0;
        }
    }
}
