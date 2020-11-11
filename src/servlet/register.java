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

@WebServlet(name = "register")
public class register extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");//设置request的编码方式
        response.setContentType("text/html;charSet=UTF-8");//设置respponse的文档类型及编码方式
        PrintWriter out = response.getWriter();//获取out对象
        String name = request.getParameter("name");
        String password = request.getParameter("password");
        String username = request.getParameter("username");
        String sex = request.getParameter("sex");
        String hoby = request.getParameter("hoby");
        UsersDao newuser = new UsersDao();
        Users users = new Users(name, sex, username, password, hoby);
        try {
            int anser = newuser.insert(users);
            if (anser != 0) {
                out.println("<body onclick=\"window.history.go(-1)\"><br><br><h2 style='left:30px'>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;Successfully!</h2>");
            } else {
                out.println("<body onclick=\"window.history.go(-1)\"><br><br><h2 style='left:30px'>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;fail!</h2>");
            }
        } catch (Exception ex) {
            System.out.println(ex);
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
