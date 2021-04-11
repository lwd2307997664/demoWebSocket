var stompClient=null;
function sendConnected(connected) {
    $("#connect").prop("disabled",connected);
    $("#disconnect").prop("disabled",!connected);
    if(connected){
        $("#conversation").show();
        $("#chat").show();
    }else{
        $("#conversation").hide();
        $("#chat").hide();
    }
    $("#greetings").html("");
}

/**
 * 连接事件
 */
function connect() {
    if(!$("#name").val()){
        return;
    }

    var socket=new SockJS("/chat");
    stompClient=Stomp.over(socket);
    stompClient.connect({},function (frame) {
        sendConnected(true);
        stompClient.subscribe("/topic/greetings",function (greeting) {
            showGreeting(JSON.parse(greeting.body));
        });
    });
}

function disconnect() {
    if(stompClient!=null){
        stompClient.disconnect();
    }
    sendConnected(false);
}

function sendName() {
    stompClient.send("/app/hello",{},JSON.stringify({'name':$("#name").val(),'context':$("#context").val()}));
}

function showGreeting(message) {
    $("#greetings").append("<div>"+message.name+":"+message.context+"</div>");
}

$(function () {
    $("#connect").click(function() {connect();});
    $("#disconnect").click(function() {disconnect();});
    $("#send").click(function() {sendName();});

});
