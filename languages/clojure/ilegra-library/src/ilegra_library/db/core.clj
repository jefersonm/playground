(ns ilegra-library.db.core
  (:use korma.core
        [korma.db :only (defdb)])
  (:require [ilegra-library.db.schema :as schema]))

(defdb db schema/db-spec)

(defentity books)

(defn save-book [name owner]
  (insert books
          (values {:name name
                   :owner owner
                   :timestamp (new java.util.Date)})))

(defn update-book [id name owner]
  (update books
  (set-fields {:name name
               :owner owner})
  (where {:id id})))

(defn get-books []
  (select books))

(defn get-book [id]
  (first (select books
                 (where {:id id})
                 (limit 1))))
