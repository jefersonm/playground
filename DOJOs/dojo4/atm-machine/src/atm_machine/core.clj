(ns atm-machine.core
  (:gen-class))

(defstruct account :name :value)

(defn deposit [account amount]
	(dosync
		(alter account assoc :value (+ (:value @account) amount))))

(defn withdraw [account amount]
	(dosync
		(alter account assoc :value (- (:value @account) amount))))


(defn -main
  "I don't do a whole lot ... yet."
  [& args]
  (println "Hello, World!"))
