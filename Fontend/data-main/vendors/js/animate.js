const content1 = document.getElementById('content1');
const content2 = document.getElementById('content2');

document.getElementById('toContent2').addEventListener('click', () => {
    content1.classList.remove('visible');
    content1.classList.add('hidden');
    content2.classList.remove('hidden');
    content2.classList.add('visible');
});

document.getElementById('toContent1').addEventListener('click', () => {
    content2.classList.remove('visible');
    content2.classList.add('hidden');
    content1.classList.remove('hidden');
    content1.classList.add('visible');
});