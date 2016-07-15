(ns redis-client-app.route.routes
  (:require [compojure.core :refer :all]
            [compojure.handler :as handler]
            [ring.middleware.json :as middleware]
            [compojure.route :as route]))

(defroutes app-routes

  (GET "/" [] {:status 200 :body "Welcome to Redis Client API"})

  (GET "/cache/" [] "cache value")

  (POST "/cache/" request
    (let [name (or  (get-in request [:params :name])
                    (get-in request [:body :name]))]
        { :status 200
          :body {:name name
          :desc (str "The name you sent to me was " name)}}))

  (route/not-found "Not Found"))

(def app
  (-> (handler/site app-routes)
      (middleware/wrap-json-body {:keywords? true})
      middleware/wrap-json-response))