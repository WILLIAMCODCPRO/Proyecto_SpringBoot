/**
@GetMapping("/api/profesion/{id}")
@GetMapping("/api/profesion/buscar?nombre=...")
@PostMapping("/api/profesion")
@PutMapping("/api/profesion/{id}")
@DeleteMapping("/api/profesion/{id}")
 */

//Funcion base para no repetir codigo:
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


//@GetMapping("/api/profesion/{id}")
function getById(id) {

    apiFetch(`http://localhost:8080/api/producto/${id}`)
        .then(data => {
            console.log(data);
            alert(JSON.stringify(data, null, 2));
        })
        .catch(error => alert(error));
}

//@GetMapping("/api/profesion");
function listar() {

    apiFetch(`http://localhost:8080/api/producto`)
        .then(data => {
            console.log(data);
            alert(JSON.stringify(data, null, 2));
        })
        .catch(error => alert(error));
}

//@PostMapping("/api/profesion")
function crear(nombre_producto, precio_producto,stock_producto) {

    const nuevoProducto = {
        nombre: nombre_producto,
        precio: precio_producto,
        stock: stock_producto
    };

    apiFetch("http://localhost:8080/api/producto", {
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
function actualizarPersonalizada(id,nombre_producto, precio_producto,stock_producto) {

    const datosActualizados = {
        nombre: nombre_producto,
        precio: precio_producto,
        stock: stock_producto
    };

    apiFetch(`http://localhost:8080/api/producto/${id}`, {
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

    apiFetch(`http://localhost:8080/api/producto/${id}`, {
        method: "DELETE"
    })
    .then(() => {
        alert("Eliminado correctamente");
    })
    .catch(error => alert(error));
}

