let isusernameValid=false;
let isemailValid=false;
let ispasswordValid=false;
let isconfirmPasswordValid=false;   
const user=document.getElementById("username");
const userId=document.getElementById("userId");
user.addEventListener("blur",function() {
const username=user.value; 
const usernameRegex=/^[a-zA-Z0-9]{3,15}$/;
userId.style.color="red";
if(!usernameRegex.test(username)) {
    userId.textContent='Username must be 3–15 characters (letters & numbers only';
    console.log(userId.textContent);
    isusernameValid=false;
} else {    
    console.log("Valid username");
     isusernameValid=true;
} 
checkvalidation();
console.log(username);
});
const email=document.getElementById("email");
const emailId=document.getElementById("emailId");
email.addEventListener("blur",function() {
const emailValue=email.value;
const emailRegex= /^[a-z0-9._%-]+@[a-z]+\.[a-z]{2,}$/;
emailId.style.color="red";
if(!emailRegex.test(emailValue)) {
    emailId.textContent="Invalid email address";
    console.log(emailId.textContent);
    isemailValid=false;
} else {
    console.log("Valid email"); 
    isemailValid=true;     
}
checkvalidation();
console.log(emailValue);
});
const password=document.getElementById("pwd");
const passwordId=document.getElementById("passwordId");
password.addEventListener("blur",function() {
    const pwdV=password.value;
    //const passwordRegex=/^(?=.[A-Z])(?=.\d)(?=.[!@#$%&])[A-Za-z\d!@#$%&*]{8,}$/;
    const passwordRegex = /^(?=.*[A-Z])(?=.*\d)(?=.*[!@#$%&])[A-Za-z\d!@#$%&*]{8,}$/;

    passwordId.style.color="red";
    if(!passwordRegex.test(pwdV)) {
        passwordId.textContent="Password must be 8+ chars, include uppercase, lowercase & number";
        console.log(passwordId.textContent);
        ispasswordValid=false;
        
    } else {
        ispasswordValid=true;           
        console.log("inValid password");  
    } 
    checkvalidation();
    console.log(pwdV);                                                                                                                                          
});
const pwd2=document.getElementById("pwd1");
const confirmPasswordId=document.getElementById("confirmPasswordId");
confirmPasswordId.style.color="red";
pwd2.addEventListener("blur",function() {
    const confirmPwd=pwd2.value;
    const originalPwd=password.value; 
    if(originalPwd!==confirmPwd) {
        confirmPasswordId.textContent="Password and Confirm Password do not match";
        console.log(confirmPasswordId.textContent);
        isconfirmPasswordValid=false; 
    } else {
        console.log("Passwords match");  
        isconfirmPasswordValid=true;
    } 
    checkvalidation();
    console.log(confirmPwd);                        

});
function checkvalidation() {
 const submitBtn=document.querySelector("#submitBtn");
 if(isusernameValid && isemailValid && ispasswordValid && isconfirmPasswordValid) {
    submitBtn.disabled=false;
 } else {
    submitBtn.disabled=true;
 }  
}


