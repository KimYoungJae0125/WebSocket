describe('Chatting Test', () => {
    it('1. 화면 접속', () => {
        cy.visit("/index");
    });
    it('2. 채팅 메시지 입력', () => {
        cy.get("#msg").type("사이프레스로 채팅");
    });
    it('3. 채팅 메시지 전송', () => {
        cy.get("#sendButton").click();
    });
})