/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Services;

import Model.Admin;
import Model.ContentRecord;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author DELL
 */
public class ContentRecordDB extends DBContext {

    public List<ContentRecord> getAllPosts() {
        List<ContentRecord> list = new ArrayList<>();
        try {
            String sql = "SELECT contentId, title, body, createdAt, updatedAt, adminId FROM ContentRecord";
            PreparedStatement ps = connection.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                // Tạo Admin object từ adminId
                Admin admin = null;
                if (rs.getString("adminId") != null) {
                    admin = new Admin();
                    admin.setAdminId(rs.getString("adminId"));
                }

                ContentRecord post = new ContentRecord(
                        rs.getString("contentId"),
                        rs.getString("title"),
                        rs.getString("body"),
                        rs.getDate("createdAt"),
                        rs.getDate("updatedAt"),
                        admin
                );

                list.add(post);
            }
            rs.close();
            ps.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }

    public boolean createPost(ContentRecord post) {
        String sql = "INSERT INTO ContentRecord (contentId, title, body, createdAt, updatedAt) VALUES (?, ?, ?, GETDATE(), GETDATE())";

        try {
            PreparedStatement stmt = connection.prepareStatement(sql);
            stmt.setString(1, post.getContentId());
            stmt.setString(2, post.getTitle());
            stmt.setString(3, post.getBody());

            int rowsAffected = stmt.executeUpdate();
            stmt.close();
            return rowsAffected > 0;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }

    }

    // xóa bài viết theo id của bài viết
    public boolean deletePost(String contentId) {
        String sql = "DELETE FROM ContentRecord WHERE contentId = ?";

        try {
            PreparedStatement stmt = connection.prepareStatement(sql);
            stmt.setString(1, contentId);

            int rowsAffected = stmt.executeUpdate();
            stmt.close();
            return rowsAffected > 0;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    //test ContentRecordDB chay dung chua
    public static void main(String[] args) {
        ContentRecordDB db = new ContentRecordDB();
        List<ContentRecord> list = db.getAllPosts();
        for (ContentRecord post : list) {
            System.out.println(post);
        }
    }
}
