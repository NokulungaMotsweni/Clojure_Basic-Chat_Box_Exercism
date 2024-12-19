(ns bob_responses
  :require [clojure.string :as str]))

(defn response_for 
  [sentence]
  (let [trimmed (str/trim s)]

;; Condition for the various responses that Bob will give.        
        (cond 
            ;; Bob's response to silense or combinations of various whitespace characters.
          (str/blank? sentence) "Fine. Be that way!"

                    ;; Bob's response to a question being yelled at him, where the sentence entails all capitals and a question mark at the end of the sentence.
        (and (last trimmed) "?")
            (= trimmed (str/upper-case trimmed))) "Calm down, I know what I'm doing!"

          ;; Bob's response to anyone yelling at home which is all capital letters within the sentence.
          (and (= trimmed |(str/upper-case trimmed))
                (some #(Character/isLetter %) trimmed)) "Whoa, chill out!"

         ;; Bob's response to sure where the sentence ends in a question mark.
          (= (last trimmed) \?) "Sure."
          
        )))
          
