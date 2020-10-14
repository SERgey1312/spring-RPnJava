let allCost = document.getElementsByClassName("autoCost");
let allYears = document.getElementsByClassName("autoYear");
for (let i = 0; i < allCost.length; i++){
    allCost[i].innerText += ' $';
    allYears[i].innerText += ' y.'
}