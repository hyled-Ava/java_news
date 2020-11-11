package servlet;

import com.*;
import com.dao.UsersDao;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

//更新密码和个人信息
@WebServlet(name = "changePassword")
public class changePassword extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");//设置request的编码方式
        response.setContentType("text/html;charSet=UTF-8");//设置respponse的文档类型及编码方式
        PrintWriter out = response.getWriter();//获取out对象
        String oldpassword = request.getParameter("oldpassword");
        String password = request.getParameter("password");
        int id = (int) request.getSession().getAttribute("id");
        UsersDao userdao = new UsersDao();
        Users users = new Users(id, "1", password, "1", "sex", "name", 0);
        int anser = userdao.update(users);
        if (anser != 0) {
            out.println("<body onclick=\"window.history.go(-1)\"><br><br><h2 style='left:30px'>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;Successfully!</h2>");
        } else {
            out.println("<body onclick=\"window.history.go(-1)\"><br><br><h2 style='left:30px'>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;fail!</h2>");
        }
//        if (anser != 0) {
//            System.out.println("更新成功！！！ ");
//            response.sendRedirect("welcome.jsp");
//        } else {
//            System.out.println("更新失败");
//            response.sendRedirect("changePassword.jsp");
//        }


    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
