import axios from 'axios';

const API_URL = 'http://localhost:9000/api/aircrafts';

// Configure Axios (optional)
// You might want to configure axios globally if you have repetitive settings like base URLs or headers.
axios.defaults.baseURL = 'http://localhost:9000';

const getAllAircrafts = async () => {
  try {
    const response = await axios.get(API_URL);
    return response.data;
  } catch (error) {
    // Error handling here if needed
    throw error;
  }
};

const getAircraftById = async (id) => {
  try {
    const response = await axios.get(`${API_URL}/${id}`);
    return response.data;
  } catch (error) {
    // Error handling here if needed
    throw error;
  }
};

const addAircraft = async (aircraft) => {
  try {
    const response = await axios.post(API_URL, aircraft);
    return response.data;
  } catch (error) {
    // Error handling here if needed
    throw error;
  }
};

const updateAircraft = async (id, aircraft) => {
  try {
    const response = await axios.put(`${API_URL}/${id}`, aircraft);
    return response.data;
  } catch (error) {
    // Error handling here if needed
    throw error;
  }
};

const deleteAircraft = async (id) => {
  try {
    const response = await axios.delete(`${API_URL}/${id}`);
    return response.data;
  } catch (error) {
    // Error handling here if needed
    throw error;
  }
};

const AircraftService = {
    getAllAircrafts,
    getAircraftById,
    addAircraft,
    updateAircraft,
    deleteAircraft,
  };
  
  export default AircraftService;
