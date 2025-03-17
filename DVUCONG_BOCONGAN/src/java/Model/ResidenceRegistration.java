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
public class ResidenceRegistration {

    private String registrationId;
    private Citizen citizenId;
    private String address;
    private Date registrationDate;
    private String status;

    public ResidenceRegistration() {
    }

    public ResidenceRegistration(String registrationId, Citizen citizenId, String address, Date registrationDate, String status) {
        this.registrationId = registrationId;
        this.citizenId = citizenId;
        this.address = address;
        this.registrationDate = registrationDate;
        this.status = status;
    }

    public String getRegistrationId() {
        return registrationId;
    }

    public void setRegistrationId(String registrationId) {
        this.registrationId = registrationId;
    }

    public Citizen getCitizenId() {
        return citizenId;
    }

    public void setCitizenId(Citizen citizenId) {
        this.citizenId = citizenId;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Date getRegistrationDate() {
        return registrationDate;
    }

    public void setRegistrationDate(Date registrationDate) {
        this.registrationDate = registrationDate;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "ResidenceRegistration{" + "registrationId=" + registrationId + ", citizenId=" + citizenId + ", address=" + address + ", registrationDate=" + registrationDate + ", status=" + status + '}';
    }

}
