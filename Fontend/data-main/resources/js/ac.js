const button = document.getElementById("myButton");


function dang_nhap() {
    window.location.href = "dang_nhap.html";
}
function dang_ki() {
    window.location.href = "dang_ki.html";
}

function dang_ki_success() {
    content_dang_ki.classList.remove("visible");
    content_dang_ki.classList.add("hidden");
    content_dang_ki_success.classList.remove("hidden");
    content_dang_ki_success.classList.add("visible");
    
}

function dang_nhap_success() {
    content_dang_nhap.classList.remove("visible");
    content_dang_nhap.classList.add("hidden");
    content_dang_nhap_success.classList.remove("hidden");
    content_dang_nhap_success.classList.add("visible");
    
}
function quen_mat_khau_success() {
    content_quen_mat_khau.classList.remove("visible");
    content_quen_mat_khau.classList.add("hidden");
    content_quen_mat_khau_success.classList.remove("hidden");
    content_quen_mat_khau_success.classList.add("visible");
}
function logg() {
    window.location.href = "main_screen.html";
}

