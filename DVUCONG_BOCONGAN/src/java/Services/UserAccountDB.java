/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Services;

import Model.Citizen;
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
                user.setAccountId(rs.getString("accountId"));
                user.setUsername(rs.getString("username"));
                user.setPassword(rs.getString("password"));
                user.setRole(rs.getInt("role"));

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

    public UserAccount GovermentLogin(String username, String password, String role) {
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
                user.setAccountId(rs.getString("accountId"));
                user.setUsername(rs.getString("username"));
                user.setPassword(rs.getString("password"));
                user.setRole(rs.getInt("role"));

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

    public UserAccount citizenLogin(String username, String password, String role) {
        UserAccount user = null;
        try {
            String sql = "SELECT us.[accountId]\n"
                    + "      ,us.[username]\n"
                    + "      ,us.[password]\n"
                    + "      ,us.[role]\n"
                    + "      ,us.[citizenId]\n"
                    + "      ,us.[isActive]\n"
                    + "	  ,c.[name]\n"
                    + "  FROM [DVUCONG_BOCONGAN].[dbo].[UserAccount] us\n"
                    + "  LEFT JOIN Citizen c ON us.citizenId = c.citizenId\n"
                    + "  WHERE us.[username] = ? AND us.[password] = ? AND us.role = ?";

            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setString(1, username);
            ps.setString(2, password);
            ps.setString(3, role);

            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                user = new UserAccount();
                user.setAccountId(rs.getString("accountId"));
                user.setUsername(rs.getString("username"));
                user.setPassword(rs.getString("password"));
                user.setRole(rs.getInt("role"));

                Citizen ci = new Citizen();
                ci.setCitizenId(rs.getInt("citizenId"));
                ci.setName(rs.getString("name"));

                user.setCitizenId(ci);
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return user;
    }

    public UserAccount userLogin(String username, String password) {
        UserAccount user = null;
        try {
            String sql = "SELECT us.[accountId], us.[username], us.[password], us.[role], "
                    + "us.[citizenId], us.[isActive] "
                    + "FROM [DVUCONG_BOCONGAN].[dbo].[UserAccount] us "
                    + "WHERE us.[username] = ? AND us.[password] = ? AND us.[isActive] = 1";

            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setString(1, username);
            ps.setString(2, password);

            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                user = new UserAccount();
                user.setAccountId(rs.getString("accountId"));
                user.setUsername(rs.getString("username"));
                user.setPassword(rs.getString("password"));
                user.setRole(rs.getInt("role"));

            } else {
                System.out.println("Sai tài khoản hoặc mật khẩu.");
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return user;
    }

    public static void main(String[] args) {
        UserAccountDB db = new UserAccountDB();
        db.userLogin("kien28", "123");
        System.out.println(db);
    }

}
