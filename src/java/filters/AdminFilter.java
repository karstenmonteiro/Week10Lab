package filters;

import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

/**
 *
 * @author Karsten Monteiro
 */
public class AdminFilter implements Filter {
    
    /**
     * 
     * @param request
     * @param response
     * @param chain
     * @throws IOException
     * @throws ServletException 
     */
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
            throws IOException, ServletException {
        
        
    }
    
    public void init(FilterConfig filterConfig) {        
    
    }
    
    /**
     * Destroy method for this filter
     */
    public void destroy() {        
    
    }
}