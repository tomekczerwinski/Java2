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

import com.example.servletjspdemo.domain.Person;

@WebServlet(urlPatterns = "/personFormData")

public class OdbierzDane extends HttpServlet {
	//StorageServiceTomek sst = new StorageServiceTomek();
	//StorageServiceTomek sst = getServletContext().getAttribute("sesja");
	StorageServiceTomek sst = (StorageServiceTomek) getServletContext().getAttribute("MojaOsoba");
	

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		if(request.getSession().getAttribute("MojaOsoba") == null){
			request.getSession().setAttribute("MojaOsoba", new OsobaBaza());
			
			
		}
		
		OsobaBaza p = (OsobaBaza) request.getSession().getAttribute("MojaOsoba");
		response.setContentType("text/html");
		HttpSession session = request.getSession(); 
		ServletContext context = request.getSession().getServletContext();
		PrintWriter writer = response.getWriter();
		 String plec = null;
		 
		 
		 //String[] hobby = request.getParameterValues("hobby");
		 String hobbyWyj = "";
		 String prawkoWyj = "";
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
				
		String selectedHobby = "";
		if(request.getParameter("hobby") != null){
				for (String hobby : request.getParameterValues("hobby")) {
					selectedHobby += hobby + " ";
					}
				}
		String selectedPrawko = "";
		
		if(request.getParameter("prawoJazdy") != null){
				for (String prawoJazdy : request.getParameterValues("prawoJazdy")) {
					selectedPrawko += prawoJazdy + " ";
				}
			}
				else selectedPrawko += "Brak prawa jazdy";
		
			 
		 
		 if(request.getParameter("plec") != null) {
             if(request.getParameter("plec").equals("M")) {
                 plec = "Mezczyzna";
             }
             else {
            	 plec = "Kobieta";
             }
		 }
		 
		 String imie = null;
		 imie = request.getParameter("imie");
		 int rokUr = 0;
		 if(request.getParameter("rokur") != null) {
			 	rokUr = Integer.parseInt(request.getParameter("rokur"));
		 	}
		 String opis = null;
		 if(request.getParameter("opis") != null) {
		 opis = request.getParameter("opis");
		 	}
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
				+ "<form action=\"/servletjspdemo/personForm\">"
				+ imie
				+ "<br/> Rok Urodzenia: "
				+ rokUr
				+ "<br/> Plec: "
				+ plec
				+ "<br/> Hobby: "
				+ selectedHobby
				+ "<br/> Opis: "
				+ opis
				+ "<br/> Wyksztalcenie: "
				+ wyksztalcenie
				+ "<br/> Prawo Jazdy: "
				+ selectedPrawko
				+ "<br/><br/>"
				+"Session id: " + session.getId() + "<br/>";

		
	
		
		
		
		
		
		//OsobaBaza p = new OsobaBaza();

		sst.add(p);
		sst.getAllPersons();
		
		
		p.setName(imie);
		p.setHobby(selectedHobby);
		p.setOpis(opis);
		p.setPlec(plec);
		p.setRokUr(rokUr);
		p.setWyksztalcenie(wyksztalcenie);
		p.setPrawoJazdy(selectedPrawko);
		
		body += "<ol>";
		for(int j=0;j<sst.size();j++){
			body+="<li> Imie: "
			+sst.getAllPersons().get(j).getName()
			+"<br/> Rok Urodzenia: "
			+sst.getAllPersons().get(j).getRokUr()
			+"<br/> Plec: "
			+sst.getAllPersons().get(j).getPlec()
			+"<br/> Hobby: "
			+sst.getAllPersons().get(j).getHobby()
			+"<br/> Opis: "
			+sst.getAllPersons().get(j).getOpis()
			+"<br/> Wyksztalcenie: "
			+sst.getAllPersons().get(j).getWyksztalcenie()
			+"<br/> Prawo jazdy: "
			+sst.getAllPersons().get(j).getWyksztalcenie();
			
			
		}
		body += "<br/><br/> <input type =\"submit\" value=\"Powrot\" />"
				+"<br/><br/></body></html>";
		
		writer.println(body);
		writer.close();
		
		
	}
		@Override
		public void init() throws ServletException {
			if(getServletContext().getAttribute("MojaOsoba") == null)
			{
				getServletContext().setAttribute("MojaOsoba", new StorageServiceTomek());
			}
		}
		
	

}
