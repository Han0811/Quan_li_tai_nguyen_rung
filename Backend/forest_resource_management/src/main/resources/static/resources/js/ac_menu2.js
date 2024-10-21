function onlyOne(checkbox) {
    var checkboxes = document.getElementsByName('checkboxes');
    checkboxes.forEach((item) => {
        if (item !== checkbox) item.checked = false;
    });
}