package cn.edu.guet.web;
/**
 * @Author liwei
 * @Date 2023/5/16 20:19
 * @Version 1.0
 */

import cn.edu.guet.bean.User;
import cn.edu.guet.service.UserService;
import cn.edu.guet.service.impl.UserServiceImpl;

import javax.servlet.*;
import javax.servlet.http.*;
import java.io.IOException;
import java.util.List;

public class UserServlet extends HttpServlet {

    private UserService userService;

    public UserServlet() {
        userService = new UserServiceImpl();
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String uri = request.getRequestURI();
        System.out.println(uri);
        if (uri.contains("save")) {
            // 调用业务层的saveUser
            String username = request.getParameter("username");
            String address = request.getParameter("address");
            User user = new User(username, address);
            userService.saveUser(user);
            // 保存成功后，跳转到查看用户界面
            request.getRequestDispatcher("viewUser.do")
                    .forward(request, response);
        } else if (uri.contains("view")) {
            List<User> userList = userService.viewUser();
            System.out.println(userList);
            request.setAttribute("userList", userList);
            request.getRequestDispatcher("viewUser.jsp")
                    .forward(request, response);
        }else if(uri.contains("delete")){
            String id=request.getParameter("id");
            System.out.println("即将要删除的用户ID："+id);
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }
}
