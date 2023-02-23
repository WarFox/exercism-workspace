(ns armstrong-numbers)

(defn- power-of
  [num pow]
  (apply * (repeat pow num)))

(defn- ->digits
  "Returns list of digits in a number"
  [num]
  (loop [acc []
         n   num]
    (if (< n 10)
      (conj acc n)
      (recur (conj acc (mod n 10))
             (quot n 10)))))

(defn- armstrong
  "Returns sum of each digit to the power of number of digits"
  [num]
  (let [digits (->digits num)]
    (reduce
     #(+ %1 (power-of %2 (count digits)))
     0
     digits)))

(defn armstrong?
  [num]
  (= num
     (armstrong num)))
