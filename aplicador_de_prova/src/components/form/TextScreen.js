import React, { useState } from "react";
import styles from "./TextScreen.module.css";

function TextScreen({ replicatedText }) {
  return (
    <div>
      <p>{replicatedText || "O texto digitado aparecerá aqui."}</p>
    </div>
  );
}

export default TextScreen;
