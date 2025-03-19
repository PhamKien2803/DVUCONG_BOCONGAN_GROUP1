/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Services;

import Model.Business;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.UUID;

/**
 *
 * @author DELL
 */
public class BusinessDB extends DBContext {

    public static void main(String[] args) {
        BusinessDB db = new BusinessDB();
        Business list = db.getBussinessforById("BS001");
        System.out.println(list);

    }

    public String createInformationCitizen(String name, String phoneNumber, String address, String emailAddress) {
        String businessId = null;
        try {
            // Chèn dữ liệu vào bảng Citizen
            String sql = "INSERT INTO [dbo].[Business] ([phoneNumber], [address], [name], [emailAddress]) VALUES (?, ?, ?, ?)";
            PreparedStatement stm = connection.prepareStatement(sql);
            stm.setString(1, phoneNumber);
            stm.setString(2, address);
            stm.setString(3, name);
            stm.setString(4, emailAddress);

            int affectedRows = stm.executeUpdate();
            if (affectedRows > 0) {
                // Lấy ID vừa chèn bằng cách truy vấn lại
                String getIdQuery = "SELECT TOP 1 businessId FROM [dbo].[Business] WHERE emailAddress = ? ORDER BY businessId DESC";
                PreparedStatement getIdStm = connection.prepareStatement(getIdQuery);
                getIdStm.setString(1, emailAddress);
                ResultSet rs = getIdStm.executeQuery();
                if (rs.next()) {
                    businessId = rs.getString("businessId");
                }
            }

            System.out.println("✅ Thêm công dân thành công, ID: " + businessId);
        } catch (SQLException e) {
            System.out.println("❌ Lỗi khi thêm công dân: " + e.getMessage());
            e.printStackTrace();
        }
        return businessId;
    }

    public Business getBussinessforById(String bussinessId) {
        Business bussiness = null;
        try {
            String sql = "SELECT [businessId], [phoneNumber], [address], [name], [emailAddress] "
                    + "FROM [DVUCONG_BOCONGAN].[dbo].[Business] WHERE businessId = ?";
            PreparedStatement stm = connection.prepareStatement(sql);
            stm.setString(1, bussinessId);
            ResultSet rs = stm.executeQuery();

            if (rs.next()) {
                bussiness = new Business();
                bussiness.setBusinessId("bussinessId");
                bussiness.setPhoneNumber(rs.getString("phoneNumber"));
                bussiness.setAddress(rs.getString("address"));
                bussiness.setName(rs.getString("name"));
                bussiness.setEmailAddress(rs.getString("emailAddress"));
            }
        } catch (SQLException e) {
            System.out.println("❌ Lỗi khi lấy thông tin công dân: " + e.getMessage());
        }
        return bussiness;
    }
}
