<%@page import="ma.school.beans.Machine"%>
<%@page import="ma.school.service.MachineService"%>
<%@page import="ma.school.beans.Marque"%>
<%@page import="ma.school.service.MarqueService"%>
<%@page import="java.util.Date"%>
<%@page import="ma.school.beans.Etudiant"%>
<%@page import="ma.school.service.EtudiantService"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>


        <tr>
                            <td>Module </td>
                            <td>
                                <select id="module" name="module">
                                    <option value="0">Choisir une option </option>
                                    <%
                                        AbsenceService ms = new AbsenceService();
                                        for (Absence m : ms.findAll()) {
                                    %>
                                    <option value="<%=m.getId()%>"><%=m.getModule()%></option>
                                    <option value="<%=m.getId()%>"><%=m.getEtudiant()%></option>
                                    <%}%>
                                </select>
                            </td>
                        </tr>
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
        <script src="machineByReference.js" type="text/javascript"></script>

    </head>
    <body>
        <%@include file="template/header.jsp" %>
        <%@include file="template/menu.jsp" %>
        <div class="content">
            <form method="GET" action="MachineByReferenceController">
                <fieldset>
                    <legend>Selectionner Reference</legend>
                    <table border="0">

                        <tr>
                            <td>Reference</td>
                            <td>
                                <select id="reference" name="reference">
                                    <option value="0">Choisir une reference</option>
                                    <%
                                        MachineService mms = new MachineService();
                                        for (Machine m : mms.findAll()) {
                                    %>
                                    <option value="<%=m.getId()%>"><%=m.getReference()%></option>
                                    <%}%>
                                </select>
                            </td>
                        </tr>


                    </table>
                </fieldset>
            </form>
            <%
                MachineService mm = new MachineService();

            %>
            <fieldset>
                <legend>Liste des Machines</legend>

                <table border="1" class="tab">
                    <thead>
                        <tr>
                            <th>Id</th>
                            <th>Reference <br>
                            <th>Prix</th>
                            <th>Marque</th>
                            <th>Date d'achat</th>

                            <th>Supprimer</th>
                            <th>Modifier</th>
                        </tr>
                    </thead>
                    <tbody  id='body'>

                        

                    </tbody>
                </table>

            </fieldset>
        </form>            
</body>
</html>

