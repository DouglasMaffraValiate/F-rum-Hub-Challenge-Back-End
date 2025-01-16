
# Challenge Fórum Hub

Este repositório contém a solução para o Desafio Fórum Backend, que visa implementar um sistema de fórum com funcionalidades essenciais, como criação de tópicos, respostas e autenticação de usuários.



# Forum Hub - Backend API

Este repositório contém a API do Fórum Hub, desenvolvida para o Challenge ONE.

## 🚀 Tecnologias Utilizadas

- **Linguagem**: Java 21
- **Framework**: Spring Boot (versão 3.4.1)
- **Banco de Dados**: MySQL, com gerenciamento de migrações via Flyway
- **Gerenciamento de Dependências**: Maven
- **Validação e Segurança**: Spring Validation e Spring Security
- **Autenticação**: Implementada com JWT (Java Web Token)
- **Documentação**: Gerada automaticamente usando Springdoc OpenAPI

## 📦 Dependências

A configuração completa do projeto está disponível no arquivo `pom.xml`, mas aqui estão as principais dependências utilizadas:

### 1. **Spring Boot Starter Web**
- **Função**: Usado para o desenvolvimento de APIs RESTful, com suporte ao Spring MVC para criação de controladores e manipulação de requisições HTTP.

### 2. **Spring Boot Starter Data JPA**
- **Função**: Facilita a integração do Spring com o banco de dados, permitindo a utilização de JPA (Java Persistence API) para realizar operações de CRUD com a base de dados de forma simples e eficiente.

### 3. **Spring Boot Starter Validation**
- **Função**: Fornece suporte à validação de objetos, garantindo que os dados recebidos via API atendam aos critérios de validação definidos.

### 4. **Spring Boot Starter Security**
- **Função**: Implementa funcionalidades de segurança, como autenticação e autorização. Ideal para proteger endpoints da aplicação e definir perfis de usuários.

### 5. **Flyway**
- **Função**: Ferramenta para gerenciamento de migrações de banco de dados, garantindo que as alterações no esquema do banco sejam aplicadas de forma controlada e segura.

### 6. **Lombok**
- **Função**: Reduz a quantidade de código boilerplate, gerando automaticamente métodos como `getters`, `setters`, `toString`, `equals`, e `hashCode` para as classes, facilitando o desenvolvimento.

### 7. **Springdoc OpenAPI**
- **Função**: Gera automaticamente a documentação da API usando o padrão OpenAPI 3, fornecendo uma interface interativa e acessível para explorar e testar os endpoints da API.

### 8. **MySQL Connector/J**
- **Função**: Fornece o driver JDBC necessário para conectar a aplicação Java ao banco de dados MySQL, permitindo a comunicação e manipulação dos dados armazenados.

### 9. **Java JWT (JSON Web Token)**
- **Função**: Utilizado para implementar a autenticação via tokens JWT, que são utilizados para validar e identificar usuários nas requisições à API de forma segura.

### 10. **Spring Boot Starter Test**
- **Função**: Inclui ferramentas para realizar testes de unidade e integração, utilizando JUnit, Mockito, e outras bibliotecas, garantindo a qualidade e o funcionamento da aplicação.

### 11. **Spring Security Test**
- **Função**: Facilita a realização de testes de segurança, permitindo simular autenticação e autorização em um ambiente de teste para garantir que a proteção da API esteja funcionando corretamente.

## 🌱 Variáveis de Ambiente

As variáveis de ambiente são essenciais para a configuração do projeto, como banco de dados, segurança e autenticação. Para configurar corretamente o ambiente de desenvolvimento, utilize as variáveis abaixo:

# Forum Hub - API Documentation

A **API do Forum Hub** é uma plataforma RESTful desenvolvida como parte do **Challenge ONE**. Ela fornece funcionalidades como cadastro de usuários, tópicos de fórum, cursos, respostas e mais.

## 🌐 **Informações da API**

- **Título**: forum.hub API
- **Descrição**: API REST genérica para o **Fórum Hub Challenge Back End**.
- **Contato**:
  - **Nome**: Douglas Maffra
  - **E-mail**: [maffradouglasopo@gmail.com](mailto:maffradouglasopo@gmail.com)
- **Versão OpenAPI**: 3.1.0

## 🚀 **Endereço do Servidor**

- **URL**: `http://localhost:8080`
- **Descrição**: URL gerada automaticamente para o servidor.

## 📋 **Endpoints Principais**

