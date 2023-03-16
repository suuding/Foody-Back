let search_btn = document.querySelector("#search-button");
search_btn.addEventListener("click", ()=>{
    let search_input = document.querySelector('#search-input');

    window.location.href = "/product?title="+search_input.value;
})