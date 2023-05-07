import React from "react";
import { CiChat1 } from "react-icons/ci";
import { Link, useNavigate } from "react-router-dom";
import TopIcon from "@assets/img/Favicon.jpg";

const GNBShort = () => {
  const navigate = useNavigate();
  return (
    <header className="w-full bg-white h-20 border-b shadow-md">
      <section className="w-full h-full flex items-center justify-between gap-4 px-8 text-lg">
        <Link to="/">
          <img src={TopIcon} alt={"파비콘"} className="h-9 w-9 rounded-full" />
        </Link>
        <input
          type="search"
          placeholder="회사, 사람, 키워드로 검색"
          className="flex flex-1 text-center border-default max-h-8 bg-default rounded-lg"
        />
        <span>
          <CiChat1
            className="text-3xl"
            onClick={() => {
              navigate("/chat");
            }}
          />
        </span>
      </section>
    </header>
  );
};

export default GNBShort;
