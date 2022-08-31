const getNow = () => {
    const now = new Date();
    return now.getFullYear() + "-" + (now.getMonth()+1) + "-" + now.getDate() + " " + now.getHours() + ":" + now.getMinutes();
}
const formattingDate = (date) => date[0] + "-" + date[1] + "-" + date[2] + " " + date[3] + ":" + date[4];