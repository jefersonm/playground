(ns atm-machine.dojo
  (:gen-class))

(defn participants
	[people]
	(println "Participants:")
	(map (fn [key] (println (str key " - " (get people key)))) (keys people))

(defn -main
  	[& args]
  	def people = {:Jef 'CanvasBusinessModel :Humberto 'FP com linguagens não funcionais}
  	(participants people)