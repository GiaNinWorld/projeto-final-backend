# projeto-final-backend

# Autores

##  Criar Autor

**POST** `/autores`

```json
{
  "nome": "J.R.R. Tolkien"
}
```

### Exemplo de resposta

```json
{
  "id": "4b60ea70-d849-4a1f-ae44-08152f482f40",
  "nome": "J.R.R. Tolkien"
}
```

---

##  Listar Autores

**GET** `/autores`

###  Resposta:

```json
[
  {
    "id": "4b60ea70-d849-4a1f-ae44-08152f482f40",
    "nome": "J.R.R. Tolkien"
  }
]
```

---

##  Buscar Autor por ID

**GET** `/autores/{id}`

```json
{
  "id": "4b60ea70-d849-4a1f-ae44-08152f482f40",
  "nome": "J.R.R. Tolkien"
}
```

---

##  Atualizar Autor

**PUT** `/autores/{id}`

```json
{
  "nome": "John Ronald Tolkien"
}
```

---

## Deletar Autor

**DELETE** `/autores/{id}`

---

#  Genero

##  Criar Gênero

**POST** `/generos-livro`

```json
{
  "nome": "Fantasia"
}
```

---

##  Listar Gêneros

**GET** `/generos-livro`

```json
[
  {
    "id": "a0c83381-93b2-4976-820a-96d9d3161838",
    "descricao": "Fantasia"
  }
]
```

---

## Buscar Gênero por ID

**GET** `/generos-livro/{id}`

```json
{
  "id": "a0c83381-93b2-4976-820a-96d9d3161838",
  "descricao": "Fantasia"
}
```

---

##  Atualizar Gênero

**PUT** `/generos-livro/{id}`

```json
{
  "nome": "Fantasia Épica"
}
```

---

## eletar Gênero

**DELETE** `/generos-livro/{id}`

---

# Livros

##  Criar Livro

**POST** `/livros`

```json
{
  "titulo": "O Hobbit",
  "anoPublicacao": 1937,
  "autorId": "4b60ea70-d849-4a1f-ae44-08152f482f40",
  "generoId": "a0c83381-93b2-4976-820a-96d9d3161838"
}
```

---

##  Listar Livros

**GET** `/livros`

```json
[
  {
    "id": "b123fcd2-8877-4495-a2df-9938de01df02",
    "titulo": "O Hobbit",
    "anoPublicacao": 1937,
    "autorId": "4b60ea70-d849-4a1f-ae44-08152f482f40",
    "generoId": "a0c83381-93b2-4976-820a-96d9d3161838"
  }
]
```

---

##  Buscar Livro por ID

**GET** `/livros/{id}`

```json
{
  "id": "b123fcd2-8877-4495-a2df-9938de01df02",
  "titulo": "O Hobbit",
  "anoPublicacao": 1937,
  "autorId": "4b60ea70-d849-4a1f-ae44-08152f482f40",
  "generoId": "a0c83381-93b2-4976-820a-96d9d3161838"
}
```

---

##  Atualizar Livro

**PUT** `/livros/{id}`

```json
{
  "titulo": "O Hobbit – Edição Revisada",
  "anoPublicacao": 1937,
  "autorId": "4b60ea70-d849-4a1f-ae44-08152f482f40",
  "generoId": "a0c83381-93b2-4976-820a-96d9d3161838"
}
```

---

##  Deletar Livro

**DELETE** `/livros/{id}`

---
