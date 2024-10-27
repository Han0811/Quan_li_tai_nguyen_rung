const apiUrl = 'http://localhost:8080/api/user/login';

function dang_nhap_success() {
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
        .then()
        .then(data =>{
            console.log(data);
            console.log('Giá trị của data.success:', data.success);
            if(data.status === 200){
                window.location.href = 'main_screen.html';
            }else{
                const errorMessage = document.getElementById("error-message");
                errorMessage.style.display = "block";
                errorMessage.innerText = "Số điện thoại hoặc mật khẩu không đúng ";
            }
        })
        .catch(error =>{
            console.error('Lỗi:',error)
        });
    // document.querySelector('.type_b').addEventListener('click',function (){
    //     window.location.href = 'dang_nhap.html';
    // });
    // document.querySelector('.type_c').addEventListener('click',function (){
    //     // window.location.href = 'dang_nhap.html';
    // });
}