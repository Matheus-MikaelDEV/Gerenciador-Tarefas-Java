# 📋 Gerenciador de Tarefas

Um pequeno projeto em Java com funcionalidades de cadastro e gerenciamento de tarefas, utilizando `LocalDate`, `ChronoUnit` e estrutura de menus com `Scanner`.

---

## 🧠 Funcionalidades

- ✅ Cadastrar tarefas com nome, descrição, data limite e prioridade  
- 📅 Listar todas as tarefas cadastradas em ordem de data  
- ⚠️ Verificar tarefas vencidas e mostrar o atraso em dias  
- ⏰ Ver tarefas agendadas para o dia atual  
- 🚪 Encerrar o programa de forma segura

---

## 🛠️ Tecnologias e Conceitos

- Java 17+  
- Programação orientada a objetos  
- API de datas (`java.time.LocalDate`)  
- Ordenação com `Comparator` e `Collections.sort()`  
- Leitura de dados com `Scanner`

---

## 📁 Estrutura

```
.
├── application
│   └── Program.java       // Classe principal, interface de console
├── entities
│   └── Tasks.java         // Entidade Tarefa com atributos e lógica de atraso
```

---

## 📌 Exemplo de Uso

```bash
Menu:
1 - Cadastrar Tarefa
2 - Listar Tarefas
3 - Tarefas vencidas
4 - Tarefas do dia
5 - Sair
```

Ao cadastrar uma tarefa:
- Digite o nome, descrição, data no formato **dd/MM/yyyy** e prioridade de 1 a 5
