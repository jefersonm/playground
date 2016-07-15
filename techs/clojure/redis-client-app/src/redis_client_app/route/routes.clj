(ns redis-client-app.route.routes
  (:require [compojure.core :refer :all]
            [compojure.handler :as handler]
            [ring.middleware.json :as middleware]
            [compojure.route :as route]
            [redis-client-app.service.redis-service :refer :all]))

(defroutes app-routes

  (GET "/" [] {:status 200 :body "Welcome to Redis Client API"})

  (GET "/cache/:key" [key]
    { :status 200
      :body {:value key
            :desc (get-from-redis key)}})

  (POST "/cache/" request
    (let [key   (or   (get-in request [:params :key])
                      (get-in request [:body :key]))
          value (or   (get-in request [:params :value])
                      (get-in request [:body :value]))]
        (set-to-redis key value)
        { :status 200
          :body {:value value
          :desc (str value " Inserted to Redis Cache")}}))

  (route/not-found "Route not Found"))


(def app
  (-> (handler/site app-routes)
      (middleware/wrap-json-body {:keywords? true})
      middleware/wrap-json-response))