package projeto.tcc;

import java.io.IOException;

import javax.enterprise.inject.Instance;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
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

import projeto.tcc.interfaceusuario.controle.LoginUsuarioBean;

@WebFilter("/xhtml/app/*")
public class FiltroTeste implements Filter {

	@Inject
    private Instance<LoginUsuarioBean> userInstance;
	
    @Override
    public void init(FilterConfig config) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest req, ServletResponse res, FilterChain chain) throws IOException, ServletException {
        HttpServletRequest request = (HttpServletRequest) req;
        HttpServletResponse response = (HttpServletResponse) res;
        Object aggregateID = request.getSession().getAttribute("aggregateID");
        if (aggregateID == null) { 
        	response.sendRedirect(request.getContextPath()+"/xhtml/loginUsuarioCPF.xhtml");
        	return;
        } 
        chain.doFilter(req, res);
        
    }

    @Override
    public void destroy() {

    }


}
