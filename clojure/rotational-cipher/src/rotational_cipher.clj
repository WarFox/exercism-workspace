(ns rotational-cipher)

(defn rotate-with-wrap [letter rot z]
  (let [ascii (int letter)
        new-ascii (+ ascii (mod rot 26))]
    (char
     (if (> new-ascii z)
       (- new-ascii 26)
       new-ascii))))

(defn rotate-letter [letter rot]
  (if (Character/isLowerCase letter)
    (rotate-with-wrap letter rot (int \z))
    (rotate-with-wrap letter rot (int \Z))))

(defn rotate [text rot]
  (loop [remaining text
         acc       []]
    (if (empty? remaining)
      (apply str acc)
      (let [ch     (first remaining)
            new-ch (if (Character/isLetter ch)
                     (rotate-letter ch rot)
                     ch)]
        (recur (rest remaining) (conj acc new-ch))))))
