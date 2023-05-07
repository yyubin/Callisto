import dataList, { data } from "@/data";
import BottomNavi from "@/components/common/BottomNavi";
import GNB from "@components/common/GNB";
import { useEffect, useState } from "react";
import { BiChevronLeft, BiChevronRight } from "react-icons/bi";
import { Link } from "react-router-dom";

const Home = () => {
  // const [data, setData] = useState<dummyProps>({
  //   id: 0,
  //   content: "",
  //   title: "",
  //   price: 0,
  // });

  // useEffect(() => {
  //   setData(data);
  // }, []);

  return (
    <main className="h-screen">
      <GNB />
      <section className="flex items-center justify-center h-[37%] m-auto">
        <Link to="/channel" className="h-[90%] w-[90%] bg-gray-100">
          <div>{data.title}</div>
          <div>
            {dataList.map((item, i) => {
              return <div>{item.title}</div>;
            })}
          </div>
        </Link>
      </section>
      <div className="flex justify-between border-b-2 ">
        <div>
          <span className="flex items-center">
            <BiChevronLeft /> 최신순
          </span>
        </div>
        <div>
          <Link to="/channel">
            <span className="flex items-center">
              채널보기
              <BiChevronRight />
            </span>
          </Link>
        </div>
      </div>
      <section className="flex items-center justify-center h-[37%] m-auto">
        <Link to="/channel" className="h-[90%] w-[90%] bg-gray-100">
          <div>안녕하세요</div>
        </Link>
      </section>
      <BottomNavi />
    </main>
  );
};

export default Home;
