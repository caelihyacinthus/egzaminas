import {useAuth} from "../context/AuthContext.jsx";
import {NavLink} from "react-router";
import api from "../utils/api.js";
import {Error} from "./Error.jsx";
import {useState} from "react";

export const ServiceCard = (props) => {
    const { service, getServicePage, currentPage, pageSize } = props
    const { id, name, workplace } = service
    const [error, setError] = useState("")
    const { user } = useAuth()

    const deleteService = async () => {
        try {
            await api.delete(`/master/${id}`);
            await getServicePage(pageSize, currentPage)
        } catch (error) {
            setError(error.response?.message || error.message);
        }
    }

    return (
        <div className=" border-[var(--special-ac)]/50 rounded-md border-2 shadow-md grid grid-cols-1 gap-2 pt-4 p-2 w-72">
            <div className="">
                <h2 className="">{name}</h2>
                <p>{workplace}</p>
            </div>
            <div className="">
                <button className="button"><NavLink to={`/services/view/${id}`} >View</NavLink></button>
                { user.roles?.includes("ROLE_ADMIN") && <button onClick={deleteService} className="button">Delete</button> }
            </div>
                
            <Error error={error} isHidden={!error} />
        </div>
    )
}