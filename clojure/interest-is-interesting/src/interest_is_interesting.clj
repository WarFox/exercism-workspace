(ns interest-is-interesting)

(defn interest-rate
  "Returns interest rate based on the balance"
  [balance]
  (cond
    (< balance 0) -3.213
    (< balance 1000) 0.5
    (< balance 5000) 1.621
    :else 2.475))

(defn- interest
  [balance]
  (* 
   1/100
    (bigdec (Math/abs (interest-rate balance)))))
       

(defn annual-balance-update
  "Adds interest rate to balance"
  [balance]      
    (+ balance
     (* balance
        (interest balance))))  

(defn amount-to-donate
  "Donation amount"
  [balance tax-free-percentage]
  (cond
    (pos? balance)(int (* 2 (* 1/100 balance tax-free-percentage)))
    :else 0))
