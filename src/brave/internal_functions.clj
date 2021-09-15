(ns brave.internal-functions)

(defn titlelize
  [cap]
  (str cap " for the brave and true"))

(titlelize "batata")

(map titlelize ["Choppe" "chop" "chopper"])

(map titlelize '("list" "list" "list"))

(map #(titlelize (second %)) {:unconfortable-thing "Winking"})


(cons :zero ["a" "b" :c])
(cons :zero '("a" "b" :c))
(cons :zero {"a" "b" :c :c})

(seq [1 2 3 4 7 5])
(seq '(1 2 3 4 7 5))
(seq {:a [1 2 3] :b :b 1 2})
(seq #{1 2 4 3})

(into {}
      (seq {:a [1 2 3] :b :b 1 2}))

(map str ["a" "b" "c" "d"] ["A" "B" "C" 0])

(def human-consumption [8.1 7.2 6.6 5.0])
(def critter-consumption [0.0 0.2 0.3 1.1])

(defn unify-diet-data
  [human critter]
  {:human   human
   :critter critter})

(unify-diet-data human-consumption critter-consumption)

(map unify-diet-data human-consumption critter-consumption)

(def sum #(reduce + %))
(def avg #(/ (sum %) (count %)))
(defn stats
  [numbers]
  (map #(% numbers) [sum count avg]))

(stats [3 4 10])

(def indentities
  [{:alias "Batman" :real "Bruce Wayne"}
   {:alias "Miranha" :real "Peter Parker"}
   {:alias "Santa" :real "Your Mom"}])

(map :real indentities)

(reduce (fn [new-map [key val]]
          (assoc new-map key (inc val)))
        {}
        {:max 30 :min 10})

(reduce (fn [new-map [key val]]
          (if (> val 18)
            (assoc new-map key "can drive")
            new-map))
        {}
        {:Renan 25 :Lorena 2})

(take 2 [1 2 3 4])
(drop 2 [1 2 3 4])

(sort [3 2 1 4])

(sort-by count ["1" "22" "4444" "333"])

(concat [1 2] [3 4])

(def mapper-boladao
  {:first-name    "Renan"
   :middle-name   "Campos"
   :last-name     "Ribeiro"
   :age           nil
   :year-of-birth 1996
   :parens        {:mom "Sirlene"}})

(assoc mapper-boladao :first-name "Naner"
                      :middle-name :Campos
                      :age (- 2021 (mapper-boladao :year-of-birth)))

(dissoc mapper-boladao :first-name)

(get-in mapper-boladao [:parens])

(concat (take 8 (repeat "na")) ["Batman!"])

(take 3 (repeatedly (fn [] (rand-int 10))))

(defn even-numbers
  ([] (even-numbers 0))
  ([n] (cons n (lazy-seq (even-numbers (+ n 2))))))

(take 10 (even-numbers))

(empty? [])
(empty? [:no!])
(empty? [nil])


(into {} (map identity {:sunlight-reaction "Glitter"}))

(map identity [:garlic :sesame-oil :fried-eggs])
(into () (map identity [:garlic :sesame-oil :fried-eggs]))

(into #{} (map identity [:banana-bread :banana-bread]))

(into {:favorite-emotion "Gloomy"} [[:sunlight-reaction "Glitter"]])

(into ["cherry"] '("pine" "pruce"))

(into {:favorite-animal "dog"} {:favorite-food "panqueca" :favorite-dessert "ice cream"})

(conj [0] [1])

(into [0] [1])

(conj [0] 1)

(conj [0] 1 2 3 4 5 6)

(conj {:ue "2"} {:ue "1"})

(conj {:time "Midnight"} [:place "neverland"] {:batata "potato"})

(defn my-conj
  [target & additions]
  (into target additions))

(my-conj [0] 1 2 3 4)

(max 102 3 4 55)

(max [1 2 3])

(apply max [1 2 3])

(defn my-into
  [target additions]
  (apply conj target additions))

(my-into [1] [2 4])

(def add11 (partial + 11))

(add11 12)

(def add-missing-elements
  (partial conj ["water" "earth" "air"]))

(add-missing-elements "fire")