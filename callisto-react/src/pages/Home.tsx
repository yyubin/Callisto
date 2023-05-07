import dataList, { data } from "@/data";
import Path from "@/utils/path/routes";
import { BiChevronLeft, BiChevronRight } from "react-icons/bi";
import { Link } from "react-router-dom";

const Home = () => {
  const { CHANNEL } = Path;
  return (
    <div className="w-full flex flex-col gap-2 py-4">
      {/* TODO 컴포넌트로 나눠주세요 무슨 페이지인지 모르겠어요  */}
      <section className="w-full flex items-center justify-center">
        <Link to={CHANNEL} className="w-full bg-gray-100 p-4">
          <div>{data.title}</div>
          <div>
            {dataList.map((item, i) => {
              return <div key={i}>{item.title}</div>;
            })}
          </div>
        </Link>
      </section>
      {/* FIXME 최신순 채널보기 무슨 페이지인지 모르겠어요 주석달아주세요 */}
      <div className="w-full flex justify-between bg-gray-100 p-4">
        <div>
          <span className="flex items-center">
            <BiChevronLeft /> 최신순
          </span>
        </div>
        <div>
          <Link to={CHANNEL}>
            <span className="flex items-center">
              채널보기
              <BiChevronRight />
            </span>
          </Link>
        </div>
      </div>
      {/* FIXME ???? */}
      <section className="w-full flex items-center justify-center">
        <Link to={CHANNEL} className="w-full bg-gray-100 p-4">
          <div>안녕하세요</div>
        </Link>
      </section>
    </div>
  );
};

export default Home;
