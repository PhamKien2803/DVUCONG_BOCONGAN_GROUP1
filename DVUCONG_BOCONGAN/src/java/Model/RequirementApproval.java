/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;

/**
 *
 * @author DELL
 */
public class RequirementApproval {

    private String requestId;
    private String applicantType;
    private Citizen citizenId;
    private Business businessId;
    private PublicService serviceId;
    private String details;
    private String submissionDate;
    private String status;
    private GovernmentAgency agencyId;

    public RequirementApproval() {
    }

    public RequirementApproval(String requestId, String applicantType, Citizen citizenId, Business businessId, PublicService serviceId, String details, String submissionDate, String status, GovernmentAgency agencyId) {
        this.requestId = requestId;
        this.applicantType = applicantType;
        this.citizenId = citizenId;
        this.businessId = businessId;
        this.serviceId = serviceId;
        this.details = details;
        this.submissionDate = submissionDate;
        this.status = status;
        this.agencyId = agencyId;
    }

    public String getRequestId() {
        return requestId;
    }

    public void setRequestId(String requestId) {
        this.requestId = requestId;
    }

    public String getApplicantType() {
        return applicantType;
    }

    public void setApplicantType(String applicantType) {
        this.applicantType = applicantType;
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

    public PublicService getServiceId() {
        return serviceId;
    }

    public void setServiceId(PublicService serviceId) {
        this.serviceId = serviceId;
    }

    public String getDetails() {
        return details;
    }

    public void setDetails(String details) {
        this.details = details;
    }

    public String getSubmissionDate() {
        return submissionDate;
    }

    public void setSubmissionDate(String submissionDate) {
        this.submissionDate = submissionDate;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public GovernmentAgency getAgencyId() {
        return agencyId;
    }

    public void setAgencyId(GovernmentAgency agencyId) {
        this.agencyId = agencyId;
    }

    @Override
    public String toString() {
        return "RequirementApproval{" + "requestId=" + requestId + ", applicantId=" + applicantType + ", citizenId=" + citizenId + ", businessId=" + businessId + ", serviceId=" + serviceId + ", details=" + details + ", submissionDate=" + submissionDate + ", status=" + status + ", agencyId=" + agencyId + '}';
    }

}
