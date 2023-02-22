(ns nth-prime)

(defn prime?
  "Returns true if given number is prime"
  [n]
  (loop [divisor 3]
    (cond
      (zero? (mod n 2))
      false

      ;; this works because be are checking odd numbers
      ;; (< (Math/sqrt n) divisor)
      (> (* divisor divisor) n)
      true

      (zero? (mod n divisor))
      false

      :else
      ;; we only check odd numbers,
      ;; we do not consider numbers divisble by 2
      (recur (+ divisor 2)))))

(defonce odd-numbers
  (iterate (partial + 2) 3))

(defonce primes
  (cons 2 (filter prime? odd-numbers)))

(defn nth-prime
  "Returns the prime number in the nth position."
  [n]
  (when (< n 1)
    (throw (IllegalArgumentException. "There is no zeroth prime")))
  (nth primes (dec n)))
