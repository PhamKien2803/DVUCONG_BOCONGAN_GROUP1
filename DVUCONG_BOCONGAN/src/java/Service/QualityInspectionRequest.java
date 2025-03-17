/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Service;

import java.util.Date;

/**
 *
 * @author DELL
 */
public class QualityInspectionRequest {

    private String requestId;
    private Business businessId;
    private String productType;
    private Date requestDate;
    private String status;
    private String inspectionDetails;

    public QualityInspectionRequest() {
    }

    public QualityInspectionRequest(String requestId, Business businessId, String productType, Date requestDate, String status, String inspectionDetails) {
        this.requestId = requestId;
        this.businessId = businessId;
        this.productType = productType;
        this.requestDate = requestDate;
        this.status = status;
        this.inspectionDetails = inspectionDetails;
    }

    public String getRequestId() {
        return requestId;
    }

    public void setRequestId(String requestId) {
        this.requestId = requestId;
    }

    public Business getBusinessId() {
        return businessId;
    }

    public void setBusinessId(Business businessId) {
        this.businessId = businessId;
    }

    public String getProductType() {
        return productType;
    }

    public void setProductType(String productType) {
        this.productType = productType;
    }

    public Date getRequestDate() {
        return requestDate;
    }

    public void setRequestDate(Date requestDate) {
        this.requestDate = requestDate;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getInspectionDetails() {
        return inspectionDetails;
    }

    public void setInspectionDetails(String inspectionDetails) {
        this.inspectionDetails = inspectionDetails;
    }

    @Override
    public String toString() {
        return "QualityInspectionRequest{" + "requestId=" + requestId + ", businessId=" + businessId + ", productType=" + productType + ", requestDate=" + requestDate + ", status=" + status + ", inspectionDetails=" + inspectionDetails + '}';
    }

}
