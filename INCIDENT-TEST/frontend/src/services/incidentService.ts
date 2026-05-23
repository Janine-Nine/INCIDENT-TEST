import api from "../api/axios";

export const getIncidents = async () => {
  const response = await api.get("/incidents");
  return response.data;
};

export const getIncidentById = async (id: number) => {
  const response = await api.get(`/incidents/${id}`);
  return response.data;
};

export const createIncident = async (data: any) => {
  const response = await api.post("/incidents", data);
  return response.data;
};

export const updateIncident = async (id: number, data: any) => {
  const response = await api.put(`/incidents/${id}`, data);
  return response.data;
};

export const deleteIncident = async (id: number) => {
  const response = await api.delete(`/incidents/${id}`);
  return response.data;
};