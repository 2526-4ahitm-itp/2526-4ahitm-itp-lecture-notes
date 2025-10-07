import { loadAllTodos } from "./features/todo/service.ts";
import "./components/todo-table"

document.querySelector<HTMLDivElement>('#app')!.innerHTML = `
  <div>
    <todo-table></todo-table>
  </div>
`
const todos = await loadAllTodos()
console.log("Todos loaded ...", todos)

