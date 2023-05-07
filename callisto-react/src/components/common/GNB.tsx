import { CiChat1 } from "react-icons/ci";
import { Link } from "react-router-dom";

const GNB = () => {
  return (
    <header>
      <section className="flex justify-around items-center bg-main-contra h-12 my-3">
        <Link to="/">
          <img
            src="/src/img/Favicon.jpg"
            alt={"파비콘"}
            className="h-9 w-9 rounded-full"
          />
        </Link>
        <input
          type="search"
          placeholder="회사, 사람, 키워드로 검색"
          className="text-lg text-center border-indigo-500/50 w- h-8 bg-gray-200 rounded-lg"
        />
        <span>
          <Link to="/chat">
            <CiChat1 className="text-3xl" />
          </Link>
        </span>
      </section>
      <section>
        <ul className="flex items-center justify-around bg-main-contra h-full border-b-4">
          <Link to="/" className=" focus:text-main">
            홈
          </Link>
          <Link to="/hire" className="focus:text-main  ">
            채용
          </Link>
          <Link to="/popular" className="focus:text-main ">
            인기
          </Link>
          <Link to="/category" className="focus:text-main ">
            카테고리
          </Link>
        </ul>
      </section>
    </header>
  );
};

export default GNB;
