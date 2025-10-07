import type { Todo } from "../features/todo/todo.ts";

export interface Model {
    todos: Todo[]
}

export const model: Model = {
    todos: []
}
