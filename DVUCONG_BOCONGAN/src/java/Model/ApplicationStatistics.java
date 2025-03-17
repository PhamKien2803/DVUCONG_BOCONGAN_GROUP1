/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;

import java.util.Date;

/**
 *
 * @author DELL
 */
public class ApplicationStatistics {
    private String reportId;
    private String serviceType;
    private int totalRequests;
    private Date generatedDate;
    private Admin adminId;

    public ApplicationStatistics() {
    }

    public ApplicationStatistics(String reportId, String serviceType, int totalRequests, Date generatedDate, Admin adminId) {
        this.reportId = reportId;
        this.serviceType = serviceType;
        this.totalRequests = totalRequests;
        this.generatedDate = generatedDate;
        this.adminId = adminId;
    }

    public String getReportId() {
        return reportId;
    }

    public void setReportId(String reportId) {
        this.reportId = reportId;
    }

    public String getServiceType() {
        return serviceType;
    }

    public void setServiceType(String serviceType) {
        this.serviceType = serviceType;
    }

    public int getTotalRequests() {
        return totalRequests;
    }

    public void setTotalRequests(int totalRequests) {
        this.totalRequests = totalRequests;
    }

    public Date getGeneratedDate() {
        return generatedDate;
    }

    public void setGeneratedDate(Date generatedDate) {
        this.generatedDate = generatedDate;
    }

    public Admin getAdminId() {
        return adminId;
    }

    public void setAdminId(Admin adminId) {
        this.adminId = adminId;
    }

    @Override
    public String toString() {
        return "ApplicationStatistics{" + "reportId=" + reportId + ", serviceType=" + serviceType + ", totalRequests=" + totalRequests + ", generatedDate=" + generatedDate + ", adminId=" + adminId + '}';
    }
    
    
}
