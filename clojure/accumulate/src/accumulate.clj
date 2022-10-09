(ns accumulate)

(defn accumulate
  "f  is a function, coll is collection"
  [f coll]
  (loop [remaining coll
         acc []]
    (if (empty? remaining)
      acc
      (recur (rest remaining) (conj acc (f (first remaining)))))))
