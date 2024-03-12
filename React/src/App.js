import React from 'react';
import { BrowserRouter as Router, Route, Routes, Link } from 'react-router-dom';
import './App.css';
import AircraftsPage from './components/AircraftsPage'; // Adjust the import path based on your project structure

// Placeholder imports for other components
// import LoginPage from './components/LoginPage';
// import RegisterPage from './components/RegisterPage';

function App() {
  return (
    <Router>
      <div className="App">
        <header className="App-header">
          <nav>
            <ul>
              <li>
                <Link to="/">Home</Link>
              </li>
              <li>
                <Link to="/aircrafts">Aircrafts</Link>
              </li>
              {/* Additional navigation links can go here */}
            </ul>
          </nav>
        </header>
        <main>
          <Routes>
            <Route path="/" element={<div><h1>Welcome to the Aviation Management System</h1></div>} />
            <Route path="/aircrafts" element={<AircraftsPage />} />
            {/* Define routes for other components here */}
            {/* <Route path="/login" element={<LoginPage />} /> */}
            {/* <Route path="/register" element={<RegisterPage />} /> */}
          </Routes>
        </main>
      </div>
    </Router>
  );
}

export default App;
