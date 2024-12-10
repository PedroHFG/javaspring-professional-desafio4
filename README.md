# Sistema de Relatórios de Vendas e Vendedores

Este é um projeto desenvolvido para gerenciar vendas (Sale) e vendedores (Seller). O sistema inclui relatórios detalhados e sumários de vendas por vendedor, com funcionalidades robustas de filtragem de dados baseadas em datas e nomes.

## 📊 Funcionalidades

1. **Relatório de Vendas**

   - **Entradas (opcionais):**
     - Data inicial (`minDate`)
     - Data final (`maxDate`)
     - Trecho do nome do vendedor (`name`)
   - **Saída:** Listagem paginada contendo:
     - ID da venda
     - Data
     - Quantia vendida
     - Nome do vendedor

2. **Sumário de Vendas por Vendedor**
   - **Entradas (opcionais):**
     - Data inicial (`minDate`)
     - Data final (`maxDate`)
   - **Saída:** Listagem contendo:
     - Nome do vendedor
     - Soma das vendas do período informado

## 📊 Especificações

- **Datas:**
  - Se a data final (`maxDate`) não for informada, o sistema considera a data atual.
  - Se a data inicial (`minDate`) não for informada, o sistema considera 1 ano antes da data final.
- **Nome:**

  - Se o nome do vendedor não for informado, o sistema considera um texto vazio.

- **Tecnologias Utilizadas:**
  - Java
  - Spring Boot
  - Maven
  - Banco de Dados H2

## 🔍 Endpoints

### 1. Relatório de Vendas

#### Descrição:

Obtém um relatório detalhado das vendas filtradas por período e nome do vendedor (opcionais).

#### Exemplo de Uso:

1. **Últimos 12 meses (padrão)**:

   ```http
   GET /sales/report
   ```

   **Saída:**

   ```json
   {
     "content": [
       {
         "id": 1,
         "date": "2024-06-16",
         "amount": 18196.0,
         "seller": "Loki Odinson"
       },
       {
         "id": 2,
         "date": "2024-06-14",
         "amount": 4255.0,
         "seller": "Logan"
       },
       {
         "id": 3,
         "date": "2024-06-14",
         "amount": 13249.0,
         "seller": "Padme"
       },
       {
         "id": 4,
         "date": "2024-06-10",
         "amount": 20751.0,
         "seller": "Padme"
       },
       {
         "id": 5,
         "date": "2024-06-04",
         "amount": 7318.0,
         "seller": "Logan"
       },
       {
         "id": 6,
         "date": "2024-06-03",
         "amount": 15608.0,
         "seller": "Thor Odinson"
       },
       {
         "id": 7,
         "date": "2024-06-03",
         "amount": 8901.0,
         "seller": "Thor Odinson"
       },
       {
         "id": 8,
         "date": "2024-06-02",
         "amount": 13231.0,
         "seller": "Anakin"
       },
       {
         "id": 9,
         "date": "2024-05-22",
         "amount": 19372.0,
         "seller": "Loki Odinson"
       },
       {
         "id": 10,
         "date": "2024-05-18",
         "amount": 21732.0,
         "seller": "Thor Odinson"
       },
       {
         "id": 11,
         "date": "2024-05-13",
         "amount": 4864.0,
         "seller": "Logan"
       },
       {
         "id": 12,
         "date": "2024-05-06",
         "amount": 20343.0,
         "seller": "Loki Odinson"
       },
       {
         "id": 13,
         "date": "2024-05-03",
         "amount": 7362.0,
         "seller": "Logan"
       },
       {
         "id": 14,
         "date": "2024-04-28",
         "amount": 10549.0,
         "seller": "Anakin"
       },
       {
         "id": 15,
         "date": "2024-04-25",
         "amount": 13333.0,
         "seller": "Padme"
       },
       {
         "id": 16,
         "date": "2024-04-23",
         "amount": 7431.0,
         "seller": "Logan"
       },
       {
         "id": 17,
         "date": "2024-04-19",
         "amount": 21099.0,
         "seller": "Thor Odinson"
       },
       {
         "id": 18,
         "date": "2024-04-19",
         "amount": 7217.0,
         "seller": "Thor Odinson"
       },
       {
         "id": 19,
         "date": "2024-04-18",
         "amount": 10107.0,
         "seller": "Anakin"
       },
       {
         "id": 20,
         "date": "2024-04-17",
         "amount": 18174.0,
         "seller": "Padme"
       }
     ],
     "pageable": {
       "sort": {
         "empty": true,
         "sorted": false,
         "unsorted": true
       },
       "offset": 0,
       "pageNumber": 0,
       "pageSize": 20,
       "unpaged": false,
       "paged": true
     },
     "last": false,
     "totalPages": 3,
     "totalElements": 51,
     "size": 20,
     "number": 0,
     "sort": {
       "empty": true,
       "sorted": false,
       "unsorted": true
     },
     "numberOfElements": 20,
     "first": true,
     "empty": false
   }
   ```

