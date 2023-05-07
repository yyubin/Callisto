import { Link } from "react-router-dom";

const BottomNavi = () => {
  const liStyle =
    "flex items-center justify-center w-1/5 h-full cursor-pointer text-3xl hover:bg-main";

  return (
    <nav className="fixed bottom-0 right-0 left-0 h-20 bg-main">
      <ul className="w-full h-full flex items-center justify-between">
        <Link className={liStyle} to="/">
          홈
        </Link>
        <Link className={liStyle} to="/">
          회사
        </Link>
        <Link className={liStyle} to="/">
          +
        </Link>
        <Link className={liStyle} to="/">
          알람
        </Link>
        <Link className={liStyle} to="/login">
          my
        </Link>
      </ul>
    </nav>
  );
};

export default BottomNavi;
