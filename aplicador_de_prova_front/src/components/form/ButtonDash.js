import styles from "./ButtonDash.module.css";

function ButtonDash({ to, text, icon, onClick, customClass }) {
  return (
    <button
      className={`${styles.btn} ${customClass ? styles[customClass] : ""}`}
      onClick={onClick}
    >
      <span className={styles.icon}>{icon}</span>
      {text}
    </button>
  );
}

export default ButtonDash;