### 1. **Atualizar Usuário**
- **Método**: `POST`
- **Rota**: `/usuarios/atualizar`
- **Tags**: `usuario-controller`
- **Descrição**: Atualiza os dados de um usuário.
- **Body de Requisição**: Necessário um objeto do tipo `UpdateUserDTO`.
- **Respostas**:
  - **200 OK**: Atualização realizada com sucesso.
- **Segurança**: Exige autenticação com Bearer Token JWT.

### 2. **Criar Tópico**
- **Método**: `POST`
- **Rota**: `/topicos/novo`
- **Tags**: `topico-controller`
- **Descrição**: Cria um novo tópico no fórum.
- **Body de Requisição**: Necessário um objeto do tipo `TopicCreationDTO`.
- **Respostas**:
  - **200 OK**: Tópico criado com sucesso.
- **Segurança**: Exige autenticação com Bearer Token JWT.

### 3. **Cadastro de Usuário (Sign Up)**
- **Método**: `POST`
- **Rota**: `/sing_up`
- **Tags**: `aplication-controller`
- **Descrição**: Realiza o cadastro de um novo usuário.
- **Body de Requisição**: Necessário um objeto do tipo `SingInDTO`.
- **Respostas**:
  - **200 OK**: Cadastro realizado com sucesso.

### 4. **Login de Usuário**
- **Método**: `POST`
- **Rota**: `/login`
- **Tags**: `aplication-controller`
- **Descrição**: Realiza o login de um usuário e retorna um token JWT.
- **Body de Requisição**: Necessário um objeto do tipo `LoginDTO`.
- **Respostas**:
  - **200 OK**: Login realizado com sucesso e token JWT gerado.

### 5. **Criar Curso**
- **Método**: `POST`
- **Rota**: `/cursos/criar`
- **Tags**: `curso-controller`
- **Descrição**: Cria um novo curso na plataforma.
- **Body de Requisição**: Necessário um objeto do tipo `CursoCreateDTO`.
- **Respostas**:
  - **200 OK**: Curso criado com sucesso.
- **Segurança**: Exige autenticação com Bearer Token JWT.

### 6. **Listar Usuários**
- **Método**: `GET`
- **Rota**: `/usuarios/listar`
- **Tags**: `usuario-controller`
- **Descrição**: Lista os usuários cadastrados na plataforma.
- **Parâmetros**: 
  - **paginacao**: Parâmetros de paginação (`page`, `size`, `sort`).
- **Respostas**:
  - **200 OK**: Lista de usuários retornada com sucesso.
- **Segurança**: Exige autenticação com Bearer Token JWT.

### 7. **Listar Tópicos**
- **Método**: `GET`
- **Rota**: `/topicos/listar`
- **Tags**: `topico-controller`
- **Descrição**: Lista os tópicos do fórum.
- **Parâmetros**: 
  - **paginacao**: Parâmetros de paginação (`page`, `size`, `sort`).
- **Respostas**:
  - **200 OK**: Lista de tópicos retornada com sucesso.
- **Segurança**: Exige autenticação com Bearer Token JWT.

### 8. **Listar Cursos**
- **Método**: `GET`
- **Rota**: `/cursos/listar`
- **Tags**: `curso-controller`
- **Descrição**: Lista os cursos disponíveis.
- **Parâmetros**:
  - **paginacao**: Parâmetros de paginação (`page`, `size`, `sort`).
- **Respostas**:
  - **200 OK**: Lista de cursos retornada com sucesso.
- **Segurança**: Exige autenticação com Bearer Token JWT.

### 9. **Deletar Usuário**
- **Método**: `DELETE`
- **Rota**: `/usuarios/delete/{id}`
- **Tags**: `usuario-controller`
- **Descrição**: Deleta um usuário pelo ID.
- **Parâmetros**: 
  - **id**: ID do usuário.
- **Respostas**:
  - **200 OK**: Usuário deletado com sucesso.
- **Segurança**: Exige autenticação com Bearer Token JWT.

### 10. **Deletar Tópico**
- **Método**: `DELETE`
- **Rota**: `/topicos/delete/{id}`
- **Tags**: `topico-controller`
- **Descrição**: Deleta um tópico pelo ID.
- **Parâmetros**: 
  - **id**: ID do tópico.
- **Respostas**:
  - **200 OK**: Tópico deletado com sucesso.
- **Segurança**: Exige autenticação com Bearer Token JWT.

### 11. **Deletar Curso**
- **Método**: `DELETE`
- **Rota**: `/cursos/delete/{id}`
- **Tags**: `curso-controller`
- **Descrição**: Deleta um curso pelo ID.
- **Parâmetros**: 
  - **id**: ID do curso.
