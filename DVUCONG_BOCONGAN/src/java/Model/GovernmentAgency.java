/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;

/**
 *
 * @author DELL
 */
public class GovernmentAgency {

    private int agencyId;
    private String agencyName;
    private String department;
    private String address;
    private String phoneNumber;
    private String emailAddress;

    public GovernmentAgency() {
    }

    public GovernmentAgency(int agencyId, String agencyName, String department, String address, String phoneNumber, String emailAddress) {
        this.agencyId = agencyId;
        this.agencyName = agencyName;
        this.department = department;
        this.address = address;
        this.phoneNumber = phoneNumber;
        this.emailAddress = emailAddress;
    }

    public int getAgencyId() {
        return agencyId;
    }

    public void setAgencyId(int agencyId) {
        this.agencyId = agencyId;
    }

    public String getAgencyName() {
        return agencyName;
    }

    public void setAgencyName(String agencyName) {
        this.agencyName = agencyName;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getEmailAddress() {
        return emailAddress;
    }

    public void setEmailAddress(String emailAddress) {
        this.emailAddress = emailAddress;
    }

    @Override
    public String toString() {
        return "GovernmentAgency{" + "agencyId=" + agencyId + ", agencyName=" + agencyName + ", department=" + department + ", address=" + address + ", phoneNumber=" + phoneNumber + ", emailAddress=" + emailAddress + '}';
    }
}
