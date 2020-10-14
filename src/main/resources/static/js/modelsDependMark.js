let markSelect = document.getElementById("autoMark");
let modelSelect = document.getElementById("model");
let allModels = modelSelect.children;

for (let i = 0; i < allModels.length; i++){
    if (allModels[i].className !== markSelect.value){
        allModels[i].style.display = "none";
    } else {
        allModels[i].style.display = "block";
    }
}
markSelect.addEventListener("click", function (){
    for (let i = 0; i < allModels.length; i++){
        if (allModels[i].className !== markSelect.value){
            allModels[i].style.display = "none";
        } else {
            allModels[i].style.display = "block";
            modelSelect.value = allModels[i].value;
        }
    }
})