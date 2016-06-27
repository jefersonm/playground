(ns hello-ring.core-test
  (:require [clojure.test :refer :all]
            [hello-ring.core :refer :all]))

(deftest test-server-remote-addr-information
  (testing "Test if remote address will be properly concat with ip-address string")
    (is (= (server-information {:remote-addr "192.168.0.1"}) "ip-address: 192.168.0.1")))
