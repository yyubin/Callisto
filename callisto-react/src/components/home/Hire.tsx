import MainButton from "@/styles/styled-button";
import Path from "@/utils/path/routes";
import { useState } from "react";
import { useNavigate } from "react-router-dom";

const Hire = () => {
  const navigate = useNavigate();
  const { HIRE } = Path;

  const [selectTab, setSelectTab] = useState<boolean>(false);

  return (
    <div className="w-full h-screen flex flex-col gap-2 py-4">
      <div className="flex justify-between items-center gap-4">
        <MainButton
          className="w-1/2"
          onClick={() => {
            setSelectTab(true);
          }}
        >
          포지션
        </MainButton>
        <MainButton
          className="w-1/2"
          onClick={() => {
            setSelectTab(false);
          }}
        >
          채용 검색
        </MainButton>
      </div>
      {/* TODO 채용화면 컴포넌트로 나눠도되고 바로써도되고*/}
      {selectTab ? (
        <section className="flex items-center justify-center">
          <div className="w-full bg-gray-100">포지션</div>
        </section>
      ) : (
        <section className="flex items-center justify-center">
          <div className="w-full bg-gray-100">채용화면입니다.</div>
        </section>
      )}
    </div>
  );
};

export default Hire;
