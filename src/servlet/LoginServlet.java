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
        //ȡֵ��ȡ��ҳ�洫�������û�����Ա��Ψһ��ţ� ����  ��֤��
        String username = req.getParameter("username");
        String password = req.getParameter("password");
        //��֤�û���������
        UserService service = new UserService();
        User user = service.login(username, password);
        if (user != null) {
            System.out.println("��¼�ɹ�");
            req.getSession().setAttribute("user", user);
            return "/welcome.jsp";
        } else {
            System.out.println("��¼ʧ��");
            req.setAttribute("result", "�û������������");
            return "/index.jsp";
        }
    }

    public String exit(HttpServletRequest req, HttpServletResponse resp) {
        return "/index.jsp";
    }
}