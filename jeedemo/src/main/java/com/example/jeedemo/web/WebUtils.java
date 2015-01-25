package com.example.jeedemo.web;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class WebUtils {
    public static Long getGameID(HttpServletRequest request) {
        String pathInfo = request.getPathInfo();
        String gameID = pathInfo.substring(pathInfo.lastIndexOf("/") + 1, pathInfo.length());

        return Long.valueOf(gameID);
    }

    public static void redirectToMainPage(HttpServletRequest request, HttpServletResponse response) throws IOException {
        response.sendRedirect(response.encodeRedirectURL(request.getContextPath() + "/main"));
    }

    public static void redirectToMessageView(HttpServletRequest request, HttpServletResponse response, Long id) throws IOException {
        response.sendRedirect(response.encodeRedirectURL(request.getContextPath() + "/view/" + id));
    }
}
