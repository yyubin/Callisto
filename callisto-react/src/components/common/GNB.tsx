import { CiChat1 } from "react-icons/ci";
import { Link } from "react-router-dom";
import Favicon from "@assets/img/Favicon.jpg";
import Path from "@/utils/path/routes";

const GNB = () => {
  const { HOME, LOGIN, SIGNUP, HIRE, CATEGORY, POPULAR } = Path;

  return (
    <nav>
      <section className="h-16 flex items-center justify-between py-2">
        <Link to={HOME}>
          <img src={Favicon} alt={"파비콘"} className="h-9 w-9 rounded-full" />
        </Link>
        <div className="">
          <input
            type="search"
            placeholder="회사, 사람, 키워드로 검색"
            className="w-fit bg-gray-200 rounded-lg px-8 py-1"
          />
        </div>
        <span>
          <Link to="/chat">
            <CiChat1 className="text-3xl" />
          </Link>
        </span>
      </section>
      <section>
        <ul className="flex items-center justify-around bg-main-contra h-full py-2">
          <Link to={HOME} className="focus:text-main">
            홈
          </Link>
          <Link to={HIRE} className="focus:text-main  ">
            채용
          </Link>
          <Link to={POPULAR} className="focus:text-main ">
            인기
          </Link>
          <Link to={CATEGORY} className="focus:text-main ">
            카테고리
          </Link>
        </ul>
      </section>
    </nav>
  );
};

export default GNB;
