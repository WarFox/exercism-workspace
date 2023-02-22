(ns protein-translation)

(defn translate-codon
  [codon]
  (case codon
    "AUG"
    "Methionine"

    ("UUU" "UUC")
    "Phenylalanine"

    ("UUA" "UUG")
    "Leucine"

    ("UCU" "UCC" "UCA" "UCG")
    "Serine"

    ("UAU" "UAC")
    "Tyrosine"

    ("UGU" "UGC")
    "Cysteine"

    "UGG"
    "Tryptophan"

    ("UAA" "UAG" "UGA")
    "STOP"))

(defn ->codons
  [rna]
  (re-seq #".{3}" rna))

(defn translate-rna
  [rna]
  (->> (->codons rna)
       (map translate-codon)
       (take-while #(not= "STOP" %))))
