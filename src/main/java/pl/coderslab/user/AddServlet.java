package pl.coderslab.user;

import pl.coderslab.User;
import pl.coderslab.UserDao;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/user/add")
public class AddServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String msg = req.getParameter("msg");
        if (msg != null){
            if( msg.equals("error")){
                req.setAttribute("msg","Coś poszło nie tak");
            }
        }
        getServletContext().getRequestDispatcher(getServletContext().getContextPath() + "/WEB-INF/add.jsp").forward(req,resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String userName = req.getParameter("username");
        String email = req.getParameter("email");
        String password = req.getParameter("password");
        User user = new User(userName,email,password);
        UserDao userDao = new UserDao();
        if( !validUser(user)){
            resp.sendRedirect(getServletContext().getContextPath() + "/user/add?msg=error");
        }
        userDao.create(user);
        resp.sendRedirect(getServletContext().getContextPath() + "/user/list?msg=added");

    }

    private boolean validUser(User user){
        if (user.getUserName() == null){
            return false;
        }
        if(user.getEmail() == null){
            return false;
        }
        if (user.getPassword() == null){
            return false;
        }
        return true;
    }
}
