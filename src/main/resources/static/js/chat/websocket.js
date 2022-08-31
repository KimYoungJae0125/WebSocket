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
    const cont = document.getElementById("testContainer");
    const createMessage = ({receiverId, sender, message, time}) => {
        const newMsg = document.createElement("div");
        newMsg.classList.add("messageContainer");
        newMsg.classList.add(sender == "나" ? "right" : "left");
        const messageHtmlArr = [];
        messageHtmlArr.push("<div>");
        const senderNames = cont.getElementsByTagName('p');
        if(senderNames.length > 0) {
            if(senderNames[senderNames.length-1].innerText != receiverId + "(" + sender + ")")
            messageHtmlArr.push("<p>" + receiverId + "(" + sender + ")</p>");
        } else {
            messageHtmlArr.push("<p>" + receiverId + "(" + sender + ")</p>");
        }
        messageHtmlArr.push("<span>" + message + "</span>")
        messageHtmlArr.push("</div>")
        messageHtmlArr.push("<span>"+formattingDate(time)+"</span>");
        newMsg.innerHTML = messageHtmlArr.join("");
        return newMsg;
    }

    cont.append(createMessage(JSON.parse(msg.data)));
}

const send = () => {
    const message = document.getElementById("msg").value;
    const receiverId = document.getElementById("receiver").innerHTML;
    const time = new Date();

    if(message != "") {
        const msg = {
              receiverId
            , message
            , time
        };
        console.log(msg);

        if(message != null) {
        console.log(JSON.stringify(msg));
            websocket.send(JSON.stringify(msg));
        }
        document.getElementById("msg").value = "";

    }
}