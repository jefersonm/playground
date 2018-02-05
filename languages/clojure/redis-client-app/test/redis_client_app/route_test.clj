(ns redis-client-app.route-test
  (:require [clojure.test :refer :all]
            [ring.mock.request :as mock]
            [redis-client-app.route.routes :refer :all]))

(deftest test-app
  (testing "main route"
    (let [response (app (mock/request :get "/"))]
      (is (= (:status response) 200))
      (is (= (:body response) "Welcome to Redis Client API"))))

  (testing "set to cache"
    (let [response (app (mock/request :post "/cache/" {:key "color" :value "blue"}))]
      (is (= (:status response) 200))
      (is (= (:body response) "{\"value\":\"blue\",\"desc\":\"blue Inserted to Redis Cache\"}"))))

  (testing "get from cache"
    (let [response (app (mock/request :get "/cache/color"))]
      (is (= (:status response) 200))
      (is (= (:body response) "{\"value\":\"color\",\"desc\":\"blue\"}"))))

  (testing "not-found route"
    (let [response (app (mock/request :get "/invalid"))]
      (is (= (:status response) 404)))))
