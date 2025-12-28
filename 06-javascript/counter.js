let count=0;
let step=1;
const head=document.getElementById("header");
const increBtn=document.getElementById("increment");
const decreBtn=document.getElementById("decrement");
const resetBtn=document.getElementById("reset");

const Btn1=document.getElementById("1");
const Btn5=document.getElementById("5");
const Btn10=document.getElementById("10");

increBtn.addEventListener("click",()=> {
    count += step
    head.textContent=count;
});
decreBtn.addEventListener("click",()=> {
    if(count>0) {
      count -= step
    head.textContent=count;   
    }
});
resetBtn.addEventListener("click",()=> {
    count = 0;
    head.textContent=count;
});
addEventListener.

Btn1.addEventListener("click",()=> {
    step=1;
});
Btn5.addEventListener("click",()=> {
    step=5;
});
Btn10.addEventListener("click",()=> {
    step=10;  
});
