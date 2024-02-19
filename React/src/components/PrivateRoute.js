// src/components/PrivateRoute.js
import { Navigate, Outlet } from 'react-router-dom';
import { isAuthenticated } from '../utils/auth'; // Ensure you have this utility function correctly implemented

const PrivateRoute = () => isAuthenticated() ? <Outlet /> : <Navigate to="/" replace />;

export default PrivateRoute;
