/// <reference types="cypress"/>

describe('Criando casos de testes para o site academico do inatel', ()=>{
  it('Caso de teste 1: Entrando e saíndo do site academico com sucesso', ()=>{
      cy.site()
      cy.Login()
      cy.get('#LoginStatus1').click()
      cy.get('#ctl00_lblTitulo').should('contain.text', 'Autenticação')
      //rodar mais de uma vez, às vezes da erro
  })
  it('Caso de teste 2: Testando um possível erro, ao entrar pela perfil incorreto', ()=>{
      cy.site()
      cy.get('#__tab_ctl00_Corpo_TabAcessoLogin_TabDocente').click()
      cy.get('#ctl00_Corpo_TabAcessoLogin_TabDocente_LoginUsuario_UserName').type('123')
      cy.get('#ctl00_Corpo_TabAcessoLogin_TabDocente_LoginUsuario_Password').type('123')
      cy.get('#ctl00_Corpo_TabAcessoLogin_TabDocente_LoginUsuario_RememberMe').click()
      cy.get('#ctl00_Corpo_TabAcessoLogin_TabDocente_LoginUsuario_LoginButton').click()
      
  })
  it('Caso de teste 3: Testando a funcionalidade da Tesouraria', ()=>{
      cy.site()
      cy.Login()
      cy.get('#ctl00_Corpo_HyperLink17').click()
      cy.get('#ctl00_Corpo_UCDebitos1_TodosRadioButton').click()
      cy.get('#ctl00_Corpo_UCDebitos1_vencidosRadioButton').click()
      cy.get('#ctl00_Corpo_UCDebitos1_vencerRadioButton').click()
      cy.get(':nth-child(9) > .x15').should('contain.text', '24.492.886/0001-04')
  })
  it('Caso de teste 4: Testando a funcionalidade de Notas', ()=>{
      cy.site()
      cy.Login()
      cy.get('#ctl00_Corpo_HyperLink2').click()
      cy.get('#ctl00_Corpo_UCNotas1_ImgGraficoTurma01').click()
      cy.get('#ctl00_Corpo_UCNotas1_UpdatePanel1 > #ctl00_Corpo_UCNotas1_programmaticPopup > table > tbody > :nth-child(1) > [style="width: 484px"] > #ctl00_Corpo_UCNotas1_programmaticPopupDragHandle2')
      .should('contain.text', 'Aproveitamento Acadêmico')
      cy.get('#ctl00_Corpo_UCNotas1_UpdatePanel1 > #ctl00_Corpo_UCNotas1_programmaticPopup > table > tbody > :nth-child(1) > [width="20"] > #ctl00_Corpo_UCNotas1_ImageButton3')
      .click()
      cy.get('#ctl00_Corpo_UCNotas1_ImgPlanoEnsino01 > img').click()
      cy.get('.SSA_GridLinha > :nth-child(2)').should('contain.text', 'DISCIPLINA')
  })

  it('Caso de teste 5: Testando a funcionalidade de Frequência', ()=>{
      cy.site()
      cy.Login()
      cy.get('#ctl00_Corpo_HyperLink4').click()
      cy.get(':nth-child(2) > .SSA_Informacao').should('contain.text', 'Frequência não computada')
  })
  it('Caso de teste 6: Testando a Funcionanlidade das Atividades Complementares Obrigatórias', ()=>{
      cy.site()
      cy.Login()
      cy.get('#ctl00_Corpo_HyperLink3').click()
      cy.get('#ctl00_MenuLateral_UCMenuAcademico1_HyperLink20').click()
      cy.get('#ctl00_Corpo_UCObrigatoriaAC1_gridDados_ctl09_LnkbtnDisciplina').click()
      cy.get('#ctl00_Corpo_UCObrigatoriaAC1_lblTotalHoras').should('contain.text', '80')
  })

})