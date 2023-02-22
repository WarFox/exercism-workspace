(ns difference-of-squares)

(defn square [n]
  (* n n))

(defn numbers [n]
  (range 1 (inc n)))

(def sum (partial reduce +))

(defn sum-of-squares [n]
  ((comp sum (partial map square)) (numbers n)))

(defn square-of-sum [n]
  ((comp square sum) (numbers n)))

(defn difference [n]
  (-
   (square-of-sum n)
   (sum-of-squares n)))
