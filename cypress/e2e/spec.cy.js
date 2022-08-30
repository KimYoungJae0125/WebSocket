describe('Chatting Test', () => {
    it('1. 화면 접속', () => {
        cy.visit("/index");
        window.open(location.origin + "/index");
    });
    it('2. 채팅 메시지 입력', () => {
        cy.get("[data-cy='messageInput']").type("사이프레스로 채팅");
    });
    it('3. 채팅 메시지 전송', () => {
        cy.get("[data-cy='sendButton']").click();
    });
    it('4. 채팅 여러번 보내보기', () => {
        for(let i=0; i<10; i++) {
            cy.get("[data-cy='messageInput']").type(i);
            cy.get("[data-cy='sendButton']").click();
        }
    });
})