package servlet;

import po.User;
import service.UserService;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Created by 18435 on 2017/7/6.
 */
public class UserServlet {
    private UserService service = new UserService();
    //���
    public String cun(HttpServletRequest req, HttpServletResponse resp){
        User user = (User)req.getSession().getAttribute("user");
        double money = Double.parseDouble(req.getParameter("money"));
        service.cunMoney(user,money);
        return "/welcome.jsp";
    }
    //ȡ��
    public String qu(HttpServletRequest req, HttpServletResponse resp){
        User user = (User)req.getSession().getAttribute("user");
        double money = Double.parseDouble(req.getParameter("money"));
        service.quMoney(user,money);
        return "/welcome.jsp";
    }
    //ת��
    public String zhuan(HttpServletRequest req, HttpServletResponse resp){
        User zcUser = (User)req.getSession().getAttribute("user");
        String zrUsername = req.getParameter("username");
        double money = Double.parseDouble(req.getParameter("money"));
        service.zhuanMoney(zrUsername,zcUser,money);
        return "/welcome.jsp";
    }
    //��ѯ���
    public String cha(HttpServletRequest req, HttpServletResponse resp){
        User user = (User)req.getSession().getAttribute("user");
        double ye = service.chaYu(user.getUsername());
        req.setAttribute("ye",ye);
        return "/showMoney.jsp";
    }
}