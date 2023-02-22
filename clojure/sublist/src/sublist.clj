(ns sublist)

(defn sublist? 
  "check list1 is sublist of list2"
  [list1 list2]
  ;; check if list1 exists in list2 with partitioned by size of list1
  ;; step by 1 so that we get all. partitinos
  (some #{list1} (partition (count list1) 1 list2)))

(defn classify [list1 list2]
  (cond 
    (= list1 list2) :equal
    (sublist? list1 list2) :sublist
    (sublist? list2 list1) :superlist
    :else :unequal))

;;(partition 3 1 [0 1 2 3 1 2 5 6])
;;((0 1 2) (1 2 3) (2 3 1) (3 1 2) (1 2 5) (2 5 6))
