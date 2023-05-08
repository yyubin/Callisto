import { BiChevronLeft, BiChevronRight } from "react-icons/bi";
import { Link } from "react-router-dom";

const Notice = () => {
  return (
    <main className="h-screen">
      <section className="flex items-center justify-center h-[37%] m-auto">
        <div className="h-[90%] w-[90%] bg-gray-100">알림화면입니다.</div>
      </section>
      <div className="flex justify-between border-b-2 ">
        <div>
          <span className="flex items-center">
            <BiChevronLeft /> 최신순
          </span>
        </div>
        <div>
          <span className="flex items-center">
            채널보기
            <Link to="/channel">
              <BiChevronRight />
            </Link>
          </span>
        </div>
      </div>
      <section className="flex items-center justify-center h-[37%] m-auto">
        <div className="h-[90%] w-[90%] bg-gray-100">알림화면입니다.</div>
      </section>
    </main>
  );
};

export default Notice;
