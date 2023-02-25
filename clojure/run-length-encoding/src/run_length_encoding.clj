(ns run-length-encoding)

(defn run-length-encode
  "Encodes a string with run-length-encoding"
  [plain-text]
  (->> plain-text
       (partition-by identity) ;; ((\a \a) (\b \b) (\d) (\c \c))
       (mapcat (juxt count first)) ;; (2 \a 2 \b 1 \d 2 \c)
       (filter #(not= 1 %)) ;; (2 \a 2 \b d 2 \c)
       (apply str)))

(defn- repeat-chars
  [[cnt chr]]
  (repeat (if (= cnt "") 1 (Integer/parseInt cnt)) chr))

(defn run-length-decode
  "Decodes a run-length-encoded string"
  [cipher-text]
  (->> cipher-text
       (re-seq #"(\d*)(\D)") ;; (["2a" "2" "a"] ["3a" "3" "a"])
       (map rest)
       (mapcat repeat-chars)
       (apply str)))
