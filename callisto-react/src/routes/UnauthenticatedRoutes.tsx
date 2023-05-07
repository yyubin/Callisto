import Company from "@/pages/Company";
import Home from "@/pages/Home";
import Notice from "@/pages/Notice";
import Profile from "@/pages/Profile";
import Write from "@/pages/Write";
import Path from "@/utils/path/routes";
import { Navigate, Route, Routes } from "react-router-dom";

const UnauthenticatedRoutes = () => {
  const {
    HOME,
    LOGIN,
    SIGNUP,
    CATEGORY,
    CHANNEL,
    HIRE,
    POPULAR,
    COMPANY,
    NOTICE,
    PROFILE,
    WRITE,
  } = Path;

  return (
    <Routes>
      {/* 비로그인 */}
      <Route path={COMPANY} element={<Company />} />
      <Route path={HOME} element={<Home />} />
      <Route path={NOTICE} element={<Notice />} />
      <Route path={PROFILE} element={<Profile />} />
      <Route path={WRITE} element={<Write />} />
      <Route path={LOGIN} element={<Write />} />
      <Route path={SIGNUP} element={<Write />} />

      <Route path="*" element={<Navigate replace to={HOME} />} />
    </Routes>
  );
};

export default UnauthenticatedRoutes;
