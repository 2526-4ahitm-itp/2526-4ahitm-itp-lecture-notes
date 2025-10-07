const tableTemplate = `
    <table>
    <thead>
      <tr>
      <th>id</th>
      <th>title</th>
      <th>completed</th>
      </tr>
    </thead>
</table>
`
class TodoTable extends HTMLElement {
    // connected callback
    connectedCallback() {
        console.log('TodoTable connected')
        this.innerHTML = tableTemplate
    }

}
customElements.define("todo-table", TodoTable)
