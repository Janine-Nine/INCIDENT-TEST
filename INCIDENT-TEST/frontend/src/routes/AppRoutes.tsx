import { BrowserRouter, Routes, Route } from "react-router-dom";

import Dashboard from "../pages/Dashboard";
import Incidents from "../pages/Incidents";
import CreateIncident from "../pages/CreateIncident";
import EditIncident from "../pages/EditIncident";
import IncidentDetails from "../pages/IncidentDetails";
import Login from "../pages/Login";
import NotFound from "../pages/NotFound";

export default function AppRoutes() {
  return (
    <BrowserRouter>
      <Routes>
        <Route path="/" element={<Dashboard />} />
        <Route path="/incidents" element={<Incidents />} />
        <Route path="/incidents/new" element={<CreateIncident />} />
        <Route path="/incidents/:id" element={<IncidentDetails />} />
        <Route path="/incidents/edit/:id" element={<EditIncident />} />
        <Route path="/login" element={<Login />} />
        <Route path="*" element={<NotFound />} />
      </Routes>
    </BrowserRouter>
  );
}