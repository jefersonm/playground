(ns atm-machine.core-test
  (:require [clojure.test :refer :all]
            [atm-machine.core :refer :all]))

(deftest withdraw-test
	(testing "result of withdraw function")
		(is (= (withdraw 10.0) 190.0)))