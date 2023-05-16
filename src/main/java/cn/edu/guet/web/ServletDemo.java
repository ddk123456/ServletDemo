package cn.edu.guet.web; /**
 * @Author liwei
 * @Date 2023/5/16 19:35
 * @Version 1.0
 */

import cn.edu.guet.bean.User;

import javax.servlet.*;
import javax.servlet.http.*;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

public class ServletDemo extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String username="zhangsan";//假设该数据是从数据库取出来的数据

        request.setAttribute("username",username);//放入request作用域

        List<User> userList=new ArrayList<>();

        User user01=new User(111,"张三","广西桂林");
        User user02=new User(222,"李四","广西南宁");
        User user03=new User(333,"王五","广西贵港");

        userList.add(user01);
        userList.add(user02);
        userList.add(user03);

//        HttpSession session=request.getSession();
//        session.setAttribute("userList",userList);

        ServletContext context=request.getServletContext();
        context.setAttribute("userList",userList);//context（全局作用域）

        request.getRequestDispatcher("/viewUser.jsp").forward(request,response);// 跳到index.jsp

//        response.setContentType("text/html");
//        PrintWriter out= response.getWriter();
//        out.print("<html>");
//        out.print("<body>"+username+"</body>");
//        out.print("</html>");

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
