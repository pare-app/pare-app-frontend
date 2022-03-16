var wt = new api.WhiteboardTeam('#wt-container', {
    clientId: '69aa79698730eb57bf7459889043f24f',
    boardCode: '69aa79698730eb57bf7459889043f24f_' + $('.board-username').val(),
    participant: {
        role: 'editor',
        name: $('.board-username').val()
    }
});
wt.onReady(ctx => console.log(ctx));
wt.getCurrentUser().then(user => console.log(user));
