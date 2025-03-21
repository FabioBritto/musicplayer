# 🎵 MusicPlayer - Web App com Servlets e JSP  

## 📌 Descrição  
O **MusicPlayer** é um sistema web desenvolvido com **Java EE (Servlets, JSP e JDBC puro)** para gerenciar usuários, playlists e músicas. O projeto foi desenvolvido de acordo com as aulas do Professor Isidro. O material está na íntegra no seu canal no Youtube (https://www.youtube.com/playlist?list=PLjcmNukBom6_5C4NrQ3Enpg37wP7fKqvJ). A aplicação permite:  

✔ Cadastro de usuários  
✔ Criação e gerenciamento de playlists  
✔ Upload e associação de músicas às playlists  

## 🎯 Propósito do Projeto

Atualmente, utilizo tecnologias modernas e amplamente adotadas no mercado, como Spring Boot e JPA/Hibernate. No entanto, este projeto foi um estudo aprofundado para compreender os fundamentos do desenvolvimento web sem o uso de frameworks que abstraem grande parte da complexidade.

O foco foi reforçar conceitos essenciais, como ciclo de vida das requisições HTTP, manipulação direta do banco de dados via JDBC e gerenciamento manual das dependências do servidor. Além disso, implementei o controle de sessão de usuário, garantindo que cada requisição estivesse associada ao usuário correto, restringindo acessos e personalizando a experiência do sistema.

Esse conhecimento mais "baixo nível" me proporciona uma base sólida para o uso de ferramentas modernas. Para isso, trabalhei diretamente com Servlets, JSP e JDBC, lidando manualmente com a estrutura das requisições, a exibição das páginas e a persistência dos dados. 

💡 **Observação**: O foco deste projeto foi o backend e a estrutura da aplicação. O frontend utilizado foi **apenas o necessário para a aplicação funcionar**, sem preocupação estética.  

---

## 🛠 Tecnologias Utilizadas  

- **Java 21** - Linguagem principal  
- **Apache Tomcat 9.0** - Servidor de aplicação  
- **JDBC Puro** - Acesso ao banco de dados sem frameworks ORM  
- **Servlets & JSP** - Controle e renderização da aplicação WEB
- **Taglib JSP** - Utilização de expressões Java em páginas HTML  
- **DAO (Data Access Object)** - Design Pattern utilizado para abstração da camada de persistência  
- **Classe DataSource** - Classe dedicada ao gerenciamento da conexão com o Banco de Dados
- **JavaScript** - Utilizado na camada de visualização  

---

## 🎯 Arquitetura e Implementação  

### 📂 **Camada de Modelo (Model)**  
As principais classes de domínio são:  

- **`Usuario`** → Representa um usuário do sistema  
- **`Playlist`** → Modela uma coleção de músicas criadas pelo usuário  
- **`Musica`** → Representa uma música, incluindo dados como seu título, artista, estilo, etc.
  - **`Estilo`** → Enum criado para definir os estilos musicais suportados  

### 🔄 **Persistência de Dados (DAO e DataSource)**  
A persistência é gerenciada por classes DAO específicas para cada entidade. A conexão com o banco de dados é inicializada através da **classe DataSource**, que fornece o método `getConnection()` para reutilizar conexões abertas pelo JDBC.  

### 🌐 **Camada de Controle (Servlets)**  
Os **Servlets** atuam como Controllers, lidando com requisições HTTP e encaminhando como resposta, páginas JSP apropriadas.  

- **`doGet`** → Manipula requisições de leitura e exibição de dados.  
- **`doPost`** → Processa requisições que envolvem envio de formulários e alterações no banco de dados.  

Em caso de sucesso, o **RequestDispatcher** direciona para a página JSP correspondente. Em caso de erro, a aplicação redireciona para uma **JSP de erro**, garantindo um fluxo adequado ao usuário.  

```java
RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/exemploDeRedirecionamento.jsp");
dispatcher.forward(request, response);
```

### 🖥 Camada de Visualização (JSP + Taglibs + JavaScript)
As páginas JSP utilizam Taglibs para embutir código Java no HTML, permitindo a exibição dinâmica de informações. Além disso, JavaScript foi utilizado para interações básicas na interface.


## 📬 Contato
📧 E-mail: fabio.tritono@gmail.com
🐙 LinkedIn: linkedin.com/in/fabio-britto-399223252
