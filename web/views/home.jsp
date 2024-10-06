<%@page import="java.util.List"%>
<%@page import="java.util.Base64"%>
<%@page import="back.entitys.Persona"%>
<%@taglib prefix="s" uri="/struts-tags" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="es">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/assets/styles/home.css"/>
    <title>Perfiles - CitaMatch</title>
</head>
<body>
    <nav class="sidebar">
        <header>
            <div class="image-text">
                <span class="image">
                    <img src="assets/styles/tinder-logo.jpg" alt="logo">
                </span>
                <div class="text header-text">
                    <span class='name'>CodingLab</span> 
                    <span class="profession">web developer</span>
                </div>
            </div>
            <img src="${pageContext.request.contextPath}/assets/styles/boxicons.min.png" class="bx-fade-right toogle" style="width: 50px; height: 50px;" alt="Icono" />
        </header>
        <div class='menu-bar'>
            <div class='menu'>
                <ul class='menu-links'>
                    <li class="nav-link">
                       <a href='#'>
                         <img src="${pageContext.request.contextPath}/assets/styles/inicio.png" class="icon">
                         <span class='text nav-text'>INICIO</span>
                       </a>
                    </li>
                    <li class="nav-link">
                         <a href='#'>
                         <img src="${pageContext.request.contextPath}/assets/styles/PERFIL.png" class="icon">
                         <span class='text nav-text'>PERFIL</span>
                       </a>
                    </li>
                    <li class="nav-link">
                         <a href='#'>
                         <img src="${pageContext.request.contextPath}/assets/styles/CONTACTO.png" class="icon">
                         <span class='text nav-text'>CONTACTO</span>
                       </a>
                    </li>
                    <li class="nav-link">
                         <a href='#'>
                         <img src="${pageContext.request.contextPath}/assets/styles/NOTIFICACION.png" class="icon">
                         <span class='text nav-text'>NOTIFICACION</span>
                       </a>
                    </li>
                    <li class="nav-link">
                         <a href='#'>
                         <img src="${pageContext.request.contextPath}/assets/styles/LIKES.png" class="icon">
                         <span class='text nav-text'>MENSAJES</span>
                       </a>
                    </li>
                </ul>
            </div>
        </div>
        
    </nav>
    <div class="shadow">
        <main>
            <section>
                <div class="white-bkg"></div>
                <header>
                    <img src="${pageContext.request.contextPath}/assets/styles/tinder-logo.jpg" alt="Tinder Logo" />
                </header>

                <div class="cards" id="cards-container">
                    <template id="profile-template">
                        <article class="profile-card">
                            <img src="" alt="Imagen de perfil" class="profile-img" />
                            <h2 class="profile-name">Nombre, Edad años</h2>
                            <div class="choice nope">NOPE</div>
                            <div class="choice like">LIKE</div>
                        </article>
                    </template>
                </div>

                <footer>
                    <button class="is-undo" aria-label="undo"></button>
                    <button class="is-remove is-big" aria-label="remove" onclick="handleNope()"></button>
                    <button class="is-star" aria-label="star"></button>
                    <button class="is-fav is-big" aria-label="fav" onclick="handleLike()"></button>
                    <button class="is-zap" aria-label="zap"></button>
                </footer>
            </section>
        </main>
    </div>

    <script>
        const profiles = [
        <%
            List<Persona> perfiles = (List<Persona>) session.getAttribute("perfiles");
            if (perfiles != null && !perfiles.isEmpty()) {
                for (int i = 0; i < perfiles.size(); i++) {
                    Persona perfil = perfiles.get(i);
                    String nombre = perfil.getNombre();
                    int edad = perfil.getEdad();
                    String imagePath;
                    if (perfil.getFotoPerfil() != null) {
                        imagePath = "data:image/jpeg;base64," + Base64.getEncoder().encodeToString(perfil.getFotoPerfil());
                    } else {
                        imagePath = request.getContextPath() + "/assets/img/9.jpg";
                    }
        %>
        {
            name: "<%= nombre %>",
            age: <%= edad %>,
            img: "<%= imagePath %>"
        }<%= (i < perfiles.size() - 1) ? "," : "" %>
        <%
                }
            } else {
        %>
        {
            name: "No hay perfiles disponibles",
            age: 0,
            img: "<%= request.getContextPath() %>/assets/images/default.jpg"
        }
        <% } %>
        ];
        console.log(profiles);
        let currentIndex = 0;
        let isAnimating = false;

        function loadProfile() {
            const cardsContainer = document.getElementById('cards-container');
            const template = document.getElementById('profile-template').content;
            if (currentIndex >= profiles.length) {
                cardsContainer.innerHTML = '<span>No hay más personas cerca de ti...<br />Vuelve a intentarlo más tarde</span>';
                return;
            }

            const profile = profiles[currentIndex];
            console.log("Cargando perfil:", profile); // Verifica que los datos estén correctos en la consola

            // Clonar la plantilla
            const clone = template.cloneNode(true);

            // Asignar nombre
            const profileName = clone.querySelector('.profile-name');
            profileName.textContent = profile.name; // Esta línea funciona correctamente

            // Añadir la edad al nombre
           profileName.textContent = profile.name + ', ' + profile.age + ' años';


            console.log("Nombre y edad asignados:", profile.name, "EDAD:", profile.age); // Verifica que se asignen correctamente
            // Asignar datos del perfil a la plantilla clonada
            clone.querySelector('.profile-img').src = profile.img;

            // Agregar la tarjeta clonada al contenedor
            cardsContainer.appendChild(clone);
            currentIndex++; // Aumentar el índice para cargar el siguiente perfil
        }

        function handleLike() {
            const actualCard = document.querySelector('article');
            if (!actualCard || isAnimating) return;
            isAnimating = true;
            slideCard(actualCard, true);
        }

        function handleNope() {
            const actualCard = document.querySelector('article');
            if (!actualCard || isAnimating) return;
            isAnimating = true;
            slideCard(actualCard, false);
        }

        function slideCard(card, goRight) {
            const pullDeltaX = goRight ? 100 : -100;
            card.style.transform = `translateX(${pullDeltaX}px)`;
            card.classList.add(goRight ? 'go-right' : 'go-left');
            card.addEventListener('transitionend', () => {
                card.remove();
                isAnimating = false;
                loadProfile(); // Cargar el siguiente perfil al finalizar la animación
            });
        }

        document.addEventListener('DOMContentLoaded', loadProfile);
    </script>
</body>
</html>
