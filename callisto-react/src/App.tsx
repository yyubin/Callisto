import { Routes, Route } from "react-router-dom";
import Home from "./pages/Home";
import Test from "./pages/Write";
import Hire from "./components/home/Hire";
import Popular from "./components/home/Popular";
import Category from "./components/home/Category";
import Chat from "./components/home/Chat";
import Company from "./pages/Company";
import Notice from "./pages/Notice";
import Profile from "./pages/Profile";
import HomeChannels from "./components/home/HomeChannels";
import HireSearch from "./components/home/HireSearch";
import { useState } from "react";
import data from "./data/index.js";
import GNB from "./components/common/GNB";

function App() {
  return (
    <Routes>
      <Route path={"/"} element={<Home />} />
      <Route path={"/channel"} element={<HomeChannels />} />
      <Route path={"/hire"} element={<Hire />} />
      <Route path={"/hire/search"} element={<HireSearch />} />
      <Route path={"/popular"} element={<Popular />} />
      <Route path={"/category"} element={<Category />} />
      <Route path={"/chat"} element={<Chat />} />
      <Route path={"/company"} element={<Company />} />
      <Route path={"/write"} element={<Test />} />
      <Route path={"/notice"} element={<Notice />} />
      <Route path={"/profile"} element={<Profile />} />
    </Routes>
  );
}

export default App;
