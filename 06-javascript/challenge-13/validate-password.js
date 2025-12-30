function validatePassword(password) {
    const commonPasswords = ['password','123456','12345678','qwerty','abc123','111111','letmein','123123'];
    const errors = [];
    const suggestions = [];
    let score = 0;

    if(password.length < 8){
        errors.push('Too short');
        suggestions.push('Use at least 8 characters');
    } else score += 20;

    if(!/[A-Z]/.test(password)){
        errors.push('Missing uppercase letter');
        suggestions.push('Add at least one uppercase letter');
    } else score += 15;

    if(!/[a-z]/.test(password)){
        errors.push('Missing lowercase letter');
        suggestions.push('Add at least one lowercase letter');
    } else score += 15;

    if(!/[0-9]/.test(password)){
        errors.push('Missing number');
        suggestions.push('Add at least one number');
    } else score += 20;

    if(!/[!@#$%^&*()_+\-=\[\]{};':"\\|,.<>\/?]/.test(password)){
        errors.push('Missing special character');
        suggestions.push('Add at least one special character');
    } else score += 20;

    if(commonPasswords.includes(password.toLowerCase())){
        errors.push('Password is too common');
        suggestions.push('Use a more unique password');
        score = Math.min(score,15);
    }

    if(password.length >= 12) score += 10;
    if(score > 100) score = 100;

    const isValid = errors.length === 0;

    return {isValid, score, errors, suggestions};
}

// DOM elements
const passwordInput = document.getElementById('passwordInput');
const scoreEl = document.getElementById('score');
const progressBar = document.getElementById('progressBar');
const errorsList = document.getElementById('errorsList');
const suggestionsList = document.getElementById('suggestionsList');

passwordInput.addEventListener('input', () => {
    const password = passwordInput.value;
    const result = validatePassword(password);

    // Update score and progress bar
    scoreEl.textContent = result.score;
    progressBar.style.width = result.score + '%';
    progressBar.className = 'progress-bar ' + (result.score >= 80 ? 'bg-success' : result.score >= 50 ? 'bg-warning' : 'bg-danger');

    // Update errors
    errorsList.innerHTML = '';
    result.errors.forEach(err => {
        const li = document.createElement('li');
        li.className = 'list-group-item list-group-item-danger';
        li.textContent = err;
        errorsList.appendChild(li);
    });

    // Update suggestions
    suggestionsList.innerHTML = '';
    result.suggestions.forEach(sug => {
        const li = document.createElement('li');
        li.className = 'list-group-item list-group-item-info';
        li.textContent = sug;
        suggestionsList.appendChild(li);
    });
});

