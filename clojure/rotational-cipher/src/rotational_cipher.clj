(ns rotational-cipher)

(defn rotate-with-wrap
  "Rotate the given character by rot, with 'a' as the lowest character.
   The result is within [a a+26]"
  [ch rot a]
  (let [ascii (int ch)
        new-ascii (+ a (mod (+ rot (- ascii a))
                            26))]
    (char new-ascii)))

(defn rotate-char
  [ch rot]
  (if (Character/isLetter ch)
    (if (Character/isLowerCase ch)
      (rotate-with-wrap ch rot (int \a))
      (rotate-with-wrap ch rot (int \A)))
    ch))

(defn rotate
  [text rot]
  (apply str (map #(rotate-char %1 rot) text)))
