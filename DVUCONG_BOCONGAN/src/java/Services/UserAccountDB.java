/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Services;

import Model.GovernmentAgency;
import Model.UserAccount;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.sql.ResultSet;

/**
 *
 * @author DELL
 */
public class UserAccountDB extends DBContext {

    public ArrayList<UserAccount> getAllAccountsByRole(String role) {
        ArrayList<UserAccount> list = new ArrayList<>();
        try {
            String sql = "SELECT ua.accountId, ua.username, ua.password, ua.role, "
                    + "       ua.agencyId, ga.agencyName "
                    + "FROM UserAccount ua "
                    + "LEFT JOIN GovernmentAgency ga ON ua.agencyId = ga.agencyId "
                    + "WHERE ua.role = ?";

            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setString(1, role);
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                UserAccount user = new UserAccount();
                user.setAccountId(rs.getInt("accountId"));
                user.setUsername(rs.getString("username"));
                user.setPassword(rs.getString("password"));
                user.setRole(rs.getString("role"));

                // Lấy thông tin cơ quan nếu có
                GovernmentAgency agency = new GovernmentAgency();
                agency.setAgencyId(rs.getInt("agencyId"));
                agency.setAgencyName(rs.getString("agencyName"));
                user.setAgencyId(agency);

                list.add(user);
            }
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());

        }
        return list;
    }

    public UserAccount login(String username, String password, String role) {
        UserAccount user = null;
        try {
            String sql = "SELECT ua.accountId, ua.username, ua.password, ua.role, "
                    + "ua.agencyId, ga.agencyName "
                    + "FROM UserAccount ua "
                    + "LEFT JOIN GovernmentAgency ga ON ua.agencyId = ga.agencyId "
                    + "WHERE ua.username = ? AND ua.password = ? AND ua.role = ?";

            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setString(1, username);
            ps.setString(2, password);
            ps.setString(3, role);

            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                user = new UserAccount();
                user.setAccountId(rs.getInt("accountId"));
                user.setUsername(rs.getString("username"));
                user.setPassword(rs.getString("password"));
                user.setRole(rs.getString("role"));

                GovernmentAgency agency = new GovernmentAgency();
                agency.setAgencyId(rs.getInt("agencyId"));
                agency.setAgencyName(rs.getString("agencyName"));
                user.setAgencyId(agency);
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return user;
    }

}
