(ns ldc.clojure.bank)

(defstruct account :name :value)

(defn bank-deposit [account amount]
  	(dosync 
		(alter account assoc :value (+ amount (:value @account)))
	)
)

(defn bank-withdraw [account amount]
  	(dosync 
		(alter account assoc :value (- (:value @account) amount))
	)
)

(defn bank-assessment [account]
  	(str "Account: " (:name account) " Amount: " (:value account))
)
 
(defn bank-transfer [acc1 acc2 value]
	(bank-deposit acc2 value)
	(bank-withdraw acc1 value)
)

(use 'clojure.test)

(deftest deposit
  	(def ac1 (ref (struct account "Jeferson" 400)))
  	(bank-deposit ac1 10)
  	(is (= 410 (:value @ac1)))
)

(deftest withdraw
  	(def ac1 (ref (struct account "Jeferson" 400)))
  	(bank-withdraw ac1 10)
  	(is (= (struct account "Jeferson" 390) @ac1))
)

(deftest assessment
  	(def ac1 (struct account "Jeferson" 400))
  	(is (= "Account: Jeferson Amount: 400" (bank-assessment ac1)))
)

(deftest transfer
	(def acc1 (ref (struct account "Poletto" 1000)))
	(def acc2 (ref (struct account "Jeferson" 600)))
	(bank-transfer acc1 acc2 500)
  	(is (= 1100 (:value @acc2)))
	(is (= 500 (:value @acc1)))
)

(run-tests 'ldc.clojure.bank)