import { useLocation } from "react-router-dom";
import Path from "./utils/path/routes";
import { useLayoutEffect, useState } from "react";
import GNB from "./components/common/GNB";
import BottomNavi from "./components/common/BottomNavi";
import ProtectedRoutes from "./routes/ProtectedRoutes";
import UnauthenticatedRoutes from "./routes/UnauthenticatedRoutes";

function App() {
  const location = useLocation();
  const { HOME } = Path;

  const [hasNav, setHasNav] = useState<boolean>(false);
  const [RoutesComponent, setRoutesComponent] =
    useState<React.ReactElement | null>(null);

  // const authToken = token.getToken("token");
  const [임시, set임시] = useState<boolean>(false);

  useLayoutEffect(() => {
    // const authToken = token.getToken("token");
    !임시 && setRoutesComponent(<ProtectedRoutes />);
    임시 && setRoutesComponent(<UnauthenticatedRoutes />);
  }, [임시]);

  useLayoutEffect(() => {
    const pathname =
      location.pathname.endsWith("/") && location.pathname.length > 1
        ? location.pathname.slice(0, -1)
        : location.pathname;

    const hasNav = [HOME].includes(pathname);

    setHasNav(hasNav);
  }, []);

  return (
    <div className="w-full max-w-[424px] h-full min-h-screen bg-gray-200">
      <header className="w-full px-4 bg-main-contra">
        {hasNav && <GNB />}
      </header>
      <main className="w-full px-4">{RoutesComponent}</main>
      <BottomNavi />
    </div>
  );
}

export default App;
