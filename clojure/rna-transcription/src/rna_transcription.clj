(ns rna-transcription)

(def dna->rna
  {\C \G
   \G \C
   \A \U
   \T \A})

(defn translate
  [dna]
  (or
   (dna->rna dna)
   (throw (AssertionError.))))

(defn to-rna
  [dna]
  (apply str (map translate (seq dna))))
