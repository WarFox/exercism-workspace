(ns anagram
  (:require [clojure.string :as str]))

(defn anagram?
  [s1 s2]
  (or (= s1 s2)
      (= (sort s1) (sort s2))))

(defn anagrams-for [word prospect-list] ;; <- arglist goes here
  ;; your code goes here
  (filter (partial anagram? word) prospect-list))


(defn make-coffee
  "make cofee"
  []
  {})

(defn drink [coffee]
  (keep 1 coffee))

(let [coffee (make-coffee)]
  (while coffee
    (drink coffee)
    (when (empty? coffee)
      (refill! coffee))))

(defn refill!
  "refill"
  [coffee]
  (print "refilling"))
  ;; (concat [1 2 3] coffee))

(defn drink
  [coffee]
  (rest coffee))

(let [coffee [1 2 3 4 5]]
  (repeatedly #((when (empty? coffee)
                  (refill! coffee))
               drink coffee)))
