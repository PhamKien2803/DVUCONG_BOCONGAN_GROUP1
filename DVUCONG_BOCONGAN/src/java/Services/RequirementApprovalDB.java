/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Services;

import Model.Citizen;
import Model.GovernmentAgency;
import Model.PublicService;
import Model.RequirementApproval;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.sql.ResultSet;

/**
 *
 * @author DELL
 */
public class RequirementApprovalDB extends DBContext {

    public static void main(String[] args) {
        // Tạo đối tượng của RequirementApprovalDB (giả sử đã có kết nối DB)
        RequirementApprovalDB db = new RequirementApprovalDB();

        // Gọi hàm lấy danh sách yêu cầu có agencyId = 1
        ArrayList<RequirementApproval> list = db.getProcedureIdentification();

        // Kiểm tra danh sách lấy được
        if (list.isEmpty()) {
            System.out.println("⚠️ Không có yêu cầu nào được tìm thấy.");
        } else {
            System.out.println("✅ Danh sách yêu cầu phê duyệt:");
            for (RequirementApproval req : list) {
                System.out.println("----------------------------------");
                System.out.println("🆔 Mã yêu cầu: " + req.getRequestId());
                System.out.println("👤 Công dân: " + req.getCitizenId().getName());
                System.out.println("📞 SĐT: " + req.getCitizenId().getPhoneNumber());
                System.out.println("📌 Loại người nộp: " + req.getApplicantType());
                System.out.println("🔎 Dịch vụ: " + req.getServiceId().getServiceName());
                System.out.println("📅 Ngày nộp: " + req.getSubmissionDate());
                System.out.println("📜 Chi tiết: " + req.getDetails());
                System.out.println("📌 Trạng thái: " + req.getStatus());
                System.out.println("🏢 Cơ quan xử lý: " + req.getAgencyId().getAgencyName());
            }
        }
    }

    public void createProcedureIdentification(
            Citizen citizen, String applicantType,
            PublicService service, String details, String submissionDate,
            String status) {

        try {
            String sql = "INSERT INTO [dbo].[RequirementApproval] "
                    + "([citizenId], [applicantType], "
                    + "[serviceId], [details], [submissionDate], [status], [agencyId]) "
                    + "VALUES (?, ?, ?, ?, ?, ?, ?)";

            PreparedStatement stm = connection.prepareStatement(sql);

            stm.setInt(1, citizen.getCitizenId());
            stm.setString(2, applicantType);
            stm.setString(3, service.getServiceId());
            stm.setString(4, details);
            stm.setString(5, submissionDate);
            stm.setString(6, status);
            stm.setInt(7, 1);

            int rowsAffected = stm.executeUpdate();
            if (rowsAffected > 0) {
                System.out.println("✅ Thêm yêu cầu phê duyệt thành công!");
            } else {
                System.out.println("⚠️ Không thể thêm yêu cầu phê duyệt.");
            }
        } catch (SQLException e) {
            System.out.println("❌ Lỗi khi thêm yêu cầu phê duyệt: " + e.getMessage());
        }
    }

    public ArrayList<RequirementApproval> getProcedureIdentification() {
        ArrayList<RequirementApproval> list = new ArrayList<>();
        try {
            // Truy vấn chỉ lấy các yêu cầu có agencyId = 1
            String sql = "SELECT r.requestId, "
                    + "       c.citizenId, c.name, c.phoneNumber, c.address, c.emailAddress, c.dateOfBirth, "
                    + "       r.applicantType, "
                    + "       s.serviceId, s.serviceName, s.description, s.category, "
                    + "       r.details, r.submissionDate, r.status, "
                    + "       g.agencyId, g.agencyName, g.department, g.address AS agencyAddress, "
                    + "       g.phoneNumber AS agencyPhone, g.emailAddress AS agencyEmail "
                    + "FROM RequirementApproval r "
                    + "LEFT JOIN Citizen c ON r.citizenId = c.citizenId "
                    + "LEFT JOIN PublicService s ON r.serviceId = s.serviceId "
                    + "LEFT JOIN GovernmentAgency g ON r.agencyId = g.agencyId "
                    + "WHERE r.agencyId = 1";

            PreparedStatement stm = connection.prepareStatement(sql);
            ResultSet rs = stm.executeQuery();

            while (rs.next()) {
                RequirementApproval req = new RequirementApproval();
                req.setRequestId(rs.getString("requestId"));
                req.setApplicantType(rs.getString("applicantType"));
                req.setDetails(rs.getString("details"));
                req.setSubmissionDate(rs.getString("submissionDate"));
                req.setStatus(rs.getString("status"));

                // Set thông tin công dân
                Citizen citizen = new Citizen();
                citizen.setCitizenId(rs.getInt("citizenId"));
                citizen.setName(rs.getString("name"));
                citizen.setPhoneNumber(rs.getString("phoneNumber"));
                citizen.setAddress(rs.getString("address"));
                citizen.setEmailAddress(rs.getString("emailAddress"));
                citizen.setDateOfBirth(rs.getString("dateOfBirth"));
                req.setCitizenId(citizen);

                // Set thông tin dịch vụ công
                PublicService service = new PublicService();
                service.setServiceId(rs.getString("serviceId"));
                service.setServiceName(rs.getString("serviceName"));
                service.setDescription(rs.getString("description"));
                service.setCategory(rs.getString("category"));
                req.setServiceId(service);

                // Set thông tin cơ quan chính phủ
                GovernmentAgency agency = new GovernmentAgency();
                agency.setAgencyId(rs.getInt("agencyId"));
                agency.setAgencyName(rs.getString("agencyName"));
                agency.setDepartment(rs.getString("department"));
                agency.setAddress(rs.getString("agencyAddress"));
                agency.setPhoneNumber(rs.getString("agencyPhone"));
                agency.setEmailAddress(rs.getString("agencyEmail"));
                req.setAgencyId(agency);

                list.add(req);
            }
        } catch (SQLException e) {
            System.out.println("❌ Lỗi khi lấy danh sách yêu cầu phê duyệt: " + e.getMessage());
        }
        return list;
    }

    public boolean updateStatus(String requestId, String status) {
        String sql = "UPDATE RequirementApproval SET status = ? WHERE requestId = ?";

        try (PreparedStatement stm = connection.prepareStatement(sql);) {

            stm.setString(1, status);
            stm.setString(2, requestId);
            int rowsUpdated = stm.executeUpdate();
            return rowsUpdated > 0;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    public void createApprovalRequest(
            String requestId, PublicService service,
            String applicantType, String details, String submissionDate,
            String status, int agencyId) {

        String sql = "INSERT INTO [dbo].[RequirementApproval] "
                + "([businessId], [serviceId], [applicantType], "
                + "[details], [submissionDate], [status], [agencyId]) "
                + "VALUES (?, ?, ?, ?, ?, ?, ?)";

        try (PreparedStatement stm = connection.prepareStatement(sql)) {
            stm.setString(1, "BIZ001");
            stm.setString(2, service.getServiceId());
            stm.setString(3, applicantType);
            stm.setString(4, details);
            stm.setString(5, submissionDate);
            stm.setString(6, status);
            stm.setInt(7, 1);

            int rowsAffected = stm.executeUpdate();
            if (rowsAffected > 0) {
                System.out.println("✅ Yêu cầu phê duyệt đã được tạo thành công!");
            } else {
                System.out.println("⚠️ Không thể tạo yêu cầu phê duyệt.");
            }
        } catch (SQLException e) {
            System.out.println("❌ Lỗi khi tạo yêu cầu phê duyệt: " + e.getMessage());
        }
    }

}
