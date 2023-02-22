(ns bob
  (:require [clojure.string :as str]))

(defn question?
  [s]
  (str/ends-with? s "?"))

(defn has-letter?
  [s]
  (some #(Character/isLetter %) s))

(defn yelling?
  [s]
  (and
   (has-letter? s)
   (= s (str/upper-case s))))

(defn yelling-question?
  [s]
  (and (yelling? s) (question? s)))

(defn response-for [s] 
    (condp apply [(str/trim s)]
      str/blank? "Fine. Be that way!"  
      yelling-question? "Calm down, I know what I'm doing!"
      question? "Sure."
      yelling? "Whoa, chill out!"    
      "Whatever."))
