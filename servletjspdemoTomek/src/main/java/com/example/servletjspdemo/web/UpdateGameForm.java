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
import com.example.servletjspdemo.domain.Person;
import com.example.servletjspdemo.service.StorageServiceTomek;

@WebServlet(urlPatterns = "/updateGameForm")

public class UpdateGameForm extends HttpServlet {
	//StorageServiceTomek sst = new StorageServiceTomek();
	//StorageServiceTomek sst = getServletContext().getAttribute("sesja");
	
	

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		PrintWriter writer = response.getWriter();
		
		StorageServiceTomek sst = (StorageServiceTomek) getServletContext().getAttribute("baza");
		
		if(request.getSession().getAttribute("gra") == null){
			request.getSession().setAttribute("gra", new Game());	
		}
		
		Game game = (Game) request.getSession().getAttribute("gra");

		 
		 


		 
		 String name = null;
		 name = request.getParameter("name");
		 
		 String dystrybutor = null;
		 dystrybutor = request.getParameter("dystrybutor");
		 
		 String platforma = null;
		 platforma = request.getParameter("platforma");
		 
		 int dataWydania = 0;
		 if(request.getParameter("dataWydania") != null) {
			 	dataWydania = Integer.parseInt(request.getParameter("dataWydania"));
		 	}
		 float cena =0;
		 if(request.getParameter("cena") != null) {
			 	cena = Float.parseFloat(request.getParameter("cena"));
		 	}

		 
		 /*
		 context.setAttribute("imie", imie);
		 context.setAttribute("rokUr", rokUr);
		 context.setAttribute("plec", plec);
		 context.setAttribute("hobby", selectedHobby);
		 context.setAttribute("opis", opis);
		 context.setAttribute("wyksztalcenie", wyksztalcenie);
		 context.setAttribute("selectedPrawko", selectedPrawko);
		 */
		 int ID = Integer.parseInt(request.getParameter("userId"));
         
		 
		 String body = "<html><body> ID: " + ID;
		 
		 sst.update(ID);

		
		body += ""
				+ "<form action=\"/servletjspdemo/updateGame\"; method=\"get\">"
				+	"Naza: <input type =\"text\" name=\"name\"value=\"" + game.getName() +"\"  />"
				+	"Data Wydania: <input type =\"text\" name=\"dataWydania\"value=\"" + game.getDataWydania() +"\"  />"
				+	"<input type =\"hidden\" name=\"id\"value=\"" + ID +"\"  />"
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
