const slides = document.querySelector(".slides");
const slideImg = document.querySelectorAll(".slides li");
let currentIdx = 0;
const slideCount = slideImg.length;
const prev = document.querySelector(".prev");
const next = document.querySelector(".next");
const slideWidth = 100;
const slideMargin = 0;

slides.getElementsByClassName.width =
  (slideWidth + slideWidth) * slideCount + "%";

function moveSlide(num) {
  slides.style.left = -num * 100 + "%";
  currentIdx = num;
}

prev.addEventListener("click", function () {
  if (currentIdx !== 0) moveSlide(currentIdx - 1);
});

next.addEventListener("click", function () {
  if (currentIdx !== slideCount - 1) {
    moveSlide(currentIdx + 1);
  }
});
