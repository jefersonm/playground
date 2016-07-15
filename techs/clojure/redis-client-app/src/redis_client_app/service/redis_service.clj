(ns redis-client-app.service.redis-service
  (:require [taoensso.carmine :as redis :refer (wcar)]))

;Redis connection setting
(def server1-conn {:pool {} :spec {:host "127.0.0.1" :port 6379}})
(defmacro redis-conn* [& body] `(redis/wcar server1-conn ~@body))

(defn set-to-redis
  "set to redis"
  [key value]
  (redis-conn*
    (redis/set key value)))

(defn get-from-redis
  "get from redis"
  [key]
  (redis-conn*
    (redis/get key)))