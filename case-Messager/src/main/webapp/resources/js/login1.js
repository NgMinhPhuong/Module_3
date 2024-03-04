let eye = document.querySelector('form img')
let pw = document.querySelector('input[name=password]')
console.log('vào')
eye.onclick = function(e){
    console.log('vào')
    if(pw.type == 'password')
    {
        pw.type = 'text'
        console.log('here12')
        eye.src = 'resources/img/login1/open-eye.png'
    }
    else {
        pw.type = 'password'
        console.log(eye.src);
        eye.src = 'resources/img/login1/close-eye.png'
    }
}

let buttonRegister = document.querySelector(".create")
let phanlammo = document.querySelector('.login');
let register = document.querySelector('.register');
buttonRegister.onclick = function(){
    phanlammo.style.pointerEvents = `none`;
    phanlammo.style.opacity = '0.4';
    register.style.visibility = `visible`
    event.preventDefault();
}

let username_regi = document.querySelector('input[name=username_regi]');
let password_regi = document.querySelector('input[name=password_regi]');
let name_regi = document.querySelector('input[name=name_regi]')
let image_regi = document.querySelector('input[name=image_regi]');
function createAccount(dataSend){
    $.ajax({
        url: '/login',
        type: 'post',
        data : dataSend,
        success: function (response){
            phanlammo.style.pointerEvents = `auto`;
            phanlammo.style.opacity = '1';
            register.style.visibility = `hidden`
        },
        error: function (err){
            console.log(err)
        }
    })
}
let buttonSubmitRegister = document.querySelector('.register2>button');
buttonSubmitRegister.onclick = function (){
    let dataSend = {
        username: username_regi.value,
        password: password_regi.value,
        name: name_regi.value,
        image: image_regi.value,
        action: 'register'
    }
    if(dataSend.username == '' || dataSend.password == '' || dataSend.name == '' || dataSend.image == ''){
        return;
    }
    createAccount(dataSend);
}
