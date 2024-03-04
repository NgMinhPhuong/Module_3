let resultSearch = document.querySelector(".resultSearch");
let inputSearch = document.querySelector('input[name=search]');

function showResultSearch(){
    let dataSend = {
        search: inputSearch.value,
        action: 'search'
    }
    $.ajax({
        url:'/home',
        type:'post',
        data: dataSend,
        success: function (response){
            let newSp = document.createElement("span");
            newSp.innerText = response
            if(newSp.innerText != 'none') {
                resultSearch.innerHTML = response
                return;
            }
            resultSearch.innerHTML = "";
        },
        error: function (err){
            console.log(err)
        }
    })
}

inputSearch.oninput = function (){
    showResultSearch();
}