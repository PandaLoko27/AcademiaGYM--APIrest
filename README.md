## [EM DESENVOLVIMENTO]

API RESTful para gerenciamento de uma academia de ginástica, desenvolvida com Spring Boot, Spring Data JPA e Maven.

## Estrutura do Projeto

```
c:\GarotoDePrograma UwU\Academia--API\
├── src\
│   ├── main\
│   │   ├── java\
│   │   │   └── com\
│   │   │       └── academia\
│   │   │           ├── model\
│   │   │           │   ├── Aluno.java
│   │   │           │   ├── Instrutor.java
│   │   │           │   ├── Plano.java
│   │   │           │   └── Treino.java
│   │   │           ├── repository\
│   │   │           │   ├── AlunoRepository.java
│   │   │           │   ├── InstrutorRepository.java
│   │   │           │   ├── PlanoRepository.java
│   │   │           │   └── TreinoRepository.java
│   │   │           ├── controller\
│   │   │           │   ├── AlunoController.java
│   │   │           │   ├── InstrutorController.java
│   │   │           │   ├── PlanoController.java
│   │   │           │   └── TreinoController.java
│   │   │           └── AcademiaApiApplication.java
│   │   └── resources\
│   │       ├── application.properties
│   │       └── ...
│   └── test\
│       └── java\
│           └── ...
├── pom.xml
└── README.md
```

## Tecnologias Utilizadas
- Java 17+
- Spring Boot
- Spring Data JPA
- Maven
- Banco de dados relacional (ex: H2, PostgreSQL)

## Como executar

1. Clone o repositório
2. Configure o banco de dados em `src/main/resources/application.properties`
3. Execute o projeto com `mvn spring-boot:run`

## Endpoints principais
- `/alunos` - CRUD de alunos
- `/instrutores` - CRUD de instrutores
- `/planos` - CRUD de planos
- `/treinos` - CRUD de treinos

# Feito por Otávio Guedes com ☕ e 🍃
