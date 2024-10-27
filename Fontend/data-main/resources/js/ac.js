// const button = document.getElementById("myButton");
//
//
// function dang_nhap() {
//     window.location.href = "dang_nhap.html";
// }
// function dang_ki() {
//     window.location.href = "dang_ki.html";
// }
//
// function dang_ki_success() {
//     content_dang_ki.classList.remove("visible");
//     content_dang_ki.classList.add("hidden");
//     content_dang_ki_success.classList.remove("hidden");
//     content_dang_ki_success.classList.add("visible");
//
// }
//
// function dang_nhap_success() {
//     content_dang_nhap.classList.remove("visible");
//     content_dang_nhap.classList.add("hidden");
//     content_dang_nhap_success.classList.remove("hidden");
//     content_dang_nhap_success.classList.add("visible");
//
// }
// function quen_mat_khau_success() {
//     content_quen_mat_khau.classList.remove("visible");
//     content_quen_mat_khau.classList.add("hidden");
//     content_quen_mat_khau_success.classList.remove("hidden");
//     content_quen_mat_khau_success.classList.add("visible");
// }
// function logg() {
//     window.location.href = "main_screen.html";
// }

const apiUrl = 'http://localhost:8080/api/user/sign_up';

function dang_ki_success() {
    const phone = document.getElementById('phone').value;
    const pass = document.getElementById('password').value;

    const data = {
        phone: phone,
        password: pass
    };

    fetch(apiUrl, {
        method: 'POST',
        headers: {
            "Content-Type": "application/json"
        },
        body: JSON.stringify(data)
    })
        // .then(response =>{
        //     if(response.ok){
        //         return response.json();
        //     }
        //     throw new Error('Đăng nhập thất bại!!')
        // })
        .then(data =>{
            console.log(data);
            if(data.status === 200){
                window.location.href = 'main_screen.html';
            }else{
                const errorMessage = document.getElementById("error-message");
                errorMessage.style.display = "block";
                errorMessage.innerText = "User đã tồn tại!!";
            }
        })
        .catch(error =>{
            console.error('Lỗi:',error)
        });
    document.querySelector('.type_a').addEventListener('click',function (){
        window.location.href = 'dang_nhap.html';
    });
}


