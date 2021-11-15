export function findAllDone(){
    const headers = new Headers({
        "Content-Type": "application/json",
    });
    const request = {
        method: 'GET',
        headers: headers,
        mode: 'cors',
        cache: 'default',
    };
    return fetch('http://localhost:8080/tarefa/feito', request).then(response => response.json());
}

export function findAllPending(){
    const headers = new Headers({
        "Content-Type": "application/json",
    });
    const request = {
        method: 'GET',
        headers: headers,
        mode: 'cors',
        cache: 'default',
    };
    return fetch('http://localhost:8080/tarefa/pendente', request).then(response => response.json());
}

export function updateToDone(tarefa){
    const headers = new Headers({
        "Content-Type": "application/json",
    });
    const request = {
        method: 'PATCH',
        headers: headers,
        mode: 'cors',
        cache: 'default',
        body: JSON.stringify(tarefa)
    };
    return fetch(`http://localhost:8080/tarefa/${tarefa.id}/update-to-done`, request).then(response => response.json());
}

export function updateToPending(tarefa){
    const headers = new Headers({
        "Content-Type": "application/json",
    });
    const request = {
        method: 'PATCH',
        headers: headers,
        mode: 'cors',
        cache: 'default',
        body: JSON.stringify(tarefa)
    }
    return fetch(`http://localhost:8080/tarefa/${tarefa.id}/update-to-pending`, request).then(response => response.json());
}

export function save(tarefa){
    const headers = new Headers({
        "Content-Type": "application/json",
    });
    const request = {
        method: 'POST',
        headers: headers,
        mode: 'cors',
        cache: 'default',
        body: JSON.stringify(tarefa)
    }
    return fetch(`http://localhost:8080/tarefa/tarefa`, request).then(response => response.json());
}