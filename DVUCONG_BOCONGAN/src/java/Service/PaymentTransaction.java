/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Service;

import java.util.Date;

/**
 *
 * @author DELL
 */
public class PaymentTransaction {

    private String paymentId;
    private float amount;
    private String paymentMethod;
    private Date paymentDate;
    private String status;
    private Citizen citizenId;
    private Business businessId;

    public PaymentTransaction() {
    }

    public PaymentTransaction(String paymentId, float amount, String paymentMethod, Date paymentDate, String status, Citizen citizenId, Business businessId) {
        this.paymentId = paymentId;
        this.amount = amount;
        this.paymentMethod = paymentMethod;
        this.paymentDate = paymentDate;
        this.status = status;
        this.citizenId = citizenId;
        this.businessId = businessId;
    }

    public String getPaymentId() {
        return paymentId;
    }

    public void setPaymentId(String paymentId) {
        this.paymentId = paymentId;
    }

    public float getAmount() {
        return amount;
    }

    public void setAmount(float amount) {
        this.amount = amount;
    }

    public String getPaymentMethod() {
        return paymentMethod;
    }

    public void setPaymentMethod(String paymentMethod) {
        this.paymentMethod = paymentMethod;
    }

    public Date getPaymentDate() {
        return paymentDate;
    }

    public void setPaymentDate(Date paymentDate) {
        this.paymentDate = paymentDate;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
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
        return "PaymentTransaction{" + "paymentId=" + paymentId + ", amount=" + amount + ", paymentMethod=" + paymentMethod + ", paymentDate=" + paymentDate + ", status=" + status + ", citizenId=" + citizenId + ", businessId=" + businessId + '}';
    }

}
