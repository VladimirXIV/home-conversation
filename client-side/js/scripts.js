function createOrdertTableFromJSON(JSONArray) {

    var divID = document.getElementById("main");

    var fullTable = "<table>" +
        "<th>" +
        "<td>Department</td>" +
        "</th>";

    for (i in JSONArray) {
        fullTable += "<tr>" +
            "<td>" + JSONArray[i].name + "</td>" +
            "</tr>";
    }

    fullTable += "</table>";

    divID.innerHTML += fullTable;
}

function getAllOrders() {
    $.ajax ({
        type: "GET",
        url: "http://localhost:9080/furniturefactory-1.0-SNAPSHOT/getAllDepartments",
        datatype: "json",
        success: function(data) {
            createTableFromJSON(data)
        }
    })
}

function populateWithMembers() {

    var chatContacts = ['PetRUShka',
                       'Donald Cobain',
                        '[xxx]Zl0[xxx]',
                       'PoMario',
                       'KuCeJIeB',
                       'JIaJIo4Ka',
                       'Donald Cobain',
                       '[xxx]Zl0[xxx]',
                       'PoMario',
                       'KuCeJIeB',
                       'JIaJIo4Ka'];

    var contactList = document.getElementById("contact-list");


    for (i in chatContacts) {

        var itemLi = document.createElement('li');
        var itemA = document.createElement('a')
        itemA.href = "#";

        itemLi.innerHTML = chatContacts[i];
        itemA.appendChild(itemLi);

        contactList.appendChild(itemA);
    }
}

$(function() {

    //The passed argument has to be at least a empty object or a object with your desired options
    $("#user-list").overlayScrollbars({
        className: "os-theme-light"
    });

    $("#conversation-list").overlayScrollbars({
        className: "os-theme-light"
    });
});


