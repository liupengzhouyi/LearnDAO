package ExpressionLanguage.Registered;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;



@WebServlet(name = "ExpressionLanguage/Registered/RegisteredUserInfoemationServlet", urlPatterns = "/ExpressionLanguage/Registered/RegisteredUserInfoemationServlet")
public class RegisteredUserInfoemationServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String lp_name = request.getParameter("lp_name");
        String lp_password01 = request.getParameter("lp_password01");
        String lp_password02 = request.getParameter("lp_password02");




        System.out.println(lp_name);

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }


}
