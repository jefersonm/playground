(ns clojure-ldc-2.car_tax
  (:use clojure.test)
)

(defstruct car :owner-name :car-type :cur-speed :licence-plate)
(defstruct taxed_car :owner-name :car-type :cur-speed :licence-plate :tax)

(defn car-tax [car-vec]
	(for [car car-vec]
		(if (= (car :cur-speed) 100)
			(apply merge car (assoc car :tax 10))
			(if (> (car :cur-speed) 100)
				(apply merge car (assoc car :tax (+ (* (- (:cur-speed car) 100) 20) 10)))
				(if (< (car :cur-speed) 100)
					(apply merge car (assoc car :tax 0))
				)		
			)
		)
	)
)

;;tests
(deftest car-speed-greater-than-100
	(def my_car (struct car "Jef" "Punto" 100 "IPJ2445"))
	(def my_taxed_car (car-tax [my_car]))
	(def expected_car [(struct taxed_car "Jef" "Punto" 100 "IPJ2445" 10)])
	(is (= expected_car my_taxed_car))
)

(deftest car-speed-less-than-100
	(def my_car (struct car "Jef" "Punto" 80 "IPJ2445"))
	(def my_taxed_car (car-tax [my_car]))
	(def expected_car [(struct taxed_car "Jef" "Punto" 80 "IPJ2445" 0)])
	(is (= expected_car my_taxed_car))
)

(run-tests)

