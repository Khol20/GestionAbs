<%@page import="java.util.Date"%>
<%@page import="ma.school.beans.Absence"%>
<%@page import="ma.school.service.AbsenceService"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <style>
            body {
                background-image: url('images/ensaj.png');
                background-size: cover; 
                font-family: "Trebuchet MS", Arial, Helvetica, sans-serif; 
            }
        </style>
        <script src="script/script.js" type="text/javascript"></script>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        
        <script src="script/jsonExemple.js" type="text/javascript"></script>
        <script src="script/listeVilles.js" type="text/javascript"></script>
        
        <link href="style/css.css" rel="stylesheet" type="text/css"/>
        <link href="style/csslocal.css" rel="stylesheet" type="text/css"/>
    </head>
    <body>
        <%@include file="template/header.jsp" %>
        <%@include file="template/menu.jsp" %>
        <div class="content">
            <form method="GET" action="AbsenceController" id="updateForm">
                <fieldset>
                    <legend>Gestion d'absence :</legend>
                    <table border="0">
                        <tr>
                            <td>Etudiant</td>
                            <td>
                                <select id="etudiant" name="etudiant">
                                    <script>
                                        getListeEtudiants('etudiant');
                                    </script>

                                </select>
                            </td>
                        </tr>
                         <tr>
                            <td>Module</td>
                            <td>
                                <select id="module" name="module">
                                    <script>
                                        getListeModules('module');
                                    </script>

                                </select>
                            </td>
                        </tr>
                        <tr>
                            <td>Date d'absence</td>
                            <td><input id="date" type="date" name="dateAbsence" value="" required="" /></td>
                        </tr>
                        <tr>
                            <td>Motif</td>
                            <td><input id="motif" type="text" name="motif" value="" required="" /></td>
                        </tr>
                        <tr>
                            <td>Justification</td>
                            <td>OUI<input id="o" type="radio" name="justifiee" value="OUI" />
                                NON<input id="n" type="radio" name="justifiee" value="NON" checked="checked" /></td>
                        </tr>
                        <tr>
                            <td></td>
                            <td>
                                <input name="op" type="submit" value="Envoyer" />
                            </td>
                        </tr>
                    </table>
                </fieldset>
            </form>
            <%
                AbsenceService es = new AbsenceService();
            %>
            <fieldset>
                <legend>Liste des étudiants </legend>

                <table border="1" class="tab">
                    <thead>
                        <tr>
                            <th>Etudiant</th>
                            <th>Module </th>>
                            <th>Date d'absence</th>
                            <th>Motif</th>
                            <th>Justification</th>
                            <th>Supprimer</th>
                            <th>Modifier</th>
                        </tr>
                    </thead>
                    <tbody>
                        <%
                            for (Absence e : es.findAll()) {
                        %>
                        <tr>
                            <td><%=e.getEtudiant()%></td>
                            <td><%=e.getModule()%></td>
                            <td><%=e.getDateAbsence()%></td>
                            <td><%=e.getMotif()%></td>
                            <td><%=e.getJustifiee()%></td>
                            <td><a class="bndelete" href="AbsenceController?op=delete&id=<%=e.getId()%>"onclick=
                                   "return confirm('Voulez-vous vraiment supprimer cet étudiant ?');">Supprimer</a></td>
                            
                                   <td>
                                <button type="submit">Modifier</button>
                              
                            </form>
                        </td>
                        </tr>
                        <%}%>
                    </tbody>
                </table>

            </fieldset>
        </form>            
</body>
</html>
