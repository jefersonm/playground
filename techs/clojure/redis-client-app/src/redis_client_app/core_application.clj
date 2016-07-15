(ns redis-client-app.core-application
  (:require
            [ring.adapter.jetty :refer :all]
            [redis-client-app.route.routes :refer :all]))

(defn -main []
  (run-jetty app {:port 3000}))