let markSelect = document.getElementById("autoMark");
let modelSelect = document.getElementById("model");
let allModels = modelSelect.children;

if(markSelect.value == ""){
    modelSelect.setAttribute("disabled", "disabled");
} else {
    modelSelect.removeAttribute("disabled");
}
for (let i = 0; i < allModels.length; i++){
    if (allModels[i].className !== markSelect.value){
        allModels[i].style.display = "none";
    } else {
        allModels[i].style.display = "block";
    }
}
markSelect.addEventListener("click", function (){
    if(markSelect.value != null){
        modelSelect.removeAttribute("disabled");
    } else {
        modelSelect.setAttribute("disabled", "disabled");
    }
    for (let i = 0; i < allModels.length; i++){
        if (allModels[i].className !== markSelect.value){
            allModels[i].style.display = "none";
        } else {
            allModels[i].style.display = "block";
        }
    }
    modelSelect.value = null;
})