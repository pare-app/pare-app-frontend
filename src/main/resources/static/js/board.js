$(document).ready(function(){
    var wt = new api.WhiteboardTeam('#wt-container', {
        clientId: '69aa79698730eb57bf7459889043f24f',
        boardCode: '69aa79698730eb57bf7459889043f24f_test_image',
        participant: {
            role: 'editor',
            name: $('.board-username').val()
        }
    });
    wt.getCurrentUser().then(user => console.log(user));
});