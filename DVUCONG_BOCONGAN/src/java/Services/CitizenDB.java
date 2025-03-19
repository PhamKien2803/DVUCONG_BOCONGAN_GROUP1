/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Services;

import Model.Citizen;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;


/**
 *
 * @author DELL
 */
public class CitizenDB extends DBContext {

    public static void main(String[] args) {
        CitizenDB db = new CitizenDB();
        Citizen list = db.getCitizenInforById(8);
        System.out.println(list);

    }

    public String createInformationCitizen(String name, String phoneNumber, String address, String emailAddress, String dateOfBirth) {
        String citizenId = null;
        try {
            // Chèn dữ liệu vào bảng Citizen
            String sql = "INSERT INTO [dbo].[Citizen] ([phoneNumber], [address], [dateOfBirth], [name], [emailAddress]) VALUES (?, ?, ?, ?, ?)";
            PreparedStatement stm = connection.prepareStatement(sql);
            stm.setString(1, phoneNumber);
            stm.setString(2, address);
            stm.setString(3, dateOfBirth);
            stm.setString(4, name);
            stm.setString(5, emailAddress);

            int affectedRows = stm.executeUpdate();
            if (affectedRows > 0) {
                // Lấy ID vừa chèn bằng cách truy vấn lại
                String getIdQuery = "SELECT TOP 1 citizenId FROM [dbo].[Citizen] WHERE emailAddress = ? ORDER BY citizenId DESC";
                PreparedStatement getIdStm = connection.prepareStatement(getIdQuery);
                getIdStm.setString(1, emailAddress);
                ResultSet rs = getIdStm.executeQuery();
                if (rs.next()) {
                    citizenId = rs.getString("citizenId");
                }
            }

            System.out.println("✅ Thêm công dân thành công, ID: " + citizenId);
        } catch (SQLException e) {
            System.out.println("❌ Lỗi khi thêm công dân: " + e.getMessage());
            e.printStackTrace();
        }
        return citizenId;
    }

    public Citizen getCitizenInforById(int citizenId) {
        Citizen citizen = null;
        try {
            String sql = "SELECT [citizenId], [phoneNumber], [address], [dateOfBirth], [name], [emailAddress] "
                    + "FROM [DVUCONG_BOCONGAN].[dbo].[Citizen] WHERE citizenId = ?";
            PreparedStatement stm = connection.prepareStatement(sql);
            stm.setInt(1, citizenId);
            ResultSet rs = stm.executeQuery();

            if (rs.next()) {
                citizen = new Citizen();
                citizen.setCitizenId(rs.getInt("citizenId"));
                citizen.setPhoneNumber(rs.getString("phoneNumber"));
                citizen.setAddress(rs.getString("address"));
                citizen.setDateOfBirth(rs.getString("dateOfBirth"));
                citizen.setName(rs.getString("name"));
                citizen.setEmailAddress(rs.getString("emailAddress"));
            }
        } catch (SQLException e) {
            System.out.println("❌ Lỗi khi lấy thông tin công dân: " + e.getMessage());
        }
        return citizen;
    }

}
