(ns cars-assemble)

(defonce rate-per-hour 221.0)

(defn success-rate
  [speed]
  (cond
    (zero? speed)
    0.0

    (<= speed 4)
    1

    (<= speed 8)
    (/ 90 100)

    (= speed 9)
    (/ 80 100)

    (= speed 10)
    (/ 77 100)))
  

(defn production-rate
  "Returns the assembly line's production rate per hour,
   taking into account its success rate"
  [speed]
  (* speed rate-per-hour (success-rate speed)))

(defn working-items
  "Calculates how many working cars are produced per minute"
  [speed]
  (int (/ (production-rate speed) 60)))

