(defproject redis-client-app "0.1.0-SNAPSHOT"
  :description "Redis client APP"
  :url "http://example.com/FIXME"
  :min-lein-version "2.0.0"

  :main redis-client-app.core-application

  :dependencies [[org.clojure/clojure "1.8.0"]
                 [compojure "1.5.1"]

                 [com.taoensso/carmine "2.13.1"]

                 [ring/ring-defaults "0.2.1"]
                 [ring/ring-jetty-adapter "1.4.0"]
                 [ring/ring-json "0.4.0"]]

  :plugins [[lein-ring "0.9.7"]]

  :ring {:handler redis-client-app.handler/app}

  :profiles
  {:dev {:dependencies [[javax.servlet/servlet-api "2.5"]
                        [ring/ring-mock "0.3.0"]]}})
