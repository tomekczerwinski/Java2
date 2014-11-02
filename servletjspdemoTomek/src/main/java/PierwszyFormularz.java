import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(urlPatterns = "/personForm")

public class PierwszyFormularz extends HttpServlet {
	

@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) 
		throws ServletException, IOException{
			
			
			if(request.getSession().getAttribute("osoba") == null){
				request.getSession().setAttribute("osoba", new OsobaBaza());
				
				
			}
			
			OsobaBaza osoba = (OsobaBaza) request.getSession().getAttribute("osoba");
			PrintWriter writer = response.getWriter();
			writer.write("<html>"
					+ "<body>"
					+ "<h2>"
					+ "HelloWord"
					+ "</h2>"
					+ "<form action=\"/servletjspdemo/personFormData\">"
					+	"Imie: <input type =\"text\" name=\"imie\"" + osoba.getName() + " />"
					+	"<br> rokUr: <input type =\"int\" name=\"rokur\"" + osoba.getRokUr() + " />"
					+ 	"<br> Plec: <input type =\"radio\" name=\"plec\" value=\"M\" /> M"
					+ 	"<input type =\"radio\" name=\"plec\" value=\"K\" /> K"
					+	"<br> Hobby: <br> <input type =\"checkbox\" name=\"hobby\" value=\"Ksiazki\" /> Ksiazki"
					+	"<br> <input type =\"checkbox\" name=\"hobby\" value=\"Plywanie\" /> Plywanie"
					+	"<br> opis: <br> <textarea name=\"opis\" cols=\"30\" rows=\"10\" /> OPIS </textarea>"
					+	"<br> Wyksztalcenie: <select name=\"wyksztalcenie\" />"
					+	"<option> Podtawowe </option>"
					+	"<option> Srednie </option>"
					+	"<option> Wyzsze </option>"
					+	"</select>"
					+	"<br> Prawo jazdy: <br/> <select multiple name=\"prawoJazdy\" />"
					+	"<option> A1 </option>"
					+	"<option> B1 </option>"
					+	"<option> C1 </option>"
					+	"</select>"
					+	"<br> <input type =\"submit\" value=\"Wyslij\" />"
					+ "</form>"
					+ "</body>"
					+ "</html>");
			
			
			
		
		
			writer.close();
		}
	
	
	
	}




