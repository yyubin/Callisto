import { Link } from "react-router-dom";

const BottomNavi = () => {
  const liStyle =
    "flex items-center justify-center w-1/5 h-full cursor-pointer text-3xl hover:bg-main";

  return (
    <nav className="fixed bottom-0 right-0 left-0 h-28 bg-rose-300">
      <ul className="w-full h-full flex items-center justify-between">
        <Link className={liStyle} to="/">
          rr
        </Link>
        <Link className={liStyle} to="/">
          rr
        </Link>
        <Link className={liStyle} to="/">
          rr
        </Link>
        <Link className={liStyle} to="/">
          rr
        </Link>
        <Link className={liStyle} to="/">
          rr
        </Link>
      </ul>
    </nav>
  );
};

export default BottomNavi;
