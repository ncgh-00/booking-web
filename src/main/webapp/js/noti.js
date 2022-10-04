const closeBtns = document.querySelectorAll('.close-btn');
const noti = document.querySelector('.noti');
const noti_container = document.querySelector('.noti-container')

for (const closeBtn of closeBtns) {
    closeBtn.addEventListener('click', function () {
        noti.classList.remove('open')
    })
}

noti_container.addEventListener('click', function (event) {
    event.stopPropagation()
})