import { useEffect, useState } from "react";
import { useParams } from "react-router";
import { Error } from "../../components/Error.jsx";
import api from "../../utils/api";

export const ViewService = () => {
    const {id} = useParams();
    const [error, setError] = useState("")
    const [service, setService] = useState();

    const getService = async () => {
        try {
            setService((await api.get(`/master/${id}`)).data);
        } catch (error) {
            setError(error.response?.message || error.message);
        }
    }

    useEffect(() => {
        getService()
    }, []);

    return (
      <div className="grid place-items-center h-100 view">
        <fieldset>
            <legend>technician</legend>
            <p>name: {service.name}</p>
        </fieldset>
        <Error error={error} isHidden={!error} />
      </div>
    );
}