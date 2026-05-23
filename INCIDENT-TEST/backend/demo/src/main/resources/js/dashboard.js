// =========================================
// DASHBOARD METRICS
// =========================================

async function loadDashboardMetrics() {

    try {

        const response =
            await axios.get("/incidents");

        const incidents = response.data;

        const total =
            incidents.length;

        const open =
            incidents.filter(
                i => i.status === "ABERTO"
            ).length;

        const resolved =
            incidents.filter(
                i => i.status === "RESOLVIDO"
            ).length;

        document.getElementById("totalIncidents")
            .innerText = total;

        document.getElementById("openIncidents")
            .innerText = open;

        document.getElementById("resolvedIncidents")
            .innerText = resolved;

        generateChart(open, resolved);

    } catch (error) {

        console.error(error);

        showError(
            "Erro ao carregar dashboard."
        );

    }

}

// =========================================
// CHART
// =========================================

function generateChart(open, resolved) {

    const ctx =
        document.getElementById("incidentChart");

    new Chart(ctx, {

        type: "doughnut",

        data: {

            labels: [
                "Abertos",
                "Resolvidos"
            ],

            datasets: [{

                data: [
                    open,
                    resolved
                ]

            }]

        }

    });

}

// =========================================
// INIT
// =========================================

loadDashboardMetrics();