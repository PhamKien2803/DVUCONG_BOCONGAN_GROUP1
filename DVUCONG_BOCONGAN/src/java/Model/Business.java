/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;

/**
 *
 * @author DELL
 */
public class Business {

    private String businessId;
    private String name;
    private String registrationNumber;
    private String address;
    private String phoneNumber;
    private String emailAddress;

    public Business() {
    }

    public Business(String businessId, String name, String registrationNumber, String address, String phoneNumber, String emailAddress) {
        this.businessId = businessId;
        this.name = name;
        this.registrationNumber = registrationNumber;
        this.address = address;
        this.phoneNumber = phoneNumber;
        this.emailAddress = emailAddress;
    }

    public String getBusinessId() {
        return businessId;
    }

    public void setBusinessId(String businessId) {
        this.businessId = businessId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getRegistrationNumber() {
        return registrationNumber;
    }

    public void setRegistrationNumber(String registrationNumber) {
        this.registrationNumber = registrationNumber;
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
        return "Business{" + "businessId=" + businessId + ", name=" + name + ", registrationNumber=" + registrationNumber + ", address=" + address + ", phoneNumber=" + phoneNumber + ", emailAddress=" + emailAddress + '}';
    }
}
