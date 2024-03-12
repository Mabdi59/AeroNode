import axios from 'axios';

const API_BASE_URL = 'http://localhost:9000'; 

const login = (username, password) => {
  return axios.post(`${API_BASE_URL}/login`, { username, password })
    .then(response => {
      if (response.data.token) {
        localStorage.setItem('user', JSON.stringify(response.data));
      }
      return response.data;
    });
};

const logout = () => {
  localStorage.removeItem('user');
};

const register = (username, email, password) => {
  return axios.post(`${API_BASE_URL}/register`, {
    username,
    email,
    password
  });
};

const AuthService = {
  login,
  logout,
  register,
};

export default AuthService;
