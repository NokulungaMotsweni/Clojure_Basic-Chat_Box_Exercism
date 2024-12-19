(ns bob_responses
  :require [clojure.string :as str]))

(defn response_for 
  [sentence]
  (let [trimmed (str/trim sentence)
        letters-only (filter #(Character/isLetter %) trimmed ]

;; Condition for the various responses that Bob will give.        
        (cond 
          ;; Bob's response to silense or combinations of various whitespace characters.
          (str/blank? sentence) "Fine. Be that way!"

          ;; Bob's response to anyone yelling at home which is all capital letters within the sentence.
          (and (= trimmed |(str/upper-case trimmed))
                (some #(Character/isLetter %) trimmed)) "Whoa, chill out!"
          
