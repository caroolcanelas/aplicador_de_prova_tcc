// componentes
import Input from "../form/Input";
import Button from "../form/Button";

// estilos
import styles from "./Login.module.css";

// ícones
import { BsPencil } from "react-icons/bs";

function Login() {
  return (
    <div className={styles.login_container}>
      <div className={styles.left_section}>
        <div className={styles.sistema_nome}>
          <h2>
            <span>Nome do Sistema</span>
            <span className={styles.icon}>
              <BsPencil />
            </span>
          </h2>
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
        <Button to="/home" text="Entrar" />
      </div>
    </div>
  );
}

export default Login;
