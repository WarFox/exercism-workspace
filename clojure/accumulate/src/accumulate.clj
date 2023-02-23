(ns accumulate)

(defn accumulate
  "f  is a function, coll is collection"
  [f coll]
  (loop [collection (seq coll)
         acc []]
    (if-let [[elem & remaining] collection]
      (recur remaining (conj acc (f elem)))
      acc)))
