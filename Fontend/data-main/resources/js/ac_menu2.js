function onlyOne(checkbox) {
    const checkboxes = document.getElementsByName('checkboxes');
    checkboxes.forEach((cb) => {
        cb.checked = false;
    });
    checkbox.checked = true;

    // Thay đổi src của iframe dựa trên checkbox được tích
    const mainHtml = document.getElementById('mainHtml');
    switch (checkbox.value) {
        case "1":
            mainHtml.src = "screen_home.html";
            break;
        case "2":
            mainHtml.src = "screen_hanhchinh.html";
            break;
        case "3":
            mainHtml.src = "screen_seed.html";
            break;
        case "4":
            mainHtml.src = "screen_wood.html";
            break;
        case "5":
            mainHtml.src = "screen_animal.html";
            break;
        case "6":
            mainHtml.src = "screen_seed.html";
            break;
        case "7":
            mainHtml.src = "screen_system.html";
            break;
        default:
            mainHtml.src = "screen_home.html";
    }
}
