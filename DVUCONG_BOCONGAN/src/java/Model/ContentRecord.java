/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;

import java.util.Date;

/**
 *
 * @author DELL
 */
public class ContentRecord {
    private String contentId;
    private String title;
    private String body;
    private Date createdAt;
    private Date updatedAt;
    private Admin adminId;

    public ContentRecord() {
    }

    public ContentRecord(String contentId, String title, String body, Date createdAt, Date updatedAt, Admin adminId) {
        this.contentId = contentId;
        this.title = title;
        this.body = body;
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
        this.adminId = adminId;
    }

    public String getContentId() {
        return contentId;
    }

    public void setContentId(String contentId) {
        this.contentId = contentId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }

    public Date getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
    }

    public Date getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(Date updatedAt) {
        this.updatedAt = updatedAt;
    }

    public Admin getAdminId() {
        return adminId;
    }

    public void setAdminId(Admin adminId) {
        this.adminId = adminId;
    }

    @Override
    public String toString() {
        return "ContentRecord{" + "contentId=" + contentId + ", title=" + title + ", body=" + body + ", createdAt=" + createdAt + ", updatedAt=" + updatedAt + ", adminId=" + adminId + '}';
    }
    
}
