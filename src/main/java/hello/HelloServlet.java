/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hello;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Calendar;
import java.util.TimeZone;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import static java.awt.Color.blue;

/**
 *
 * @author viter
 */
@WebServlet("/alomundo")
public class HelloServlet extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet HelloServlet</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h2>Servlet HelloServlet at " + request.getContextPath() +  "</h2");
            out.println("</body>");
            out.println("</html>");
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        String msg = "";

        TimeZone tz1 = TimeZone.getTimeZone("America/Sao_Paulo");
        Calendar c1 = Calendar.getInstance(tz1);
        int hora = c1.get(Calendar.HOUR_OF_DAY);

        String periodo = "nada";

        if (hora >= 6 && hora < 12) {
            periodo = "dia";
        }
        else if(hora >= 12 && hora < 18){
            periodo = "tarde";
        }
        else{
            periodo = "noite";
        }

        String lang = request.getParameter("lang");

        if(periodo=="dia"){
            if(lang==null)
                lang = "pt";
            switch(lang){
                case "pt":
                    msg = "Bom dia, ";
                    break;
                case "en":
                    msg = "Good morning, ";
                    break;
                case "fr":
                    msg = "Bonjour, ";
                    break;
                case "gr":
                    msg = "Kaliméra, ";
                    break;
                case "jp":
                    msg = "Ohayō, ";
                    break;
            }
        }else if(periodo=="tarde"){
            if(lang==null)
                lang = "pt";
            switch(lang){
                case "pt":
                    msg = "Boa tarde, ";
                    break;
                case "en":
                    msg = "Good afternoon, ";
                    break;
                case "fr":
                    msg = "Bon après-midi, ";
                    break;
                case "gr":
                    msg = "Kaló apógevma, ";
                    break;
                case "jp":
                    msg = "Kon'nichiwa, ";
                    break;
            }
        }else if(periodo=="noite"){
            if(lang==null)
                lang = "pt";
            switch(lang){
                case "pt":
                    msg = "Boa noite, ";
                    break;
                case "en":
                    msg = "Good evening, ";
                    break;
                case "fr":
                    msg = "Bonsoir, ";
                    break;
                case "gr":
                    msg = "Kalinychta, ";
                    break;
                case "jp":
                    msg = "Oyasumi, ";
                    break;
            }
        }

        String trat= request.getParameter("trat");
        if(trat==null)
            trat = "nenhum";
        switch(trat){
            case "nenhum":
                trat = "";
                break;
            case "sr":
                trat = "Sr. ";
                break;
            case "sra":
                trat = "Sra. ";
                break;
        }

        String nome = request.getParameter("nome");

        if(nome==null)
            nome = "Viterbo";
        
        msg = msg+trat+nome+"!";

        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet HelloServlet</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet HelloServlet</h1>");
            out.println("<p>" + msg + "</p>");
            out.println("</body>");
            out.println("</html>");
        }
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String msg = "";

        String cor = request.getParameter("cor");

        cor = '"'+cor+'"';

        TimeZone tz1 = TimeZone.getTimeZone("America/Sao_Paulo");
        Calendar c1 = Calendar.getInstance(tz1);
        int hora = c1.get(Calendar.HOUR_OF_DAY);

        String periodo = "nada";

        if (hora >= 6 && hora < 12) {
            periodo = "dia";
        }
        else if(hora >= 12 && hora < 18){
            periodo = "tarde";
        }
        else{
            periodo = "noite";
        }
        
        String lang = request.getParameter("lang");
        if(periodo=="dia"){
            if(lang==null)
                lang = "pt";
            switch(lang){
                case "pt":
                    msg = "Bom dia, ";
                    break;
                case "en":
                    msg = "Good morning, ";
                    break;
                case "fr":
                    msg = "Bonjour, ";
                    break;
                case "de":
                    msg = "Guten Morgen, ";
                    break;
                case "gr":
                    msg = "Kaliméra, ";
                    break;
                case "jp":
                    msg = "Ohayō, ";
                    break;
            }
        }else if(periodo=="tarde"){
            if(lang==null)
                lang = "pt";
            switch(lang){
                case "pt":
                    msg = "Boa tarde, ";
                    break;
                case "en":
                    msg = "Good afternoon, ";
                    break;
                case "fr":
                    msg = "Bon après-midi, ";
                    break;
                case "de":
                    msg = "Guten Nachmittag, ";
                    break;
                case "gr":
                    msg = "Kaló apógevma, ";
                    break;
                case "jp":
                    msg = "Kon'nichiwa, ";
                    break;
            }
        }else if(periodo=="noite"){
            if(lang==null)
                lang = "pt";
            switch(lang){
                case "pt":
                    msg = "Boa noite, ";
                    break;
                case "en":
                    msg = "Good evening, ";
                    break;
                case "fr":
                    msg = "Bonsoir, ";
                    break;
                case "de":
                    msg = "Gute Nacht, ";
                    break;
                case "gr":
                    msg = "Kalinychta, ";
                    break;
                case "jp":
                    msg = "Oyasumi, ";
                    break;
            }
        }

        String trat= request.getParameter("trat");
        if(trat==null)
            trat = "nenhum";
        switch(trat){
            case "nenhum":
                trat = "";
                break;
            case "sr":
                trat = "Sr. ";
                break;
            case "sra":
                trat = "Sra. ";
                break;
        }

        String nome = request.getParameter("nome");

        if(nome==null)
            nome = "Viterbo";

        msg = "<div class="+ cor + '>' + msg+trat+nome + cor+  "!</div>";

        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet HelloServlet</title>");            
            out.println("</head>");
            out.println("<body>");
//            out.println("C1:  "+ c1);
//            out.println("Hora:  "+ hora);
//            out.println("Período: "+ periodo);
            out.println("<h1>Servlet HelloServlet</h1>");
            out.println("<p>" + msg + "</p>");
            out.println("</body>");
            out.println("</html>");
        }
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
