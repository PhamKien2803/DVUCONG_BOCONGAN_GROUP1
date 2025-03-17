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
public class RequirementApproval {

    private String requestId;
    private String applicantId;
    private String applicantType;
    private PublicService serviceId;
    private String details;
    private Date submissionDate;
    private String status;
    private GovernmentAgency agencyId;

    public RequirementApproval() {
    }

    public RequirementApproval(String requestId, String applicantId, String applicantType, PublicService serviceId, String details, Date submissionDate, String status, GovernmentAgency agencyId) {
        this.requestId = requestId;
        this.applicantId = applicantId;
        this.applicantType = applicantType;
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

    public String getApplicantId() {
        return applicantId;
    }

    public void setApplicantId(String applicantId) {
        this.applicantId = applicantId;
    }

    public String getApplicantType() {
        return applicantType;
    }

    public void setApplicantType(String applicantType) {
        this.applicantType = applicantType;
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

    public Date getSubmissionDate() {
        return submissionDate;
    }

    public void setSubmissionDate(Date submissionDate) {
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
        return "RequirementApproval{" + "requestId=" + requestId + ", applicantId=" + applicantId + ", applicantType=" + applicantType + ", serviceId=" + serviceId + ", details=" + details + ", submissionDate=" + submissionDate + ", status=" + status + ", agencyId=" + agencyId + '}';
    }

}
