/*
 * Paquete que representa el controlador
 */
package edu.uniandes.ecos.psp21.controller;

import edu.uniandes.ecos.psp21.model.CalcularSimpson;
import edu.uniandes.ecos.psp21.view.MainView;
import javax.servlet.http.HttpServlet;
import java.io.IOException;
import java.util.LinkedList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.eclipse.jetty.server.Server;
import org.eclipse.jetty.servlet.ServletContextHandler;
import org.eclipse.jetty.servlet.ServletHolder;

/**
 * Clase de entrada para el controlador
 * @author wilman rincon
 */
public class App extends HttpServlet{
    public static void main(String[] args) {
        Server server = new Server(Integer.valueOf(System.getenv("PORT")));
        ServletContextHandler context = new ServletContextHandler(ServletContextHandler.SESSIONS);
        context.setContextPath("/");
        server.setHandler(context);
        context.addServlet(new ServletHolder(new App()), "/*");
        try {
            server.start();
            server.join();
        } catch (Exception ex) {
            Logger.getLogger(App.class.getName()).log(Level.SEVERE, null, ex);
        }

    }
    
     /*
     sobreescritura del metodo doGet
     */
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        MainView.showHome(req,resp);
       // MainView.showResults(req,resp,0.0," ",0.0);       
    }

    /*
    Sobreescritura del metodo DoPost
    */
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
                
        try {
            MainView.showHome(req,resp);
            consoleInput(req, resp);
        } catch (Exception ex) {
            Logger.getLogger(App.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    /*
    Metodo que llama al model y retorna el valor esperado P
    */
    public void consoleInput(HttpServletRequest req, HttpServletResponse resp) throws Exception {
         try{
        String calcx = req.getParameter("calcx");
        String calcy = req.getParameter("calcy");

        double x = Double.valueOf(calcx);
        double dof = Double.valueOf(calcy);
        double resul = 0;
        
        CalcularSimpson calcSimpson = new CalcularSimpson(x,dof);
        
        
        resul = calcSimpson.integral();
        
        MainView.showResults(req, resp, x, dof, resul);
       }catch(Exception ex){
         MainView.error(req, resp);
       }
    }
}
