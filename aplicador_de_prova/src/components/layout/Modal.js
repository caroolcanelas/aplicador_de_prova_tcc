import React from "react";
import styles from "./Modal.module.css";

function Modal({ isOpen, onClose, children }) {
  if (!isOpen) return null; // Não renderiza o modal se ele não estiver aberto

  return (
    <div className={styles.modalOverlay}>
      <div className={styles.modalContent}>
        <button className={styles.closeButton} onClick={onClose}>
          &times;
        </button>
        {children}
      </div>
    </div>
  );
}

export default Modal;
