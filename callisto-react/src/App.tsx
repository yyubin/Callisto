import { useLocation } from "react-router-dom";
import Path from "./utils/path/routes";
import { useLayoutEffect, useState } from "react";
import GNB from "./components/common/GNB";
import BottomNavi from "./components/common/BottomNavi";
import ProtectedRoutes from "./routes/ProtectedRoutes";
import UnauthenticatedRoutes from "./routes/UnauthenticatedRoutes";
import token from "./libs/token";

function App() {
  const location = useLocation();
  const {
    HOME,
    CATEGORY,
    CHANNEL,
    COMPANY,
    HIRE,
    LOGIN,
    NOTICE,
    POPULAR,
    PROFILE,
    SIGNUP,
    WRITE,
  } = Path;

  const [hasNav, setHasNav] = useState<boolean>(false);
  const [RoutesComponent, setRoutesComponent] =
    useState<React.ReactElement | null>(null);

  const authToken = token.get();

  useLayoutEffect(() => {
    const authToken = token.get();
    !authToken && setRoutesComponent(<ProtectedRoutes />);
    !!authToken && setRoutesComponent(<UnauthenticatedRoutes />);
  }, [authToken]);

  useLayoutEffect(() => {
    const pathname =
      location.pathname.endsWith("/") && location.pathname.length > 1
        ? location.pathname.slice(0, -1)
        : location.pathname;

    const hasNav = [
      HOME,
      CATEGORY,
      CHANNEL,
      COMPANY,
      HIRE,
      LOGIN,
      NOTICE,
      POPULAR,
      PROFILE,
      SIGNUP,
      WRITE,
    ].includes(pathname);

    setHasNav(hasNav);
  }, []);

  return (
    <div className="w-full max-w-[424px] h-full min-h-screen bg-gray-200">
      <header className="w-full px-4 bg-main-contra">
        {hasNav && <GNB />}
      </header>
      <main className="w-full h-full p-4">{RoutesComponent}</main>
      <BottomNavi />
    </div>
  );
}

export default App;
