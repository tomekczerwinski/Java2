package com.example.jeedemo.web;

import java.io.IOException;

import javax.inject.Inject;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.example.jeedemo.service.GameManager;


@WebServlet(urlPatterns = "/edit/*")
public class EditGameServlet extends HttpServlet {
	@Inject
    private GameManager storage;

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Long gameID = WebUtils.getGameID(request);

        request.setAttribute("game", storage.get(gameID));
        request.getRequestDispatcher("/edit.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String name = request.getParameter("name");
        float price = Float.parseFloat(request.getParameter("cena"));
        Long gameID = WebUtils.getGameID(request);

        storage.update(gameID, name, price);

        WebUtils.redirectToMessageView(request, response, gameID);
    }
}


