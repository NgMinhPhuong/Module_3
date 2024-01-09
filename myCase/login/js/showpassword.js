let eye = document.querySelector('form img')
console.log(eye);
eye.onclick = function(e){
    let pw = document.querySelector('input[name=password]')
    if(pw.type == 'password')
    {
        pw.type = 'text'
        console.log(eye.src);
        eye.src = `./img/open-eye.jpg`
    }
    else {
        pw.type = 'password'
        console.log(eye.src);
        eye.src = `./img/close-eye.png`
    }   
}

let selectYear = document.createElement('select')
selectYear.name = `birthYear`
let result = ''
for(let i = 1900; i <= 2023; i++){
    result+=(`<option value='${i}'>${i}</option>`)
}
selectYear.innerHTML = result;
document.querySelector('.birth').append(selectYear)
