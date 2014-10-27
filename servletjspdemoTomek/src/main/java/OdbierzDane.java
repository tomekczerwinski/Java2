import java.io.IOException;
import java.io.PipedWriter;
import java.io.PrintWriter;
import java.io.Writer;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.ws.rs.core.Response;

import com.example.servletjspdemo.domain.Person;

@WebServlet(urlPatterns = "/personFormData")

public class OdbierzDane extends HttpServlet {
	StorageServiceTomek sst = new StorageServiceTomek();

	
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/html");
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
				for (String hobby : request.getParameterValues("hobby")) {
					selectedHobby += hobby + " ";
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
		 
		 String imie = request.getParameter("imie");
		 int rokUr = Integer.parseInt(request.getParameter("rokur"));
		 String opis = request.getParameter("opis");
		 String wyksztalcenie = request.getParameter("wyksztalcenie");
		 
		String body = "<html><body> Name: "
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
				+ "<br/><br/>";

		
	
		
		
		OsobaBaza p = new OsobaBaza();
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
		for(OsobaBaza osoba : sst.getAllPersons()){
			body+="<li>"
			+osoba.getName()
			+"<li>"
			+osoba.getRokUr()
			+"<li>"
			+osoba.getPlec()
			+"<li>"
			+osoba.getHobby()
			+"<li>"
			+osoba.getOpis()
			+"<li>"
			+osoba.getWyksztalcenie()
			+"<li>"
			+osoba.getPrawoJazdy()
			+"<li>"
			+"<br/><br/></body></html>";
			
		}
		
		writer.println(body);
		writer.close();
		
		
	}
	

}
