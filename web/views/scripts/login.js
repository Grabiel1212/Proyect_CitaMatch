/* 
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/JavaScript.js to edit this template
 */


document.addEventListener('DOMContentLoaded', function() {
    document.getElementById('show-register').addEventListener('click', function(event) {
        event.preventDefault();
        switchSection('login-section', 'register-section-email');
    });

    document.getElementById('show-login').addEventListener('click', function(event) {
        event.preventDefault();
        switchSection('register-section-email', 'login-section');
    });

    document.querySelectorAll('form').forEach(form => {
        form.addEventListener('submit', function(event) {
            event.preventDefault();
            const currentSection = this.closest('.slide');
            let nextSection = null;
            
            if (currentSection.id === 'register-section-email') {
                nextSection = 'register-section-code';
            } else if (currentSection.id === 'register-section-code') {
                nextSection = 'register-section-password';
            } else if (currentSection.id === 'register-section-password') {
                nextSection = 'carousel-section-personal';
            } else if (currentSection.id === 'carousel-section-personal') {
                nextSection = 'carousel-section-photos';
            } else if (currentSection.id === 'carousel-section-photos') {
                nextSection = 'carousel-section-additional';
            } else {
                return; // End of registration steps
            }

            switchSection(currentSection.id, nextSection);
        });
    });

    function switchSection(currentId, nextId) {
        document.getElementById(currentId).style.display = 'none';
        document.getElementById(nextId).style.display = 'block';
    }
});
