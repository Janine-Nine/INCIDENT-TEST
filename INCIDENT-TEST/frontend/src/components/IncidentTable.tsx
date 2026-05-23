import { useIncidents } from "../hooks/useIncidents";

export default function IncidentTable() {
  const { incidents, loading } = useIncidents();

  if (loading) {
    return <p>Carregando...</p>;
  }

  return (
    <table>
      <thead>
        <tr>
          <th>ID</th>
          <th>Título</th>
          <th>Status</th>
          <th>Severidade</th>
        </tr>
      </thead>

      <tbody>
        {incidents.map((incident: any) => (
          <tr key={incident.id}>
            <td>{incident.id}</td>
            <td>{incident.title}</td>
            <td>{incident.status}</td>
            <td>{incident.severity}</td>
          </tr>
        ))}
      </tbody>
    </table>
  );
}