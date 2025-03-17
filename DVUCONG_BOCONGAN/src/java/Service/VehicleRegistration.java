/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Service;

/**
 *
 * @author DELL
 */
public class VehicleRegistration {

    private String vehicleId;
    private Citizen ownerId;
    private String vehicleType;

    public VehicleRegistration(String vehicleId, Citizen ownerId, String vehicleType) {
        this.vehicleId = vehicleId;
        this.ownerId = ownerId;
        this.vehicleType = vehicleType;
    }

    public String getVehicleId() {
        return vehicleId;
    }

    public void setVehicleId(String vehicleId) {
        this.vehicleId = vehicleId;
    }

    public Citizen getOwnerId() {
        return ownerId;
    }

    public void setOwnerId(Citizen ownerId) {
        this.ownerId = ownerId;
    }

    public String getVehicleType() {
        return vehicleType;
    }

    public void setVehicleType(String vehicleType) {
        this.vehicleType = vehicleType;
    }

    @Override
    public String toString() {
        return "VehicleRegistration{" + "vehicleId=" + vehicleId + ", ownerId=" + ownerId + ", vehicleType=" + vehicleType + '}';
    }

}
