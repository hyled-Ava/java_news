package servlet;

import com.*;
import com.dao.UsersDao;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

//更新密码和个人信息
@WebServlet(name = "changePassword")
public class changePassword extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String oldpassword = request.getParameter("oldpassword");
        String password = request.getParameter("password");
        String name = request.getParameter("name");
        String sex = request.getParameter("sex");
        String hoby = request.getParameter("hoby");
        int id = (int) request.getSession().getAttribute("id");
        UsersDao userdao = new UsersDao();
        Users users = new Users(id, name, sex, "1", password, hoby, 0);
        int anser = userdao.update(users);
        if (anser != 0) {
            System.out.println("更新成功！！！ ");
            response.sendRedirect("welcome.jsp");
        } else {
            System.out.println("更新失败");
            response.sendRedirect("changePassword.jsp");
        }


    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
