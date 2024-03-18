#Documentação da API Beneficiario/API Beneficiario Documentation 
Esta documentaçao da API Beneficiario fornece informações sobre os endpoints disponiveis no prototipo.
- Documentação Swagger v2 - /tivia/v2/api-docs - GET
- Cadastrar um Beneficiario com Documentos - /tivia/api/beneficiario - POST JSON BODY
- Listar todos os Beneficiarios - /tivia/api/beneficiario/beneficiarios - GET
- Listar todos os Documentos de um Beneficiario - /tivia/api/beneficiario/documentos/{beneficiarioId} - GET
- Atualizar um Beneficiario - /tivia/api/beneficiario/{beneficiarioId} - PUT JSON BODY
- Remover um Beneficiario - /tivia/api/beneficiario/{beneficiarioId} - DELETE

##Pré-requisitos/Pre-Requisites
Apos download, build da aplicação em sua IDE preferida e deploy em seu Servidor local preferido, acessaremos os endereços do projeto em http://localhost:8080/tivia

##Autenticação/Auth
O software foi desenvolvido com autenticação/autorização HTTP Basic. Utilizar credenciais:
- usuario: user
- senha: user

##Respostas/Responses
	200: Success
	201: Created
	401: Unauthorized
	403: Forbidden
	404: Not Found

##Tecnologias/Technologies
- Spring Boot
- Spring Web MVC
- Spring Rest
- Spring JPA
- Spring Security
- Lombok
- Swagger
- Thymeleaf
- H2 Database

##Status
- Versão 1.0.0 concluida

##Documentação Swagger v2
Endpoint: GET /tivia/v2/api-docs

HTTP Basic auth: user/user

##Cadastrar um Beneficiario com Documentos
Endpoint: POST /tivia/api/beneficiario

HTTP Basic auth: user/user

POST JSON BODY:

```
{
  "nome": string,
  "telefone": string,
  "dataNascimento": string (format: date),
  "documentos": [
    {
      "tipoDocumento": string,
      "descricao": string
    }
  ]
}
```
##Listar todos os Beneficiarios
Endpoint: GET /tivia/api/beneficiario/beneficiarios

HTTP Basic auth: user/user

##Listar todos os Documentos de um Beneficiario
Endpoint: GET /tivia/api/beneficiario/documentos/{beneficiarioId}

HTTP Basic auth: user/user

##Atualizar um Beneficiario
Endpoint: PUT /tivia/api/beneficiario/{beneficiarioId}

HTTP Basic auth: user/user

PUT JSON BODY:

```
{
  "id": integer,
  "nome": string,
  "telefone": string,
  "dataNascimento": string (format: date)
}
```
##Remover um Beneficiario
Endpoint: DELETE /tivia/api/beneficiario/{beneficiarioId}

HTTP Basic auth: user/user

##Autor/Author
- Charles

##Licença/License
MIT License

Copyright (c) <2024>

Permission is hereby granted, free of charge, to any person obtaining a copy
of this software and associated documentation files (the "Software"), to deal
in the Software without restriction, including without limitation the rights
to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
copies of the Software, and to permit persons to whom the Software is
furnished to do so, subject to the following conditions:

The above copyright notice and this permission notice shall be included in all
copies or substantial portions of the Software.

THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE
SOFTWARE.