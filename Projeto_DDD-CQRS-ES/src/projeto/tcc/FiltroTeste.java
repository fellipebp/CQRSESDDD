package projeto.tcc;

import java.io.IOException;

import javax.enterprise.inject.Instance;
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
        String url = request.getContextPath()+"/xhtml/loginUsuario.xhtml";
//        HttpSession session = request.getSession(false);
        
        LoginUsuarioBean user;
        user = userInstance.get();

        if (user.getFazerLoginDTO().getLogin() == null) { // Do jeito que está, se não conseguir se logar, ele vai conseguir acessar paginas que nao deveria. Tem que pensar melhor aqui
            response.sendRedirect(url);
        } else {
            chain.doFilter(req, res);
        }
    }

    @Override
    public void destroy() {

    }


}