- **Respostas**:
  - **200 OK**: Curso deletado com sucesso.
- **Segurança**: Exige autenticação com Bearer Token JWT.

---

## 🛠 **Componentes de Esquema**

Abaixo estão os esquemas de dados utilizados pela API para as operações de criação e atualização:

### `UpdateUserDTO`
- **id**: Identificador único do usuário.
- **nome**: Nome do usuário.
- **email**: E-mail do usuário.

### `TopicCreationDTO`
- **titulo**: Título do tópico.
- **mensagem**: Mensagem inicial do tópico.
- **autorId**: ID do autor do tópico.
- **cursoId**: ID do curso associado.

### `SingInDTO`
- **nome**: Nome do novo usuário.
- **email**: E-mail do novo usuário.
- **senha**: Senha do novo usuário.
- **perfil**: Perfil do usuário (Administrador, Moderador, Usuário).

### `LoginDTO`
- **email**: E-mail do usuário.
- **senha**: Senha do usuário.

### `CursoCreateDTO`
- **nome**: Nome do curso.
- **categorias**: Categorias do curso.

---

## 🔐 **Segurança**

A API utiliza **JWT (JSON Web Token)** para autenticação. Os endpoints que exigem autenticação devem ser acessados com um token válido no cabeçalho da requisição usando o esquema `Bearer`.

---

## 🛠 **Padrões de Paginamento e Ordenação**

A API suporta paginação e ordenação para listar usuários, tópicos e cursos:

- **Parâmetros de Paginação**: `page`, `size`, `sort`
- **Estrutura de Resposta**:
  - **totalPages**: Total de páginas disponíveis.
  - **totalElements**: Total de elementos.
  - **content**: Conteúdo da página atual.
  
Os parâmetros de **sort** são usados para definir a ordenação dos resultados.

---


# Forum Hub - API Documentation

A **API do Forum Hub** é uma plataforma RESTful desenvolvida como parte do **Challenge ONE**. Ela fornece funcionalidades como cadastro de usuários, tópicos de fórum, cursos, respostas e mais.

## 🌐 **Informações da API**

- **Título**: forum.hub API
- **Descrição**: API REST genérica para o **Fórum Hub Challenge Back End**.
- **Contato**:
  - **Nome**: Douglas Maffra
  - **E-mail**: [maffradouglasopo@gmail.com](mailto:maffradouglasopo@gmail.com)

## 🚀 **Endereço do Servidor**

- **URL**: `http://localhost:8080`
- **Descrição**: URL gerada automaticamente para o servidor.

## 📋 **Endpoints Principais**

### 1. **Atualizar Usuário**
- **Método**: `POST`
- **Rota**: `/usuarios/atualizar`
- **Tags**: `usuario-controller`
- **Descrição**: Atualiza os dados de um usuário.
- **Body de Requisição**: Necessário um objeto do tipo `UpdateUserDTO`.
- **Respostas**:
  - **200 OK**: Atualização realizada com sucesso.
- **Segurança**: Exige autenticação com Bearer Token JWT.

### 2. **Criar Tópico**
- **Método**: `POST`
- **Rota**: `/topicos/novo`
- **Tags**: `topico-controller`
- **Descrição**: Cria um novo tópico no fórum.
- **Body de Requisição**: Necessário um objeto do tipo `TopicCreationDTO`.
- **Respostas**:
  - **200 OK**: Tópico criado com sucesso.
- **Segurança**: Exige autenticação com Bearer Token JWT.

### 3. **Cadastro de Usuário (Sign Up)**
- **Método**: `POST`
- **Rota**: `/sing_up`
- **Tags**: `aplication-controller`
- **Descrição**: Realiza o cadastro de um novo usuário.
- **Body de Requisição**: Necessário um objeto do tipo `SingInDTO`.
- **Respostas**:
  - **200 OK**: Cadastro realizado com sucesso.

### 4. **Login de Usuário**
- **Método**: `POST`
- **Rota**: `/login`
- **Tags**: `aplication-controller`
- **Descrição**: Realiza o login de um usuário e retorna um token JWT.
- **Body de Requisição**: Necessário um objeto do tipo `LoginDTO`.
- **Respostas**:
  - **200 OK**: Login realizado com sucesso e token JWT gerado.

### 5. **Criar Curso**
- **Método**: `POST`
- **Rota**: `/cursos/criar`
- **Tags**: `curso-controller`
- **Descrição**: Cria um novo curso na plataforma.
- **Body de Requisição**: Necessário um objeto do tipo `CursoCreateDTO`.
- **Respostas**:
  - **200 OK**: Curso criado com sucesso.
