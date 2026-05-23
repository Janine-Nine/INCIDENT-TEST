// =========================================
// GLOBAL CONFIG
// =========================================

const API_BASE_URL = "http://localhost:8080/api";

// =========================================
// GLOBAL ALERTS
// =========================================

function showSuccess(message) {

    Swal.fire({
        icon: "success",
        title: "Sucesso",
        text: message
    });

}

function showError(message) {

    Swal.fire({
        icon: "error",
        title: "Erro",
        text: message
    });

}

function showInfo(message) {

    Swal.fire({
        icon: "info",
        title: "Informação",
        text: message
    });

}

// =========================================
// LOADING
// =========================================

function showLoading() {

    Swal.fire({
        title: "Carregando...",
        allowOutsideClick: false,
        didOpen: () => {
            Swal.showLoading();
        }
    });

}

function hideLoading() {
    Swal.close();
}

// =========================================
// TOKEN
// =========================================

function getToken() {
    return localStorage.getItem("token");
}

function setToken(token) {
    localStorage.setItem("token", token);
}

function removeToken() {
    localStorage.removeItem("token");
}

// =========================================
// AXIOS CONFIG
// =========================================

axios.defaults.baseURL = API_BASE_URL;

axios.interceptors.request.use(config => {

    const token = getToken();

    if (token) {

        config.headers.Authorization = `Bearer ${token}`;

    }

    return config;

});

// =========================================
// INIT
// =========================================

console.log("🚨 Incident Management System iniciado.");