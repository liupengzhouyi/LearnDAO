package ExpressionLanguage.Landing;

import ExpressionLanguage.Registered.User;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

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



    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }
}
