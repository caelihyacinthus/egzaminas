import { useForm } from "react-hook-form";
import {NavLink} from "react-router";
import {useState} from "react";
import {useAuth} from "../../context/AuthContext.jsx";
import {Error} from "../../components/Error.jsx";
import api from "../../utils/api.js";

export const AddService = () => {
    const [error, setError] = useState("");
    const { user } = useAuth();

 const {
    register,
    handleSubmit,
    reset,
    formState: { errors },
  } = useForm({
    defaultValues: {
      name: ""
    },
  });

    const onSubmit = async (data) => {
        try {
            await api.post(`/master`, data.name);
        } catch (error) {
            console.log(error); 
            setError(error.response?.data?.message ?? error.message)
        }
    };

    return (<div>
    <div className="grid w-80">
        <form onSubmit={handleSubmit(onSubmit)} className="form-basic">
                <fieldset className="">
                    <legend className="">Add Service</legend>
                    <div className="flex flex-col">
                        <label className="">name</label>
                        <input {...register("name")} type="text" className="" placeholder="Enter name" />
                    </div>
                    <div className="flex flex-col items-center mt-4">
                        <button type="submit" className="button w-fit">Add</button>
                    </div>
                </fieldset>
            </form>
            <Error error={error} isHidden={!error} />
    </div>
        
    </div>
    )
}