import { Link } from "react-router-dom";

export default function Navbar() {

  return (
    <header
      style={{
        display: "flex",
        justifyContent: "space-between",
        alignItems: "center",
        background: "#1e293b",
        padding: "16px 24px",
        borderRadius: "12px",
        marginBottom: "24px"
      }}
    >

      <h2>Incident Manager</h2>

      <nav
        style={{
          display: "flex",
          gap: "20px"
        }}
      >

        <Link to="/">
          Dashboard
        </Link>

        <Link to="/incidents">
          Incidentes
        </Link>

        <Link to="/incidents/new">
          Novo
        </Link>

      </nav>

    </header>
  );
}