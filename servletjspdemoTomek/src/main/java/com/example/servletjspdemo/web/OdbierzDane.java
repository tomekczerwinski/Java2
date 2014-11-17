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

@WebServlet(urlPatterns = "/gameData")

public class OdbierzDane extends HttpServlet {
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
		
		//response.setContentType("text/html");
		//HttpSession session = request.getSession(); 
		//ServletContext context = request.getSession().getServletContext();
		
		 
		 
		 
		 //String[] hobby = request.getParameterValues("hobby");

		// for(int i=0; i<hobby.length; i++){
		//	 hobbyWyj += hobby[i] + " ";
		// }
		
		/*String[] prawko = request.getParameterValues("prawoJazdy");
			 	
				if (prawko != null){
					for (int k = 0; k < prawko.length; k++) {
						if (k == prawko.length - 1){
							prawkoWyj = prawkoWyj + "'" + prawko[k] + "'";
						}else{
							prawkoWyj = prawkoWyj + "'" + prawko[k] + "',";
						}
					}
				}*/
				
		/*String[] hobby = request.getParameterValues("hobby");
			 	
				if (hobby != null){
					for (int k = 0; k < hobby.length; k++) {
						if (k == hobby.length - 1){
							hobbyWyj = hobbyWyj + "'" + hobby[k] + "'";
						}else{
							hobbyWyj = hobbyWyj + "'" + hobby[k] + "',";
						}
					}
				}*/
				

		
		
		/*
		String selectedPrawko = "";
		
		if(request.getParameter("prawoJazdy") != null){
				for (String prawoJazdy : request.getParameterValues("prawoJazdy")) {
					selectedPrawko += prawoJazdy + " ";
				}
			}
				else selectedPrawko += "Brak prawa jazdy";
		
		*/	 
		 /*
		 if(request.getParameter("plec") != null) {
             if(request.getParameter("plec").equals("M")) {
                 plec = "Mezczyzna";
             }
             else {
            	 plec = "Kobieta";
             }
		 }
		 */
		
		
		String selectedPlatforma = "";
		if(request.getParameter("platforma") != null){
				for (String platforma : request.getParameterValues("platforma")) {
					selectedPlatforma += platforma + " ";
					}
				}
		 
		 String name = null;
		 name = request.getParameter("name");

		 String dystrybutor = null;
		 dystrybutor = request.getParameter("dystrybutor");
		
		 int dataWydania = 0;
		 if(request.getParameter("dataWydania") != null) {
			 	dataWydania = Integer.parseInt(request.getParameter("dataWydania"));
		 	}
		 
		 
		Float cena = null;
		cena = Float.parseFloat(request.getParameter("cena"));
		 
		 
		String body = "<html><body><head><link rel=\"stylesheet\" type=\"text/css\" href=\"dist/css/bootstrap.css\"></head><title>Add</title> Rekord zostal dodany! "
				+ "<form action=\"/servletjspdemo/showAllGames.jsp\">";

		Game newGame = new Game();
		
		newGame.setName(name);
		newGame.setPlatforma(selectedPlatforma);
		newGame.setCena(cena);
		newGame.setDystrybutor(dystrybutor);
		newGame.setDataWydania(dataWydania);
		newGame.setId(Game.lastID);

		sst.add(newGame);
		Game.lastID++;
		
		
		body += "<br/> <input type =\"submit\" value=\"Powrot\" />"
				+"<br/></body></html>";
		
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
