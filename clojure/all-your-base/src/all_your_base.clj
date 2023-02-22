(ns all-your-base)

;; https://cs.stackexchange.com/questions/10318/the-math-behind-converting-from-any-base-to-any-base-without-going-through-base

(defn base-x
  "Convert list of numbers to base b representation"
  [numbers b]
  (reduce
   (fn [acc n]
     (+ (* acc b)  n))
   0
   numbers))

(defn to-digits
  "Convert a positive number n to its digit representation in base b."
  [number b]
  (loop [n number
         acc '()]
    (if (<= n 1)
      (if (zero? n) acc (conj acc n))
      (recur
       (quot n b);; quotient
       (conj acc (mod n b))))))

(defn convert
  "a from base, numbers sequence of numbers, b to base"
  [in-base numbers out-base]
  (cond
    (or (< in-base 2) (< out-base 2))
    nil

    (some neg? numbers)
    nil

    (empty? numbers)
    []

    (every? zero? numbers)
    [0]

    (some #(>= %1 in-base) numbers)
    nil

    :else
    (to-digits (base-x numbers in-base) out-base)))
