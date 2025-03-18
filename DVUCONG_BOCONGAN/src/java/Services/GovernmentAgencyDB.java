/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Services;

import Model.GovernmentAgency;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.ResultSet;

/**
 *
 * @author DELL
 */
public class GovernmentAgencyDB extends DBContext {

    public static void main(String[] args) {
        GovernmentAgencyDB db = new GovernmentAgencyDB();
        GovernmentAgency list = db.getGovernmentAgencyById("AG001");
        System.out.println(list);

    }

    public GovernmentAgency getGovernmentAgencyById(String agencyId) {
        GovernmentAgency agency = null;
        try {
            String sql = "SELECT [agencyId], [agencyName], [department], [address], "
                    + "[phoneNumber], [emailAddress] "
                    + "FROM [DVUCONG_BOCONGAN].[dbo].[GovernmentAgency] WHERE agencyId = ?";
            PreparedStatement stm = connection.prepareStatement(sql);
            stm.setString(1, agencyId);
            ResultSet rs = stm.executeQuery();

            if (rs.next()) {
                agency = new GovernmentAgency();
                agency.setAgencyId(rs.getString("agencyId"));
                agency.setAgencyName(rs.getString("agencyName"));
                agency.setDepartment(rs.getString("department"));
                agency.setAddress(rs.getString("address"));
                agency.setPhoneNumber(rs.getString("phoneNumber"));
                agency.setEmailAddress(rs.getString("emailAddress"));
            }
        } catch (SQLException e) {
            System.out.println("❌ Lỗi khi lấy thông tin cơ quan chính phủ: " + e.getMessage());
        }
        return agency;
    }

}
