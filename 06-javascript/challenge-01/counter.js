let count = 0;
let step = 1;

const head = document.getElementById("header");
const increBtn = document.getElementById("increment");
const decreBtn = document.getElementById("decrement");
const resetBtn = document.getElementById("reset");

// Step buttons: 1, 5, 10
[1, 5, 10].forEach(n => {
  document.getElementById(n).addEventListener("click", () => {
    step = n;
    head.textContent = `${step}`; // Template literal
  });
});

// Increment
increBtn.addEventListener("click", () => {
  count += step;
  head.textContent = `${count}`; // Template literal
});

// Decrement (cannot go below 0)
decreBtn.addEventListener("click", () => {
  if (count >= step) { // Using strict comparison logic
    count -= step;
    head.textContent = `${count}`;
  } else if (count > 0 && count < step) {
    count = 0;
    head.textContent = `${count}`;
  }
});

// Reset
resetBtn.addEventListener("click", () => {
  count = 0;
  head.textContent = `${count}`;
});

