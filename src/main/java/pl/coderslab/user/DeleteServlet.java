package pl.coderslab.user;

import pl.coderslab.User;
import pl.coderslab.UserDao;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/user/delete")
public class DeleteServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int id = Integer.parseInt(req.getParameter("id"));
        UserDao userDao = new UserDao();
        User user = userDao.read(id);
        req.setAttribute("name",user.getUserName());
        getServletContext().getRequestDispatcher(getServletContext().getContextPath() + "/WEB-INF/delete.jsp").forward(req,resp);

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int id = Integer.parseInt(req.getParameter("id"));
        UserDao userDao = new UserDao();
        boolean confirmation = userDao.deleteWithConfirmation(id);
        if ( confirmation) {
            resp.sendRedirect(getServletContext().getContextPath() + "/user/list?msg=deleted");
        } else {
            resp.sendRedirect(getServletContext().getContextPath() + "/user/list?msg=errordelete");
        }

    }
}
