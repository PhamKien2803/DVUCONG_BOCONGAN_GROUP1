/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Service;

/**
 *
 * @author DELL
 */
public class UserAccount {

    private String accountId;
    private String username;
    private String password;
    private String role;
    private Citizen citizenId;
    private Business businessId;
    private GovernmentAgency citizen;
    private Admin adminId;
    private boolean isActive;

    public UserAccount() {
    }

    public UserAccount(String accountId, String username, String password, String role, Citizen citizenId, Business businessId, GovernmentAgency citizen, Admin adminId, boolean isActive) {
        this.accountId = accountId;
        this.username = username;
        this.password = password;
        this.role = role;
        this.citizenId = citizenId;
        this.businessId = businessId;
        this.citizen = citizen;
        this.adminId = adminId;
        this.isActive = isActive;
    }

    public String getAccountId() {
        return accountId;
    }

    public void setAccountId(String accountId) {
        this.accountId = accountId;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public Citizen getCitizenId() {
        return citizenId;
    }

    public void setCitizenId(Citizen citizenId) {
        this.citizenId = citizenId;
    }

    public Business getBusinessId() {
        return businessId;
    }

    public void setBusinessId(Business businessId) {
        this.businessId = businessId;
    }

    public GovernmentAgency getCitizen() {
        return citizen;
    }

    public void setCitizen(GovernmentAgency citizen) {
        this.citizen = citizen;
    }

    public Admin getAdminId() {
        return adminId;
    }

    public void setAdminId(Admin adminId) {
        this.adminId = adminId;
    }

    public boolean isIsActive() {
        return isActive;
    }

    public void setIsActive(boolean isActive) {
        this.isActive = isActive;
    }

    @Override
    public String toString() {
        return "UserAccount{" + "accountId=" + accountId + ", username=" + username + ", password=" + password + ", role=" + role + ", citizenId=" + citizenId + ", businessId=" + businessId + ", citizen=" + citizen + ", adminId=" + adminId + ", isActive=" + isActive + '}';
    }
    
    

}
