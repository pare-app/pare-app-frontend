
$('#question-image-modal').modal('show');
var boardId =  $('.session-id').val() + '-' + $('.question-id').val();

var wt = new api.WhiteboardTeam('#wt-container', {
    clientId: '69aa79698730eb57bf7459889043f24f',
    boardCode: '69aa79698730eb57bf7459889043f24f' + boardId,
    participant: {
        role: 'editor',
        name: $('.user-username').val()
    }
});
wt.onReady(ctx => console.log(ctx));
wt.getCurrentUser().then(user => console.log(user));