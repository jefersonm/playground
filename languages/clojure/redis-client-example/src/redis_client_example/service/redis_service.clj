(ns redis-client-example.service.redis-service
  (:require [taoensso.carmine :as redis :refer (wcar)]))

;Redis connection setting
(def server1-conn {:pool {} :spec {:host "127.0.0.1" :port 6379}})
(defmacro redis-conn* [& body] `(redis/wcar server1-conn ~@body))

(defn set
  "set to redis"
  [value]
  (redis-conn*
    (redis/set "name" value)))