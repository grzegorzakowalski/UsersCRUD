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
            if( msg.equals("edited")){
                req.setAttribute("msg","Poprawnie edytowano użytkownika");
            }
            if( msg.equals("deleted")){
                req.setAttribute("msg","Poprawnie usunięto użytkownika");
            }
            if( msg.equals("erroradd")){
                req.setAttribute("msg","Nie udało się dodać użytkownika");
            }
            if (msg.equals("erroredit")){
                req.setAttribute("msg","Nie udało się edytować użytkownika");
            }
            if (msg.equals("errordelete")){
                req.setAttribute("msg","Nie udało się usunąć użytkownika");
            }
        }

        getServletContext().getRequestDispatcher(getServletContext().getContextPath() + "/WEB-INF/list.jsp").forward(req,resp);
    }
    //TODO popraw linki i upiększ to

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

    }
}
