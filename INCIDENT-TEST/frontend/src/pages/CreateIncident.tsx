import { useState, type ChangeEvent, type FormEvent } from "react";
import { useNavigate } from "react-router-dom";

import { createIncident } from "../services/incidentService";

import styles from "../styles/form.module.css";

export default function CreateIncident() {

  const navigate = useNavigate();

  const [formData, setFormData] = useState({
    title: "",
    description: "",
    severity: "LOW",
    status: "OPEN"
  });

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

      await createIncident(formData);

      alert("Incidente criado com sucesso!");

      navigate("/incidents");

    } catch (error) {

      console.error(error);

      alert("Erro ao criar incidente");
    }
  }

  return (
    <div className={styles.container}>

      <h1 className={styles.title}>
        Criar Incidente
      </h1>

      <form onSubmit={handleSubmit}>

        <div className={styles.formGroup}>
          <label className={styles.label}>
            Título
          </label>

          <input
            type="text"
            name="title"
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
            className={styles.textarea}
            onChange={handleChange}
          />
        </div>

        <div className={styles.formGroup}>
          <label className={styles.label}>
            Severidade
          </label>

          <select
            name="severity"
            className={styles.select}
            onChange={handleChange}
          >
            <option>LOW</option>
            <option>MEDIUM</option>
            <option>HIGH</option>
            <option>CRITICAL</option>
          </select>
        </div>

        <button className={styles.button}>
          Salvar
        </button>

      </form>
    </div>
  );
}