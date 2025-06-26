import {BrowserRouter, Navigate, Route, Routes} from "react-router";
import {MainLayout} from "./layouts/MainLayout.jsx";
import {BookList} from "./pages/books/BookList.jsx";
import {AuthGuard} from "./components/AuthGuard.jsx";
import {Login} from "./pages/auth/Login.jsx";
import {Register} from "./pages/auth/Register.jsx";
import {AuthProvider} from "./context/AuthContext.jsx";
import {ViewBook} from "./pages/books/ViewBook.jsx";
import { NotFound } from "./components/NotFound.jsx";

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
                    <Route path="books" element={<BookList/>} />
                    <Route path="books/view/:id" element={<ViewBook />} />
                    <Route path="*" element={<NotFound/>}/>
                </Route>
            </Routes>
        </BrowserRouter>
    )
}

export default App
