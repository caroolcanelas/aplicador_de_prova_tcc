import styles from "./Button.module.css";
import { Link } from "react-router-dom";

function Button({ to, text }) {
  return (
    <Link className={styles.btn} to={to}>
      {text}
    </Link>
  );
}

export default Button;
