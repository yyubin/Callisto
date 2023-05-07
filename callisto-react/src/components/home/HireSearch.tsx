import React from "react";
import GNB from "../common/GNB";
import { Link } from "react-router-dom";
import BottomNavi from "../common/BottomNavi";

const HireSearch = () => {
  return (
    <main className="h-screen">
      <GNB />
      <section className="flex justify-around items-center  h-16 border-b-4">
        <Link to="/hire">
          <div className="bg-gray-100 h-10 w-40 leading-9 text-center">
            포지션
          </div>
        </Link>
        <Link to="/hire/search">
          <div className="bg-black text-white h-10 w-40 leading-9 text-center">
            채용 검색
          </div>
        </Link>
      </section>
      <section className="flex items-center justify-center h-[34%] m-auto">
        <div className="h-[90%] w-[90%] bg-gray-100">채용화면입니다.</div>
      </section>
      <section className="flex items-center justify-center h-[34%] m-auto">
        <div className="h-[90%] w-[90%] bg-gray-100">채용화면입니다.</div>
      </section>
      <BottomNavi />
    </main>
  );
};

export default HireSearch;
