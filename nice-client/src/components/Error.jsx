export const Error = (props) => {
    const { isHidden, error } = props

    if (isHidden) return;

    return (
        <div role="alert" className="bg-red-500/60 px-4 py-2 border-0 rounded-sm">
            <span className=" text-[var(--bg-dark-base)] font-bold mr-2">!</span>
            <span className=" text-[var(--bg-dark-base)]">{error}</span>
        </div>
    )
}