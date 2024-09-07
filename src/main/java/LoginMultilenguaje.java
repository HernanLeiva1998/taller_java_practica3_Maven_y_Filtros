

import jakarta.servlet.ServletConfig;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.util.Properties;

public class LoginMultilenguaje extends HttpServlet {
	Properties properties;
    
	@Override
    public void init(ServletConfig config) throws ServletException {
		super.init(config);
    	this.properties= new Properties();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try (InputStream input = 
				this.getClass().
				getClassLoader().
				getResourceAsStream(request.getAttribute("Language-File").toString());
			)
		{
			if (input == null) {
				System.out.println("No existe el archivo:" + request.getAttribute("Language-File").toString());
				return;
			}

			this.properties.load(input);
			
			response.setContentType("text/html");
			PrintWriter out = response.getWriter();
			
			out.println("<html><body>");
			out.println("<h1>" + this.properties.getProperty("titulo") +  "</h1>");
			out.println("<form action=\"\" method=\"\">");
			out.println("<label for=\"nombre\">" + this.properties.getProperty("labelusuario") + "</label>");
			out.println("<input type=\"text\" id=\"nombre\" name=\"nombre\"><br>");
			out.println("<label for=\"password\">" + this.properties.getProperty("labelpassword") + "</label>");
			out.println("<input type=\"text\" id=\"password\" name=\"password\"><br>");
			out.println("<input type=\"submit\" name=\"b1\" value=\"Enviar\">");
			out.println("</body></html>");
			out.close();
			
			
		} catch (IOException ex) {
			ex.printStackTrace();
		}
	}

}
