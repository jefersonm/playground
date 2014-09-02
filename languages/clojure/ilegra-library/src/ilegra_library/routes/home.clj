(ns ilegra-library.routes.home
  (:require [compojure.core :refer :all]
            [ilegra-library.layout :as layout]
            [ilegra-library.util :as util]
            [ilegra-library.db.core :as db]))

(defn home-page [& [name book error]]
  (layout/render "home.html"
                 {:error    error
                  :name     name
                  :book  	book
                  :books (db/get-books)}))

(defn save-book [name owner]
  (cond

    (empty? name)
    (home-page name owner "Somebody forgot to leave a name")

    (empty? owner)
    (home-page name owner "Don't you have something to say?")

    :else
    (do
      (db/save-book name owner)
      (home-page))))

(defn about-page []
  (layout/render "about.html"))

(defroutes home-routes
  (GET "/" [] (home-page))
  (POST "/" [name owner] (save-book name owner))
  (GET "/about" [] (about-page)))
