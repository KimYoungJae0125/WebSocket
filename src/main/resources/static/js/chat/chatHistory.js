const setChatHistory = (name) => {
    const value = [];
    document.querySelectorAll(".message-li").forEach(item => {
        const time = item.querySelector(".message-data > .message-data-time").textContent;
        const message = item.querySelector(".message").textContent;
        const type = item.querySelector(".message").classList[1];
        const senderId = type == "my-message" ? myId : name;

        const data = {
              time
            , message
            , senderId
        }
        value.push(data);
    })
    sessionStorage.setItem(name, JSON.stringify(value));
}

const getChatHistory = (name) => {
    const data = JSON.parse(name) {
        if(data != null) {
            data.forEach(item => {
                const {time, message, senderId} = item;

                insertMessage(senderId, time, message);

            })
        }
    }
}