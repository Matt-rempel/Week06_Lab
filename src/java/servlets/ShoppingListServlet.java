/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author 584893
 */
@WebServlet(name = "ShoppingListServlet", urlPatterns = {"/ShoppingList"})
public class ShoppingListServlet extends HttpServlet {


    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        
        String action = request.getParameter("action");
        
        HttpSession session = request.getSession();
        
        if (action != null && action.equals("logout")) {
            session.removeAttribute("username");
            session.removeAttribute("items");
        }
        
        
        String username = (String) session.getAttribute("username");

        if (username != null) {
            getServletContext().getRequestDispatcher("/WEB-INF/shoppinglist.jsp").forward(request, response);
        } else {
            getServletContext().getRequestDispatcher("/WEB-INF/register.jsp").forward(request, response);
        }
    }


    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        String action = request.getParameter("action");
        
        HttpSession session = request.getSession();

        ArrayList<String> items = (ArrayList<String>) session.getAttribute("items");
        
        String item = (String) request.getParameter("item");
                
        if (items == null) {
            items = new ArrayList<String>();
        }
        
        switch(action) {

            case "add":
                items.add(item);
                session.setAttribute("items", items);
                getServletContext().getRequestDispatcher("/WEB-INF/shoppinglist.jsp").forward(request, response);
            break;
            case "delete":
                items.remove(item);
                
                getServletContext().getRequestDispatcher("/WEB-INF/shoppinglist.jsp").forward(request, response);
            break;
            case "register":
                String username = request.getParameter("username");
                if (username != null && !"".equals(username)) {
                    session.setAttribute("username", username);
                    getServletContext().getRequestDispatcher("/WEB-INF/shoppinglist.jsp").forward(request, response);
                } else {
                    getServletContext().getRequestDispatcher("/WEB-INF/register.jsp").forward(request, response);
                }

            break;
            default:
                getServletContext().getRequestDispatcher("/WEB-INF/register.jsp").forward(request, response);
        }
        
        
    }

}
