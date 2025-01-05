import styles from "./ContainerHome.module.css";

function ContainerHome(props) {
  return (
    <div className={`${styles.Container} ${styles[props.customClass]} || ""`}>
      {props.children}
    </div>
  );
}

export default ContainerHome;
