import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet(urlPatterns = "/personForm")

public class PierwszyFormularz extends HttpServlet {
	

@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) 
		throws ServletException, IOException{
			
			
			if(request.getSession().getAttribute("osoba") == null){
				request.getSession().setAttribute("osoba", new OsobaBaza());
				
				
			}
			int m=0,k=0, ksiazki=0, plywanie=0, pdst=0, srednie=0, wyzsze=0, a1=0, b1=0, c1=0;
			
			
			OsobaBaza osoba = (OsobaBaza) request.getSession().getAttribute("osoba");
			if(osoba.getPlec().equalsIgnoreCase("Mezczyzna") ){
				m=1;
			}else 
			if(osoba.getPlec().equalsIgnoreCase("Kobieta") ){
				k=1;
			}
			
			if(osoba.getHobby().toLowerCase().contains("Ksiazki".toLowerCase())) ksiazki = 1;
			if(osoba.getHobby().toLowerCase().contains("Plywanie".toLowerCase())) plywanie = 1;
			
			if(osoba.getWyksztalcenie().equalsIgnoreCase("Wyzsze") ){
				wyzsze=1;
			}else 
			if(osoba.getWyksztalcenie().equalsIgnoreCase("Srednie") ){
				srednie=1;
			}else		
			if(osoba.getWyksztalcenie().equalsIgnoreCase("Podstawowe") ) {
				pdst=1;
			}
			
			
			if(osoba.getPrawoJazdy().equalsIgnoreCase("A1") ){
				a1=1;
			}
			if(osoba.getPrawoJazdy().equalsIgnoreCase("B1") ){
				b1=1;
			}
			if(osoba.getPrawoJazdy().equalsIgnoreCase("C1") ){
				c1=1;
			}
			
			PrintWriter writer = response.getWriter();
			writer.write("<html>"
					+ "<body>"
					+ "<h2>"
					+ "HelloWord"
					+ "</h2>"
					+ "<form action=\"/servletjspdemo/personFormData\"; method=\"get\">"
					+	"Imie: <input type =\"text\" name=\"imie\"value=\"" + osoba.getName() +"\"  />"
					+"<br> rokUr: <input type =\"int\" name=\"rokur\"value=\""+osoba.getRokUr()+"\" /><br/>");
			
			
			if(k==1) writer.println("Plec: <br><input type=\"radio\" name=\"plec\" value=\"K\" checked>Kobieta<br> ");
			else writer.println("Plec: <br><input type=\"radio\" name=\"plec\" value=\"K\">Kobieta<br> ");
			if(m==1) writer.println("<input type=\"radio\" name=\"plec\" value=\"M\" checked>Mezczyzna<br>");      
			else writer.println("<input type=\"radio\" name=\"plec\" value=\"M\">Mezczyzna<br>"); 
			
			if(ksiazki==1) writer.println("Hobby: <br><input type=\"checkbox\" name=\"hobby\" value=\"Ksiazki\" checked>Ksiazki<br> ");
			else writer.println("Hobby: <br><input type=\"checkbox\" name=\"hobby\" value=\"Ksiazki\">Ksiazki<br> ");
			if(plywanie==1) writer.println("<input type=\"checkbox\" name=\"hobby\" value=\"Plywanie\" checked> Plywanie<br>");      
			else writer.println("<input type=\"checkbox\" name=\"hobby\" value=\"Plywanie\"> Plywanie<br>"); 
			
		
			
			writer.write("<br> opis: <br> <textarea name=\"opis\" cols=\"30\" rows=\"10\">" + osoba.getOpis() + "</textarea><br/>");
			
			writer.println("Wyksztalcenie :<br> <select name=\"wyksztalcenie\">");
			
			if(wyzsze==1)writer.println("<option selected>Wyzsze</option>");
			else writer.println("<option>Wyzsze</option>");
			if(srednie==1)writer.println("<option selected>Srednie</option>");
			else writer.println("<option>Srednie</option>");
			if(pdst==1)writer.println("<option selected>Podstawowe</option>");
			else writer.println("<option>Podstawowe</option><br/>");
			writer.println("</select><br/>");
			
			
			writer.println("Prawo Jazdy :<br> <select multiple name=\"prawoJazdy\">");
			if(a1==1)writer.println("<option selected>A1</option>");
			else writer.println("<option>A1</option>");
			if(b1==1)writer.println("<option selected>B1</option>");
			else writer.println("<option>B1</option>");
			if(c1==1)writer.println("<option selected>C1</option>");
			else writer.println("<option>C1</option>");
			writer.println("</select>");
			
			
			writer.write(
					"<br> <input type =\"submit\" value=\"Wyslij\" />"
					+ "</form>"
					+ "</body>"
					+ "</html>");
			
			
			
		
		
			writer.close();
		}
	
	
	
	}




