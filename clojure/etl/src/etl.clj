(ns etl
  (:require [clojure.string :as str]))

(defn word-scores
  "Convert {1 {\"APPLE\" \"BOAT\"}}, [\"apple\" 1 \"board\" 1]"
  [source]
  (mapcat
   (fn [[score words]]
     (for [word words] [(str/lower-case word) score]))
   source))

(defn transform
  [source]
  (into {} (word-scores source)))
