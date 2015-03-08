/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.uniandes.ecos.psp21.view;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Administrador
 */
public class MainView {
     /*
    metodo para visualizar el formulario inicial
    */
     public static void showHome(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        
        PrintWriter pw = resp.getWriter();
        pw.write("<html>");
        pw.println("<h1>PSP 2.1 Program!</h1>");
        
         pw.write("<form action=\"calc\" method=\"post\"> \n" +
                "    Ingrese p: <input type=\"text\" name=\"calcx\">\n" +
                "    Ingrese Dof: <input type=\"text\" name=\"calcy\">\n" +
                "    <input type=\"submit\" value=\"Calc\">\n" +
                "</form> ");
        pw.write("</html>");

    }
     
       /*
     Metodo para escribir el resultado
     */
    public static void showResults(HttpServletRequest req, HttpServletResponse resp,  Double valX, Double valY, Double result)
            throws ServletException, IOException {
        resp.getWriter().println("<b>X:</b> "+valX +"<br>");
        resp.getWriter().println("<b>Dof:</b> "+valY +"<br>");
        resp.getWriter().println("<b>P:</b> "+ result + "<br>");
        //resp.getWriter().println("<b>STD: </b> "+stdDev + "<br>");
    }
    
    /*
    Metodo para escribir un error de la aplicacion
    */
    public static void error(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        resp.getWriter().println("Error!!!");
    }
}
