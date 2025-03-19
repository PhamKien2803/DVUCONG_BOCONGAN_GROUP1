package Model;


public class Citizen {

    private int citizenId;
    private String phoneNumber;
    private String address;
    private String dateOfBirth;
    private String name;
    private String emailAddress;

    public Citizen() {
    }

    public Citizen(int citizenId, String phoneNumber, String address, String dateOfBirth, String name, String emailAddress) {
        this.citizenId = citizenId;
        this.phoneNumber = phoneNumber;
        this.address = address;
        this.dateOfBirth = dateOfBirth;
        this.name = name;
        this.emailAddress = emailAddress;
    }

    public int getCitizenId() {
        return citizenId;
    }

    public void setCitizenId(int citizenId) {
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

    public String getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(String dateOfBirth) {
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
