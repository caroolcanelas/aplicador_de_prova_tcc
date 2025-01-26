import styles from "./TextPlaceholder.module.css";

function TextPlaceholder({ placeholder, value, onChange }) {
  return (
    <div className={styles.textArea}>
      <textarea
        placeholder={placeholder}
        value={value}
        onChange={onChange}
      ></textarea>
    </div>
  );
}

export default TextPlaceholder;
