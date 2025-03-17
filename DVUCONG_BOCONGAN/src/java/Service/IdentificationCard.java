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
public class IdentificationCard {

    private String cardId;
    private Citizen citizenId;
    private Date issueDate;
    private Date expiryDate;

    public IdentificationCard() {
    }

    public IdentificationCard(String cardId, Citizen citizenId, Date issueDate, Date expiryDate) {
        this.cardId = cardId;
        this.citizenId = citizenId;
        this.issueDate = issueDate;
        this.expiryDate = expiryDate;
    }

    public String getCardId() {
        return cardId;
    }

    public void setCardId(String cardId) {
        this.cardId = cardId;
    }

    public Citizen getCitizenId() {
        return citizenId;
    }

    public void setCitizenId(Citizen citizenId) {
        this.citizenId = citizenId;
    }

    public Date getIssueDate() {
        return issueDate;
    }

    public void setIssueDate(Date issueDate) {
        this.issueDate = issueDate;
    }

    public Date getExpiryDate() {
        return expiryDate;
    }

    public void setExpiryDate(Date expiryDate) {
        this.expiryDate = expiryDate;
    }

    @Override
    public String toString() {
        return "IdentificationCard{" + "cardId=" + cardId + ", citizenId=" + citizenId + ", issueDate=" + issueDate + ", expiryDate=" + expiryDate + '}';
    }

}
