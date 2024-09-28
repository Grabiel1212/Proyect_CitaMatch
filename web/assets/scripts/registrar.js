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
}
