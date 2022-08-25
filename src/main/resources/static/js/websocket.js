console.log("hihi");

const websocket = new WebSocket("ws://localhost:8080/websocket");

websocket.onopen = (evt) => {
    console.log("open event :", evt);
}

websocket.onclose = (evt) => {
    console.log("close event :", evt);
}

websocket.onerror = (error) => {
    console.log("error :", error)
}

websocket.onmessage = (msg) => {
console.log("hihi");
//    const data = JSON.parse(msg.data);
//    const {senderId, message, time, newOne, outOne} = data;
    const cont = document.getElementById("testContainer");
    const newMsg = document.createElement("div");
    console.log(msg);
    newMsg.innerHTML = msg.data;
    cont.append(newMsg);
}

const send = () => {
    const message = document.getElementById("msg").value;
    const receiverId = document.getElementById("receiver").innerHTML;

    if(message != "") {
        const msg = {
              receiverId
            , message
        };
        console.log(msg);

        if(message != null) {
        console.log(JSON.stringify(msg));
            websocket.send(JSON.stringify(msg));
        }
        document.getElementById("msg").value = "";

    }

}