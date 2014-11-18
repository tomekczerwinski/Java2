package com.example.servletjspdemo.web;
import java.io.IOException;
import java.io.PipedWriter;
import java.io.PrintWriter;
import java.io.Writer;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.ws.rs.core.Response;

import com.example.servletjspdemo.domain.Game;
import com.example.servletjspdemo.service.StorageServiceTomek;

@WebServlet(urlPatterns = "/updateGameForm")

public class UpdateGameForm extends HttpServlet {

	
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		PrintWriter writer = response.getWriter();
		
		 
		 String name = null;
		 name = request.getParameter("name");
		 
		 
		 boolean sq = false;
		 boolean sony = false;
		 if(request.getParameter("dystrybutor").equalsIgnoreCase("Square-Enix") ){
				sq=true;
			}
		 if(request.getParameter("dystrybutor").equalsIgnoreCase("Sony") ){
				sony=true;
			}
		 
		 String dystrybutor = null;
		 dystrybutor = request.getParameter("dystrybutor");

		 
		 int dataWydania = 0;
		 if(request.getParameter("dataWydania") != null) {
			 	dataWydania = Integer.parseInt(request.getParameter("dataWydania"));
		 	}
		 float cena =0;
		 if(request.getParameter("cena") != null) {
			 	cena = Float.parseFloat(request.getParameter("cena"));
		 	}

		 
		 int ID = Integer.parseInt(request.getParameter("gameId"));
         
		 
		 String body = "<html><body><head><link rel=\"stylesheet\" type=\"text/css\" href=\"dist/css/bootstrap.css\"></head><title>Update</title> ID: " + ID;

		 boolean ps3 = false;
		 boolean x360 = false;
		 	if(request.getParameter("platforma").toLowerCase().contains("Playstation 3".toLowerCase())) ps3 = true;
		 	if(request.getParameter("platforma").toLowerCase().contains("Xbox 360".toLowerCase())) x360 = true;
		 	
		 	
		
		body += ""
				+ "<form action=\"/servletjspdemo/updateGame\"; method=\"get\">"
				+	"Nazwa: <input type =\"text\" name=\"name\"value=\"" + name +"\"  /><br />"
				+	"Dystrybutor :<select name=\"dystrybutor\">";
		if(sq) body+="<option selected>Square-Enix</option>";
		else body+="<option>Square-Enix</option>";
		if(sony) body+="<option selected>Sony</option>";
		else body+="<option>Sony</option>";
		
		body+="</select><br/>";
		
		body+="Data Wydania: <input type =\"int\" name=\"dataWydania\"value=\"" + dataWydania +"\"  /><br />";
		
		if(ps3) body+="Platforma: <br><input type=\"checkbox\" name=\"platforma\" value=\"Playstation 3\" checked>Playstation 3<br/> ";
		else body+="Platforma: <br><input type=\"checkbox\" name=\"platforma\" value=\"Playstation 3\">Playstation 3<br /> ";
		if(x360) body+="<input type=\"checkbox\" name=\"platforma\" value=\"Xbox 360\" checked> Xbox 360<br/>" ;
		else body+="<input type=\"checkbox\" name=\"platforma\" value=\"Xbox 360\"> Xbox 360<br/>" ;
		
		body+=	"Cena: <input type =\"float\" name=\"cena\"value=\"" + cena +"\"  /><br />"
				+"<input type =\"hidden\" name=\"id\"value=\"" + ID +"\"  />"
				+ "<br/><br/> <input type =\"submit\" value=\"Update\" />"
				+"<br/><br/></body></html>";
		
		writer.println(body);
		writer.close();
		
		
	}
		@Override
		public void init() throws ServletException {
			if(getServletContext().getAttribute("baza") == null)
			{
				getServletContext().setAttribute("baza", new StorageServiceTomek());
			}
		}
		
	

}
