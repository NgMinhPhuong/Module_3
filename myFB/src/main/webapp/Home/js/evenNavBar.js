let lists = document.querySelectorAll('.header li')
for(let x of lists){
    if(x.innerText == 'Trang chủ') continue;
    x.onmouseover = function(e){
        x.classList.add("active")
    }

    x.onmouseout = function(e){
        x.classList.remove('active')
        console.log("hehe")
    }
}

lists = document.querySelectorAll('.main .left li')
for(let x of lists){
    if(x.innerText == 'Trang chủ') continue;
    x.onmouseover = function(e){
        x.classList.add("active")
    }

    x.onmouseout = function(e){
        x.classList.remove('active')
    }
}