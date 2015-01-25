package com.example.jeedemo.web;

import java.io.IOException;

import javax.inject.Inject;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.example.jeedemo.service.GameManager;

@WebServlet(urlPatterns = "/view/*")
public class ViewGameServlet extends HttpServlet {
	
	@Inject
    private GameManager storage;

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Long gameID = WebUtils.getGameID(request);

        request.setAttribute("message", storage.get(gameID));
        request.getRequestDispatcher("/view.jsp").forward(request, response);
    }

}
