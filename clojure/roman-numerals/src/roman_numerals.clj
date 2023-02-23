(ns roman-numerals)

;; Algorithms available https://medium.com/@tomas.langkaas/eight-algorithms-for-roman-numerals-b06c83db12dd

;; Method 1: Using algorithm similar to Coin Change
(def numbers->numerals
  [[1  "I"]
   [4 "IV"]
   [5 "V"]
   [9 "IX"]
   [10 "X"]
   [40 "XL"]
   [50 "L"]
   [90 "XC"]
   [100 "C"]
   [400 "CD"]
   [500 "D"]
   [900 "CM"]
   [1000 "M"]])

(defn closest-numeral
  "Returns the biggest known Roman numeral less than or equal to n"
  [n]
  (last
   (for [[k _] numbers->numerals :when (<= k n)]
     [k _])))

(defn numeral-seq
  "Returns a lazy seq of Roman numeral strings"
  [n]
  (when (>= n 1)
    (lazy-seq (let [[number numeral] (closest-numeral n)]
                (cons numeral (numeral-seq (- n number)))))))

(defn to-roman
  "Returns the Roman numeral string representation of n"
  [n]
  (apply str (numeral-seq n)))

;; Method 2: Using lookup table for 1s, 10s, 100s and 1000s
(def ones ["" "I" "II" "III" "IV" "V" "VI" "VII" "VIII" "IX"])
(def tens ["" "X" "XX" "XXX" "XL" "L" "LX" "LXX" "LXXX" "XC"])
(def hundreds ["" "C" "CC" "CCC" "CD" "D" "DC" "DCC" "DCCC" "CM"])
(def thousands ["" "M" "MM" "MMM"])

(defn to-roman-2
  [n]
  (str (thousands (quot n 1000)) ;; quotient of n divided by 1000
       (hundreds (quot (mod n 1000) 100))
       (tens (quot (mod n 100) 10))
       (ones (mod n 10))))

(defn numerals [n]
  (to-roman-2 n))

(to-roman-2 200)
