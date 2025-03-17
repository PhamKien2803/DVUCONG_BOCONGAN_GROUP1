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
public class SealRegistration {

    private String registrationId;
    private GovernmentAgency ownerId;
    private String sealType;
    private Date registrationDate;

    public SealRegistration() {
    }

    public SealRegistration(String registrationId, GovernmentAgency ownerId, String sealType, Date registrationDate) {
        this.registrationId = registrationId;
        this.ownerId = ownerId;
        this.sealType = sealType;
        this.registrationDate = registrationDate;
    }

    public String getRegistrationId() {
        return registrationId;
    }

    public void setRegistrationId(String registrationId) {
        this.registrationId = registrationId;
    }

    public GovernmentAgency getOwnerId() {
        return ownerId;
    }

    public void setOwnerId(GovernmentAgency ownerId) {
        this.ownerId = ownerId;
    }

    public String getSealType() {
        return sealType;
    }

    public void setSealType(String sealType) {
        this.sealType = sealType;
    }

    public Date getRegistrationDate() {
        return registrationDate;
    }

    public void setRegistrationDate(Date registrationDate) {
        this.registrationDate = registrationDate;
    }

    @Override
    public String toString() {
        return "SealRegistration{" + "registrationId=" + registrationId + ", ownerId=" + ownerId + ", sealType=" + sealType + ", registrationDate=" + registrationDate + '}';
    }

}
