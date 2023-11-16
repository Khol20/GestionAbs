<%@page import="ma.school.beans.Absence"%>
<%@page import="ma.school.service.AbsenceService"%>
<%@page import="java.util.Date"%>

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
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <link href="style/css.css" rel="stylesheet" type="text/css"/>
        <link href="style/csslocal.css" rel="stylesheet" type="text/css"/>
        <script src="script/jquery-3.3.1.min.js" type="text/javascript"></script>
        <script src="script/absenceByModule.js" type="text/javascript"></script>
          <script src="script/listeVilles.js" type="text/javascript"></script>

    </head>
    <body>
        <%@include file="template/header.jsp" %>
        <%@include file="template/menu.jsp" %>
        <div class="content">
            <form method="GET" action="AbsenceController">
                <fieldset>
                    <legend>Selectionner </legend>
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


                    </table>
                </fieldset>
            </form>
            <%
                AbsenceService mms = new AbsenceService();

            %>
            <fieldset>
                <legend>Liste des Etudiants </legend>

                <table border="1" class="tab">
                    <thead>
                        <tr>
                            <th>Etudiant</th>
                            <th>Date d'absence</th>
                            <th>Motif</th>
                            <th>Justification</th>
                        </tr>
                    </thead>
                    <tbody  id='body'>
   
              
 
                    </tbody>
                </table>

            </fieldset>
        </form>            
</body>
</html>
