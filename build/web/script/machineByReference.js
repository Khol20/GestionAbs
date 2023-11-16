/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
$(document).ready(function () {
    
    $("#reference").change(function () {
            $.ajax ({
            url: 'MachineByReferenceController',
            data: {reference:  $(this).val()},//this = élément sélectionné
            type: 'POST',
            success: function (data) {
                var ligne="";
                for (var i = 0; i < data.length; i++) {
                    ligne+='<tr>'
                            +'<td>'+data[i].id+'</td>'
                            +'<td>'+data[i].reference+'</td>'
                            +'<td>'+data[i].prix+'</td>'
                            +'<td>'+data[i].dateAchat+'</td>'
                            +'<td>'+data[i].marque.libelle+'</td>'
                            +'<td><a class="bndelete" href="MachineController?op=delete&id='+data[i].id+'">Supprimer</a></td>'
                            +'<td><a class="bnupdate" href="">Modifier</a></td>'
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


