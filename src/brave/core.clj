(ns brave.core
  (:gen-class))

(defn -main
  "I don't do a whole lot ... yet."
  [& args]
  (println "Hello, World!"))

(defn cal-age
  [year-of-birth]
  (- 2021 year-of-birth))

(cal-age 1996)


(def renan (hash-map
  :name {:first-name  "Renan"
         :middle-name "Campos"
         :last-name   "Ribeiro"
         :full-name   (str (get-in renan [:name :first-name]) " "
                           (get-in renan [:name :middle-name]) " "
                           (get-in renan [:name :last-name]))}
  :year-of-birth 1996
  :age (cal-age (get renan :year-of-birth))))

(println renan)

(get-in renan [:name :full-name])

(renan :age)

(:age renan)

(:phone-number renan :not-informed)

