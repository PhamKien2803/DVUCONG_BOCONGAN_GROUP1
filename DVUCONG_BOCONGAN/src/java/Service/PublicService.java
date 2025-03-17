/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Service;

/**
 *
 * @author DELL
 */
public class PublicService {

    private String serviceId;
    private String serviceName;
    private String description;
    private String category;
    private GovernmentAgency agencyId;

    public PublicService(String serviceId, String serviceName, String description, String category, GovernmentAgency agencyId) {
        this.serviceId = serviceId;
        this.serviceName = serviceName;
        this.description = description;
        this.category = category;
        this.agencyId = agencyId;
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

    public GovernmentAgency getAgencyId() {
        return agencyId;
    }

    public void setAgencyId(GovernmentAgency agencyId) {
        this.agencyId = agencyId;
    }

    @Override
    public String toString() {
        return "PublicService{" + "serviceId=" + serviceId + ", serviceName=" + serviceName + ", description=" + description + ", category=" + category + ", agencyId=" + agencyId + '}';
    }

}
