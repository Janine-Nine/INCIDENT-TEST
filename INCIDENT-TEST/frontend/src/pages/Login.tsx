import { useState, type FormEvent } from "react";

import styles from "../styles/form.module.css";

export default function Login() {

  const [email, setEmail] = useState("");

  const [password, setPassword] = useState("");

  function handleSubmit(
    e: FormEvent<HTMLFormElement>
  ) {

    e.preventDefault();

    console.log({
      email,
      password
    });

    alert("Login realizado!");
  }

  return (
    <div className={styles.container}>

      <h1 className={styles.title}>
        Login
      </h1>

      <form onSubmit={handleSubmit}>

        <div className={styles.formGroup}>
          <label className={styles.label}>
            Email
          </label>

          <input
            type="email"
            className={styles.input}
            onChange={(e) =>
              setEmail(e.target.value)
            }
          />
        </div>

        <div className={styles.formGroup}>
          <label className={styles.label}>
            Senha
          </label>

          <input
            type="password"
            className={styles.input}
            onChange={(e) =>
              setPassword(e.target.value)
            }
          />
        </div>

        <button className={styles.button}>
          Entrar
        </button>

      </form>
    </div>
  );
}