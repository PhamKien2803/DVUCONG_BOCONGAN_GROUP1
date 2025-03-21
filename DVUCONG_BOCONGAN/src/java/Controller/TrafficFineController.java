package Controller;

import Model.TrafficFine;
import Services.TrafficFineDB;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@WebServlet("/trafficFines")
public class TrafficFineController extends HttpServlet {
    private TrafficFineDB trafficFineDB;

    @Override
    public void init() {
        trafficFineDB = new TrafficFineDB();
    }

    // Xử lý GET request - Tra cứu lỗi vi phạm theo fineId hoặc citizenId
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String fineIdParam = request.getParameter("fineId");
        String citizenId = request.getParameter("citizenId");

        try {
            List<TrafficFine> fines = new ArrayList<>();

            if (fineIdParam != null && !fineIdParam.trim().isEmpty()) {
                int fineId = Integer.parseInt(fineIdParam);
                TrafficFine fine = trafficFineDB.getTrafficFineById(fineId);
                if (fine != null) {
                    fines.add(fine);
                } else {
                    request.setAttribute("error", "Không tìm thấy lỗi vi phạm với mã: " + fineId);
                }
            } else if (citizenId != null && !citizenId.trim().isEmpty()) {
                fines = trafficFineDB.getFinesByCitizenId(citizenId);
                if (fines.isEmpty()) {
                    request.setAttribute("error", "Không có vi phạm nào được tìm thấy cho số CCCD này.");
                }
            } else {
                request.setAttribute("error", "Vui lòng nhập fineId hoặc số CCCD để tra cứu!");
            }

            request.setAttribute("fines", fines);
        } catch (NumberFormatException e) {
            request.setAttribute("error", "Fine ID không hợp lệ!");
        } catch (Exception e) {
            request.setAttribute("error", "Lỗi khi truy xuất dữ liệu. Vui lòng thử lại sau.");
            e.printStackTrace();
        }

        request.getRequestDispatcher("trafficFine.jsp").forward(request, response);
    }

    // Xử lý POST request - Thêm lỗi vi phạm mới
   @Override
protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    String citizenId = request.getParameter("citizenId");
    String violationType = request.getParameter("violationType");
    String fineAmountStr = request.getParameter("fineAmount");
    String fineDateStr = request.getParameter("fineDate");
    String violationDateStr = request.getParameter("violationDate");
    String status = request.getParameter("status");

    // Kiểm tra nếu trafficFineDB chưa được khởi tạo
    if (trafficFineDB == null) {
        request.setAttribute("error", "Lỗi kết nối đến cơ sở dữ liệu.");
        request.getRequestDispatcher("trafficFine.jsp").forward(request, response);
        return;
    }

    // Kiểm tra dữ liệu nhập vào
    if (citizenId == null || citizenId.isEmpty() ||
        violationType == null || violationType.isEmpty() ||
        fineAmountStr == null || fineAmountStr.isEmpty() ||
        fineDateStr == null || fineDateStr.isEmpty() ||
        violationDateStr == null || violationDateStr.isEmpty() ||
        status == null || status.isEmpty()) {

        request.setAttribute("error", "Vui lòng nhập đầy đủ thông tin.");
        request.getRequestDispatcher("trafficFine.jsp").forward(request, response);
        return;
    }

    try {
        float fineAmount = Float.parseFloat(fineAmountStr);

        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        Date fineDate = sdf.parse(fineDateStr);
        Date violationDate = sdf.parse(violationDateStr);

        TrafficFine fine = new TrafficFine();
        int generatedId = trafficFineDB.addTrafficFine(fine);

        if (generatedId > 0) {
            request.setAttribute("success", "Thêm lỗi vi phạm thành công.");
        } else {
            request.setAttribute("error", "Thêm lỗi vi phạm thất bại. Vui lòng thử lại.");
        }
    } catch (NumberFormatException e) {
        request.setAttribute("error", "Số tiền phạt không hợp lệ. Vui lòng nhập số.");
    } catch (ParseException e) {
        request.setAttribute("error", "Định dạng ngày không hợp lệ. Vui lòng nhập theo định dạng yyyy-MM-dd.");
    } catch (Exception e) {
        request.setAttribute("error", "Lỗi xử lý dữ liệu. Vui lòng kiểm tra đầu vào.");
        e.printStackTrace(); // Có thể thay bằng logger để ghi log
    }

    request.getRequestDispatcher("trafficFine.jsp").forward(request, response);
}

}
