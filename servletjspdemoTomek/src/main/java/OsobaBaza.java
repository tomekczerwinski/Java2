
public class OsobaBaza {
	private String imie = "";
	private int rokUr =0;
	private String plec = "";
	private String hobby = "";
	private String opis = "";
	private String wyksztalcenie = "";
	private String prawoJazdy = "";
	
	
	public OsobaBaza() {
		super();
	}
	
	public OsobaBaza(String imie, int rokUr, String plec, String hobby, String opis, String wyksztalcenie, String prawoJazdy) {
		super();
		this.imie = imie;
		this.rokUr = rokUr;
		this.plec = plec;
		this.hobby = hobby;
		this.opis = opis;
		this.wyksztalcenie = wyksztalcenie;
		this.prawoJazdy = prawoJazdy;
	}

	public String getName() {
		return imie;
	}
	public void setName(String imie) {
		this.imie = imie;
	}
	
	public int getRokUr() {
		return rokUr;
	}
	public void setRokUr(int rokUr) {
		this.rokUr = rokUr;
	}
	
	public String getPlec() {
		return plec;
	}
	public void setPlec(String plec) {
		this.plec = plec;
	}
	
	public String getHobby() {
		return hobby;
	}
	public void setHobby(String hobby) {
		this.hobby = hobby;
	}
	
	public String getOpis() {
		return opis;
	}
	public void setOpis(String opis) {
		this.opis = opis;
	}
	
	public String getWyksztalcenie() {
		return wyksztalcenie;
	}
	public void setWyksztalcenie(String wyksztalcenie) {
		this.wyksztalcenie = wyksztalcenie;
	}
	
	public String getPrawoJazdy() {
		return prawoJazdy;
	}
	public void setPrawoJazdy(String prawoJazdy) {
		this.prawoJazdy = prawoJazdy;
	}

}
