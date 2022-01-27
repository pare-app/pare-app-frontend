$(document).ready(function() {
    $('.login_btn').click(function () {
        let form = $(this).parents('form').get(0);
        if(form) {
            form.submit();
        }
    });
});