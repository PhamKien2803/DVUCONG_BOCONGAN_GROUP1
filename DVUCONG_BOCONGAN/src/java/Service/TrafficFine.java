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
public class TrafficFine {

    private String fineId;
    private Citizen citizenId;
    private String violationType;
    private float fineAmount;
    private Date fineDate;
    private Date violationDate;
    private String status;

    public TrafficFine() {
    }

    public TrafficFine(String fineId, Citizen citizenId, String violationType, float fineAmount, Date fineDate, Date violationDate, String status) {
        this.fineId = fineId;
        this.citizenId = citizenId;
        this.violationType = violationType;
        this.fineAmount = fineAmount;
        this.fineDate = fineDate;
        this.violationDate = violationDate;
        this.status = status;
    }

    public String getFineId() {
        return fineId;
    }

    public void setFineId(String fineId) {
        this.fineId = fineId;
    }

    public Citizen getCitizenId() {
        return citizenId;
    }

    public void setCitizenId(Citizen citizenId) {
        this.citizenId = citizenId;
    }

    public String getViolationType() {
        return violationType;
    }

    public void setViolationType(String violationType) {
        this.violationType = violationType;
    }

    public float getFineAmount() {
        return fineAmount;
    }

    public void setFineAmount(float fineAmount) {
        this.fineAmount = fineAmount;
    }

    public Date getFineDate() {
        return fineDate;
    }

    public void setFineDate(Date fineDate) {
        this.fineDate = fineDate;
    }

    public Date getViolationDate() {
        return violationDate;
    }

    public void setViolationDate(Date violationDate) {
        this.violationDate = violationDate;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "TrafficFine{" + "fineId=" + fineId + ", citizenId=" + citizenId + ", violationType=" + violationType + ", fineAmount=" + fineAmount + ", fineDate=" + fineDate + ", violationDate=" + violationDate + ", status=" + status + '}';
    }

}
