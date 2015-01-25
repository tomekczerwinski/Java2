package com.example.jeedemo.web;
import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.example.jeedemo.domain.MessageStorageService;

import java.io.IOException;

@WebServlet(urlPatterns = "/search")
public class SearchMessageServlet extends HttpServlet {
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@EJB
    private MessageStorageService storage;

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String type = request.getParameter("type");
        if (type == null) {
            response.sendRedirect(response.encodeRedirectURL(request.getContextPath() + "/main"));
            return;
        }

        request.setAttribute("type", type);

        if (type.equals("author")) {
            String author = request.getParameter("author");
            request.setAttribute("messages", storage.getAllByAuthor(author));
            request.setAttribute("headerText", "Messages by " + author);
            request.setAttribute("author", author);
        }

        request.getRequestDispatcher("search.jsp").forward(request, response);
    }

}
