package web.filters;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import web.SessionKey;
import domain.model.Account;

@WebFilter(urlPatterns = {"/addProfile.html","/addProfileServlet","/yourProfile.html","/addAccountServlet"})
public class AddAccountFilter implements Filter {

    public AddAccountFilter() {
    }

    public void destroy() {
    }

    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        HttpServletRequest req = (HttpServletRequest)request;
        HttpSession session = req.getSession();
        Account account = (Account) session.getAttribute(SessionKey.account);
        if(account==null){
            ((HttpServletResponse) response).sendRedirect("/FindMate/addAccount.html");
        }
        else{
            chain.doFilter(request, response);
        }
    }

    public void init(FilterConfig fConfig) throws ServletException {
    }

}