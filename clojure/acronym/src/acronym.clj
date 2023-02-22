(ns acronym
  (:require [clojure.string :as str]))

(defn tokenise
  "Tokenise the phrase with all words and capitalised words, removes non alphabetic characters. [A-Z]+[a-z]* => Start with capital letter, followed by small letters. w+ => non white space characters"
  [phrase]
  (re-seq #"[A-Z]+[a-z]*|\w+" phrase))

(defn acronym
  "Converts phrase to its acronym."
  [phrase]        
  (->> phrase
    tokenise
    (map (comp first str/upper-case))
    str/join ))  