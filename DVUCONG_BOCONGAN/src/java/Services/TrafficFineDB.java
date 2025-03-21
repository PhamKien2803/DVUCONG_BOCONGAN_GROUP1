package Services;

import Model.TrafficFine;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class TrafficFineDB extends DBContext {

     // Phương thức để thêm một lỗi giao thông vào cơ sở dữ liệu
    public int addTrafficFine(TrafficFine fine) {
        // Kiểm tra kết nối database
        if (connection == null) {
            System.err.println("Lỗi: Kết nối cơ sở dữ liệu chưa được khởi tạo.");
            throw new IllegalStateException("Database connection is not initialized.");
        }

        // Kiểm tra dữ liệu đầu vào
        if (fine == null || 
            fine.getCitizenId() == null || fine.getCitizenId().isEmpty() ||
            fine.getViolationType() == null || fine.getViolationType().isEmpty() ||
            fine.getFineAmount() <= 0 ||
            fine.getFineDate() == null || fine.getViolationDate() == null ||
            fine.getStatus() == null || fine.getStatus().isEmpty()) {
            
            System.err.println("Lỗi: Dữ liệu đầu vào không hợp lệ.");
            throw new IllegalArgumentException("Dữ liệu đầu vào không hợp lệ. Vui lòng kiểm tra lại.");
        }

        // Câu lệnh SQL để thêm dữ liệu
        String sql = "INSERT INTO TrafficFine (citizenId, violationType, fineAmount, fineDate, violationDate, status) " +
                     "VALUES (?, ?, ?, ?, ?, ?)";

        try (PreparedStatement stmt = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {
            stmt.setInt(1, fine.getCitizenId());
            stmt.setString(2, fine.getViolationType());
            stmt.setFloat(3, fine.getFineAmount());
            stmt.setDate(4, new java.sql.Date(fine.getFineDate().getTime()));
            stmt.setDate(5, new java.sql.Date(fine.getViolationDate().getTime()));
            stmt.setString(6, fine.getStatus());

            System.out.println("Thực thi câu lệnh SQL: " + stmt.toString()); // In ra SQL để debug

            // Thực hiện truy vấn
            int affectedRows = stmt.executeUpdate();
            if (affectedRows > 0) {
                // Lấy ID được tự động tạo ra
                try (ResultSet generatedKeys = stmt.getGeneratedKeys()) {
                    if (generatedKeys.next()) {
                        int generatedId = generatedKeys.getInt(1);
                        System.out.println("Thêm lỗi giao thông thành công với ID: " + generatedId);
                        return generatedId;
                    }
                }
            }
        } catch (SQLException e) {
            e.printStackTrace(); // In lỗi ra console
            System.err.println("Lỗi khi thêm dữ liệu vào database: " + e.getMessage());
            throw new RuntimeException("Lỗi khi thêm dữ liệu vào database. Vui lòng kiểm tra log để biết thêm chi tiết.", e);
        }

        System.err.println("Không thể thêm lỗi giao thông vào database.");
        return -1; // Trả về -1 nếu không thêm thành công
    }
    // Lấy danh sách lỗi vi phạm theo citizenId
public List<TrafficFine> getFinesByCitizenId(String citizenId) {
    String sql = "SELECT * FROM TrafficFine WHERE citizenId = ?";
    List<TrafficFine> fines = new ArrayList<>();

    try (PreparedStatement stmt = connection.prepareStatement(sql)) {
        stmt.setString(1, citizenId);
        ResultSet rs = stmt.executeQuery();

        while (rs.next()) {
            fines.add(new TrafficFine(
                rs.getString("fineId"),
                rs.getString("citizenId"),
                rs.getString("violationType"),
                rs.getFloat("fineAmount"),
                rs.getDate("fineDate"),
                rs.getDate("violationDate"),
                rs.getString("status")
            ));
        }
    } catch (SQLException e) {
        e.printStackTrace();
    }
    return fines;
}


    // Phương thức để lấy thông tin người bị phạt từ fineId
    public TrafficFine getTrafficFineById(int fineId) {  // Sửa kiểu dữ liệu từ String -> int
        String sql = "SELECT * FROM TrafficFine WHERE fineId = ?";
        TrafficFine fine = null;

        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setInt(1, fineId);  // Sử dụng setInt thay vì setString
            try (ResultSet rs = stmt.executeQuery()) {  // Đóng ResultSet khi hoàn thành
                if (rs.next()) {
                    fine = new TrafficFine(
                        rs.getInt("fineId") + "",  // Chuyển int thành String nếu model yêu cầu
                        rs.getString("citizenId"),
                        rs.getString("violationType"),
                        rs.getFloat("fineAmount"),
                        rs.getDate("fineDate"),
                        rs.getDate("violationDate"),
                        rs.getString("status")
                    );
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return fine;
    }
}
