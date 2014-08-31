(ns atm-machine.core
  (:gen-class))


(defn withdraw
  "withdraw function"
  [money]
  (double (- 200.0 money)))

(defn -main
  "I don't do a whole lot ... yet."
  [& args]
  (println "Hello, World!")

  (withdraw 2.0) )
