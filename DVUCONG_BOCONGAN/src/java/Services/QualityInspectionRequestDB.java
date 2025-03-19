package Services;

import Model.Business;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 * DAO class for QualityInspectionRequest
 */
public class QualityInspectionRequestDB extends DBContext {

    public void registerQualityInspectionRequest(
            String requestId, String productType,
            String requestDate, String status, String inspectionDetails) {

        String sql = "INSERT INTO [dbo].[QualityInspectionRequest] "
                + "([requestId], [businessId], [productType], [requestDate], [status], [inspectionDetails]) "
                + "VALUES (?, ?, ?, ?, ?, ?)";

        try (PreparedStatement stm = connection.prepareStatement(sql)) {
            stm.setString(1, requestId);
            stm.setString(2, "BIZ001");
            stm.setString(3, productType);
            stm.setString(4, requestDate);
            stm.setString(5, status);
            stm.setString(6, inspectionDetails);

            int rowsAffected = stm.executeUpdate();
            if (rowsAffected > 0) {
                System.out.println("✅ Yêu cầu kiểm định chất lượng đã được đăng ký thành công!");
            } else {
                System.out.println("⚠️ Không thể đăng ký yêu cầu kiểm định chất lượng.");
            }
        } catch (SQLException e) {
            System.out.println("❌ Lỗi khi đăng ký yêu cầu kiểm định chất lượng: " + e.getMessage());
        }
    }
}
