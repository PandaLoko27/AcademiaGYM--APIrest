## [EM DESENVOLVIMENTO]

# Academia API

API RESTful para gerenciamento de academia de ginástica.

## Tecnologias
- Spring Boot
- Spring Data JPA
- Maven
- H2 Database

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

## Como executar
1. Instale o Maven e o Java 17+
2. Execute `mvn spring-boot:run` na raiz do projeto

## Configuração
- O banco H2 é usado para testes locais (application.properties)

## Customização
Adicione endpoints, regras de negócio e integrações conforme necessário.
