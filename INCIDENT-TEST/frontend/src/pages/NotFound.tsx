import { Link } from "react-router-dom";

export default function NotFound() {

  return (
    <div
      style={{
        display: "flex",
        height: "100vh",
        justifyContent: "center",
        alignItems: "center",
        flexDirection: "column",
        gap: "20px"
      }}
    >

      <h1>404</h1>

      <p>Página não encontrada</p>

      <Link to="/">
        Voltar ao Dashboard
      </Link>

    </div>
  );
}