package ExpressionLanguage.AddGoods;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.sql.SQLException;

@WebServlet(name = "AddGoodServlet", urlPatterns = "/ExpressionLanguage/AddGoods/AddGoodServlet")
public class AddGoodServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        //获取表单提交数据

        String lp_good_name = request.getParameter("lp_good_name");
        String lp_good_price = request.getParameter("lp_good_price");
        String lp_good_number = request.getParameter("lp_good_number");

        //构建类
        Good good = new Good();
        good.setGood_name(lp_good_name);
        good.setGood_price(Integer.valueOf(lp_good_price));
        good.setGood_number(Integer.valueOf(lp_good_number));

        int key = -1;

        JudegGood judegGood = new JudegGood(good);

        key = judegGood.getKey();

        if (key == 0) {
            //正常操作，可以入库
            try {
                SaveGoods saveGoods = new SaveGoods(good);
                if (saveGoods.isKey()) {
                    //没有问题，数据保存成功
                    //页面跳转
                    HttpSession httpSession = request.getSession();
                    httpSession.setAttribute("newGood", good);
                    //成功页面
                    response.sendRedirect("");
                } else {
                    //商品数据保存失败，原因未知
                    //数据保存失败页面
                    response.sendRedirect("");
                }

            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        } else {
            //信息报错，走报错页面
            response.sendRedirect("");
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }
}
