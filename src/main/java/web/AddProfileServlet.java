package web;

import domain.model.Account;
import domain.model.Profile;
import domain.model.Like;

import java.io.IOException;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/addProfileServlet")
public class AddProfileServlet extends HttpServlet{

    private static final long serialVersionUID = 1L;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        String age =req.getParameter("age");

        HttpSession session = req.getSession();
        Account account = (Account) session.getAttribute(SessionKey.account);
        if(account==null)
        {
            resp.sendRedirect("/addAccount.html");
        }

        Profile profile = new Profile();
        profile.setFirstName(req.getParameter("firstName"));
        profile.setLastName(req.getParameter("lastName"));
        profile.setCity(req.getParameter("city"));
        profile.setCountry(req.getParameter("country"));
        profile.setAge(Integer.parseInt(age));

        resp.sendRedirect("yourProfile.html");
    }
}