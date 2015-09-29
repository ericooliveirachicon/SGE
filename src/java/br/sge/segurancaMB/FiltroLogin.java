package br.sge.segurancaMB;


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
 * @author alex
 */
public class FiltroLogin implements Filter{

     public void destroy() {
        
    }
    
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException{
        TbUsuarioMB usr = null;
        HttpSession sess = ((HttpServletRequest) request).getSession(false);
        
        if(sess != null){
            usr = (TbUsuarioMB) sess.getAttribute("usuarioLogin");
        }
        
            if(usr == null){
                String contexPath = ((HttpServletRequest)request).getContextPath();
                ((HttpServletResponse) response).sendRedirect(contexPath + "/faces/login.xhtml");
            }else{
                chain.doFilter(request, response);
            }
    }    

    
    public void init(FilterConfig arg0) throws ServletException {
     
    }
}