2. **Período e vendedor especificados**:

   ```http
   GET /sales/report?minDate=2022-05-01&maxDate=2022-05-31&name=odinson
   ```

   **Saída:**

   ```json
   {
     "content": [
       {
         "id": 125,
         "date": "2022-05-22",
         "amount": 19476.0,
         "seller": "Loki Odinson"
       },
       {
         "id": 126,
         "date": "2022-05-18",
         "amount": 20530.0,
         "seller": "Thor Odinson"
       },
       {
         "id": 128,
         "date": "2022-05-06",
         "amount": 21753.0,
         "seller": "Loki Odinson"
       }
     ],
     "pageable": {
       "sort": {
         "empty": true,
         "sorted": false,
         "unsorted": true
       },
       "offset": 0,
       "pageNumber": 0,
       "pageSize": 20,
       "unpaged": false,
       "paged": true
     },
     "last": true,
     "totalPages": 1,
     "totalElements": 3,
     "size": 20,
     "number": 0,
     "sort": {
       "empty": true,
       "sorted": false,
       "unsorted": true
     },
     "numberOfElements": 3,
     "first": true,
     "empty": false
   }
   ```

### 2. Sumário de Vendas por Vendedor

#### Descrição:

Fornece um sumário das vendas agrupadas por vendedor, filtradas por período (opcional).

#### Exemplo de Uso:

1. **Últimos 12 meses (padrão):**

   ```http
   GET /sales/summary
   ```

   **Saída:**

   ```json
   [
     {
       "sellerName": "Anakin",
       "total": 110571.0
     },
     {
       "sellerName": "Logan",
       "total": 83587.0
     },
     {
       "sellerName": "Loki Odinson",
       "total": 149083.0
     },
     {
       "sellerName": "Padme",
       "total": 135902.0
     },
     {
       "sellerName": "Thor Odinson",
       "total": 146098.0
     }
   ]
   ```

2. **Período especificado:**

   ```http
   GET /sales/summary?minDate=2022-01-01&maxDate=2022-06-30
   ```

   **Saída:**

   ```json
   [
     {
       "sellerName": "Anakin",
       "total": 110571.0
     },
     {
       "sellerName": "Logan",
       "total": 83587.0
     },
     {
       "sellerName": "Loki Odinson",
       "total": 150597.0
     },
     {
       "sellerName": "Padme",
       "total": 135902.0
     },
     {
       "sellerName": "Thor Odinson",
       "total": 144896.0
     }
   ]
   ```

## 🔧 Configuração e Execução

1. Clone o repositório:

   ```bash
   git clone https://github.com/PedroHFG/javaspring-professional-desafio4.git
   ```

2. Acesse o diretório do projeto:

   ```bash
   cd javaspring-professional-desafio4
   ```

3. Execute o projeto:

   ```bash
   ./mvnw spring-boot:run
   ```

4. Acesse o H2 Console em:

   ```
   http://localhost:8080/h2-console
   ```

   **Credenciais:**

   - URL JDBC: `jdbc:h2:mem:testdb`
   - Usuário: `sa`
   - Senha: _vazia_

## 📖 Licença

Este projeto está licenciado sob a Licença MIT. Consulte o arquivo [LICENSE](LICENSE) para mais detalhes.

## 🔗 Contato

Para quaisquer dúvidas ou sugestões, entre em contato:

- **Nome:** Pedro Henrique
- **Email:** pedrohfidg@gmail.com
- **GitHub:** [PedroHFG](https://github.com/PedroHFG)
