// ***********************************************
// This example commands.js shows you how to
// create various custom commands and overwrite
// existing commands.
//
// For more comprehensive examples of custom
// commands please read more here:
// https://on.cypress.io/custom-commands
// ***********************************************
//
//
// -- This is a parent command --
// Cypress.Commands.add('login', (email, password) => { ... })
//
//
// -- This is a child command --
// Cypress.Commands.add('drag', { prevSubject: 'element'}, (subject, options) => { ... })
//
//
// -- This is a dual command --
// Cypress.Commands.add('dismiss', { prevSubject: 'optional'}, (subject, options) => { ... })
//
//
// -- This will overwrite an existing command --
// Cypress.Commands.overwrite('visit', (originalFn, url, options) => { ... })

Cypress.Commands.add('site', ()=>{
    cy.visit('https://siteseguro.inatel.br/PortalAcademico/WebLogin.aspx?ReturnUrl=%2fPortalAcademico%2fDefault.aspx')
} )
Cypress.Commands.add('Login', ()=>{
        cy.get('#ctl00_Corpo_TabAcessoLogin_TabAluno_LogOn_dropSubCurso').select('zzzzzzzzzzz') // TROCAR pelo seu curso
        cy.get('#ctl00_Corpo_TabAcessoLogin_TabAluno_LogOn_tbMatricula').type('YYY') // trocar YYY pela sua matricula de ALUNO
        cy.get('#ctl00_Corpo_TabAcessoLogin_TabAluno_LogOn_Password').type('ZZZZZ') // trocar o zzzz pela sua senha academica
        cy.get('#ctl00_Corpo_TabAcessoLogin_TabAluno_LogOn_LoginButton').click()
})