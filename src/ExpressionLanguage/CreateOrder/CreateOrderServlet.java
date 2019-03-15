package ExpressionLanguage.CreateOrder;

import ExpressionLanguage.AddGoods.Good;
import ExpressionLanguage.Registered.User;
import com.mysql.cj.x.protobuf.MysqlxCrud;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.sql.SQLException;

@WebServlet(name = "CreateOrderServlet", urlPatterns = "/ExpressionLanguage/CreateOrder/CreateOrderServlet")
public class CreateOrderServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //String good_id = request.getParameter("good_id");
        //获取当前的Session对象
        HttpSession httpSession = request.getSession();
        //获取商品数量
        String numbers = request.getParameter("goods_number");
        System.out.println("Numbers:" + numbers);
        //获取选择的商品
        Good good = (Good) httpSession.getAttribute("good_information");
        String user_id = (String) httpSession.getAttribute("user_id");
        //创建订单类
        Order order = new Order();
        //注入订单数据
        order.setUser_id(Integer.valueOf(user_id));
        order.setGood_id(Integer.valueOf(good.getGood_id()));
        order.setGood_number(Integer.valueOf(numbers));

        //校验订单的有效性
        try {
            JudgeOrder judgeOrder = new JudgeOrder(order);

            int key = -1;
            key = judgeOrder.getKey();

            /**
             * * 0：正常要求
             * * 1：你的要求数量太大
             * * 2：你的要求数量太小
             * * 3：库存量不足
             */
            if (key == 0) {
                //正常要求
                //保存订单
                SaveOrder saveOrder = new SaveOrder(order);
                ReduceInventory reduceInventory = new ReduceInventory(order);
                System.out.println("测试页面跳转-F");

            } else {
                //保存错误信息到Session
                httpSession.setAttribute("orderErrorTypeNumber", "" + key);
                //跳转错误页面
                System.out.println("测试页面跳转-E");
                response.sendRedirect("/ExpressionLanguage/ErrorPages/ErrorByOrder.jsp");
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
