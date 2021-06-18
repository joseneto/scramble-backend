(ns scramble-backend.handler
  (:require [compojure.core :refer :all]
            [compojure.route :as route]
            [cheshire.core :as json]
            [scramble-backend.middleware :refer :all]
            [ring.middleware.defaults :refer [wrap-defaults api-defaults]]
            [ring.middleware.json :refer [wrap-json-body]]
            [scramble-backend.libs.string-library :refer :all]))

;;Help function to encode json body response
(defn encode-json	[content & [status]]
	 {:status (or status 200)
   :headers {"Content-Type" "application/json; charset=utf-8"}
   :body (json/generate-string	content)
   :throw-exceptions false})

(defroutes app-routes
  
  (POST "/scramble" request 
    (if (scramble? (:str1 (:body request)) (:str2 (:body request)))
        (encode-json {:message "Matched"}	200)
        (encode-json {:message "Not Matched"} 200)))
  
  (route/not-found "Not Found"))

(def app
  (-> (wrap-defaults app-routes api-defaults )
      (wrap-json-body {:keywords? true})
      (allow-cross-origin))) 
