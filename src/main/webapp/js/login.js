const btnLogIn = document.querySelector('.log-btn');
const btnSignUp = document.querySelector('.sign-btn');
const signUp = document.querySelector('.sign-up');
const logIn = document.querySelector('.log-in1');

document.addEventListener('click', e =>{ 
    if(e.target === btnLogIn || e.target === btnSignUp){
        console.log('uwu');
        logIn.classList.toggle('active');
        signUp.classList.toggle('active');
    }   
});
        
