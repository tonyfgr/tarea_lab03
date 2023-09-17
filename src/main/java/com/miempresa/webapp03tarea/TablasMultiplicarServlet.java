
package com.miempresa.webapp03tarea;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "TablasMultiplicarServlet", urlPatterns = {"/TablasMultiplicarServlet"})
public class TablasMultiplicarServlet extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        
        int n = Integer.parseInt(request.getParameter("n"));

        try (PrintWriter out = response.getWriter()) {
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Tablas de Multiplicar</title>");
            out.println("<link rel=\"stylesheet\" href=\"webjars/bootstrap/5.1.0/css/bootstrap.min.css\" type=\"text/css\" />");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1 class='display-4'>Las primeras " + n + " tablas de multiplicar son:</h1>");

            
            for (int i = 1; i <= n; i++) {
                out.println("<h2>Tabla del " + i + ":</h2>");
                out.println("<table class='table table-bordered table-hover'>");

                out.println("<tr><th>Multiplicador</th><th>Resultado</th></tr>");
                for (int j = 1; j <= 10; j++) {
                    out.println("<tr><td>" + j + "</td><td>" + (i * j) + "</td></tr>");
                }
                out.println("</table>");
            }
            
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
        return "Servlet para imprimir las n primeras tablas de multiplicar";
    }
}
