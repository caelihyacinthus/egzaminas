import api from "../../utils/api.js";
import {ServiceCard} from "../../components/ServiceCard.jsx";
import {Error} from "../../components/Error.jsx";
import {useNavigate} from "react-router";

export const ViewService = () => {

   const [books, setBooks] = useState([]);
    const [currentPage, setCurrentPage] = useState(1);
    const [pageSize, setPageSize] = useState(12);
    const [error, setError] = useState();
    const navigate = useNavigate();

const getBookPage = async (size, page) => {
        try {
            const response = await api.get(`/master?size=${size}&page=${page}`)
            setBooks(response.data)
        } catch (error) {
            if (error.response.status === 401) {
                setError("");
                navigate("/login");
            } else {
                setError(error.response?.data?.message || error.message)
            }
        }
    }

    return (
        <div className="grid place-items-center h-100">
            <p>Not implemented :c</p>
        </div>
    )
}