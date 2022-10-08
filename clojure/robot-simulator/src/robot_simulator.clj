(ns robot-simulator)

(defn robot
  [coordinates direction]
  {:bearing direction
   :coordinates coordinates})

(defn turn-right
  [direction]
  (get {:north :east
        :east :south
        :south :west
        :west :north}
       direction))

(defn turn-left
  [direction]
  (get {:north :west
        :east :north
        :south :east
        :west :south}
       direction))

(def advance
  {:north #(update % :y inc)
   :east #(update % :x inc)
   :south #(update % :y dec)
   :west #(update % :x dec)})

(defn- run-instruction
  [{:keys [bearing] :as robot} instruction]
  (condp = instruction
    \R (assoc robot :bearing (turn-right bearing))
    \L (assoc robot :bearing (turn-left bearing))
    \A (update robot :coordinates (advance bearing))))

(defn simulate
  [simulation robot]
  (loop [remaining simulation
         robbie robot]
    (if (empty? remaining)
      robbie
      (recur (rest remaining)
             (run-instruction robbie (first remaining))))))
