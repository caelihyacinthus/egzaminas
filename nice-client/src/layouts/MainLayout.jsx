import {NavLink, Outlet} from "react-router";
import {useAuth} from "../context/AuthContext.jsx";

export const MainLayout = () => {
    const { logout } = useAuth();

    return (
      <div className="">
        <nav className="flex justify-between w-full fixed top-0 bg-stone-900 h-fit border-b-[var(--special-ac)] border-b-4">
          <div className="button-nav">
            <NavLink to="/books">Books</NavLink>
          </div>
          <div>
            {localStorage.getItem("user") && (
              <div className="button-nav">
                <button onClick={logout} className="">
                  Logout
                </button>
              </div>
            )}
            {!localStorage.getItem("user") && (
              <div className="button-nav">
                <NavLink to="/login">Login</NavLink>
              </div>
            )}
          </div>
        </nav>
        <main className="mt-12">
          <Outlet />
        </main>
      </div>
    );
}