/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;

/**
 *
 * @author DELL
 */
public class PublicService {

    private String serviceId;
    private String serviceName;
    private String description;
    private String category;
    private Citizen citizenId;
    private Business businessId;

    public PublicService() {
    }

    public PublicService(String serviceId, String serviceName, String description, String category, Citizen citizenId, Business businessId) {
        this.serviceId = serviceId;
        this.serviceName = serviceName;
        this.description = description;
        this.category = category;
        this.citizenId = citizenId;
        this.businessId = businessId;
    }

    public String getServiceId() {
        return serviceId;
    }

    public void setServiceId(String serviceId) {
        this.serviceId = serviceId;
    }

    public String getServiceName() {
        return serviceName;
    }

    public void setServiceName(String serviceName) {
        this.serviceName = serviceName;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
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

    @Override
    public String toString() {
        return "PublicService{" + "serviceId=" + serviceId + ", serviceName=" + serviceName + ", description=" + description + ", category=" + category + ", citizenId=" + citizenId + ", businessId=" + businessId + '}';
    }

}
