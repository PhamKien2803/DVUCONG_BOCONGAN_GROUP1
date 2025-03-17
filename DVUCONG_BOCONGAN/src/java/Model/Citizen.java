package Model;

import java.util.Date;

public class Citizen {

    private String citizenId;
    private String phoneNumber;
    private String address;
    private Date dateOfBirth;
    private String name;
    private String emailAddress;

    public Citizen() {
    }

    public Citizen(String citizenId, String phoneNumber, String address, Date dateOfBirth, String name, String emailAddress) {
        this.citizenId = citizenId;
        this.phoneNumber = phoneNumber;
        this.address = address;
        this.dateOfBirth = dateOfBirth;
        this.name = name;
        this.emailAddress = emailAddress;
    }

    public String getCitizenId() {
        return citizenId;
    }

    public void setCitizenId(String citizenId) {
        this.citizenId = citizenId;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Date getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(Date dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmailAddress() {
        return emailAddress;
    }

    public void setEmailAddress(String emailAddress) {
        this.emailAddress = emailAddress;
    }

    @Override
    public String toString() {
        return "Citizen{" + "citizenId=" + citizenId + ", phoneNumber=" + phoneNumber + ", address=" + address + ", dateOfBirth=" + dateOfBirth + ", name=" + name + ", emailAddress=" + emailAddress + '}';
    }
}
