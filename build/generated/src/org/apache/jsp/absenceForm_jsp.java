package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import java.util.Date;
import ma.school.beans.Absence;
import ma.school.service.AbsenceService;

public final class absenceForm_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {

  private static final JspFactory _jspxFactory = JspFactory.getDefaultFactory();

  private static java.util.List<String> _jspx_dependants;

  static {
    _jspx_dependants = new java.util.ArrayList<String>(2);
    _jspx_dependants.add("/template/header.jsp");
    _jspx_dependants.add("/template/menu.jsp");
  }

  private org.glassfish.jsp.api.ResourceInjector _jspx_resourceInjector;

  public java.util.List<String> getDependants() {
    return _jspx_dependants;
  }

  public void _jspService(HttpServletRequest request, HttpServletResponse response)
        throws java.io.IOException, ServletException {

    PageContext pageContext = null;
    HttpSession session = null;
    ServletContext application = null;
    ServletConfig config = null;
    JspWriter out = null;
    Object page = this;
    JspWriter _jspx_out = null;
    PageContext _jspx_page_context = null;

    try {
      response.setContentType("text/html;charset=UTF-8");
      pageContext = _jspxFactory.getPageContext(this, request, response,
      			null, true, 8192, true);
      _jspx_page_context = pageContext;
      application = pageContext.getServletContext();
      config = pageContext.getServletConfig();
      session = pageContext.getSession();
      out = pageContext.getOut();
      _jspx_out = out;
      _jspx_resourceInjector = (org.glassfish.jsp.api.ResourceInjector) application.getAttribute("com.sun.appserv.jsp.resource.injector");

      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("<!DOCTYPE html>\n");
      out.write("<html>\n");
      out.write("    <head>\n");
      out.write("        <style>\n");
      out.write("            body {\n");
      out.write("                background-image: url('images/ensaj.png');\n");
      out.write("                background-size: cover; \n");
      out.write("                font-family: \"Trebuchet MS\", Arial, Helvetica, sans-serif; \n");
      out.write("            }\n");
      out.write("        </style>\n");
      out.write("        <script src=\"script/script.js\" type=\"text/javascript\"></script>\n");
      out.write("        <meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\">\n");
      out.write("        <title>JSP Page</title>\n");
      out.write("        \n");
      out.write("        <script src=\"script/jsonExemple.js\" type=\"text/javascript\"></script>\n");
      out.write("        <script src=\"script/listeVilles.js\" type=\"text/javascript\"></script>\n");
      out.write("        \n");
      out.write("        <link href=\"style/css.css\" rel=\"stylesheet\" type=\"text/css\"/>\n");
      out.write("        <link href=\"style/csslocal.css\" rel=\"stylesheet\" type=\"text/css\"/>\n");
      out.write("    </head>\n");
      out.write("    <body>\n");
      out.write("        ");
      out.write("\n");
      out.write("<div class=\"header\" style=\"height:110px;width: 100%;\">\n");
      out.write("    <img id=\"logo\" src=\"images/Logo_Ensaj.png\" alt=\"logo\" style=\"width:100px;height:100px;\"/>     \n");
      out.write("    <span id=\"horloge\" style=\"font-family: Courier New;text-align: center; width:100%;color: orange;position: absolute;\n");
      out.write("            top: 50px; justify-content: center \"></span>\n");
      out.write("</div>\n");
      out.write("<script src=\"script/horloge.js\" type=\"text/javascript\"></script>\n");
      out.write("\n");
      out.write("\n");
      out.write("        ");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("<ul>\n");
      out.write("    \n");
      out.write("    <li><a class=\"active\" href=\"#home\">Home</a></li>\n");
      out.write("    <li><a href=\"absenceForm.jsp\">Gestion des Absences</a></li>\n");
      out.write("    <li><a href=\"marqueForm.jsp\">Gestion des marques</a></li>\n");
      out.write("    <li><a href=\"machineForm.jsp\">Gestion des machines</a></li>\n");
      out.write("    <li><a href=\"machineByMarqueForm.jsp\">Machines par marque</a></li>\n");
      out.write("    <li><a href=\"machineByReferenceForm.jsp\">Machines par reference</a></li>\n");
      out.write("    <li><a href=\"graphe.jsp\">Graphe : Nombre de Machines par marque</a></li>\n");
      out.write("    \n");
      out.write("\n");
      out.write("</ul>");
      out.write("\n");
      out.write("        <div class=\"content\">\n");
      out.write("            <form method=\"GET\" action=\"AbsenceController\" id=\"updateForm\">\n");
      out.write("                <fieldset>\n");
      out.write("                    <legend>Gestion d'absence :</legend>\n");
      out.write("                    <table border=\"0\">\n");
      out.write("                        <tr>\n");
      out.write("                            <td>Etudiant</td>\n");
      out.write("                            <td>\n");
      out.write("                                <select id=\"etudiant\" name=\"etudiant\">\n");
      out.write("                                    <script>\n");
      out.write("                                        getListeEtudiants('etudiant');\n");
      out.write("                                    </script>\n");
      out.write("\n");
      out.write("                                </select>\n");
      out.write("                            </td>\n");
      out.write("                        </tr>\n");
      out.write("                         <tr>\n");
      out.write("                            <td>Module</td>\n");
      out.write("                            <td>\n");
      out.write("                                <select id=\"module\" name=\"module\">\n");
      out.write("                                    <script>\n");
      out.write("                                        getListeModules('module');\n");
      out.write("                                    </script>\n");
      out.write("\n");
      out.write("                                </select>\n");
      out.write("                            </td>\n");
      out.write("                        </tr>\n");
      out.write("                        <tr>\n");
      out.write("                            <td>Date d'absence</td>\n");
      out.write("                            <td><input id=\"date\" type=\"date\" name=\"dateAbsence\" value=\"\" required=\"\" /></td>\n");
      out.write("                        </tr>\n");
      out.write("                        <tr>\n");
      out.write("                            <td>Motif</td>\n");
      out.write("                            <td><input id=\"motif\" type=\"text\" name=\"motif\" value=\"\" required=\"\" /></td>\n");
      out.write("                        </tr>\n");
      out.write("                        <tr>\n");
      out.write("                            <td>Justification</td>\n");
      out.write("                            <td>OUI<input id=\"o\" type=\"radio\" name=\"justifiee\" value=\"OUI\" />\n");
      out.write("                                NON<input id=\"n\" type=\"radio\" name=\"justifiee\" value=\"NON\" checked=\"checked\" /></td>\n");
      out.write("                        </tr>\n");
      out.write("                        <tr>\n");
      out.write("                            <td></td>\n");
      out.write("                            <td>\n");
      out.write("                                <input name=\"op\" type=\"submit\" value=\"Envoyer\" />\n");
      out.write("                            </td>\n");
      out.write("                        </tr>\n");
      out.write("                    </table>\n");
      out.write("                </fieldset>\n");
      out.write("            </form>\n");
      out.write("            ");

                AbsenceService es = new AbsenceService();
            
      out.write("\n");
      out.write("            <fieldset>\n");
      out.write("                <legend>Liste des étudiants </legend>\n");
      out.write("\n");
      out.write("                <table border=\"1\" class=\"tab\">\n");
      out.write("                    <thead>\n");
      out.write("                        <tr>\n");
      out.write("                            <th>Etudiant</th>\n");
      out.write("                            <th>Module </th>>\n");
      out.write("                            <th>Date d'absence</th>\n");
      out.write("                            <th>Motif</th>\n");
      out.write("                            <th>Justification</th>\n");
      out.write("                            <th>Supprimer</th>\n");
      out.write("                            <th>Modifier</th>\n");
      out.write("                        </tr>\n");
      out.write("                    </thead>\n");
      out.write("                    <tbody>\n");
      out.write("                        ");

                            for (Absence e : es.findAll()) {
                        
      out.write("\n");
      out.write("                        <tr>\n");
      out.write("                            <td>");
      out.print(e.getEtudiant());
      out.write("</td>\n");
      out.write("                            <td>");
      out.print(e.getModule());
      out.write("</td>\n");
      out.write("                            <td>");
      out.print(e.getDateAbsence());
      out.write("</td>\n");
      out.write("                            <td>");
      out.print(e.getMotif());
      out.write("</td>\n");
      out.write("                            <td>");
      out.print(e.getJustifiee());
      out.write("</td>\n");
      out.write("                            <td><a class=\"bndelete\" href=\"AbsenceController?op=delete&id=");
      out.print(e.getId());
      out.write("\"onclick=\n");
      out.write("                                   \"return confirm('Voulez-vous vraiment supprimer cet étudiant ?');\">Supprimer</a></td>\n");
      out.write("                            \n");
      out.write("                                   <td>\n");
      out.write("                                <button type=\"submit\">Modifier</button>\n");
      out.write("                              \n");
      out.write("                            </form>\n");
      out.write("                        </td>\n");
      out.write("                        </tr>\n");
      out.write("                        ");
}
      out.write("\n");
      out.write("                    </tbody>\n");
      out.write("                </table>\n");
      out.write("\n");
      out.write("            </fieldset>\n");
      out.write("        </form>            \n");
      out.write("</body>\n");
      out.write("</html>\n");
    } catch (Throwable t) {
      if (!(t instanceof SkipPageException)){
        out = _jspx_out;
        if (out != null && out.getBufferSize() != 0)
          out.clearBuffer();
        if (_jspx_page_context != null) _jspx_page_context.handlePageException(t);
        else throw new ServletException(t);
      }
    } finally {
      _jspxFactory.releasePageContext(_jspx_page_context);
    }
  }
}
