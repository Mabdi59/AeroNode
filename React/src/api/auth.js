import axios from 'axios';

const API_URL = 'http://localhost:8080'; // Update with your backend URL

export const login = async (username, password) => {
  const response = await axios.post(`${API_URL}/login`, { username, password });
  if (response.data.token) {
    localStorage.setItem('user', JSON.stringify(response.data));
  }
  return response.data;
};
