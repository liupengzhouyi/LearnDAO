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

        int key = 0;

        AuthenticationYourInformation authenticationYourInformation = new AuthenticationYourInformation(lp_name, lp_password01, lp_password02);

        key = authenticationYourInformation.canUsed();

        /*      * 0：合法
                * 1：用户名太长
                * 2：用户密码太长
                * 3：用户密码不一致
                * 4：用户密码太短*/
        if (key == 0) {

        } else {
            // 跳转错误页面
        }

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }


}
