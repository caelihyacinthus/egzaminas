import {createContext, useContext, useState} from "react";
import { useNavigate } from "react-router";
import api, { setAuth, clearAuth } from "../utils/api.js";


const AuthContext = createContext({
    user: {},
    login: () => {},
    logout: () => {},
    register: () => {},
});

export const AuthProvider = ({ children }) => {
    const navigate = useNavigate();
    const [user, setUser] = useState(() => {
        const maybeUser = localStorage.getItem("user");

        if (maybeUser) {
            return JSON.parse(maybeUser);
        }
    });

    const login = async (username, password) => {
        setAuth(username, password);
        const response = await api.get("/auth/me");
        const userData = response.data

        const user = {
            username,
            password,
            roles: userData.roles
        }
        localStorage.setItem("user", JSON.stringify(user));
        setUser(user);
        navigate("/services");
    };

    const register = async (username, password) => {
        await api.post("/auth/register", { username, password });
        navigate("/login");
    };

    const logout = () => {
        setUser({});
        clearAuth();
        localStorage.removeItem("user");
        navigate("/login");
    };

    return (
        <AuthContext.Provider value={{ user, login, logout, register }}>
            {children}
        </AuthContext.Provider>
    );
};

// Sukuriamas custom hookas, kuris leidžia naudoti AuthContext
export const useAuth = () => {
    return useContext(AuthContext);
};
