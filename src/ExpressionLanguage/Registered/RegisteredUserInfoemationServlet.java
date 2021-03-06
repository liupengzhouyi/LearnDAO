package ExpressionLanguage.Registered;

import com.mysql.cj.Session;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.sql.SQLException;


@WebServlet(name = "ExpressionLanguage/Registered/RegisteredUserInfoemationServlet", urlPatterns = "/ExpressionLanguage/Registered/RegisteredUserInfoemationServlet")
public class RegisteredUserInfoemationServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        System.out.println("进入：");

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
                * 4：用户密码太短
                * 5：未知原因，用户注册信息没有存储到数据库
                * */
        if (key == 0) {
            System.out.println("注册用户信息进入数据库8888888");

            // 注册用户信息进入数据库标示
            boolean temp = false;

            //构件注册用户类
            User user = new User();
            user.setUser_name(lp_name);
            user.setUser_password(lp_password01);
            //保存用户注册类 到数据库
            SaveUserData saveUserData = new SaveUserData(user);
            try {
                temp = saveUserData.save();
                if (temp == true) {
                    System.out.println("注册用户数据保存到数据库");
                    //获取用户注册的ID
                    GetUserID getUserID = new GetUserID();
                    int user_id = getUserID.getUser_id();
                    user.setUser_id(user_id + "");

                    //用户信息保存到Session
                    HttpSession httpSession = request.getSession();
                    httpSession.setAttribute("user_id", user_id + "");
                    httpSession.setAttribute("user_name", lp_name);

                    //页面跳转
                    response.sendRedirect("/ExpressionLanguage/SuccessPages/RegisteredSuccessPage.jsp");


                } else {
                    System.out.println("注册用户的信息没哦呦进入数据库！");
                    HttpSession httpSession = request.getSession();
                    httpSession.setAttribute("ErrorNumber", 5+"");
                    //页面跳转
                    response.sendRedirect("/ExpressionLanguage/ErrorPages/ErrorNumber.jsp");
                }
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            } catch (SQLException e) {
                e.printStackTrace();
            }

        } else {
            // 跳转错误页面
            System.out.println("跳转错误页面!");
            //保存Seesion信息
            HttpSession httpSession = request.getSession();
            httpSession.setAttribute("ErrorNumber", key+"");
            //页面跳转
            response.sendRedirect("/ExpressionLanguage/ErrorPages/ErrorNumber.jsp");
        }

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }


}
