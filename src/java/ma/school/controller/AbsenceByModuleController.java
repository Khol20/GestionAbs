/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ma.school.controller;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import java.io.IOException;
import java.lang.reflect.Modifier;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import ma.school.beans.Machine;
import ma.school.beans.Absence;
import ma.school.service.MachineService;
import ma.school.service.AbsenceService;
import ma.school.util.HibernateUtil;
import org.hibernate.Hibernate;

/**
 *
 * @author a
 */
@WebServlet(name = "AbsenceByModuleController", urlPatterns = {"/AbsenceByModuleController"})
public class AbsenceByModuleController extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    AbsenceService ms = new AbsenceService();

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
     String module = request.getParameter("module");
    String etudiant = request.getParameter("etudiant");
    response.setContentType("application/json;charset=UTF-8");

    // Filtrer les absences en fonction du module et de l'étudiant
    List<Absence> absences = ms.findAbsencesByModuleAndStudent(module, etudiant);

    String json = new Gson().toJson(absences);
    response.getWriter().write(json);

        //Type type = new TypeToken<Collection<Machine>>(){}.getType(); 
        //  Collection<Machine> etudiants = new Gson().fromJson(response, type);        
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
