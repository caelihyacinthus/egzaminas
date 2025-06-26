import {NavLink, Outlet} from "react-router";
import {useAuth} from "../context/AuthContext.jsx";

export const MainLayout = () => {
    const { logout } = useAuth();

    return (
      <div className="">
        <nav className="flex justify-between w-full fixed top-0 bg-stone-900 h-fit border-b-[var(--special-ac)] border-b-4">
          <div className="flex">
          <div className="button-nav mr-4">
            <NavLink to="/services">Services</NavLink>
          </div>
          <div className="button-nav mr-4">
            {JSON.parse(localStorage.getItem("user")).roles.includes("ROLE_ADMIN")
               && <NavLink to="/addservices">Add service</NavLink>}
          </div>
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