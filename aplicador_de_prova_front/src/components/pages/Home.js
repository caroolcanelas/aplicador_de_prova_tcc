import React, { useState } from "react";

// Componentes
import ContainerHome from "../layout/ContainerHome";
import ButtonFilter from "../form/ButtonFilter";
import TextScreen from "../form/TextScreen";
import TextPlaceholder from "../form/TextPlaceholder";
import ButtonDash from "../form/ButtonDash";
import Modal from "../layout/Modal";

// estilo
import styles from "../pages/Home.module.css";

// ícones
import { CgProfile } from "react-icons/cg";
import { IoIosColorPalette } from "react-icons/io";
import { IoSunnyOutline } from "react-icons/io5";
import { FaRegEye } from "react-icons/fa";
import { GiBrain } from "react-icons/gi";
import { FaPlus } from "react-icons/fa";
import { FaSearch } from "react-icons/fa";
import { IoIosSave } from "react-icons/io";

function Home() {
  const [inputText, setInputText] = useState(""); // Texto atual digitado
  const [replicatedText, setReplicatedText] = useState(""); // Texto mostrado no TextScreen
  const [typingTimeout, setTypingTimeout] = useState(null); // Timeout para debounce

  // Estados do modal
  const [isModalOpen, setIsModalOpen] = useState(false);

  const handleInputChange = (e) => {
    const value = e.target.value;
    setInputText(value);

    // Limpa o timeout anterior
    if (typingTimeout) {
      clearTimeout(typingTimeout);
    }

    // Define um novo timeout
    setTypingTimeout(
      setTimeout(() => {
        setReplicatedText(value); // Atualiza o texto apenas após o debounce
      }, 500) // Tempo de espera (500ms)
    );
  };

  return (
    <div className={styles.container}>
      <div className={styles.leftSection}>
        <ContainerHome customClass="user_info">
          <div>
            <span className={styles.profile_img}>
              <CgProfile />
            </span>
          </div>
          <div className={styles.profile_info}>
            <h4>Nome</h4>
            <p>Carolina Canelas Gomes</p>
            <h4>Email</h4>
            <p>caroolcanelas@gmail.com</p>
            <h4>Curso</h4>
            <p>Sistemas de informação</p>
            <h4>Disciplinas</h4>
            <p>Trabalho Final</p>
          </div>
        </ContainerHome>

        <ContainerHome customClass="filters">
          <div className={styles.filter_column}>
            <h4>Filtros de acessibilidade</h4>
            <ButtonFilter
              to="#"
              text="Daltonismo"
              icon={<IoIosColorPalette />}
            ></ButtonFilter>
            <ButtonFilter
              to="#"
              text="Autismo"
              icon={<IoSunnyOutline />}
            ></ButtonFilter>
            <ButtonFilter
              to="#"
              text="Baixa Visão"
              icon={<FaRegEye />}
            ></ButtonFilter>
            <ButtonFilter
              to="#"
              text="Dislexia"
              icon={<GiBrain />}
            ></ButtonFilter>
          </div>
        </ContainerHome>
      </div>
      <div className={styles.rightSection}>
        <ContainerHome customClass="textScreen">
          <div className={styles.replicatedText}>
            <h4>Preview da Prova</h4>
            <TextScreen replicatedText={replicatedText} />
          </div>
        </ContainerHome>
        <ContainerHome customClass="placeholderContainer">
          <div className={styles.dashboard}>
            <h4>Dashboard da Prova</h4>
            <TextPlaceholder
              placeholder="Digite algo aqui..."
              value={inputText}
              onChange={handleInputChange}
            ></TextPlaceholder>
          </div>
          <div className={styles.botoesDash}>
            <ButtonDash to="#" text="Nova Prova" icon={<FaPlus />}></ButtonDash>
            <ButtonDash
              to="#"
              text="Banco de Questões"
              icon={<FaSearch />}
              onClick={() => setIsModalOpen(true)}
            ></ButtonDash>
            <ButtonDash to="#" text="Salvar" icon={<IoIosSave />}></ButtonDash>
          </div>
        </ContainerHome>
      </div>

      {/* Modal */}
      <Modal isOpen={isModalOpen} onClose={() => setIsModalOpen(false)}>
        <h3>Banco de Questões</h3>
        <p>Este é o conteúdo do modal.</p>
      </Modal>
    </div>
  );
}

export default Home;
