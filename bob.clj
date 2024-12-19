(ns bob_responses
  :require [clojure.string :as str]))

(defn response-for 
  [sentence]
  (let [trimmed_sentence (clojure.string/trim sentence)]
  
    (cond 
      ;; Bob's response to silense or combinations of various whitespace characters.
      (clojure.string/blank? trimmed_sentence) "Fine. Be that way!"

      ;; Bob's response to a question being yelled at him, where the sentence entails all capitals and a question mark at the end of the sentence.
      (and (= (last trimmed_sentence) \?)
           (= trimmed_sentence (str/upper-case trimmed_sentence))
           (some #(Character/isLetter %) trimmed_sentence)) "Calm down, I know what I'm doing!"

      ;; Bob's response to anyone yelling at home which is all capital letters within the sentence.
      (and (= trimmed_sentence (clojure.string/upper-case trimmed_sentence))
           (some #(Character/isLetter %) trimmed_sentence)) "Whoa, chill out!"

     ;; Bob's response to sure where the sentence ends in a question mark.
      (= (last trimmed_sentence) \?) "Sure."

      ;; Default response for anything else.
      :else "Whatever."
    ))
  )

          
