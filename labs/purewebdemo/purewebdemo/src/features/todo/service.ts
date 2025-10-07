export async function loadAllTodos() {
    // TODO: add proxy
    const response = await fetch("/api/todos")
    return await response.json()
}




