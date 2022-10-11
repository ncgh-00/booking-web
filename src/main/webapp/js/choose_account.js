const closeBtns = document.querySelectorAll('.close-btn');
const noti = document.querySelector('.noti');
const notify = document.querySelector('.notify')
const noti_container = document.querySelector('.noti-container');
const choose_account = document.querySelector('.show-choose-account');

choose_account.addEventListener('click', function (){
    noti.classList.toggle('open')
})
for (const closeBtn of closeBtns) {
    closeBtn.addEventListener('click', function () {
        noti.classList.remove('open')
        notify.classList.remove('open')
    })
}

noti_container.addEventListener('click', function (event) {
    event.stopPropagation()
})