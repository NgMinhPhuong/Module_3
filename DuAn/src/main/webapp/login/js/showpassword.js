let eye = document.querySelector('form img')
console.log(eye);
eye.onclick = function(e){
    let pw = document.querySelector('input[name=password]')
    if(pw.type == 'password')
    {
        pw.type = 'text'
        console.log(eye.src);
        eye.src = `login/img/open-eye.png`
    }
    else {
        pw.type = 'password'
        console.log(eye.src);
        eye.src = `login/img/close-eye.png`
    }

}
