import { BrowserRouter as Router, Routes, Route, Link } from "react-router-dom";

import Home from "./components/pages/Home";
import Login from "./components/pages/Login";

import Container from "./components/layout/Container";

function App() {
  return (
    <Router>
      <Container customClass="minHeight">
        <Routes>
          <Route path="/" element={<Login />} />
          <Route path="/home" element={<Home />} />
        </Routes>
      </Container>
    </Router>
  );
}

export default App;
