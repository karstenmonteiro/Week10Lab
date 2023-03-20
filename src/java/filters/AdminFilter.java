package filters;

import dataaccess.UserDB;
import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author Karsten Monteiro
 */
public class AdminFilter implements Filter {
    
    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
        throws IOException, ServletException {
        
        // executed before the servlet
        HttpServletRequest httpRequest = (HttpServletRequest)request;
        HttpSession session = httpRequest.getSession();
        String email = (String)session.getAttribute("email");
        
        // get the user's 'roleId'
        UserDB userDB = new UserDB();
        int roleId = userDB.get(email).getRole().getRoleId();
        
        // redirect non-admin users to 'notes' servlet
        if (roleId != 1) {
            HttpServletResponse httpResponse = (HttpServletResponse)response;
            httpResponse.sendRedirect("notes");
            
            return;
        }
        
        // execute servlet for verified admins
        chain.doFilter(request, response);
    }
    
    @Override
    public void init(FilterConfig filterConfig) {        
    
    }
    
    @Override
    public void destroy() {        
    
    }
}