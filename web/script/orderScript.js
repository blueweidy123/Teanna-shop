/* 
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/JavaScript.js to edit this template
 */


const priceFilter = document.getElementById("priceFilter");
function Filter(){
//    alert(priceFilter.value);
    window.location.href = "Orders?filter="+priceFilter.value;
}





const Ocontainer = document.getElementById("OutC");
const body = document.querySelector("body");
const navbar = document.querySelector(".navbar");
const menuBtn = document.querySelector(".menu-btn");
const cancelBtn = document.querySelector(".cancel-btn");
const navbar1 = document.getElementById("navbar");
const itemNav = document.getElementById("itemNav");
const banner = document.getElementById("banner");
const bannerHeading = document.getElementById("bannerHeading");
const sideBar = document.getElementById("sideBarContent");

menuBtn.onclick = () => {
    navbar.classList.add("show");
    menuBtn.classList.add("hide");
    body.classList.add("disabled");
};

cancelBtn.onclick = () => {
    body.classList.remove("disabled");
    navbar.classList.remove("show");
    menuBtn.classList.remove("hide");
};

window.onscroll = () => {
    this.scrollY > 20 ? navbar.classList.add("sticky") : navbar.classList.remove("sticky");
};
Ocontainer.onscroll = () => {
    Ocontainer.scrollTop > 20 ? navbar.classList.add("sticky") : navbar.classList.remove("sticky");
};

Ocontainer.addEventListener('scroll', (event) => {
    console.log("FT " + document.getElementById("FT").getBoundingClientRect().top);
    console.log("MT " + document.getElementById("MT").getBoundingClientRect().top);
    reveal();
    if ((Ocontainer.scrollTop > Ocontainer.offsetHeight * 0.8) && window.innerWidth > 992) {
        sideBar.classList.add('active');
        bannerHeading.classList.add('hide');
    } else if ((Ocontainer.scrollTop < Ocontainer.offsetHeight * 0.8) && window.innerWidth > 992) {
        sideBar.classList.remove('active');
        bannerHeading.classList.remove('hide');
    }
});

window.addEventListener('scroll', (event) => {
    reveal();
    let scroll = this.scrollY;
    if ((scroll > window.innerHeight * 0.5) && window.innerWidth < 992) {
        sideBar.classList.add('active');
        bannerHeading.classList.add('hide');
    } else if ((scroll < window.innerHeight * 0.5) && window.innerWidth < 992) {
        sideBar.classList.remove('active');
        bannerHeading.classList.remove('hide');
    }
});

function reveal() {
    var reveals = document.querySelectorAll('.reveal');
    for (var i = 0; i < reveals.length; i++) {
        var wHeight = window.innerHeight;
        var revealtop = reveals[i].getBoundingClientRect().top;
        var revealPoint = 50;

        if (revealtop < wHeight - revealPoint) {
            reveals[i].classList.add('active');
        } else {
            reveals[i].classList.remove('active');
        }
    }
}


//SMOOTH SCROLL TO DIV
if (window.innerWidth < 992) {
    var links = document.querySelectorAll('.itemNav a');
    links.forEach(function (link) {
        link.addEventListener('click', function (e) {
            e.preventDefault();
            var target = document.querySelector(this.getAttribute('href'));
            var yOffset = -120;
            var y = target.getBoundingClientRect().top + window.pageYOffset + yOffset;
            var yw = target.getBoundingClientRect().top;

            if (window.innerWidth < 992) {
                window.scrollTo({top: y, block: 'start', behavior: 'smooth'});
            }
        });
    });
}
//SMOOTH SCROLL TO DIV