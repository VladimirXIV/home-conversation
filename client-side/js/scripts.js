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

       if (namesWithMottos[i].name.startsWith(strToSearch)) {
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

        document.getElementById("search-results").style.display = "none";

        var myNode = document.getElementById("search-results");

        while (myNode.firstElementChild.nextElementSibling) {
            myNode.removeChild(myNode.firstElementChild.nextElementSibling);
        }

        return;

    }

    if (namesWithMottos.length !== 0) {

        document.getElementById("search-results").style.display = "block";

        var filteredNamesWithMottos = getFilteredArray(namesWithMottos, strToSearch);

        console.log("filteredNamesWithMottos.length = " + filteredNamesWithMottos.length);

        for (i in filteredNamesWithMottos) {

            console.log("i = " + i);

            var divListRow = createListRowForSearchResults(filteredNamesWithMottos[i].name, filteredNamesWithMottos[i].motto);

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