- **Segurança**: Exige autenticação com Bearer Token JWT.

### 6. **Listar Usuários**
- **Método**: `GET`
- **Rota**: `/usuarios/listar`
- **Tags**: `usuario-controller`
- **Descrição**: Lista os usuários cadastrados na plataforma.
- **Parâmetros**: 
  - **paginacao**: Parâmetros de paginação (`page`, `size`, `sort`).
- **Respostas**:
  - **200 OK**: Lista de usuários retornada com sucesso.
- **Segurança**: Exige autenticação com Bearer Token JWT.

### 7. **Listar Tópicos**
- **Método**: `GET`
- **Rota**: `/topicos/listar`
- **Tags**: `topico-controller`
- **Descrição**: Lista os tópicos do fórum.
- **Parâmetros**: 
  - **paginacao**: Parâmetros de paginação (`page`, `size`, `sort`).
- **Respostas**:
  - **200 OK**: Lista de tópicos retornada com sucesso.
- **Segurança**: Exige autenticação com Bearer Token JWT.

### 8. **Listar Cursos**
- **Método**: `GET`
- **Rota**: `/cursos/listar`
- **Tags**: `curso-controller`
- **Descrição**: Lista os cursos disponíveis.
- **Parâmetros**:
  - **paginacao**: Parâmetros de paginação (`page`, `size`, `sort`).
- **Respostas**:
  - **200 OK**: Lista de cursos retornada com sucesso.
- **Segurança**: Exige autenticação com Bearer Token JWT.

### 9. **Deletar Usuário**
- **Método**: `DELETE`
- **Rota**: `/usuarios/delete/{id}`
- **Tags**: `usuario-controller`
- **Descrição**: Deleta um usuário pelo ID.
- **Parâmetros**: 
  - **id**: ID do usuário.
- **Respostas**:
  - **200 OK**: Usuário deletado com sucesso.
- **Segurança**: Exige autenticação com Bearer Token JWT.

### 10. **Deletar Tópico**
- **Método**: `DELETE`
- **Rota**: `/topicos/delete/{id}`
- **Tags**: `topico-controller`
- **Descrição**: Deleta um tópico pelo ID.
- **Parâmetros**: 
  - **id**: ID do tópico.
- **Respostas**:
  - **200 OK**: Tópico deletado com sucesso.
- **Segurança**: Exige autenticação com Bearer Token JWT.

### 11. **Deletar Curso**
- **Método**: `DELETE`
- **Rota**: `/cursos/delete/{id}`
- **Tags**: `curso-controller`
- **Descrição**: Deleta um curso pelo ID.
- **Parâmetros**: 
  - **id**: ID do curso.
- **Respostas**:
  - **200 OK**: Curso deletado com sucesso.
- **Segurança**: Exige autenticação com Bearer Token JWT.

---

## 🛠 **Componentes de Esquema**

Abaixo estão os esquemas de dados utilizados pela API para as operações de criação e atualização:

### `UpdateUserDTO`
- **id**: Identificador único do usuário.
- **nome**: Nome do usuário.
- **email**: E-mail do usuário.

### `TopicCreationDTO`
- **titulo**: Título do tópico.
- **mensagem**: Mensagem inicial do tópico.
- **autorId**: ID do autor do tópico.
- **cursoId**: ID do curso associado.

### `SingInDTO`
- **nome**: Nome do novo usuário.
- **email**: E-mail do novo usuário.
- **senha**: Senha do novo usuário.
- **perfil**: Perfil do usuário (Administrador, Moderador, Usuário).

### `LoginDTO`
- **email**: E-mail do usuário.
- **senha**: Senha do usuário.

### `CursoCreateDTO`
- **nome**: Nome do curso.
- **categorias**: Categorias do curso.

---

## 🔐 **Segurança**

A API utiliza **JWT (JSON Web Token)** para autenticação. Os endpoints que exigem autenticação devem ser acessados com um token válido no cabeçalho da requisição usando o esquema `Bearer`.

---

## 🛠 **Padrões de Paginamento e Ordenação**

A API suporta paginação e ordenação para listar usuários, tópicos e cursos:

- **Parâmetros de Paginação**: `page`, `size`, `sort`
- **Estrutura de Resposta**:
  - **totalPages**: Total de páginas disponíveis.
  - **totalElements**: Total de elementos.
  - **content**: Conteúdo da página atual.
  
Os parâmetros de **sort** são usados para definir a ordenação dos resultados.

---
