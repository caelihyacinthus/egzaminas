import {useAuth} from "../context/AuthContext.jsx";
import {NavLink} from "react-router";
import api from "../utils/api.js";
import {Error} from "./Error.jsx";
import {useState} from "react";

export const BookCard = (props) => {
    const { book, getBookPage, currentPage, pageSize } = props
    const { id, imageUrl, title, author, publishDate } = book
    const [error, setError] = useState("")
    const { user } = useAuth()

    const deleteBook = async () => {
        try {
            await api.delete(`/books/${id}`);
            await getBookPage(pageSize, currentPage)
        } catch (error) {
            setError(error.response?.message || error.message);
        }
    }

    return (
        <div className=" border-[var(--special-ac)]/50 rounded-md border-2 shadow-md grid grid-cols-1 gap-2 pt-4 p-2 w-72">
            <figure className="w-40 h-40">
                <img
                    className="max-w-auto max-h-40 mr-auto ml-auto"
                    src={imageUrl}
                    alt="Book Tumbnail" />
            </figure>
            <div className="">
                <h2 className="">{title}</h2>
                <p>{author}</p>
                <p>{publishDate}</p>
            </div>
            <div className="">
                <button className="button"><NavLink to={`/books/view/${id}`} >View</NavLink></button>
                { user.roles?.includes("ROLE_ADMIN") && <button onClick={deleteBook} className="button">Delete</button> }
            </div>
                
            <Error error={error} isHidden={!error} />
        </div>
    )
}