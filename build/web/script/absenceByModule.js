$(document).ready(function () {
    
    $("#absence").change(function () {
            $.ajax ({
            url: 'AbsenceByModuleController',
            data:{
                module: $(this).val(), // Module sélectionné
                etudiant: $("#etudiant").val() // Étudiant sélectionné
            },//this = élément sélectionné
            type: 'POST',
            success: function (data) {
                var ligne="";
                for (var i = 0; i < data.length; i++) {
                    ligne+='<tr>'
                            +'<td>'+data[i].id+'</td>'
                            +'<td>'+data[i].etudiant+'</td>'
                            +'<td>'+data[i].dateAbsence+'</td>'
                            +'<td>'+data[i].motif+'</td>'
                            +'<td>'+data[i].justifiee+'</td>'
//                            +'<td><a class="bndelete" href="AbsenceController?op=delete&id='+data[i].id+'">Supprimer</a></td>'
//                            +'<td><a class="bnupdate" href="">Modifier</a></td>'
                        +'</tr>';
                }
                $("#body").html(ligne);
            },
            error: function (jqXHR, textStatus, errorThrown) {
                console.log(textStatus);
            }
        });
    });


});
