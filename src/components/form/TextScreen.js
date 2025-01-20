import styles from "./TextScreen.module.css";

function TextScreen({ replicatedText }) {
  return (
    <div className={styles.text}>
      <p>{replicatedText || "O texto digitado aparecerá aqui."}</p>
    </div>
  );
}

export default TextScreen;
