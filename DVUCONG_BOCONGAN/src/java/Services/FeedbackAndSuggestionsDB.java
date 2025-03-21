/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Services;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 *
 * @author DELL
 */
public class FeedbackAndSuggestionsDB extends DBContext {

    public void createFeedback(String feedbackId, String citizenName, String message, String submissionDate) {
        String sql = "INSERT INTO FeedbackAndSuggestions (feedbackId, citizenName, message, submissionDate) VALUES (?, ?, ?, ?)";

        try (PreparedStatement stm = connection.prepareStatement(sql)) {

            stm.setString(1, feedbackId);
            stm.setString(2, citizenName);
            stm.setString(3, message);
            stm.setString(4, submissionDate);

            stm.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

}
