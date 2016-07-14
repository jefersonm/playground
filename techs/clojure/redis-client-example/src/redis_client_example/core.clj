(ns redis-client-example.core
  (:use redis-client-example.redis.redis-service))

(defn -main
  []
  (set-redis "jeff2"))