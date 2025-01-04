import Input from "../form/Input";
import styles from "./Login.module.css";

function Login() {
  return (
    <div className={styles.login_container}>
      <div className={styles.left_section}>
        <div className={styles.sistema_nome}>
          <h2>Nome do Sistema</h2>
        </div>
      </div>

      <div className={styles.right_section}>
        <div className={styles.login_message}>
          <h2>Faça login para acessar</h2>
        </div>

        <div className={styles.login_inputs}>
          <Input type="text" text="Email" name="email" placeholder="Email" />
          <Input
            type="password"
            text="Senha"
            name="senha"
            placeholder="Senha"
          />
        </div>
      </div>
    </div>
  );
}

export default Login;
