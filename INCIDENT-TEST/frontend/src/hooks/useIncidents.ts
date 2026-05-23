import { useEffect, useState } from "react";
import { getIncidents } from "../services/incidentService";

export function useIncidents() {
  const [incidents, setIncidents] = useState([]);
  const [loading, setLoading] = useState(true);

  useEffect(() => {
    loadIncidents();
  }, []);

  async function loadIncidents() {
    try {
      const data = await getIncidents();
      setIncidents(data);
    } catch (error) {
      console.error(error);
    } finally {
      setLoading(false);
    }
  }

  return {
    incidents,
    loading,
    loadIncidents
  };
}