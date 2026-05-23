🚨 Incident Management System

Sistema Full Stack enterprise para gerenciamento, monitoramento e análise de incidentes em tempo real, desenvolvido com arquitetura moderna utilizando:

Frontend: React + Vite + TypeScript
Backend: Java Spring Boot
Banco de Dados: PostgreSQL
Autenticação: JWT Authentication
Deploy: Vercel + Render
Observabilidade: Logs + Monitoring + Health Checks
DevOps: Docker + CI/CD Ready
📌 Sobre o Projeto

Este projeto foi desenvolvido como desafio técnico para vaga de:

💼 Desenvolvedor(a) Full Stack — Java & React/Angular

O objetivo foi construir uma aplicação completa seguindo boas práticas de engenharia de software, incluindo:

✅ Backend RESTful
✅ Frontend responsivo
✅ Segurança com JWT
✅ Persistência de dados
✅ Monitoramento e logs
✅ Dockerização
✅ Testes automatizados
✅ Arquitetura escalável
✅ Clean Code e SOLID

📸 Preview do Sistema

Sistema inspirado em plataformas enterprise modernas como:

Jira
Datadog
PagerDuty
ServiceNow
Zendesk

Incluindo:

Dashboard Analytics
Incident Tracking
JWT Authentication
Dark Mode
Responsive UI
Logs estruturados
Segurança enterprise
🏗 Arquitetura da Aplicação
Frontend (React + Vite)
        ↓
REST API (Spring Boot)
        ↓
PostgreSQL Database
        ↓
Cloud Deploy (Render + Vercel + Neon)
🧱 Tecnologias Utilizadas
🎨 Frontend
React
Vite
TypeScript
React Router DOM
Axios
CSS Modules
Bootstrap Icons
Chart.js
SweetAlert2
⚙️ Backend
Java 17
Spring Boot 3
Spring Security
Spring Data JPA
JWT Authentication
Bean Validation
Lombok
Swagger/OpenAPI
Spring Boot Actuator
🗄 Banco de Dados
PostgreSQL
H2 Database (testes)
Neon PostgreSQL
🧪 Testes
Backend
JUnit 5
Mockito
Spring Boot Test
MockMvc
Frontend
Vitest
React Testing Library
🐳 DevOps & Deploy
Docker
Docker Compose
Render
Vercel
GitHub Actions (CI/CD Ready)
📂 Estrutura do Projeto
incident-management-system/
│
├── frontend/
│   ├── public/
│   ├── src/
│   │   ├── api/
│   │   ├── assets/
│   │   ├── components/
│   │   ├── hooks/
│   │   ├── pages/
│   │   ├── routes/
│   │   ├── services/
│   │   ├── styles/
│   │   ├── App.tsx
│   │   ├── main.tsx
│   │   └── index.css
│   │
│   ├── package.json
│   ├── vite.config.ts
│   └── tsconfig.json
│
├── backend/
│   ├── src/
│   │   ├── main/
│   │   │   ├── java/com/incidents/
│   │   │   │   ├── config/
│   │   │   │   ├── controller/
│   │   │   │   ├── dto/
│   │   │   │   ├── entity/
│   │   │   │   ├── exception/
│   │   │   │   ├── logging/
│   │   │   │   ├── monitoring/
│   │   │   │   ├── repository/
│   │   │   │   ├── security/
│   │   │   │   ├── service/
│   │   │   │   └── IncidentApplication.java
│   │   │
│   │   └── resources/
│   │       ├── static/
│   │       ├── templates/
│   │       ├── application.yml
│   │       ├── data.sql
│   │       └── logback-spring.xml
│   │
│   └── test/
│       ├── controller/
│       ├── service/
│       └── integration/
│
├── Dockerfile
├── docker-compose.yml
├── render.yaml
├── pom.xml
├── .env
└── README.md
⚙️ Funcionalidades
🔐 Authentication
JWT Authentication
Refresh Token
BCrypt Password Encryption
Rotas protegidas
Session validation
🚨 Incident Management
Criar incidente
Atualizar incidente
Excluir incidente
Buscar incidente por ID
Filtrar por severidade
Paginação
Status tracking
📊 Dashboard
Métricas em tempo real
Incidentes críticos
Analytics
Cards dinâmicos
Gráficos
Status badges
📈 Monitoramento
Health Check
Logs estruturados
Request logging
Exception logging
Spring Boot Actuator
🔒 Segurança

O sistema possui:

✅ Spring Security
✅ JWT Authentication
✅ BCrypt Encryption
✅ Request Filter
✅ Protected Routes
✅ Validation
✅ Exception Handling

📦 Principais Dependências
Spring Boot Web
<dependency>
    <groupId>org.springframework.boot</groupId>
    <artifactId>spring-boot-starter-web</artifactId>
</dependency>
Spring Security
<dependency>
    <groupId>org.springframework.boot</groupId>
    <artifactId>spring-boot-starter-security</artifactId>
</dependency>
JWT
<dependency>
    <groupId>io.jsonwebtoken</groupId>
    <artifactId>jjwt-api</artifactId>
