package pl.coderslab.user;

import pl.coderslab.User;
import pl.coderslab.UserDao;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;

@WebServlet("/user/edit")
public class EditServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int id = Integer.parseInt(req.getParameter("id"));
        UserDao userDao = new UserDao();
        User user = userDao.read(id);
        req.setAttribute("user",user);
        String msg = req.getParameter("msg");
        if( msg != null) {
            if (msg.equals("error")) {
                req.setAttribute("msg", "Źle podane wartości");
            }
        }
        getServletContext().getRequestDispatcher(getServletContext().getContextPath() + "/WEB-INF/edit.jsp").forward(req,resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String userName = req.getParameter("username");
        String email = req.getParameter("email");
        String password = req.getParameter("password");
        int id = Integer.parseInt(req.getParameter("id"));
        User user = new User(id,userName,email,password);
        if( !validUser(user)){
            resp.sendRedirect(getServletContext().getContextPath() + "/user/edit?msg=error");
        }
        UserDao userDao = new UserDao();
        try {
            userDao.update(user);
        } catch (SQLException e){
            resp.sendRedirect(getServletContext().getContextPath() + "/user/list?msg=erroredit");
        }
        resp.sendRedirect(getServletContext().getContextPath() + "/user/list?msg=edited");
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
