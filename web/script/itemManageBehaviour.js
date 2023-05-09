/* 
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/JavaScript.js to edit this template
 */


//edit div
const edView = document.getElementById("editView");
const descText = document.getElementById("editView-desc");
const edForm = document.getElementById("edForm");
//id and mode, call server to trigger corresponding mode's method
const iId = document.getElementById("iId");
const mode = document.getElementById("mode");
//element in edit div
const edCate = document.getElementById("editItemCate");
const edCateSelect = document.getElementById("cateSelect");
const edImgUrl = document.getElementById("editItemImgUrl");
const iURL = document.getElementById("iURL");
const edName = document.getElementById("editItemName");
const iName = document.getElementById("iName");
const edPrice = document.getElementById("editItemPrice");
const iPrice = document.getElementById("iPrice");
const fileInput = document.getElementById('filePick');
//data table
var table = document.getElementById("itemTable");
var searchInput = document.getElementById("search");
var showCate = document.getElementById("showCate");
var cateFilter = document.getElementById("cateFilter");
//for loop purposes
var rows = document.getElementsByTagName('tr');
//for check classList
const tableRows = document.querySelectorAll('.table-row');
//image to show url
const edIMG = document.getElementById("editItemImg");

window.onload = checkAnySelected();
document.getElementById("search").addEventListener("keyup", searchTable);

//onclick and search func for each row
for (var i = 0; i < rows.length; i++) {
    rows[i].addEventListener('click', function () {
        checkAnySelected();
        var cateID = this.cells[0].innerHTML;
        var itemID = this.cells[1].innerHTML;
        var imgURL = this.cells[2].innerHTML;
        var itemName = this.cells[3].innerHTML;
        var itemPrice = this.cells[4].innerHTML;
        var index = this.rowIndex;
        for (var i = 0; i < rows.length; i++) {
            rows[i].classList.remove("selected");
        }
        mode.value = 0;
        //turn off to reset this div state
        edView.classList.remove('active');
        edView.classList.remove('active');
        descText.classList.remove('active');
//                  this.classList.toggle("selected");
        if (this.classList.contains('selected')) {
            this.classList.remove("selected");
        }
        if (!this.classList.contains('selected')) {
            this.classList.add("selected");
        }

        checkAnySelected();

        edView.classList.add('active');
        edForm.classList.add('active');
        descText.classList.add('active');
        edIMG.innerHTML = "<img src='data:image/jpeg;base64," + imgURL + "' alt='My Image'>";

        if (cateID.indexOf("FT") !== -1) {
            edCateSelect.selectedIndex = 0;
        } else if (cateID.indexOf("GT") !== -1) {
            edCateSelect.selectedIndex = 1;
        } else if (cateID.indexOf("IS") !== -1) {
            edCateSelect.selectedIndex = 2;
        } else if (cateID.indexOf("MT") !== -1) {
            edCateSelect.selectedIndex = 3;
        } else if (cateID.indexOf("SS") !== -1) {
            edCateSelect.selectedIndex = 4;
        } else if (cateID.indexOf("YS") !== -1) {
            edCateSelect.selectedIndex = 5;
        } else {
            edCateSelect.selectedIndex = -1;
        }

        iId.value = itemID.trim();
        iURL.value = imgURL.trim();
        iName.value = itemName.trim();
        iPrice.value = itemPrice.trim();
    });
}

function browseFile() {
    const input = document.createElement('input');
    input.type = 'file';
    input.addEventListener('change', (event) => {
        const file = event.target.files[0];
        const reader = new FileReader();
        reader.onload = (event) => {
            const base64String = event.target.result.split(',')[1];
            edIMG.innerHTML = "<img src='data:image/jpeg;base64," + base64String + "' alt='My Image'>";
            iURL.value = base64String;
        };
        reader.readAsDataURL(file);
    });
    input.click();
}

//fileInput.addEventListener('change', (event) => {
//    const selectedFile = event.target.files[0];
//    const url = URL.createObjectURL(selectedFile);
//    iURL.value = url;
//});

