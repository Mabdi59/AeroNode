import React, { useState, useEffect } from 'react';
import AircraftService from '../services/AircraftService';

const AircraftsPage = () => {
  const [aircrafts, setAircrafts] = useState([]);
  const [loading, setLoading] = useState(true);
  const [newAircraft, setNewAircraft] = useState({ name: '', type: '' }); // For adding new aircraft

  useEffect(() => {
    fetchAircrafts();
  }, []);

  const fetchAircrafts = async () => {
    setLoading(true);
    try {
      const response = await AircraftService.getAllAircrafts();
      setAircrafts(response.data);
    } catch (error) {
      console.error("Failed to fetch aircrafts:", error);
    }
    setLoading(false);
  };
  const handleAddAircraft = async (e) => {
    e.preventDefault();
    try {
      await AircraftService.addAircraft(newAircraft);
      setNewAircraft({ name: '', type: '' }); // Reset form
      fetchAircrafts(); // Refresh list
    } catch (error) {
      console.error("Failed to add aircraft:", error);
    }
  };

  const handleInputChange = (e) => {
    const { name, value } = e.target;
    setNewAircraft({ ...newAircraft, [name]: value });
  };
  const handleDeleteAircraft = async (id) => {
    if (window.confirm('Are you sure you want to delete this aircraft?')) {
      try {
        await AircraftService.deleteAircraft(id);
        fetchAircrafts(); // Refresh list after deletion
      } catch (error) {
        console.error("Failed to delete aircraft:", error);
      }
    }
  };
  if (loading) return <div>Loading aircrafts...</div>;

  return (
    <div>
      <h2>Aircrafts</h2>
      <form onSubmit={handleAddAircraft}>
        <input
          type="text"
          placeholder="Name"
          name="name"
          value={newAircraft.name}
          onChange={handleInputChange}
          required
        />
        <input
          type="text"
          placeholder="Type"
          name="type"
          value={newAircraft.type}
          onChange={handleInputChange}
          required
        />
        <button type="submit">Add Aircraft</button>
      </form>

      <ul>
        {aircrafts.map((aircraft) => (
          <li key={aircraft.aircraftID}>
            {aircraft.name} - {aircraft.type}
            <button onClick={() => handleDeleteAircraft(aircraft.aircraftID)}>Delete</button>
          </li>
        ))}
      </ul>
    </div>
  );
};

export default AircraftsPage;
