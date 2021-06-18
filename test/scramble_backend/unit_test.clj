(ns scramble-backend.unit-test
  (:require [midje.sweet :refer :all]
            [scramble-backend.libs.string-library :refer :all]))

(facts "String library"  :unit
       
       (fact "Scramble strings matched" 
             (scramble? "rekqodlw" "world") => true)
       
       (fact "Scramble strings not matched"
             (scramble? "katas" "steak") => false)
       
       (fact "Scramble strings null argument"
             (scramble? nil "steak") => false)
       
       (fact "Scramble strings empty argument"
             (scramble? " " " ") => false))
