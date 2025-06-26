import { useForm } from "react-hook-form";
import {NavLink} from "react-router";
import {useState} from "react";
import {useAuth} from "../../context/AuthContext.jsx";
import {Error} from "../../components/Error.jsx";

export const Login = () => {
    const { register, handleSubmit } = useForm();
    const [error, setError] = useState("")
    const { login } = useAuth()

    const onSubmit = async (data) => {
        try {
            await login(data.username, data.password);
        } catch (error) {
            if (error.response.status === 401) {
                setError("Invalid credentials")
            } else {
                setError(error.response?.data?.message || error.message)
            }
        }
    };

    return (
        <main className="grid place-items-center h-screen">
            <div className="flex flex-col gap-2 items-center">
                <form onSubmit={handleSubmit(onSubmit)}>
                    <fieldset className="w-xs border p-4 border-[var(--special-ac)]">
                        <legend className="p-1 text-[var(--special-ac)]">Login</legend>
                        <div className="flex flex-col">
                            <label className="">Username</label>
                            <input {...register("username")} type="text" className="border-[var(--special-ac)] border-2 p-1" placeholder="Enter username" />

                            <label className="">Password</label>
                            <input {...register("password")} type="password" className="border-[var(--special-ac)] border-2 p-1" placeholder="Enter password" />
                        </div>
                        <div className="flex flex-col items-center mt-4">
                            <button type="submit" className="button w-fit">Login</button>
                            <NavLink to="/register" className="border-b-[var(--special-ac)] border-b-2 text-center mt-2">Register</NavLink>
                        </div>
                    </fieldset>
                </form>
                <Error error={error} isHidden={!error} />
            </div>
        </main>
    );
};
