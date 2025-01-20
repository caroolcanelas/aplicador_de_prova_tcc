import styles from "./ButtonDash.module.css";

function ButtonDash({ to, text, icon, onClick }) {
  return (
    <button className={styles.btn} onClick={onClick}>
      <span className={styles.icon}>{icon}</span>
      {text}
    </button>
  );
}

export default ButtonDash;
