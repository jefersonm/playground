(ns atm-machine.core-test
  (:require [clojure.test :refer :all]
            [atm-machine.core :refer :all]))

(deftest deposit-test
	(def p1 (ref (struct account "Jeferson" 400)))
	(deposit p1 10)
	(is (= 410 (:value @p1))))

(deftest withdraw-test
	(def p1 (ref (struct account "Jeferson" 400)))
	(withdraw p1 10)
	(is (= 390 (:value @p1))))