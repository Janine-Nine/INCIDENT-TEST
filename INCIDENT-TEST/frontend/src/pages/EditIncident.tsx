import { useEffect, useState, type ChangeEvent, type FormEvent } from "react";
import { useNavigate, useParams } from "react-router-dom";

import {
  getIncidentById,
  updateIncident
} from "../services/incidentService";

import styles from "../styles/form.module.css";

export default function EditIncident() {

  const { id } = useParams();

  const navigate = useNavigate();

  const [formData, setFormData] = useState<any>({
    title: "",
    description: "",
    severity: "",
    status: ""
  });

  useEffect(() => {
    loadIncident();
  }, []);

  async function loadIncident() {

    const data = await getIncidentById(Number(id));

    setFormData(data);
  }

  function handleChange(
    e: ChangeEvent<HTMLInputElement | HTMLTextAreaElement | HTMLSelectElement>
  ) {

    setFormData({
      ...formData,
      [e.target.name]: e.target.value
    });
  }

  async function handleSubmit(
    e: FormEvent<HTMLFormElement>
  ) {

    e.preventDefault();

    try {

      await updateIncident(Number(id), formData);

      alert("Incidente atualizado!");

      navigate("/incidents");

    } catch (error) {

      console.error(error);
    }
  }

  return (
    <div className={styles.container}>

      <h1 className={styles.title}>
        Editar Incidente
      </h1>

      <form onSubmit={handleSubmit}>

        <div className={styles.formGroup}>
          <label className={styles.label}>
            Título
          </label>

          <input
            type="text"
            name="title"
            value={formData.title}
            className={styles.input}
            onChange={handleChange}
          />
        </div>

        <div className={styles.formGroup}>
          <label className={styles.label}>
            Descrição
          </label>

          <textarea
            name="description"
            value={formData.description}
            className={styles.textarea}
            onChange={handleChange}
          />
        </div>

        <button className={styles.button}>
          Atualizar
        </button>

      </form>
    </div>
  );
}