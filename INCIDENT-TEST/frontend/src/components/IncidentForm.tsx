import { useState, type ChangeEvent, type FormEvent } from "react";

import styles from "../styles/form.module.css";

interface Props {

  initialData?: any;

  onSubmit: (data: any) => void;
}

export default function IncidentForm({
  initialData,
  onSubmit
}: Props) {

  const [formData, setFormData] = useState({

    title: initialData?.title || "",

    description:
      initialData?.description || "",

    severity:
      initialData?.severity || "LOW",

    status:
      initialData?.status || "OPEN"
  });

  function handleChange(
    e: ChangeEvent<HTMLInputElement | HTMLTextAreaElement | HTMLSelectElement>
  ) {

    setFormData({
      ...formData,
      [e.target.name]: e.target.value
    });
  }

  function handleSubmit(
    e: FormEvent<HTMLFormElement>
  ) {

    e.preventDefault();

    onSubmit(formData);
  }

  return (
    <form onSubmit={handleSubmit}>

      <div className={styles.formGroup}>

        <label className={styles.label}>
          Título
        </label>

        <input
          type="text"
          name="title"
          className={styles.input}
          value={formData.title}
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
          value={formData.description}
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
          value={formData.severity}
          onChange={handleChange}
        >

          <option value="LOW">
            LOW
          </option>

          <option value="MEDIUM">
            MEDIUM
          </option>

          <option value="HIGH">
            HIGH
          </option>

          <option value="CRITICAL">
            CRITICAL
          </option>

        </select>

      </div>

      <div className={styles.formGroup}>

        <label className={styles.label}>
          Status
        </label>

        <select
          name="status"
          className={styles.select}
          value={formData.status}
          onChange={handleChange}
        >

          <option value="OPEN">
            OPEN
          </option>

          <option value="IN_PROGRESS">
            IN_PROGRESS
          </option>

          <option value="CLOSED">
            CLOSED
          </option>

        </select>

      </div>

      <button className={styles.button}>
        Salvar Incidente
      </button>

    </form>
  );
}