(ns raindrops)

(comment
 has 3 as a factor, add 'Pling' to the result.
has 5 as a factor, add 'Plang' to the result.
has 7 as a factor, add 'Plong' to the result.
does not have any of 3, 5, or 7 as a factor, the result should be the digits of the number.
 )

(defn convert [n]   
  (cond-> nil
    (zero? (mod n 3)) (str "Pling")
    (zero? (mod n 5)) (str "Plang")
    (zero? (mod n 7)) (str "Plong")
    :always (or (str n))))
