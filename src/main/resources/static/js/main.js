$(document).ready(function() {
    $('.submit_btn').click(function () {
        $(this).parents('form').get(0).submit();
    });
    $('form').keypress(function(event) {
        if (event.keyCode === 13) {
            $(this).find('.submit_btn').click()
        }
    });
});