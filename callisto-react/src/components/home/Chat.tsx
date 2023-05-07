import React from "react";
import GNB from "../common/GNB";
import { BiChevronLeft, BiChevronRight } from "react-icons/bi";
import BottomNavi from "../common/BottomNavi";

const Chat = () => {
  return (
    <main className="h-screen">
      <GNB />
      <section className="flex items-center justify-center h-[37%] m-auto">
        <div className="h-[90%] w-[90%] bg-gray-100">채팅방입니다.</div>
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
            <BiChevronRight />
          </span>
        </div>
      </div>
      <section className="flex items-center justify-center h-[37%] m-auto">
        <div className="h-[90%] w-[90%] bg-gray-100">채팅방입니다.</div>
      </section>
      <BottomNavi />
    </main>
  );
};

export default Chat;
