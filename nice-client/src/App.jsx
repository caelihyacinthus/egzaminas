import {BrowserRouter, Navigate, Route, Routes} from "react-router";
import {MainLayout} from "./layouts/MainLayout.jsx";
import {ServiceList} from "./pages/services/ServiceList.jsx";
import {AuthGuard} from "./components/AuthGuard.jsx";
import {Login} from "./pages/auth/Login.jsx";
import {Register} from "./pages/auth/Register.jsx";
import {AuthProvider} from "./context/AuthContext.jsx";
import {ViewService} from "./pages/services/ViewService.jsx";
import { NotFound } from "./components/NotFound.jsx";
import {AddService} from "./pages/services/AddService.jsx";

const App = () => {
    return (
        <BrowserRouter>
            <Routes>
                <Route path={"/login"} element={
                    <AuthProvider>
                        <Login/>
                    </AuthProvider>
                }/>
                <Route path={"/register"} element={
                    <AuthProvider>
                        <Register/>
                    </AuthProvider>
                }/>
                <Route path={"/"} element={
                    <AuthGuard>
                        <AuthProvider>
                            <MainLayout/>
                        </AuthProvider>
                    </AuthGuard>
                }>
                    <Route index element={<Navigate to="login" replace />} />
                    <Route path="services" element={<ServiceList/>} />
                    <Route path="services/view/:id" element={<ViewService />} />
                    <Route path="addservices" element={<AddService/>}/>
                    <Route path="*" element={<NotFound/>}/>
                </Route>
            </Routes>
        </BrowserRouter>
    )
}

export default App
