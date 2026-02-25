# Agenda
📖 Guia de Uso e Documentação
📂 Estrutura do Projeto
O projeto utiliza o padrão DAO (Data Access Object) para organizar a comunicação com o banco de dados:

Agenda.java: Ponto de entrada da aplicação (Main). Gerencia o menu interativo no terminal.

AgendaModel.java: Define a entidade Contato com atributos como nome, e-mail e telefone.

AgendaDao.java: Contém a lógica de persistência (SQL), realizando as operações de inserir e buscar no PostgreSQL.

ConnectDB.java: Gerencia a conexão JDBC com o servidor remoto (Supabase).

🛠️ Pré-requisitos
Java JDK 21 ou superior instalado.

Driver JDBC do PostgreSQL configurado no projeto.

Uma conta no Supabase com uma tabela criada.
