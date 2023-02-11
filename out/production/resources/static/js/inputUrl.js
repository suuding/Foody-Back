let search_button = document.querySelector('#search-button');
search_button.addEventListener('click', ()=>{
    let getUrl = document.querySelector('#search-url');
    alert('/product?title='+getUrl.value)

    window.location.href='/product?title='+getUrl.value;
})


