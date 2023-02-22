(ns complex-numbers)

(defn real
  [[a b]]
  a)

(defn imaginary
  [[a b]]
  b)

(defn abs
  [[a b]]
  (Math/sqrt (+ (* a a) (* b b))))

(defn conjugate [c]
  (update c 1 -))

(defn add [c1 c2]
  (map + c1 c2))

(defn sub [c1 c2]
  (map - c1 c2))

(defn mul [c1 c2]
  [(reduce - (map * c1 c2))
   (reduce + (map * (reverse c1) c2))])

(defn div [[a b :as c1] [c d :as c2]]
  (let [denominator (+
                     (* c c)
                     (* d d))]
    (map double
         [(/ (reduce + (map * c1 c2)) denominator)
          (/ (reduce - (map * (reverse c1) c2)) denominator)])))
