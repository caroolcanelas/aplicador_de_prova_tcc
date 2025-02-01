import React from "react";

//Styles
import styles from "./Modal.module.css";

//ícones
import { FaSearch } from "react-icons/fa";

//Componentes
import Input from "../form/Input";
import ButtonDash from "../form/ButtonDash";

function Modal({ isOpen, onClose, children }) {
  if (!isOpen) return null; // Não renderiza o modal se ele não estiver aberto

  return (
    <div className={styles.modalOverlay}>
      <div className={styles.modalContent}>
        <button className={styles.closeButton} onClick={onClose}>
          &times;
        </button>
        <div className={styles.modalHeader}>
          <h3>Banco de Questões</h3>
        </div>
        <div className={styles.modalPesquisa}>
          <Input
            type="text"
            name="busca"
            placeholder="Pesquisar"
            className={styles.barraPesquisa}
          ></Input>
          <ButtonDash
            customClass="pesquisa"
            to="#"
            icon={<FaSearch />}
          ></ButtonDash>
        </div>
        <p>Este é o conteúdo do modal.</p>
        {children}
      </div>
    </div>
  );
}

export default Modal;
