function populateListWithTestData() {

    var namesWithMottos =
        [{
            "name": "Konstantine",
            "motto": "the greate frontend!"
        }, {
            "name": "VladimiRUS",
            "motto": "hating IT person"
        }, {
            "name": "Pavlo",
            "motto": "american idiot"
        }, {
            "name": "Boris",
            "motto": "berserk with axe"
        }, {
            "name": "Andrew",
            "motto": "underdog"
        }, {
            "name": "Eugen",
            "motto": "husband, police officer"
        }, {
            "name": "Vladi",
            "motto": "undefined person"
        }, {
            "name": "Petr Eugenievich",
            "motto": "math genius"
        }, {
            "name": "Grigory",
            "motto": "master of pupets"
        }, {
            "name": "Oleg",
            "motto": "just kopron!"
        }, {
            "name": "Angelina nagina",
            "motto": "lloks like Angelina Jolie"
        }, {
            "name": "Nicolashka",
            "motto": "it-scum"
        }];

    var strToSearch = document.getElementById("contacts-list");

    for (i in namesWithMottos) {
        var divListRow = createRowForContactList(namesWithMottos[i].name, namesWithMottos[i].motto);
        document.getElementById("contacts-list").appendChild(divListRow);
    }
}

function getFilteredArray(namesWithMottos, strToSearch) {

    var result = [];

    for (i in namesWithMottos) {

       if (namesWithMottos[i].name.toLowerCase().startsWith(strToSearch.toLowerCase())) {
           result.push(namesWithMottos[i]);
       }
    }

    return result;
}

function searchGlobalContacts() {

    var namesWithMottos =
        [{
            "name": "Alexander",
            "motto": "Fire!"
        }, {
            "name": "Anthony",
            "motto": "Hey now!"
        }, {
            "name": "Andrew",
            "motto": "Live!"
        }, {
            "name": "Aaron",
            "motto": "GD"
        }, {
            "name": "Asher",
            "motto": "ich bin da"
        }, {
            "name": "Austin",
            "motto": "kasabian"
        }, {
            "name": "Grayson",
            "motto": "milk shaker"
        }, {
            "name": "Gavin",
            "motto": "bronson"
        }, {
            "name": "Greyson",
            "motto": "rhcp fan"
        }, {
            "name": "George",
            "motto": "jhony the first"
        }, {
            "name": "Giovanni",
            "motto": "L&M smoker"
        }, {
            "name": "Grant",
            "motto": "software prog"
        }];

    var strToSearch = document.getElementById("srch-ipt").value;

    console.log("strToSearch = " + strToSearch );

    if (!strToSearch) {
        clearSearchResults();
        document.getElementById("srch-my-list").style.display = "none";
        return;
    }

    if (namesWithMottos.length !== 0) {

        var filteredNamesWithMottos = getFilteredArray(namesWithMottos, strToSearch);

        clearSearchResults();

        if (filteredNamesWithMottos && filteredNamesWithMottos.length) {

            document.getElementById("search-results").style.display = "block";

            document.getElementById("srch-my-list").style.display = "block";

            console.log("filteredNamesWithMottos.length = " + filteredNamesWithMottos.length);

            for (i in filteredNamesWithMottos) {

                console.log("i = " + i);

                var divListRow = createListRowForSearchResults(filteredNamesWithMottos[i].name, filteredNamesWithMottos[i].motto);

                document.getElementById("search-results").appendChild(divListRow);
            }
        }

    }
}

function clearSearchResults() {
    document.getElementById("search-results").style.display = "none";

    var myNode = document.getElementById("search-results");

    while (myNode.firstElementChild.nextElementSibling) {
        myNode.removeChild(myNode.firstElementChild.nextElementSibling);
    }
}

function createRowForContactList(name, moto) {

    var divListRow = document.createElement('div');
    divListRow.className = "list-row";

    var divContactImage = document.createElement('div');
    divContactImage.className = "contact-image";

    var divSearchCI = document.createElement('div');
    divSearchCI.className = "contact-info";

    var divName = document.createElement('div');
    divName.style.fontSize = "18px";
    divName.innerHTML = name;

    var divMoto = document.createElement('div');
    divMoto.style.fontSize = "14px";
    divMoto.innerHTML = moto;

    var divContactStatus = document.createElement('div');
    divContactStatus.className = "contact-status";

    var divRemoveBtnWrapper = document.createElement('div');
    divRemoveBtnWrapper.className = "remove-btn-wrapper";

    var buttonRemoveBtn = document.createElement('button');
    buttonRemoveBtn.className = "remove-button";

    divListRow.appendChild(divContactImage);

    divSearchCI.appendChild(divName);
    divSearchCI.appendChild(divMoto);

    divListRow.appendChild(divSearchCI);

    divListRow.appendChild(divContactStatus);

    divRemoveBtnWrapper.appendChild(buttonRemoveBtn);
    divListRow.appendChild(divRemoveBtnWrapper);

    return divListRow;

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