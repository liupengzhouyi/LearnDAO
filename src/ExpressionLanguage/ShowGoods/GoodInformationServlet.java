package ExpressionLanguage.ShowGoods;

import ExpressionLanguage.AddGoods.Good;
import ExpressionLanguage.GetGoods.JudgeGoodId;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.sql.SQLException;

@WebServlet(name = "GoodInformationServlet", urlPatterns = "/ExpressionLanguage/ShowGoods/GoodInformationServlet")
public class GoodInformationServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println("商品详情页");


        //获取用户传入的商品ID号
        String good_id = request.getParameter("good_id");

        //验证改商品ID的有效性
        try {
            JudgeGoodId judgeGoodId = new JudgeGoodId(good_id);

            boolean key = judgeGoodId.isKey();

            //如果有改商品ID，显示改商品的详细信息
            if (key) {

                HttpSession httpSession = request.getSession();
                //清除原来在Session中的商品信息
                httpSession.removeAttribute("good_information");

                Good good = judgeGoodId.getGood();
                //保存新的商品信息到Session中

                httpSession.setAttribute("good_information", good);

                //页面转发
                response.sendRedirect("/ExpressionLanguage/ShowOrder/HTMLFlie/index.jsp");

            } else {
                //如果没有该商品的信息，显示错误提示

                response.sendRedirect("/ExpressionLanguage/ErrorPages/ErrorOfGoodPages.jsp");
            }

        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }
}
