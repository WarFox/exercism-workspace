(ns robot-name)

(def letters (map char (range (int \A) (inc (int \Z)))))

(def numbers (range 100 1000))

(defn- gen-name [] (str
                    (rand-nth letters)
                    (rand-nth letters)
                    (rand-nth numbers)))

(def names-db
  "Atom for holding used names"
  (atom #{}))

(defn unique-name
  []
  (let [uname (first
               (filter
                #(not (@names-db %)) ;; get first name that is not in names-db
                (repeatedly gen-name)))]
    (swap! names-db conj uname) ;; add name to names-db
    uname))

(defn robot []
  (atom
   {:name (unique-name)}))

(defn robot-name
  [robot]
  (:name @robot))

(defn reset-name
  [robot]
  (swap! robot assoc :name (unique-name)))
