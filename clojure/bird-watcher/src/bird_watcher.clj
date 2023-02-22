(ns bird-watcher)

(def last-week [0 2 5 3 7 8 4])

(defn today [birds]
  (last birds))

(defn inc-bird [birds]
  (conj (pop birds) (inc (last birds))))

(defn day-without-birds? [birds]
  (not (empty? (filter zero? birds))))

(defn n-days-count [birds n]  
  (reduce + (take n birds)))

(defn- busy? 
  [d]
  (>= d 5))

(defn busy-days [birds]
  (count (filter busy? birds)))

(def odd-pattern [1 0 1 0 1 0 1])

(defn odd-week? [birds]
  (= odd-pattern birds))
