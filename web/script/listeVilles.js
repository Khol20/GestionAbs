function getListeEtudiants(elementId) {
    var etudiants = [
        '  ','El habbouli kholoud','Chtioui Salma','Baghdad Ghita'
    ];

    var selectElement = document.getElementById(elementId);

    if (selectElement) {
        for (var i = 0; i < etudiants.length; i++) {
            var option = document.createElement('option');
            option.value = etudiants[i];
            option.text = etudiants[i];
            selectElement.appendChild(option);
        }
    } else {
        console.error("The element with the specified ID was not found.");
    }
}

function getListeModules(elementId) {
    var modules = [
        ' Selectionner ','Management de la Maintenance','Anglais','TEC'
    ];

    var selectElement = document.getElementById(elementId);

    if (selectElement) {
        for (var i = 0; i < modules.length; i++) {
            var option = document.createElement('option');
            option.value = modules[i];
            option.text = modules[i];
            selectElement.appendChild(option);
        }
    } else {
        console.error("The element with the specified ID was not found.");
    }
}







