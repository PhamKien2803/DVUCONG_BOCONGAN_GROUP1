/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Services;

import Model.AdministrativeComplaint;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 *
 * @author DELL
 */
public class AdministrativeComplaintDB extends DBContext {

    // Phương thức thêm khiếu nại
    public boolean insertComplaint(AdministrativeComplaint complaint) {
        String sql = "INSERT INTO AdministrativeComplaint (businessId, complaintType, complaintDetails, submissionDate) VALUES (?, ?, ?, ?)";
        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setString(1, complaint.getBusinessId().getBusinessId());
            stmt.setString(2, complaint.getComplaintType());
            stmt.setString(3, complaint.getComplaintDetails());
            stmt.setDate(4, new java.sql.Date(complaint.getSubmissionDate().getTime()));

            int rowsInserted = stmt.executeUpdate();
            return rowsInserted > 0; // Trả về true nếu thêm thành công
        } catch (SQLException ex) {
            System.out.println("❌ Lỗi: " + ex.getMessage());
            return false;
        }
    }

}
