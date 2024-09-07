

import jakarta.servlet.Filter;
import jakarta.servlet.FilterChain;
import jakarta.servlet.FilterConfig;
import jakarta.servlet.ServletException;
import jakarta.servlet.ServletRequest;
import jakarta.servlet.ServletResponse;
import jakarta.servlet.annotation.WebFilter;
import jakarta.servlet.http.HttpFilter;
import jakarta.servlet.http.HttpServletRequest;

import java.io.IOException;
import java.time.LocalDateTime;
import jakarta.servlet.http.HttpServletResponse;
/**
 * Servlet Filter implementation class FiltroLogDeAccesos
 */
public class FiltroLogDeAccesos extends HttpFilter implements Filter {
	
	FilterConfig config;
	
	public void init(FilterConfig config) throws ServletException{
		this.config=config;
	}
       

	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		HttpServletRequest req= (HttpServletRequest)request;
		
		
		this.config.getServletContext().log("Host: " + req.getRemoteHost());
		this.config.getServletContext().log("User-Agent: " + req.getHeader("User-Agent") + " | Hora: " + LocalDateTime.now().toString());
		this.config.getServletContext().log("Request Line: Protocolo = " + req.getProtocol() +
				" |Metodo = " + req.getMethod() + " |Recurso = " + req.getRequestURI());
		chain.doFilter(request, response);
	}
}
