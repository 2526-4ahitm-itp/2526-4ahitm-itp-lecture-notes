import { model } from "../model"
import { loadAllTodos } from "../features/todo/service.ts";
import type { Todo } from "../features/todo/todo.ts";


const tableTemplate = `
    <table>
    <thead>
      <tr>
      <th>id</th>
      <th>title</th>
      <th>completed</th>
      </tr>
    </thead>
    <tbody></tbody>
</table>
`
const todoTemplate = (todo: Todo) => `
  <td>${todo.id}</td>
  <td>${todo.title}</td>
  <td>${todo.completed}</td>
`

class TodoTable extends HTMLElement {
    // connected callback
    async connectedCallback() {
        console.log('TodoTable connected')
        this.innerHTML = tableTemplate
        model.todos = await loadAllTodos()
        const tbody = this.querySelector("tbody")!
        model.todos.forEach(todo => {
            const row = tbody.insertRow()
            row.onclick = () => alert(`clicked ${todo.title}`)
            row.innerHTML = todoTemplate(todo)
        })
        console.log("Todos loaded ...", model.todos)
    }

}

customElements.define("todo-table", TodoTable)
