const add = document.getElementById("ad")
const list = document.getElementById("task")
const doneButton = document.getElementById("done")
let todo = document.getElementById("newTodo")

add.onclick = function () {
    if(todo.value.length === 0){
        return
    }
    list.innerHTML += `
                   <li class="t"> ${todo.value}</li>    
                   <button class = "done" id = "done">Done</button>
                `
}

//another realization
    // const newTodo = document.createElement("li")
    // newTodo.textContent = todo.value
    // list.append(newTodo)
