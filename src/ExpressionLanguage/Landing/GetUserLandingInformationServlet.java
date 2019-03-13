package ExpressionLanguage.Landing;

import ExpressionLanguage.Registered.User;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.sql.SQLException;

@WebServlet(name = "GetUserLandingInformationServlet", urlPatterns = "/ExpressionLanguage/Landing/GetUserLandingInformationServlet")
public class GetUserLandingInformationServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String user_id = null;
        String user_password = null;

        user_id = request.getParameter("user_id");
        user_password = request.getParameter("user_password");

        User user = new User();
        user.setUser_id(user_id);
        user.setUser_password(user_password);


        boolean key = false;

        try {
            JudgeUser judgeUser = new JudgeUser(user);
            key = judgeUser.isKey();

            if (key == true) {
                // 用户正确
                GetUserName getUserName = new GetUserName(user_id);
                String user_name = getUserName.getUserName();
                HttpSession httpSession1 = request.getSession();
                httpSession1.invalidate();
                HttpSession httpSession = request.getSession();
                httpSession.setAttribute("user_id", user_id);
                httpSession.setAttribute("user_name", user_name);
                response.sendRedirect("/ExpressionLanguage/SuccessPages/LandingSuccessPage.jsp");

            } else {
                // 用户错误

                // 跳转错误页面
                response.sendRedirect("/ExpressionLanguage/ErrorPages/ErrorUserNameOrPassword.jsp");

            }

        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }
}
