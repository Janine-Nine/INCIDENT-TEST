// =========================================
// LOGIN
// =========================================

async function login(event) {

    event.preventDefault();

    const username =
        document.getElementById("username").value;

    const password =
        document.getElementById("password").value;

    try {

        showLoading();

        const response = await axios.post(
            "/auth/login",
            {
                username,
                password
            }
        );

        const token = response.data.accessToken;

        setToken(token);

        hideLoading();

        showSuccess("Login realizado com sucesso!");

        setTimeout(() => {

            window.location.href = "/dashboard";

        }, 1500);

    } catch (error) {

        hideLoading();

        console.error(error);

        showError(
            "Usuário ou senha inválidos."
        );

    }

}

// =========================================
// LOGOUT
// =========================================

function logout() {

    removeToken();

    showInfo("Logout realizado.");

    setTimeout(() => {

        window.location.href = "/login";

    }, 1000);

}

// =========================================
// VERIFY AUTH
// =========================================

function verifyAuthentication() {

    const token = getToken();

    if (!token) {

        window.location.href = "/login";

    }

}

verifyAuthentication();