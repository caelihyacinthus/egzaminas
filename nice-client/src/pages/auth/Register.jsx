import { useForm } from "react-hook-form";
import {NavLink} from "react-router";
import {useState} from "react";
import {useAuth} from "../../context/AuthContext.jsx";
import {Error} from "../../components/Error.jsx";

export const Register = () => {
    const { register, handleSubmit } = useForm();
    const [error, setError] = useState("")
    const { register: registerUser } = useAuth()

    const onSubmit = async (data) => {
        try {
            await registerUser(data.username, data.password);
        } catch (error) {
            console.log(error);
            
            setError(error.response?.data?.message ?? error.message)
        }
    };

    return (
        <main className="grid place-items-center h-screen">
            <div className="flex flex-col gap-2 items-center">
                <form onSubmit={handleSubmit(onSubmit)} onClick={() => setError("")}>
                    <fieldset className="w-xs border p-4 border-[var(--special-ac)]">
                        <legend className="p-1 text-[var(--special-ac)]">Register</legend>
                        <div className="flex flex-col">
                            <label className="">Username</label>
                            <input {...register("username")} type="text" className="border-[var(--special-ac)] border-2 p-1" placeholder="Enter username" />

                            <label className="">Password</label>
                            <input {...register("password")} type="password" className="border-[var(--special-ac)] border-2 p-1" placeholder="Enter password" />
                        </div>
                        <div className="flex flex-col items-center mt-4">
                            <button type="submit" className="button w-fit">Register</button>
                            <NavLink to="/login" className="border-b-[var(--special-ac)] border-b-2 text-center mt-2">Login</NavLink>
                        </div>
                    </fieldset>
                </form>
                <Error error={error} isHidden={!error} />
            </div>
        </main>
    );
};