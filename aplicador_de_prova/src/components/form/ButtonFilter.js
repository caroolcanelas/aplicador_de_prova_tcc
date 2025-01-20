import styles from "./ButtonFilter.module.css";
import { Link } from "react-router-dom";

function ButtonFilter({ to, text, icon }) {
  return (
    <Link className={styles.btn} to={to}>
      <span className={styles.icon}>{icon}</span>
      {text}
    </Link>
  );
}

export default ButtonFilter;
