const closeBtns = document.querySelectorAll('.close-btn');
const vote_conatainer = document.querySelector('.vote-conatainer');
const vote_form = document.querySelector('.vote-form');
const rate_hotel = document.querySelector('.rate-hotel');

rate_hotel.addEventListener('click', function (){
    vote_conatainer.classList.toggle('open')
})
for (const closeBtn of closeBtns) {
    closeBtn.addEventListener('click', function () {
        vote_conatainer.classList.remove('open')
    })
}

vote_form.addEventListener('click', function (event) {
    event.stopPropagation()
})