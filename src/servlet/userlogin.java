package servlet;

import com.*;
import com.dao.UsersDao;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet(name = "userlogin")
public class userlogin extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String user = request.getParameter("username");
        String password = request.getParameter("passwd");
        UsersDao newuser = new UsersDao();
        try {
            int check = newuser.check(user, password);
            if (check != 0) {
                HttpSession session = request.getSession();
                session.setAttribute("id", check);
                response.sendRedirect("welcome.jsp");
            } else {
                System.out.println("error");
                response.sendRedirect("index.jsp");
            }
        } catch (Exception ex) {
            System.out.println(ex);
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
