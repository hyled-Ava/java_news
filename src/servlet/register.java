package servlet;

import com.*;
import com.dao.UsersDao;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "register")
public class register extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
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
                System.out.println("<h1>注册成功<h1>");
                response.sendRedirect("index.jsp");
            } else {
                response.sendRedirect("userRegister.jsp");
            }
        } catch (Exception ex) {
            System.out.println(ex);
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
