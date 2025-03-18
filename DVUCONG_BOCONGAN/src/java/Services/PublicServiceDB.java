/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Services;

import Model.PublicService;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.ResultSet;
import java.util.List;
import java.util.ArrayList;


/**
 *
 * @author DELL
 */
public class PublicServiceDB extends DBContext {

    public PublicService getPublicServiceById(String serviceId) {
        PublicService service = null;
        try {
            String sql = "SELECT [serviceId], [serviceName], [description], [category] "
                    + "FROM [DVUCONG_BOCONGAN].[dbo].[PublicService] WHERE serviceId = ?";
            PreparedStatement stm = connection.prepareStatement(sql);
            stm.setString(1, serviceId);
            ResultSet rs = stm.executeQuery();

            if (rs.next()) {
                service = new PublicService();
                service.setServiceId(rs.getString("serviceId"));
                service.setServiceName(rs.getString("serviceName"));
                service.setDescription(rs.getString("description"));
                service.setCategory(rs.getString("category"));
            }
        } catch (SQLException e) {
            System.out.println("❌ Lỗi khi lấy thông tin dịch vụ công: " + e.getMessage());
        }
        return service;
    }
    
    public List<PublicService> getAllPublicServices() {
    List<PublicService> serviceList = new ArrayList<>();
    try {
        String sql = "SELECT [serviceId], [serviceName], [description], [category] FROM [DVUCONG_BOCONGAN].[dbo].[PublicService]";
        PreparedStatement stm = connection.prepareStatement(sql);
        ResultSet rs = stm.executeQuery();

        while (rs.next()) {
            PublicService service = new PublicService();
            service.setServiceId(rs.getString("serviceId"));
            service.setServiceName(rs.getString("serviceName"));
            service.setDescription(rs.getString("description"));
            service.setCategory(rs.getString("category"));
            serviceList.add(service);
        }
    } catch (SQLException e) {
        System.out.println("❌ Lỗi khi lấy danh sách dịch vụ công: " + e.getMessage());
    }
    return serviceList;
}


}
