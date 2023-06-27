package pl.coderslab.user;

import pl.coderslab.User;
import pl.coderslab.UserDao;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/user/list")
public class ListServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        UserDao userDao = new UserDao();
        User[] users = userDao.findAll();
        req.setAttribute("users", users);
        String msg = req.getParameter("msg");
        if( msg != null){
            if( msg.equals("added")){
                req.setAttribute("msg","Poprawnie dodano nowego użytkownika");
            }
        }

        getServletContext().getRequestDispatcher(getServletContext().getContextPath() + "/WEB-INF/list.jsp").forward(req,resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

    }
}