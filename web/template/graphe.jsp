<%@page import="ma.school.service.MarqueService"%>
<%@page import="ma.school.beans.Marque"%>
<%@page import="ma.school.service.MachineService"%>
<%@page import="java.util.List"%>
<%@page import="ma.school.beans.Machine"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>


<!DOCTYPE html>
<html>
    <head>
        <title>Histogramme de machines par marque</title>
        <script src="https://cdn.jsdelivr.net/npm/chart.js"></script>
        <link href="style/css1.css" rel="stylesheet" type="text/css"/>
        <style>
            body {
                font-family: Arial, sans-serif;
                background-color: #f7f7f7;
                padding: 20px;
            }
            .center-div {
                text-align: center;
                display: flex;
                justify-content: center;
                align-items: center;
            }
            canvas#machineChart {
                width: 100%;
                margin: 2px auto;
            }
            h1 {
                text-align: center;
                font-size: 24px;
                margin-bottom: 20px;
            }
        </style>
    </head>
    <body>


        <%@include file="header.jsp" %>
        <%@include file="menu.jsp" %>
        <%@include file="footer.jsp" %>
        <div class="center-div">
            <div style="background-color: #fff; border: 1px solid #ddd; padding: 20px; width: 400px; height: 550px;">
                <h1 style="text-align: center;">Histogramme de machines par marque</h1>
                <canvas id="machineChart"></canvas>
            </div>
        </div>

        <%
            MachineService ms = new MachineService();
            MarqueService mrs = new MarqueService();
            List<Marque> marques = mrs.findAll();
        %>

        <script>
            var labels = [];
            var data = [];
            var backgroundColors = [];
            <%
                for (Marque marque : marques) {
            %>
            labels.push("<%= marque.getLibelle()%>");
            data.push(<%= ms.findByMarque(marque).size()%>);
            backgroundColors.push('rgba(54, 162, 235, 0.6)'); // Blue color for bars
            <%
                }
            %>

            var selectedType = 'bar';
            var ctx = document.getElementById('machineChart').getContext('2d');
            var machineChart = new Chart(ctx, {
                type: selectedType,
                data: {
                    labels: labels,
                    datasets: [{
                            label: 'Nombre de machines par marque',
                            data: data,
                            backgroundColor: backgroundColors,
                            borderColor: 'rgba(54, 162, 235, 1)',
                            borderWidth: 1
                        }]
                },
                options: {
                    scales: {
                        y: {
                            beginAtZero: true,
                            suggestedMax: 10
                        }
                    }
                }
            });
        </script>
    </body>
</html>

