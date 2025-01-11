import React, { useState } from "react";

function TextPlaceholder() {
  const [inputText, setInputText] = useState("");

  return (
    <div
      style={{
        width: "100%",
        height: "100%",
        display: "flex",
        justifyContent: "center",
        alignItems: "center",
        flexDirection: "column",
        backgroundColor: "#f2f2f2",
        borderRadius: "8px",
        padding: "10px",
        boxShadow: "0 4px 6px rgba(0, 0, 0, 0.2)",
      }}
    >
      <textarea
        placeholder="Digite algo aqui..."
        value={inputText}
        onChange={(e) => setInputText(e.target.value)}
        style={{
          width: "90%",
          height: "80%",
          padding: "10px",
          borderRadius: "8px",
          border: "1px solid #ccc",
          resize: "none",
        }}
      ></textarea>
    </div>
  );
}

export default TextPlaceholder;
