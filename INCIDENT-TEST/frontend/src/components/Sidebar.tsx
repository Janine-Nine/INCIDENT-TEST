import { Link, useLocation } from "react-router-dom";

export default function Sidebar() {

  const location = useLocation();

  const menu = [
    {
      name: "Dashboard",
      path: "/"
    },
    {
      name: "Incidentes",
      path: "/incidents"
    },
    {
      name: "Criar Incidente",
      path: "/incidents/new"
    },
    {
      name: "Login",
      path: "/login"
    }
  ];

  return (
    <aside
      style={{
        width: "260px",
        background: "#1e293b",
        minHeight: "100vh",
        padding: "24px"
      }}
    >

      <h2
        style={{
          marginBottom: "30px"
        }}
      >
        🚨 Incident App
      </h2>

      <nav
        style={{
          display: "flex",
          flexDirection: "column",
          gap: "12px"
        }}
      >

        {menu.map((item) => (

          <Link
            key={item.path}
            to={item.path}
            style={{
              padding: "12px",
              borderRadius: "10px",
              background:
                location.pathname === item.path
                  ? "#3b82f6"
                  : "transparent",

              color: "white",
              textDecoration: "none"
            }}
          >

            {item.name}

          </Link>
        ))}

      </nav>

    </aside>
  );
}