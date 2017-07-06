package servlet;

import po.User;
import service.UserService;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Created by 18435 on 2017/7/6.
 */
public class LoginServlet {
    public String login(HttpServletRequest req, HttpServletResponse resp) {
        //取值，取从页面传过来的用户名（员工唯一编号） 密码  验证码
        String username = req.getParameter("username");
        String password = req.getParameter("password");
        //验证用户名，密码
        UserService service = new UserService();
        User user = service.login(username, password);
        if (user != null) {
            System.out.println("登录成功");
            req.getSession().setAttribute("user", user);
            return "/welcome.jsp";
        } else {
            System.out.println("登录失败");
            req.setAttribute("result", "用户名或密码错误！");
            return "/index.jsp";
        }
    }

    public String exit(HttpServletRequest req, HttpServletResponse resp) {
        return "/index.jsp";
    }
}
