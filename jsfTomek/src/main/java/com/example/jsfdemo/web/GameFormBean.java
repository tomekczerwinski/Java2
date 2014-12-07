package com.example.jsfdemo.web;

import java.io.Serializable;
import java.util.Calendar;
import java.util.Date;

import javax.enterprise.context.SessionScoped;
import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.component.UIForm;
import javax.faces.component.UIInput;
import javax.faces.context.FacesContext;
import javax.faces.event.ComponentSystemEvent;
import javax.faces.model.ListDataModel;
import javax.faces.validator.ValidatorException;
import javax.inject.Inject;
import javax.inject.Named;

import com.example.jsfdemo.domain.Game;
import com.example.jsfdemo.service.GameMenager;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Arrays;

import javax.faces.bean.ManagedBean;
@SessionScoped
@Named("gameBean")

/*
@ManagedBean(name = "gameBean", eager = true)
@SessionScoped

public class GameFormBean implements Serializable {

private static final long serialVersionUID = 1L;

   private String name;
   private String producent;
   private double cena;
   private String pegi;
   private ListDataModel<Game> games = new ListDataModel<Game>();



   public ArrayList<Game> getGames() {
      return games;
   }

   public String addGame() {		 
      Game game = new Game(name,producent,cena,pegi);
      games.add(game);
      return null;
   }

 /*  public String deleteGame(Game game) {
      games.remove(game);		
      return null;
   }
   
	public String deleteGame() {
		Game gameToDelete = games.getRowData();
		gm.deleteGame(gameToDelete);
		return null;
	}

   public String editGame(Game game){
      game.setCanEdit(true);
      return null;
   }

   public String saveGame(){
      //set "canEdit" of all employees to false 
      for (Game game : games){
         game.setCanEdit(false);
      }		
      return null;
   }
   
   public String getName() {
      return name;
   }

   public void setName(String name) {
      this.name = name;
   }

   public String getProducent() {
      return producent;
   }

   public void setProducent(String producent) {
      this.producent = producent;
   }

   public double getCena() {
      return cena;
   }

   public void setCena(int cena) {
      this.cena = cena;
   }

   public String getPegi() {
      return pegi;
   }

   public void setPegi(String pegi) {
      this.pegi = pegi;
   }
}
*/

public class GameFormBean implements Serializable {

	private static final long serialVersionUID = 1L;

	private Game game = new Game();

	private ListDataModel<Game> games = new ListDataModel<Game>();

	@Inject
	private GameMenager gm;

	public Game getGame() {
		return game;
	}

	public void setGame(Game game) {
		this.game = game;
	}

	public ListDataModel<Game> getAllGames() {
		games.setWrappedData(gm.getAllGames());
		return games;
	}

	// Actions
	public String addGame() {
		gm.addGame(game);
		return "showPersons";
		//return null;
	}

	public String deleteGame() {
		Game gameToDelete = games.getRowData();
		gm.deleteGame(gameToDelete);
		return null;
	}
	

	
	public String editGame(){
		Game gameToUpdate = games.getRowData();
		gm.updateGame(gameToUpdate);
		     
		      return "showUpdate";
		   }
	
	   public String saveGame(){
		      //set "canEdit" of all employees to false 
		   
		   gm.updateGameFinish(game);
		      return "showPersons";
		   }
	

	// Validators

	// Business logic validation
	
	/*
	public void uniquePin(FacesContext context, UIComponent component,
			Object value) {

		String pin = (String) value;

		for (Game person : pm.getAllGames()) {
			if (person.getPin().equalsIgnoreCase(pin)) {
				FacesMessage message = new FacesMessage(
						"Person with this PIN already exists in database");
				message.setSeverity(FacesMessage.SEVERITY_ERROR);
				throw new ValidatorException(message);
			}
		}
	}
	

	// Multi field validation with <f:event>
	// Rule: first two digits of PIN must match last two digits of the year of
	// birth
	public void validatePinDob(ComponentSystemEvent event) {

		UIForm form = (UIForm) event.getComponent();
		UIInput pin = (UIInput) form.findComponent("pin");
		UIInput dob = (UIInput) form.findComponent("dob");

		if (pin.getValue() != null && dob.getValue() != null
				&& pin.getValue().toString().length() >= 2) {
			String twoDigitsOfPin = pin.getValue().toString().substring(0, 2);
			Calendar cal = Calendar.getInstance();
			cal.setTime(((Date) dob.getValue()));

			String lastDigitsOfDob = ((Integer) cal.get(Calendar.YEAR))
					.toString().substring(2);

			if (!twoDigitsOfPin.equals(lastDigitsOfDob)) {
				FacesContext context = FacesContext.getCurrentInstance();
				context.addMessage(form.getClientId(), new FacesMessage(
						"PIN doesn't match date of birth"));
				context.renderResponse();
			}
		}
	}*/
}

