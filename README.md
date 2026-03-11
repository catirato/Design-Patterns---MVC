## CESAE Resort - Hotel Tematico da Programacao

Aplicacao de consola desenvolvida em Java no ambito do modulo de Algoritmia e Programacao do CESAE, com implementacao baseada no padrao MVC. O projeto simula a gestao de um resort tematico, recorrendo a ficheiros CSV como fonte de dados para quartos, tipologias, experiencias, clientes, reservas, vendas e utilizadores.

O sistema foi organizado em `Models`, `Views`, `Controllers` e `Repositories`, separando a logica de negocio, a interface em consola e o acesso aos dados. Esta estrutura torna a aplicacao mais clara, modular e facil de manter, ao mesmo tempo que demonstra a aplicacao pratica do padrao Model-View-Controller.

Atualmente, a app permite:

- efetuar autenticacao por perfil;
- entrar como `ADMIN`, `GESTAO` ou `GUIA`;
- aceder a uma area publica de cliente;
- consultar quartos disponiveis;
- registar reservas de experiencias para adultos e criancas;
- consultar receitas mensais com base em reservas e vendas;
- visualizar o historico de experiencias associado a cada guia.

Algumas funcionalidades encontram-se ainda em desenvolvimento, mas a base principal da aplicacao ja demonstra o fluxo completo entre carregamento de dados, autenticacao, navegacao por perfis e execucao de operacoes especificas por tipo de utilizador.
