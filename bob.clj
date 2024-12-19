(ns bob_responses
  :require [clojure.string :as str]))

(defn response_for 
  [sentence]
  (let [trimmed (str/trim sentence)
        letters-only (filter #(Character/isLetter %) trimmed ]

        (cond 
          (str/blank? sentence) "Fine. Be that way!"
          
