(ns pig-latin
  (:require [clojure.string :as str]))

(def vowels #{\a \e \i \o \u})

(def treat-as-vowels #{"yt" "xr"})

(def treat-as-consonant #{"ch" "qu" "th"})

(defn translate-word
  [word]
  (cond
    (vowels (first word))
    (str word "ay")

    (treat-as-vowels (subs word 0 2))
    (str word "ay")

    (re-matches #".qu.*" word)
    (str (subs word 3) (subs word 0 3) "ay")

    (re-matches #"^thr.*" word)
    (str (subs word 3) (subs word 0 3) "ay")

    (treat-as-consonant (subs word 0 2))
    (str (subs word 2) (subs word 0 2) "ay")

    (and (== 2 (count word)) (= \y (second word)))
    (str (nth word 1) (nth word 0) "ay")

    ;; y or vowels followed by consonant cluster
    :else
    (when-let [[_ start end] (re-matches #"(.[^aeiouy]*)([aeiouy].*)" word)]
      (str end start "ay"))))

(defn translate
  [phrase]
  (str/join " " (map translate-word (str/split phrase #" "))))
