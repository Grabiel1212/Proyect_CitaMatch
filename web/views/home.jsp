<%@taglib prefix="s" uri="/struts-tags" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="es">
    <head>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <link rel="stylesheet" href="assets/styles/home.css"/>
        <title>Perfiles - CitaMatch</title>
    </head>
    <body>
        <div class="shadow">
            <main>
                <section>
                    <div class="white-bkg"></div>
                    <header>
                        <img src="assets/styles/tinder-logo.jpg" alt="Tinder Logo" />
                    </header>

                    <div class="cards">
                        <article>
                            <img src="assets/styles/2.jpg" alt="Álex, brown hair man, 25 years old" />
                            <h2>Álex <span>25</span></h2>
                            <div class="choice nope">NOPE</div>
                            <div class="choice like">LIKE</div>
                        </article>

                        <article>
                            <img src="assets/styles/1.jpg" alt="Leila, redhead, 25 years old" />
                            <h2>Leila <span>27</span></h2>
                            <div class="choice nope">NOPE</div>
                            <div class="choice like">LIKE</div>
                        </article>

                        <span>
                            No hay más personas cerca de ti...<br />
                            Vuelve a intentarlo más tarde
                        </span>
                    </div>

                    <footer>
                        <button class="is-undo" aria-label="undo"></button>
                        <button class="is-remove is-big" aria-label="remove"></button>
                        <button class="is-star" aria-label="star"></button>
                        <button class="is-fav is-big" aria-label="fav"></button>
                        <button class="is-zap" aria-label="zap"></button>

                    </footer>
                </section>
            </main>
        </div>
        <script>
            const DECISION_THRESHOLD = 75

            let isAnimating = false
            let pullDeltaX = 0 // distance from the card being dragged

            function startDrag(event) {
                if (isAnimating)
                    return

                // get the first article element
                const actualCard = event.target.closest('article')
                if (!actualCard)
                    return

                // get initial position of mouse or finger
                const startX = event.pageX ?? event.touches[0].pageX

                // listen the mouse and touch movements
                document.addEventListener('mousemove', onMove)
                document.addEventListener('mouseup', onEnd)

                document.addEventListener('touchmove', onMove, {passive: true})
                document.addEventListener('touchend', onEnd, {passive: true})

                function onMove(event) {
                    // current position of mouse or finger
                    const currentX = event.pageX ?? event.touches[0].pageX

                    // the distance between the initial and current position
                    pullDeltaX = currentX - startX

                    // there is no distance traveled in X axis
                    if (pullDeltaX === 0)
                        return

                    // change the flag to indicate we are animating
                    isAnimating = true

                    // calculate the rotation of the card using the distance
                    const deg = pullDeltaX / 14

                    // apply the transformation to the card
                    actualCard.style.transform = `translateX(${pullDeltaX}px) rotate(${deg}deg)`

                    // change the cursor to grabbing
                    actualCard.style.cursor = 'grabbing'

                    // change opacity of the choice info
                    const opacity = Math.abs(pullDeltaX) / 100
                    const isRight = pullDeltaX > 0

                    const choiceEl = isRight
                            ? actualCard.querySelector('.choice.like')
                            : actualCard.querySelector('.choice.nope')

                    choiceEl.style.opacity = opacity
                }

                function onEnd(event) {
                    // remove the event listeners
                    document.removeEventListener('mousemove', onMove)
                    document.removeEventListener('mouseup', onEnd)

                    document.removeEventListener('touchmove', onMove)
                    document.removeEventListener('touchend', onEnd)

                    // saber si el usuario tomo una decisión
                    const decisionMade = Math.abs(pullDeltaX) >= DECISION_THRESHOLD

                    if (decisionMade) {
                        const goRight = pullDeltaX >= 0

                        // add class according to the decision
                        actualCard.classList.add(goRight ? 'go-right' : 'go-left')
                        actualCard.addEventListener('transitionend', () => {
                            actualCard.remove()
                        })
                    } else {
                        actualCard.classList.add('reset')
                        actualCard.classList.remove('go-right', 'go-left')

                        actualCard.querySelectorAll('.choice').forEach(choice => {
                            choice.style.opacity = 0
                        })
                    }

                    // reset the variables
                    actualCard.addEventListener('transitionend', () => {
                        actualCard.removeAttribute('style')
                        actualCard.classList.remove('reset')

                        pullDeltaX = 0
                        isAnimating = false
                    })

                    // reset the choice info opacity
                    actualCard
                            .querySelectorAll(".choice")
                            .forEach((el) => (el.style.opacity = 0));
                }
            }

            document.addEventListener('mousedown', startDrag)
            document.addEventListener('touchstart', startDrag, {passive: true})
        </script>
    </body>
</html>
