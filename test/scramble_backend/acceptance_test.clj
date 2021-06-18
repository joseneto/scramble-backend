(ns scramble-backend.acceptance-test
(:require
 [midje.sweet :refer :all]
 [clj-http.client :as http]
 [cheshire.core :as json]
 [scramble-backend.auxiliary :refer :all]))

(against-background [(before :facts [(start-server default-port)])
                     (after :facts  (stop-server))]

                    (fact "post to scramble router" :acceptance
                          (let [response
                                (http/post (default-address "/scramble") (json-content {:str1 "rekqodlw" :str2 "world"}))]

                            (:status response) => 200))

                    (fact "post to scramble router missing text" :acceptance
                          (let [response
                                (http/post (default-address "/scramble") (json-content {}))]

                            (:status response) => 200))

                    (fact "post to scramble invalid router name" :acceptance
                          (let [response
                                (http/post (default-address "/scrambler") (json-content {:str1 "rekqodlw" :str2 "world"}))]

                            (:status response) => 404))

                    (fact "post matched strings" :acceptance
                          (json/parse-string (:body (http/post (default-address "/scramble")
                                                               (json-content {:str1 "rekqodlw" :str2 "world"})))) =>  {"message" "Matched"})

                    (fact "post unmatched strings" :acceptance
                          (json/parse-string (:body (http/post (default-address "/scramble")
                                                               (json-content {:str1 "katas" :str2 "steak"})))) =>  {"message" "Not Matched"}))
