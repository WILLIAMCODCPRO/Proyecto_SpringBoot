//@GetMapping("/api/profesion/{id}")
function apiFetch(url, options = {}) {

    const token = localStorage.getItem("token");

    if (!token) {
        alert("Debes iniciar sesión");
        return Promise.reject("No token");
    }

    return fetch(url, {
        ...options,
        headers: {
            "Content-Type": "application/json",
            "Authorization": "Bearer " + token,
            ...options.headers
        }
    })
    .then(response => {

        if (response.status === 401) {
            localStorage.removeItem("token");
            throw new Error("Sesión expirada");
        }

        if (!response.ok) {
            throw new Error("Error en la petición");
        }

        return response.json();
    });
}


function getById(id) {

    apiFetch(`http://localhost:8080/api/venta/${id}`)
        .then(data => {
            console.log(data);
            alert(JSON.stringify(data, null, 2));
        })
        .catch(error => alert(error));
}

//@GetMapping("/api/profesion");
function listar() {

    apiFetch(`http://localhost:8080/api/venta`)
        .then(data => {
            console.log(data);
            alert(JSON.stringify(data, null, 2));
        })
        .catch(error => alert(error));
}

//@PostMapping("/api/profesion")
function crear(total) {

    const nuevoProducto = {
        total: total,
        fecha : new Date
    };

    apiFetch("http://localhost:8080/api/venta", {
        method: "POST",
        body: JSON.stringify(nuevoProducto)
    })
    .then(data => {
        alert("Creado correctamente: \n"+JSON.stringify(data, null, 2));
        console.log(data);
    })
    .catch(error => alert(error));
}

//@PutMapping("/api/profesion/{id}")
function actualizarPersonalizada(id,total) {

    const datosActualizados = {
        total: total,
        fecha: null
    };

    apiFetch(`http://localhost:8080/api/venta/${id}`, {
        method: "PUT",
        body: JSON.stringify(datosActualizados)
    })
    .then(data => {
        alert("Actualizado correctamente\n"+JSON.stringify(data, null, 2));
        console.log(data);
    })
    .catch(error => alert(error));
}

//@DeleteMapping("/api/profesion/{id}")
function eliminar(id) {

    apiFetch(`http://localhost:8080/api/venta/${id}`, {
        method: "DELETE"
    })
    .then(() => {
        alert("Eliminado correctamente");
    })
    .catch(error => alert(error));
}