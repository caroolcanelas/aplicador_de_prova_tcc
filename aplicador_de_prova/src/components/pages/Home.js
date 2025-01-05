// Componentes
import ContainerHome from "../layout/ContainerHome";
import ButtonFilter from "../form/ButtonFilter";

// estilo
import styles from "../pages/Home.module.css";

// ícones
import { CgProfile } from "react-icons/cg";
import { IoIosColorPalette } from "react-icons/io";
import { IoSunnyOutline } from "react-icons/io5";
import { FaRegEye } from "react-icons/fa";
import { GiBrain } from "react-icons/gi";

function Home() {
  return (
    <div>
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
  );
}

export default Home;
