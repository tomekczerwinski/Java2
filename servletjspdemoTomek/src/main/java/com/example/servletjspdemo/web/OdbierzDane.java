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
				
	
		
		/*if(request.getParameter("platforma") != null){
				for (String platforma : request.getParameterValues("platforma")) {
					selectedPlatforma += platforma + " ";
					}
				}
		*/
		
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
		 
		 String name = null;
		 name = request.getParameter("name");
		 
		String selectedPlatforma = "";
		selectedPlatforma = (request.getParameter("platforma"));
		 
		String dystrybutor = null;
		dystrybutor = request.getParameter("dystrybutor");
		
		 int dataWydania = 0;
		 if(request.getParameter("dataWydania") != null) {
			 	dataWydania = Integer.parseInt(request.getParameter("dataWydania"));
		 	}
		 
		 
		 Float cena = null;
		 cena = Float.parseFloat(request.getParameter("cena"));
		 
		 
		/* if(request.getParameter("opis") != null) {
		 cena = request.getParameter("opis");
		 	}
		 	
		 	*/
		 
		 String wyksztalcenie = null;
		 if(request.getParameter("wyksztalcenie") != null) {
			 	wyksztalcenie = request.getParameter("wyksztalcenie");
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

		 
		String body = "<html><body> Name: "
				+ "<form action=\"/servletjspdemo/showAllGames.jsp\">"
				+ name
				+ "<br/> Rok Urodzenia: "
				+ dataWydania
				+ "<br/> Plec: "
				+ dystrybutor
				+ "<br/> Hobby: "
				+ selectedPlatforma
				+ "<br/> Opis: "
				+ cena
				+ "<br/><br/>";
				//+"Session id: " + session.getId() + "<br/>";

		
	
		
		
		
		// int id = 0;
		// if(request.getParameter("id") != null) {
			 //	dataWydania = Integer.parseInt(request.getParameter("id"));
		// 	}
		
		//OsobaBaza p = new OsobaBaza();

		
		//sst.getAllPersons();
		
		
		game.setName(name);
		game.setPlatforma(selectedPlatforma);
		game.setCena(cena);
		game.setDystrybutor(dystrybutor);
		game.setDataWydania(dataWydania);
		game.setId(game.id);
		
		sst.add(game);
		game.id++;
		
		
		/*body += "<ol>";
		for(int j=0;j<sst.size();j++){
			body+="<li> Imie: "
			+sst.getAllGames().get(j).getName()
			+"<br/> Rok Urodzenia: "
			+sst.getAllGames().get(j).getDataWydania()
			+"<br/> Plec: "
			+sst.getAllGames().get(j).getDystrybutor()
			+"<br/> Hobby: "
			+sst.getAllGames().get(j).getPlatforma()
			+"<br/> Opis: "
			+sst.getAllGames().get(j).getCena();
			
			
		}*/
		
		body += "<br/><br/> <input type =\"submit\" value=\"Powrot\" />"
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
