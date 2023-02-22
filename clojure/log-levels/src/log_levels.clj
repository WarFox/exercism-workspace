(ns log-levels
  (:require [clojure.string :as str]))

(defn- parts 
  [s]
  (let [[level message] (str/split s #":")]
      {:log-level (-> level (str/replace #"\[|\]" "") str/lower-case)
      :message (-> message (str/trim))}))

(defn message
  "Takes a string representing a log line
   and returns its message with whitespace trimmed."
  [s]
  (:message (parts s)))

(defn log-level
  "Takes a string representing a log line
   and returns its level in lower-case."
  [s]
  (:log-level (parts s)))

(defn reformat
  "Takes a string representing a log line and formats it
   with the message first and the log level in parentheses."
  [s]
  (format "%s (%s)" (message s) (log-level s)))
