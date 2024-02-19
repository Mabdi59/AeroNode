import React from 'react';
import { BrowserRouter as Router, Routes, Route } from 'react-router-dom';
// Import only one component initially
import Header from './components/Header';

function App() {
  return (
    <Router>
      <Header />
      {/* Temporarily remove other components */}
    </Router>
  );
}

export default App;
