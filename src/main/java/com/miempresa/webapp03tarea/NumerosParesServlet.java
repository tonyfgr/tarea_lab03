
package com.miempresa.webapp03tarea;


import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "NumerosParesServlet", urlPatterns = {"/NumerosParesServlet"})
public class NumerosParesServlet extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        
        int n = Integer.parseInt(request.getParameter("n"));

        try (PrintWriter out = response.getWriter()) {
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Números Pares</title>");
            out.println("<link rel=\"stylesheet\" href=\"webjars/bootstrap/5.1.0/css/bootstrap.min.css\" type=\"text/css\" />");
            out.println("</head>");
            out.println("<body>");
            out.println("<div class='container'>"); 
            out.println("<h1 class='display-4'>Los primeros " + n + " números pares son:</h1>");
            out.println("<ul class='list-group'>"); 

            for (int i = 2; i <= 2 * n; i += 2) {
                out.println("<li class='list-group-item'>" + i + "</li>"); 
            }

            out.println("</ul>");
            out.println("</div>"); 
            out.println("</body>");
            out.println("</html>");

        }
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    @Override
    public String getServletInfo() {
        return "Servlet para imprimir los n primeros números pares";
    }
}
