

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
import java.io.InputStream;
import java.util.Properties;

import com.sun.tools.javac.Main;


public class FiltroLenguajeCliente extends HttpFilter implements Filter {
       
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		
		HttpServletRequest httpRequest = (HttpServletRequest)request;
		String lenguaje=httpRequest.getLocale().getLanguage();
		String nombreArchivoLenguaje;
		
		if ( lenguaje == "en") {
			nombreArchivoLenguaje= "textos_en.properties";
		} else {
			nombreArchivoLenguaje= "textos_es.properties";
		}
		httpRequest.setAttribute("Language-File", nombreArchivoLenguaje);
		chain.doFilter(httpRequest, response);
	}
}
