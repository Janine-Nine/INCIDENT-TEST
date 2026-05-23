import Sidebar from "../components/Sidebar";
import Navbar from "../components/Navbar";

export default function Dashboard() {
  return (
    <div className="layout">
      <Sidebar />

      <main className="content">
        <Navbar />

        <h1>Dashboard de Incidentes</h1>

        <div className="cards">
          <div className="card">Total de Incidentes</div>
          <div className="card">Críticos</div>
          <div className="card">Resolvidos</div>
        </div>
      </main>
    </div>
  );
}