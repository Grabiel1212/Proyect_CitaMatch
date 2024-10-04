/* 
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/JavaScript.js to edit this template
 */


 
//            // Función para mostrar la siguiente sección del formulario
//            function showNextSection(currentSectionId, nextSectionId) {
//                document.getElementById(currentSectionId).style.display = 'none';
//                document.getElementById(nextSectionId).style.display = 'block';
//            }
//        
function showNextSection(currentSection, nextSection) {
    document.getElementById(currentSection).style.display = 'none';
    document.getElementById(nextSection).style.display = 'block';
    
    // Reiniciar el campo de entrada del siguiente paso
    const nextInput = document.querySelector(`#${nextSection} input`);
    if (nextInput) {
        nextInput.focus(); // Focalizar el siguiente campo de entrada
    }
}
document.addEventListener('DOMContentLoaded', function () {
    const sections = [
        'register-section-email',
        'register-section-code',
        'register-section-password',
        'carousel-section-personal',
        'carousel-section-photos',
        'carousel-section-additional'
    ];

    sections.forEach(section => {
        const inputElements = document.querySelectorAll(`#${section} input`);
        inputElements.forEach(input => {
            input.addEventListener('keydown', function (event) {
                if (event.key === 'Enter') {
                    event.preventDefault(); // Evitar que se envíe el formulario
                    const nextSection = getNextSection(section);
                    if (nextSection) {
                        showNextSection(section, nextSection);
                    }
                }
            });
        });
    });

    function getNextSection(currentSection) {
        const sectionOrder = [
            'register-section-email',
            'register-section-code',
            'register-section-password',
            'carousel-section-personal',
            'carousel-section-photos',
            'carousel-section-additional'
        ];
        const currentIndex = sectionOrder.indexOf(currentSection);
        return currentIndex < sectionOrder.length - 1 ? sectionOrder[currentIndex + 1] : null;
    }
});
