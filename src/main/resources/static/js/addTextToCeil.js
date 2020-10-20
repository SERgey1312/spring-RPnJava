let allCost = document.getElementsByClassName("autoCost");
let allYears = document.getElementsByClassName("autoYear");
for (let i = 0; i < allCost.length; i++){
    allCost[i].innerText += ' $';
    allYears[i].innerText += ' y.'
}

let allRow = document.getElementsByTagName("tr");
for (let i = 0 ; i < allRow.length; i++){
    if (i % 2 !== 0){
        allRow[i].style.background = "#f5f5f5";
    }
}