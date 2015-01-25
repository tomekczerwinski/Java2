package com.example.jeedemo.web;

import java.io.IOException;

import javax.inject.Inject;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.example.jeedemo.domain.Game;
import com.example.jeedemo.domain.MessageStorageService;
import com.example.jeedemo.service.GameManager;

@WebServlet(urlPatterns = "/add")
public class AddGameServlet extends HttpServlet {
	
    @Inject
    private GameManager storage;

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String name = request.getParameter("name");
        float price = Float.parseFloat(request.getParameter("cena"));
        //String title = request.getParameter("title");

        Game newGame = new Game();
        newGame.setName(name);
        newGame.setCena(price);

        storage.addGame(newGame);

        response.sendRedirect(response.encodeRedirectURL(request.getContextPath() + "/main"));
    }

}
