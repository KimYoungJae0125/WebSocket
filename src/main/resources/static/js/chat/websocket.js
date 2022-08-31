console.log("hihi");

const websocket = new WebSocket("ws://"+document.getElementById("portInfo").value+"/websocket");

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
//    const {senderId, message, time, newOne, outOne} = data;
    console.log("byebye")
    console.log("${portInfo}")
    const cont = document.getElementById("testContainer");
    const createMessage = ({receiverId, sender, message}) => {
        const newMsg = document.createElement("div");
        newMsg.classList.add(sender == "나" ? "senderChat" : "receiverChat");
        newMsg.innerHTML = receiverId + "(" + sender + ") : " + message;
        return newMsg;
    }

    cont.append(createMessage(JSON.parse(msg.data)));
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