(ns scramble-backend.libs.string-library
  (:require [clojure.string :as string]))


;;scramble?
;;Returns true if a portion of str1 characters can be rearranged to match str2 and vice versa, otherwise returns false
(defn scramble? [str1 str2]
  (if-not (some string/blank? [str1 str2])
    (let [s1 (frequencies (string/lower-case (string/replace str1 #"[^a-zA-Z ]" "")))
          s2 (frequencies (string/lower-case (string/replace str2 #"[^a-zA-Z ]" "")))]
      (= s2 (select-keys s2 (keys s1)))) ; checking if both the strings contains the same keys
    false))


