API de Cadastro de Estudantes - Spring Boot
📝 Descrição
API RESTful desenvolvida em Spring Boot para cadastro e gerenciamento de estudantes, com operações CRUD básicas. Desenvolvida como parte do processo seletivo para a vaga de estágio na Avanade (Decola Tech 2025).

🚀 Tecnologias Utilizadas
Java 17

Spring Boot 3.x

Spring Data JPA

H2 Database (banco em memória)

Maven (gerenciamento de dependências)

🔧 Funcionalidades
✅ Cadastro de estudantes (nome e matrícula)

✅ Listagem de todos os estudantes cadastrados

✅ Busca de estudante por ID

✅ Atualização de dados do estudante

✅ Exclusão de estudante

📋 Endpoints da API
Método	Endpoint	Descrição
POST	/estudantes	Cria um novo estudante
GET	/estudantes	Lista todos os estudantes
GET	/estudantes/{id}	Busca um estudante por ID
PUT	/estudantes/{id}	Atualiza os dados de um estudante
DELETE	/estudantes/{id}	Remove um estudante
📦 Estrutura do Projeto
Copy
src/
├── main/
│   ├── java/
│   │   └── me/dio/avanade_decola_tech_2025/
│   │       ├── controller/      # Controllers REST
│   │       ├── domain/          # Entidades JPA
│   │       ├── repository/      # Interfaces JpaRepository
│   │       └── AvanadeDecolaTech2025Application.java
│   └── resources/
│       ├── application.properties # Configurações
│       └── data.sql             # Dados iniciais (opcional)
