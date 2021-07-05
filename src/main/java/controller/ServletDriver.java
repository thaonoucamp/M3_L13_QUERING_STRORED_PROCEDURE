package controller;

import connection.DAOManager;
import connection.IDAO;
import model.User;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

@WebServlet(name = "ServletDriver", urlPatterns = "/ServletDriver")
public class ServletDriver extends HttpServlet {
    IDAO manager = new DAOManager();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");

        if (action == null) {
            action = "";
        }
        try {

            switch (action) {
                case "create":
                    showCreateForm(request, response);
                    break;
                default:
                    showAllUsers(request, response);
                    break;
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        if (action == null) {
            action = "";
        }
        try {

            switch (action) {
                case "create":
                    create(request, response);
                    break;
                default:
                    showAllUsers(request, response);
                    break;
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    private void create(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        RequestDispatcher dispatcher = request.getRequestDispatcher("/list.jsp");
        dispatcher.forward(request, response);

    }

    private void showAllUsers(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, SQLException {
        List<User> userList = manager.selectAllUser();
        RequestDispatcher dispatcher = request.getRequestDispatcher("/list.jsp");
        request.setAttribute("userList", userList);
        dispatcher.forward(request, response);
    }

    private void showCreateForm(HttpServletRequest request, HttpServletResponse response) throws SQLException {
        int id = Integer.parseInt(request.getParameter("user_id"));
        User user = manager.getUserById(id);
        manager.insertUser(user);
    }
}
