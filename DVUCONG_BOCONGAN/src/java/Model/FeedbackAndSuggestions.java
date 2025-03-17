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
public class FeedbackAndSuggestions {

    private String feedbackId;
    private Business businessId;
    private Citizen citizenId;
    private String message;
    private Date submissionDate;

    public FeedbackAndSuggestions() {
    }

    public FeedbackAndSuggestions(String feedbackId, Business businessId, Citizen citizenId, String message, Date submissionDate) {
        this.feedbackId = feedbackId;
        this.businessId = businessId;
        this.citizenId = citizenId;
        this.message = message;
        this.submissionDate = submissionDate;
    }

    public String getFeedbackId() {
        return feedbackId;
    }

    public void setFeedbackId(String feedbackId) {
        this.feedbackId = feedbackId;
    }

    public Business getBusinessId() {
        return businessId;
    }

    public void setBusinessId(Business businessId) {
        this.businessId = businessId;
    }

    public Citizen getCitizenId() {
        return citizenId;
    }

    public void setCitizenId(Citizen citizenId) {
        this.citizenId = citizenId;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Date getSubmissionDate() {
        return submissionDate;
    }

    public void setSubmissionDate(Date submissionDate) {
        this.submissionDate = submissionDate;
    }

    @Override
    public String toString() {
        return "FeedbackAndSuggestions{" + "feedbackId=" + feedbackId + ", businessId=" + businessId + ", citizenId=" + citizenId + ", message=" + message + ", submissionDate=" + submissionDate + '}';
    }

}
