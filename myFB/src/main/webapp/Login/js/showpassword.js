let eye = document.querySelector('form img')
console.log('hello');
eye.onclick = function(e){

    let pw = document.querySelector('input[name=password]')
    if(pw.type == 'password')
    {
        pw.type = 'text'
        console.log('here12')
        eye.src = 'Login/img/open-eye.png'
    }
    else {
        pw.type = 'password'
        console.log(eye.src);
        eye.src = 'Login/img/close-eye.png'
    }   
}
