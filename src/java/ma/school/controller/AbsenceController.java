/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ma.school.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import ma.school.beans.Absence;
import ma.school.service.AbsenceService;

/**
 *
 * @author leblond
 */
@WebServlet(name = "AbsenceController", urlPatterns = {"/AbsenceController"})
public class AbsenceController extends HttpServlet {

    String op = null;

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    public void init()
            throws ServletException {
        super.init(); //To change body of generated methods, choose Tools | Templates.
        op = null;
    }

    protected void processRequest(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        op = request.getParameter("op");
        AbsenceService es = new AbsenceService();

        if (op.equals("Envoyer")) {
           
            String motif = request.getParameter("motif");
            String justifiee = request.getParameter("justifiee");
            String date = request.getParameter("dateAbsence");
            Date dateAbsence = new Date(date.replace("-", "/"));
            String module = request.getParameter("module");
            String etudiant = request.getParameter("etudiant");
            es.create(new Absence( dateAbsence, motif, justifiee,  module, etudiant));
            response.sendRedirect("absenceForm.jsp"); 
        } else if (op.equals("delete")) {
            int id = Integer.parseInt(request.getParameter("id"));
            es.delete(es.findById(id));
            response.sendRedirect("absenceForm.jsp");
//        } else if (op.equals("update")) {
//            int id = Integer.parseInt(request.getParameter("id"));
//            Absence absenceToUpdate = es.findById(id);
//
//            if (absenceToUpdate != null) {
//                String nom = request.getParameter("nom");
//                String prenom = request.getParameter("prenom");
//                String ville = request.getParameter("ville");
//                String date = request.getParameter("dateNaissance");
//                String sexe = request.getParameter("sexe");
//
//                // Mettre à jour les attributs de l'étudiant
//                absenceToUpdate.setNom(nom);
//                absenceToUpdate.setPrenom(prenom);
//                absenceToUpdate.setVille(ville);
//
//                // Assurez-vous que la date est correctement formatée avant de la transformer en objet Date
//                Date dateNaissance = null;
//                try {
//                    dateNaissance = new SimpleDateFormat("yyyy-MM-dd").parse(date);
//                } catch (ParseException e) {
//                    e.printStackTrace(); // Gérer l'erreur de parsing
//                }
//
//                absenceToUpdate.setDateNaissance(dateNaissance);
//                absenceToUpdate.setSexe(sexe);
//
//                // Appeler la méthode de mise à jour
//                es.update(absenceToUpdate);
//                response.sendRedirect("etudiantForm.jsp");
//            
//
//            } else {
//                response.sendRedirect("errorPage.jsp?message=L'étudiant avec l'identifiant spécifié n'existe pas");
//            }
        
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
        processRequest(request, response);
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
        processRequest(request, response);
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