</dependency>
PostgreSQL
<dependency>
    <groupId>org.postgresql</groupId>
    <artifactId>postgresql</artifactId>
</dependency>
🚀 Como Executar o Projeto
1️⃣ Clonar o repositório
git clone https://github.com/seu-usuario/incident-management-system.git
2️⃣ Entrar no projeto
cd incident-management-system
▶️ Executando o Frontend
Instalar dependências
cd frontend
npm install
Rodar aplicação
npm run dev

Frontend disponível em:

http://localhost:5173
▶️ Executando o Backend
Entrar na pasta backend
cd backend
Rodar aplicação
Linux/macOS
./mvnw spring-boot:run
Windows
mvn spring-boot:run

Backend disponível em:

http://localhost:8080
🐘 Configuração PostgreSQL
application.yml
spring:
  datasource:
    url: jdbc:postgresql://localhost:5432/incidents
    username: postgres
    password: postgres

  jpa:
    hibernate:
      ddl-auto: update

    show-sql: true
🐳 Docker
Subir containers
docker-compose up --build
Build manual
docker build -t incident-api .
Executar container
docker run -p 8080:8080 incident-api
🌐 URLs da Aplicação
Frontend
http://localhost:5173
Backend API
http://localhost:8080/api
Swagger
http://localhost:8080/swagger-ui/index.html
Health Check
http://localhost:8080/actuator/health
🔑 Login Padrão
{
  "username": "admin",
  "password": "admin123"
}
📡 API Endpoints
🔐 Authentication
Método	Endpoint	Descrição
POST	/api/auth/login	Login
POST	/api/auth/register	Registro
POST	/api/auth/refresh	Refresh Token
🚨 Incidents
Método	Endpoint	Descrição
GET	/api/incidents	Listar incidentes
GET	/api/incidents/{id}	Buscar incidente
POST	/api/incidents	Criar incidente
PUT	/api/incidents/{id}	Atualizar incidente
DELETE	/api/incidents/{id}	Remover incidente
📊 Exemplo de Payload
Criar Incidente
{
  "title": "Erro de autenticação",
  "description": "Usuário não consegue realizar login",
  "status": "OPEN",
  "severity": "HIGH"
}
🧪 Executando Testes
Rodar testes backend
mvn test
Gerar build completa
mvn clean install
☁️ Deploy
Frontend — Vercel

Vercel

npm run build
Backend — Render

Render

Build Command
./mvnw clean install
Start Command
java -jar target/incidents.jar
Banco de Dados — Neon PostgreSQL

Neon PostgreSQL

📈 Monitoring & Observability

Integração preparada para:

Spring Boot Actuator
Prometheus
Grafana
Structured Logs
Health Metrics
🚨 Análise de Incidente
Problema identificado

Erro recorrente de autenticação JWT causado por:

Token expirado
Header Authorization ausente
Parsing inválido do token
Solução aplicada

✅ JwtAuthenticationFilter
✅ Tratamento global de exceções
✅ Logs detalhados
✅ Respostas HTTP padronizadas
✅ Validação centralizada

🧠 Decisões Técnicas
Spring Boot

Escolhido pela produtividade, ecossistema robusto e facilidade de escalabilidade.

PostgreSQL

Banco relacional sólido e confiável para persistência enterprise.

JWT

Autenticação stateless com alta escalabilidade.

Docker

Ambiente padronizado e simplificação do deploy.

⚠️ Trade-offs
Thymeleaf vs React

Inicialmente, o projeto utilizava Thymeleaf para acelerar a entrega do teste técnico.

A arquitetura evoluiu posteriormente para React + Vite, permitindo:

maior escalabilidade
melhor experiência do usuário
componentização
melhor separação frontend/backend
🚀 Melhorias Futuras
CI/CD com GitHub Actions
Kubernetes
Redis Cache
Rate Limiting avançado
Observabilidade com Grafana
ELK Stack
OAuth2
Microservices
RabbitMQ/Kafka
Upload de anexos
WebSocket realtime
Multi-tenant
RBAC avançado
Elasticsearch
🛡️ Boas Práticas Aplicadas

✅ SOLID
✅ Clean Architecture
✅ DTO Pattern
✅ Repository Pattern
✅ Service Layer
✅ RESTful API
✅ Exception Handler
✅ Logging estruturado
✅ Segurança JWT
✅ Dockerização
✅ Responsividade
✅ Clean Code

👩‍💻 Desenvolvido por
Janine Cunha

Desenvolvedora Full Stack Java & Web

Stack Principal
Java
Spring Boot
React
TypeScript
HTML
CSS
JavaScript
PostgreSQL
Docker
APIs REST
⭐ Diferenciais do Projeto

Este projeto foi desenvolvido seguindo padrões reais de mercado:

Arquitetura escalável
Backend desacoplado
Frontend modular
Segurança enterprise
Observabilidade
Performance
Boas práticas de engenharia
Organização profissional de código
📄 Licença

Este projeto foi desenvolvido para fins educacionais, portfólio e avaliação técnica.

Licença MIT.