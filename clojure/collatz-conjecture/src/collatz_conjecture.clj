(ns collatz-conjecture)

(defn collatz
  [number]
  (loop
      [num number
       n   0]
    (cond
      (< num 1)
      (throw (Exception.))

      (= num 1)
      n

      (zero? (mod num 2))
      (recur (/ num 2)
             (inc n))

      :else
      (recur (inc (* 3 num))
             (inc n)))))
