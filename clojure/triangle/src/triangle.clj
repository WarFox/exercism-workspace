(ns triangle)

(defn is-valid?
  [x y z]
  (let [[x y z] (sort [x y z])]
    (and (pos? x)
         (<= z (+ x y)))))

;; An equilateral triangle has all three sides the same length.
(defn equilateral?
  [x y z]
  (and (is-valid? x y z)
       (= x y z)))

;; An isosceles triangle has at least two sides the same length.
(defn isosceles?
  [x y z]
  (and (is-valid? x y z)
       (< (count (set [x y z])) 3)))

;; A scalene triangle has all sides of different lengths.
(defn scalene?
  [x y z]
  (and (is-valid? x y z)
       (not (isosceles? x y z))))
