const btnToggle = document.querySelector('.check') 

btnToggle.addEventListener('click', function(){
    document.getElementById('side').classList.toggle('active') 
});
btnToggle.addEventListener('click', function(){
     document.getElementById('contenido').classList.toggle('margen') 
});
 
