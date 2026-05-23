import { useEffect, useState } from "react";
import { useParams } from "react-router-dom";

import { getIncidentById } from "../services/incidentService";

export default function IncidentDetails() {

  const { id } = useParams();

  const [incident, setIncident] = useState<any>(null);

  useEffect(() => {
    loadIncident();
  }, []);

  async function loadIncident() {
    try {
      const data = await getIncidentById(Number(id));
      setIncident(data);
    } catch (error) {
      console.error(error);
    }
  }

  if (!incident) {
    return <p>Carregando...</p>;
  }

  return (
    <div>
      <h1>{incident.title}</h1>

      <p>{incident.description}</p>

      <p>Status: {incident.status}</p>

      <p>Severity: {incident.severity}</p>
    </div>
  );
}