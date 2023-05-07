import React from "react";
import { BiChevronLeft, BiChevronRight } from "react-icons/bi";
import BottomNavi from "../common/BottomNavi";
import { Link } from "react-router-dom";
import Path from "@/utils/path/routes";
import dataList from "@/data";
import iconBase from "@assets/img/CompanyImg.png";

const Category = () => {
  const { HOME } = Path;

  return (
    <>
      <section className="w-full flex flex-row items-center justify-center gap-20">
        <BiChevronLeft
          className="text-5xl text-gray-500"
          onClick={() => {
            //FIXME 경로 넣어서 바꿔주세요
          }}
        />
        <div className="text-4xl text-gray-500">카테고리</div>
      </section>
      {/* FIXME 컴포넌트화 해주세요. */}
      <main className="w-full flex flex-1 flex-col items-center">
        <section className="w-full flex flex-col items-center justify-center py-8 px-16 m:px-4 gap-4">
          {dataList.map((i) => {
            return (
              <div
                key={i.id}
                className="w-full flex justify-between items-center gap-4"
              >
                <div className="flex flex-row justify-start items-center gap-2">
                  <img src={iconBase} alt="그림" className="max-h-6 max-w-6" />
                  <div className="flex">회사</div>
                </div>
                <div className="ml-20 bg-gray-200 w-50 h-6 solid">
                  팔로우(나중에 fix로 고정)
                </div>
              </div>
            );
          })}

          {dataList.map((i) => {
            return (
              <div key={"data-" + i.id}>
                <div>{i.title}</div>
                <div>{i.content}</div>
                <div>{i.price}</div>
              </div>
            );
          })}
          <div className="flex items-center mb-4 border-b-2 gap-4">
            <img src={iconBase} alt="그림" className="h-9 w-9" />
            <div>채널보기 입니다.</div>
            <div className="ml-32 bg-gray-200 w-50 h-6 solid">팔로우</div>
          </div>
        </section>
        <BottomNavi />
      </main>
    </>
  );
};

export default Category;
