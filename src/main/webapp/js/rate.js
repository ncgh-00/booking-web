const closeBtns = document.querySelectorAll('.close-btn');
const vote_conatainer = document.querySelector('.vote-conatainer');
const edit_conatainer = document.querySelector('.edit-conatainer')
const vote_forms = document.querySelectorAll('.vote-form');
const rate_hotel = document.querySelector('.rate-hotel');
const edit_rate = document.querySelector('.edit-rate');


if (rate_hotel != null) {
    rate_hotel.addEventListener('click', function () {
        vote_conatainer.classList.toggle('open')
    })
}

if (edit_rate != null) {
    edit_rate.addEventListener('click', function () {
        edit_conatainer.classList.toggle('open')
    })
}

for (const closeBtn of closeBtns) {
    closeBtn.addEventListener('click', function () {
        vote_conatainer.classList.remove('open')
        edit_conatainer.classList.remove('open')
    })
}

for (const vote_form of vote_forms) {
    vote_form.addEventListener('click', function (event) {
        event.stopPropagation()
    })
}
