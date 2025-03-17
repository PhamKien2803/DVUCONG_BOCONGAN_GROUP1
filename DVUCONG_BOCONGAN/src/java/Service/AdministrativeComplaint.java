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
public class AdministrativeComplaint {

    private String complaintId;
    private Citizen citizenId;
    private Business businessId;
    private String status;
    private Date submissionDate;
    private String complaintDetails;
    private String resolutionDetails;
    private String complaintType;

    public AdministrativeComplaint() {
    }

    public AdministrativeComplaint(String complaintId, Citizen citizenId, Business businessId, String status, Date submissionDate, String complaintDetails, String resolutionDetails, String complaintType) {
        this.complaintId = complaintId;
        this.citizenId = citizenId;
        this.businessId = businessId;
        this.status = status;
        this.submissionDate = submissionDate;
        this.complaintDetails = complaintDetails;
        this.resolutionDetails = resolutionDetails;
        this.complaintType = complaintType;
    }

    public String getComplaintId() {
        return complaintId;
    }

    public void setComplaintId(String complaintId) {
        this.complaintId = complaintId;
    }

    public Citizen getCitizenId() {
        return citizenId;
    }

    public void setCitizenId(Citizen citizenId) {
        this.citizenId = citizenId;
    }

    public Business getBusinessId() {
        return businessId;
    }

    public void setBusinessId(Business businessId) {
        this.businessId = businessId;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Date getSubmissionDate() {
        return submissionDate;
    }

    public void setSubmissionDate(Date submissionDate) {
        this.submissionDate = submissionDate;
    }

    public String getComplaintDetails() {
        return complaintDetails;
    }

    public void setComplaintDetails(String complaintDetails) {
        this.complaintDetails = complaintDetails;
    }

    public String getResolutionDetails() {
        return resolutionDetails;
    }

    public void setResolutionDetails(String resolutionDetails) {
        this.resolutionDetails = resolutionDetails;
    }

    public String getComplaintType() {
        return complaintType;
    }

    public void setComplaintType(String complaintType) {
        this.complaintType = complaintType;
    }

    @Override
    public String toString() {
        return "AdministrativeComplaint{" + "complaintId=" + complaintId + ", citizenId=" + citizenId + ", businessId=" + businessId + ", status=" + status + ", submissionDate=" + submissionDate + ", complaintDetails=" + complaintDetails + ", resolutionDetails=" + resolutionDetails + ", complaintType=" + complaintType + '}';
    }

}
