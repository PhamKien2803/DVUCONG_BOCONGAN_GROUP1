/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;

/**
 *
 * @author DELL
 */
public class Notification {

    private String notificationId;
    private String message;
    private String status;
    private UserAccount userAccountId;

    public Notification() {
    }

    public Notification(String notificationId, String message, String status, UserAccount userAccountId) {
        this.notificationId = notificationId;
        this.message = message;
        this.status = status;
        this.userAccountId = userAccountId;
    }

    public String getNotificationId() {
        return notificationId;
    }

    public void setNotificationId(String notificationId) {
        this.notificationId = notificationId;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public UserAccount getUserAccountId() {
        return userAccountId;
    }

    public void setUserAccountId(UserAccount userAccountId) {
        this.userAccountId = userAccountId;
    }

    @Override
    public String toString() {
        return "Notification{" + "notificationId=" + notificationId + ", message=" + message + ", status=" + status + ", userAccountId=" + userAccountId + '}';
    }

}
