package web;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import domain.model.Account;

@WebServlet("/addAccountServlet")
public class AddAccountServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    protected void doGet(HttpServletRequest request,
                         HttpServletResponse response)
            throws ServletException, IOException {

        Account account = new Account();
        account.setUserName(request.getParameter("userName"));
        account.setUserPassword(request.getParameter("password"));
        account.setUserEmail(request.getParameter("email"));
        HttpSession session = request.getSession();
        session.setAttribute(SessionKey.account, account);



        response.sendRedirect("addProfile.html");

    }
}