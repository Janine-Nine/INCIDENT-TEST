// =========================================
// LOAD INCIDENTS
// =========================================

async function loadIncidents() {

    try {

        const response =
            await axios.get("/incidents");

        const incidents = response.data;

        const tableBody =
            document.getElementById("incidentTableBody");

        tableBody.innerHTML = "";

        incidents.forEach(incident => {

            tableBody.innerHTML += `
                <tr>

                    <td>${incident.id}</td>
                    <td>${incident.title}</td>
                    <td>${incident.status}</td>

                    <td>

                        <button
                            class="btn btn-primary"
                            onclick="editIncident(${incident.id})">

                            Editar

                        </button>

                        <button
                            class="btn btn-danger"
                            onclick="deleteIncident(${incident.id})">

                            Excluir

                        </button>

                    </td>

                </tr>
            `;

        });

    } catch (error) {

        console.error(error);

        showError(
            "Erro ao carregar incidentes."
        );

    }

}

// =========================================
// CREATE INCIDENT
// =========================================

async function createIncident() {

    const title =
        document.getElementById("title").value;

    const description =
        document.getElementById("description").value;

    const status =
        document.getElementById("status").value;

    try {

        await axios.post("/incidents", {

            title,
            description,
            status

        });

        showSuccess(
            "Incidente criado com sucesso!"
        );

        loadIncidents();

    } catch (error) {

        console.error(error);

        showError(
            "Erro ao criar incidente."
        );

    }

}

// =========================================
// DELETE INCIDENT
// =========================================

async function deleteIncident(id) {

    const result = await Swal.fire({

        title: "Deseja excluir?",
        text: "Essa ação não poderá ser desfeita.",
        icon: "warning",

        showCancelButton: true,

        confirmButtonText: "Sim",
        cancelButtonText: "Cancelar"

    });

    if (!result.isConfirmed) {
        return;
    }

    try {

        await axios.delete(`/incidents/${id}`);

        showSuccess(
            "Incidente removido."
        );

        loadIncidents();

    } catch (error) {

        console.error(error);

        showError(
            "Erro ao excluir incidente."
        );

    }

}

// =========================================
// EDIT INCIDENT
// =========================================

function editIncident(id) {

    showInfo(
        `Editar incidente ${id}`
    );

}

// =========================================
// INIT
// =========================================

loadIncidents();