import React from "react";
import GNB from "../common/GNB";
import { BiChevronLeft, BiChevronRight } from "react-icons/bi";
import BottomNavi from "../common/BottomNavi";

const Popular = () => {
  return (
    <main className="h-screen">
      <GNB />
      <section className="flex items-center justify-center h-[37%]">
        <div className="h-[90%] w-[90%] bg-gray-100">인기페이지입니다.</div>
      </section>
      <section className="flex items-center justify-center h-[37%]">
        <div className="h-[90%] w-[90%] bg-gray-100">인기페이지입니다.</div>
      </section>
      <BottomNavi />
    </main>
  );
};

export default Popular;
