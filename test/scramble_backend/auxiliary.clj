(ns scramble-backend.auxiliary
(:require
 [midje.sweet :refer :all]
 [scramble-backend.handler :refer [app]]
 [ring.adapter.jetty :refer [run-jetty]]
 [cheshire.core :as json]))


(def server (atom  nil))

(defn start-server [port]
  (swap! server
        (fn [_] (run-jetty app {:port port :join? false}))))

(defn stop-server []
  (.stop @server))

(def default-port 3001)

(defn default-address [route] (str "http://localhost:" default-port route))

(defn json-content [content]
  {:content-type :json
   :body (json/generate-string content)
   :throw-exceptions false})