//default confirm = update
function confirm() {

    if (iURL.value === '' || iName.value === '' || iPrice.value === '' || edCateSelect.selectedIndex === -1) {
        alert('empty input');
    } else {
        edView.classList.remove('active');
        edForm.classList.remove('active');
        descText.classList.remove('active');
        for (var i = 0; i < rows.length; i++) {
            rows[i].classList.remove("selected");
        }
        if (mode.value === "0") {
            mode.value = 1;
        }
        if (mode.value === "3") {
            mode.value = 3;
        }
        setTimeout(() => {
            edForm.submit();
        }, 1000);
    }
}

//confirm delete
function deleteItem() {
    if (confirm("Are you sure you want to delete this item?")) {
        del();
    } else {
        // cancel the deletion
    }
}

function del() {
    edView.classList.remove('active');
    edForm.classList.remove('active');
    descText.classList.remove('active');
    for (var i = 0; i < rows.length; i++) {
        rows[i].classList.remove("selected");
    }
    mode.value = 2;
    setTimeout(() => {
        edForm.submit();
    }, 1000);
}

//add
function addItem() {
    edView.classList.remove('active');
    edForm.classList.remove('active');
    descText.classList.remove('active');
    for (var i = 0; i < rows.length; i++) {
        rows[i].classList.remove("selected");
    }

    mode.value = 3;

    edIMG.innerHTML = "<img src='css/newDrink.jpg' alt='IMG'/>";
    edCateSelect.selectedIndex = -1;
    iId.value = "";
    iURL.value = "";
    iName.value = "";
    iPrice.value = "";

    edView.classList.add('active');
    edForm.classList.add('active');
    descText.classList.add('active');

}

function cancelEdit() {
    mode.value = 0;
    edView.classList.remove('active');
    edForm.classList.remove('active');
    descText.classList.remove('active');
    for (var i = 0; i < rows.length; i++) {
        rows[i].classList.remove("selected");
    }
}

function checkAnySelected() {
    let selectedExists = false;
    for (let i = 0; i < tableRows.length; i++) {
        if (tableRows[i].classList.contains('selected')) {
            selectedExists = true;
            break;
        }
    }
    if (selectedExists) {
        console.log("s");
        edView.classList.add('active');
        edForm.classList.add('active');
        descText.classList.add('active');
    } else {
        console.log("ns");
        edView.classList.remove('active');
        edForm.classList.remove('active');
        descText.classList.remove('active');
    }
}

//search 
function searchTable() {
    var filter, tr, td, itemName;
    filter = searchInput.value.toUpperCase();
    tr = table.getElementsByTagName("tr");

    for (var i = 0; i < tr.length; i++) {
        td = tr[i].getElementsByTagName("td")[3];
        if (td) {
            itemName = td.textContent || td.innerText;
            if (itemName.toUpperCase().indexOf(filter) > -1) {
                tr[i].classList.remove("hide");
            } else {
                tr[i].classList.add("hide");
            }
        }
    }
}

showCate.addEventListener("change", function () {
    if (showCate.checked) {
        // If the checkbox is checked, show all table headers
        var headers = table.getElementsByTagName("th");
        for (var i = 0; i < headers.length; i++) {
            headers[i].style.display = "table-cell";
        }
    } else {
        // If the checkbox is not checked, hide all table headers
        var headers = table.getElementsByTagName("th");
        for (var i = 0; i < headers.length; i++) {
            headers[i].style.display = "none";
        }
    }
});

cateFilter.onchange = function () {
    var selectedValue = cateFilter.value.toLowerCase();
    console.log(selectedValue);
    for (var i = 0; i < table.rows.length; i++) {
        var row = table.rows[i];
        var firstCell = row.cells[0].textContent.toLowerCase();
        console.log(firstCell.trim());
        if (selectedValue === '0') {
            row.style.display = "";
            showCate.checked=true;
        } else if (firstCell.trim() !== selectedValue) {
            row.style.display = "none";
            showCate.checked=false;
        } else {
            row.style.display = "";
            showCate.checked=false;
        }
    }
};

