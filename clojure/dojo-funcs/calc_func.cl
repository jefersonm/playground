(defn calc
	"Function that implement a simple calculator"
	[operation n1 n2]
	(if (= operation "+")
		(+ n1 n2)
		(if (= operation "-")
			(- n1 n2)
			(if (= operation "*")
				(* n1 n2)
				(if (= operation "/")
					(/ n1 n2)
				)
			)
		)
	)
)

(calc "+" 4 5)
;; 9
(calc "-" 5 1)
;; 4
(calc "*" 2 3)
;; 6
(calc "/" 27 3)
;; 9