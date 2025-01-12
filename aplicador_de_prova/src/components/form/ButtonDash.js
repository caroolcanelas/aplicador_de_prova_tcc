import styles from "./ButtonDash.module.css";
import { Link } from "react-router-dom";

function ButtonDash({ to, text, icon, onClick }) {
  return (
    <button className={styles.btn} onClick={onClick}>
      <span className={styles.icon}>{icon}</span>
      {text}
    </button>
  );
}

export default ButtonDash;
