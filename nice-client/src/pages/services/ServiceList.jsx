import {useEffect, useState} from "react";
import api from "../../utils/api.js";
import {ServiceCard} from "../../components/ServiceCard.jsx";
import {Error} from "../../components/Error.jsx";
import {useNavigate} from "react-router";

export const ServiceList = () => {
    const [services, setService] = useState([]);
    const [currentPage, setCurrentPage] = useState(1);
    const [pageSize, setPageSize] = useState(12);
    const [error, setError] = useState();
    const navigate = useNavigate();

    const getServicePage = async (size, page) => {
        try {
            const response = await api.get(`/master?size=${size}&page=${page}`)
            setService(response.data)
            
        } catch (error) {
            if (error.response.status === 401) {
                setError("");
                navigate("/login");
            } else {
                setError(error.response?.data?.message || error.message)
            }
        }
    }

    const onPageSizeChange = async (e) => {
        const pageSize = e.target.value;
        await getServicePage(pageSize, 1)
        setCurrentPage(1)
        setPageSize(pageSize)
    }

    const onPaginate = async (page) => {
        if (page < 1) return

        await getServicePage(pageSize, page)
        setCurrentPage(page)
    }

    useEffect(() => {
        getServicePage(pageSize, currentPage)
    }, []);

    return (
        <div className="flex flex-col items-center gap-8 p-8">
            <ul className="grid grid-cols-1 gap-6 md:grid-cols-2 lg:grid-cols-3 justify-center">
                {services?.map(service => (
                    <ServiceCard key={service.id} service={service} getSErvicePage={getServicePage} currentPage={currentPage} pageSize={pageSize} />
                ))}
            </ul>
            <div className="">
                <button className="button" onClick={async () => await onPaginate(currentPage - 1)}>«</button>
                <button className="button">Page {currentPage}</button>
                <button className="button" onClick={async () => await onPaginate(currentPage + 1)}>»</button>
                <select
                    defaultValue="12"
                    className="ml-4 button"
                    onChange={onPageSizeChange}
                >
                    <option className="" value="9">9</option>
                    <option className="" value="12">12</option>
                    <option className="" value="15">15</option>
                </select>
            </div>
            <Error error={error} isHidden={!error} />
        </div>
    )
}