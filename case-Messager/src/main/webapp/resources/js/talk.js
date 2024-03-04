let imgSend = document.querySelector("img.imgSend");
let content = document.querySelector("input[name=contentTalk]");
let idTalk = document.querySelector('input[name=idTalk]');
let idUser2 = document.querySelector('input[name=idUser2]');
let body = document.querySelector('body')
let main = document.querySelector(".main")
let backgroundList = document.querySelectorAll(".background>img");

body.scrollTop = body.scrollHeight;

function updateMessage(){
    let newSp = document.createElement('span');
    newSp.setAttribute("class", "one");
    newSp.innerText = document.querySelector("input[name=contentTalk]").value;
    main.appendChild(newSp);
    main.appendChild(document.createElement("br"))
    let idTalk = document.querySelector('input[name=idTalk]');
    let contentTalk = document.querySelector("input[name=contentTalk]");
    $.ajax({
        url:"/talk",
        type:'post',
        data: {
            idTalk: idTalk.value,
            contentTalk: contentTalk.value
        }
    })
    contentTalk.value = ''
    body.scrollTop = body.scrollHeight;

}

imgSend.onclick = function (){
    if(content.value != ""){
        updateMessage();
    }
    event.preventDefault()
}

content.onkeyup = function (e){
    if(e.keyCode == 13 && (content.value) != ""){
        updateMessage();

    }
}

function autoUpdate(){
    let dataSend = {
        action: "autoUpdate",
        idTalk: idTalk.value,
        idUser2: idUser2.value,
    }
    $.ajax({
        url:'/talk',
        type: 'post',
        data: dataSend,
        // headers: {
        //     'Accept': 'text/plain'
        // },
        success: function (response){
                let newSp = document.createElement('span');
                newSp.className = 'two';
                newSp.innerText = response;
                if(newSp.innerText != 'none') {
                    main.appendChild(newSp);
                    main.appendChild(document.createElement('br'));
                    body.scrollTop = body.scrollHeight;
                }

        },
        error: function (err){
            console.log(err)
        }
    })

}

 setTimeout(() => {
    setInterval(() => {
        autoUpdate()
    }, 1000)
}, 1500)

for(let x of backgroundList){
    x.onclick = function (){
        console.log(main.style.backgroundImage)
        if(main.style.backgroundImage == `url("${x.src}")`){
            main.style.backgroundImage = '';
            return;
        }
        main.style.backgroundImage = `url('${x.src}')`
    }
}
