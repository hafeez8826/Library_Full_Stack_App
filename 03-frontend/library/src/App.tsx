import { Redirect, Route, Switch } from "react-router-dom";
import "./App.css";
import HomePage from "./layouts/HomePage/HomePage";
import Footer from "./layouts/NavbarAndFooter/Footer";
import { Navbar } from "./layouts/NavbarAndFooter/Navbar";
import SearchBookPage from "./layouts/SearchBookPage/SearchBookPage";
import BookCheckoutPage from "./layouts/BookCheckoutPage/BookCheckoutPage";

export const App = () => {
  return (
    <div className="d-flex flex-column min-vh-100">
      <Navbar />
      <div className="flex-grow-1">
        <Switch>
          <Route path="/" exact>
            <Redirect to="/home" />
          </Route>
          <Route path="/home">
            <HomePage />
          </Route>
          <Route path="/search">
            <SearchBookPage />
          </Route>
          <Route path="/checkout/:bookId">
            <BookCheckoutPage />
          </Route>
        </Switch>
      </div>
      <Footer />
    </div>
  );
};
