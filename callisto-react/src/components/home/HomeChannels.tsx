import { BiChevronLeft } from "react-icons/bi";
import { Link } from "react-router-dom";

const HomeChannels = () => {
  return (
    <main>
      <section className="flex gap-x-20">
        <span>
          <Link to="/">
            <BiChevronLeft className="ml-2 text-5xl text-gray-500" />
          </Link>
        </span>
        <div className="text-4xl leading-normal text-gray-500 mb-8">
          채널 목록
        </div>
      </section>
      <section className="items-center justify-center h-[37%] m-auto">
        <div className="flex items-center m-auto mb-4 h-[15%] w-[90%] border-b-2 gap-4">
          <img src="src/Img/CompanyImg.png" alt="그림" className="h-9 w-9" />
          <div>채널보기 입니다.</div>
          <div className="ml-32 bg-gray-200 w-50 h-6 solid">팔로우</div>
        </div>
        <div className="flex items-center m-auto mb-4 h-[15%] w-[90%] border-b-2 gap-4">
          <img src="src/Img/CompanyImg.png" alt="그림" className="h-9 w-9" />
          <div>채널보기 입니다.</div>
          <div className="ml-32 bg-gray-200 w-50 h-6 solid">팔로우</div>
        </div>
        <div className="flex items-center m-auto mb-4 h-[15%] w-[90%] border-b-2 gap-4">
          <img src="src/Img/CompanyImg.png" alt="그림" className="h-9 w-9" />
          <div>채널보기 입니다.</div>
          <div className="ml-32 bg-gray-200 w-50 h-6 solid">팔로우</div>
        </div>
        <div className="flex items-center m-auto mb-4 h-[15%] w-[90%] border-b-2 gap-4">
          <img src="src/Img/CompanyImg.png" alt="그림" className="h-9 w-9" />
          <div>채널보기 입니다.</div>
          <div className="ml-32 bg-gray-200 w-50 h-6 solid">팔로우</div>
        </div>
        <div className="flex items-center m-auto mb-4 h-[15%] w-[90%] border-b-2 gap-4">
          <img src="src/Img/CompanyImg.png" alt="그림" className="h-9 w-9" />
          <div>채널보기 입니다.</div>
          <div className="ml-32 bg-gray-200 w-50 h-6 solid">팔로우</div>
        </div>
        <div className="flex items-center m-auto mb-4 h-[15%] w-[90%] border-b-2 gap-4">
          <img src="src/Img/CompanyImg.png" alt="그림" className="h-9 w-9" />
          <div>채널보기 입니다.</div>
          <div className="ml-32 bg-gray-200 w-50 h-6 solid">팔로우</div>
        </div>
        <div className="flex items-center m-auto mb-4 h-[15%] w-[90%] border-b-2 gap-4">
          <img src="src/Img/CompanyImg.png" alt="그림" className="h-9 w-9" />
          <div>채널보기 입니다.</div>
          <div className="ml-32 bg-gray-200 w-50 h-6 solid">팔로우</div>
        </div>
        <div className="flex items-center m-auto mb-4 h-[15%] w-[90%] border-b-2 gap-4">
          <img src="src/Img/CompanyImg.png" alt="그림" className="h-9 w-9" />
          <div>채널보기 입니다.</div>
          <div className="ml-32 bg-gray-200 w-50 h-6 solid">팔로우</div>
        </div>
        <div className="flex items-center m-auto mb-4 h-[15%] w-[90%] border-b-2 gap-4">
          <img src="src/Img/CompanyImg.png" alt="그림" className="h-9 w-9" />
          <div>채널보기 입니다.</div>
          <div className="ml-32 bg-gray-200 w-50 h-6 solid">팔로우</div>
        </div>
        <div className="flex items-center m-auto mb-4 h-[15%] w-[90%] border-b-2 gap-4">
          <img src="src/Img/CompanyImg.png" alt="그림" className="h-9 w-9" />
          <div>채널보기 입니다.</div>
          <div className="ml-32 bg-gray-200 w-50 h-6 solid">팔로우</div>
        </div>
      </section>
    </main>
  );
};

export default HomeChannels;
