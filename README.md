# README

## Inicialização do Backend
Este é o backend da aplicação, desenvolvido em **Spring Boot**, utilizando **PostgreSQL** e **RabbitMQ**. O Docker Compose gerencia todo o ambiente automaticamente.

### **1. Pré-requisitos**
Certifique-se de ter instalado:
- [Docker](https://www.docker.com/get-started)
- [Docker Compose](https://docs.docker.com/compose/install/)

### **2. Como rodar o backend**
1. No terminal, vá até a pasta do backend:
   ```sh
   cd backend
   ```
2. Construa a imagem Docker do backend:
   ```sh
   docker build -t backend-app .
   ```
3. Suba o ambiente com Docker Compose:
   ```sh
   docker-compose up -d --build
   ```

### **3. Acessando a API**
- A API estará disponível em: `http://localhost:8080`
- O painel do RabbitMQ pode ser acessado em: `http://localhost:15672` (usuário: `guest`, senha: `guest`)

### **4. Parando o backend**
Para parar os containers:
```sh
   docker-compose down
```

### **5. Debugging e Logs**
- Para visualizar os logs do backend:
  ```sh
  docker logs -f $(docker ps -q --filter ancestor=backend-app)
  ```

