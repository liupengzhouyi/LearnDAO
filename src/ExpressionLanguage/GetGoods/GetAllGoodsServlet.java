package ExpressionLanguage.GetGoods;

import ExpressionLanguage.AddGoods.Good;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

@WebServlet(name = "GetAllGoodsServlet", urlPatterns = "/ExpressionLanguage/GetGoods/GetAllGoodsServlet")
public class GetAllGoodsServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            List<Good> list = new GetAllGoods().getListOfGoods();

            if (list.size() == 0) {
                // 没有取到数据
                // 走错误页面
                response.sendRedirect("/ExpressionLanguage/ErrorPages/GetGoodsErrorPage.jsp");
            } else {
                // 保存Session
                HttpSession httpSession = request.getSession();
                httpSession.setAttribute("goodList", list);
                httpSession.setAttribute("goodListNumber", list.size());
                //跳转详情查看页面
                System.out.println("11111");
                response.sendRedirect("/ExpressionLanguage/SuccessPages/ShowAllGoods.jsp");
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
