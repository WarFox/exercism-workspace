(ns nucleotide-count)

(defonce nucleotides {\A 0 \T 0 \G 0 \C 0})

(defn count-items
  [strand]
  (into nucleotides (frequencies strand)))

(defn count-of-nucleotide-in-strand
  [nucleotide strand]
  (or
   ((count-items strand) nucleotide)
   (throw (ex-info (format "%s is not a valid nucleotide." nucleotide) {}))))

(defn nucleotide-counts
  [strand]
  (select-keys
   (count-items strand)
   (keys nucleotides)))
