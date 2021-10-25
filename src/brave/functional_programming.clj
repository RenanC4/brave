(ns brave.functional-programming)
(require '[clojure.string :as s])


;; pure functions
;; referential transparent
;; can't cause any side-effect
(+ 1 2)

(defn wisdom
  [words]
  (str words ", Daniel San"))

(wisdom "Patience is the key")
(wisdom "Always bathe on fridays")

;; unpure functions

(defn year-ed-evaluation
  []
  (if (> (rand) 0.5)
    "You get a raise!"
    "Better luck next year!"))

(year-ed-evaluation)

(def great-baby-name "Rosanthony")
great-baby-name

(let  [great-baby-name "Bloodthunder"]
  great-baby-name)
great-baby-name

(defn sum
  ([vals]
   (sum vals 0))
  ([vals accumulating-total]
   (if (empty? vals)
     accumulating-total
     (recur (rest vals) (+ (first vals) accumulating-total)))))

(sum [39 5 1])


;;function composition
;;instead of create a big function, break the logic in smaller and simpler functions and compose it
(defn clean
  [text]
  (s/replace (s/trim text) #"lol" "LOL"))

(clean "cuca beludo lol!          ")

;; composing using comp
((comp inc *) 2 3)

(def character
  {:name "Cuca Beludo the brave"
   :attributes {:intelligence 10
                :strength 9
                :dexterity 3}})

(def c-int (comp :intelligence :attributes))
(def c-str (comp :strength :attributes))
(def c-dex (comp :dexterity :attributes))

(get-in character [:attributes :intelligence ])

(c-int character)
(c-str character)
(c-dex character)

(defn level-up
  [char skill]
  (let [level-up-char
        (assoc-in char [:attributes skill]
                  (+ 1 (get-in char [:attributes skill])))]
    level-up-char))

(level-up character :dexterity)

(defn level-up-2
  [char skill]
  (assoc-in char [:attributes skill]
            (+ 1 (get-in char [:attributes skill]))))

(level-up-2 character :dexterity)

(defn level-up-3
  [char skill]
  (assoc-in char [:attributes skill]
            (inc (get-in char [:attributes skill]))))

(level-up-3 character :dexterity)


