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

function getFilteredArray(namesWithMottos, strToSearch) {

    var result = [];

    for (i in namesWithMottos) {

        if (namesWithMottos.names.startsWith(strToSearch)) {
            result.push(namesWithMottos[i]);
        }

    }

    return result;
}

function searchGlobalContacts() {

    var namesWithMottos =
        [{
            "name": "Alexander",
            "motto": 25
        }, {
            "name": "Anthony",
            "motto": 25
        }, {
            "name": "Jay",
            "motto": 25
        }, {
            "name": "Jay",
            "motto": 25
        }, {
            "name": "Jay",
            "motto": 25
        }, {
            "name": "Jay",
            "motto": 25
        }, {
            "name": "Jay",
            "motto": 25
        }, {
            "name": "Jay",
            "motto": 25
        }, {
            "name": "Jay",
            "motto": 25
        }]


        {
        "names": ["Alexander", "Anthony", "Andrew", "Aaron", "Asher", "Austin", "Grayson", "Gavin", "Greyson", "George", "Giovanni", "Grant"],
        "mottos": ["Fire!", "Hey now!", "Live!", "GD", "ich bin da", "kasabian", "milk shaker", "bronson", "rhcp fan", "jhony the first", "L&M smoker", "software prog"]
    }

    if (namesWithMottos.length !== 0) {

        document.getElementById("search-results").style.display = "block";

        for (i in contactsName) {

            var divListRow = createListRowForSearchResults(contactsName[i], contactsMotos[i]);

            document.getElementById("search-results").appendChild(divListRow);
        }
    }

}

function createListRowForSearchResults(name, moto) {

    var divListRow = document.createElement('div');
    divListRow.className = "list-row";

    var divContactImage = document.createElement('div');
    divContactImage.className = "contact-image";

    var divSearchCI = document.createElement('div');
    divSearchCI.style.minWidth = "calc(100% - 100px)";
    divSearchCI.className = "contact-info";

    var divName = document.createElement('div');
    divName.style.fontSize = "18px";
    divName.innerHTML = name;

    var divMoto = document.createElement('div');
    divMoto.style.fontSize = "14px";
    divMoto.innerHTML = moto;

    var divAddBtnWrapper = document.createElement('div');
    divAddBtnWrapper.className = "add-btn-wrapper";

    var buttonAddBtn = document.createElement('button');
    buttonAddBtn.className = "add-btn";

    divListRow.appendChild(divContactImage);

    divSearchCI.appendChild(divName);
    divSearchCI.appendChild(divMoto);

    divListRow.appendChild(divSearchCI);

    divAddBtnWrapper.appendChild(buttonAddBtn);
    divListRow.appendChild(divAddBtnWrapper);

    return divListRow;
}


/*$(function() {

    //The passed argument has to be at least a empty object or a object with your desired options
    $("#user-list").overlayScrollbars({
        className: "os-theme-light"
    });

    $("#conversation-list").overlayScrollbars({
        className: "os-theme-light"
    });
});*/


