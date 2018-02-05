(defproject
  guestbook2
  "0.1.0-SNAPSHOT"
  :description
  "FIXME: write description"
  :ring
  {:handler guestbook2.handler/app,
   :init guestbook2.handler/init,
   :destroy guestbook2.handler/destroy}
  :ragtime
  {:migrations ragtime.sql.files/migrations,
   :database
   "jdbc:postgresql://localhost/guestbook2?user=db_user_name_here&password=db_user_password_here"}
  :plugins
  [[lein-ring "0.8.10"]
   [lein-environ "0.5.0"]
   [ragtime/ragtime.lein "0.3.6"]]
  :url
  "http://example.com/FIXME"
  :profiles
  {:uberjar {:aot :all},
   :production
   {:ring
    {:open-browser? false, :stacktraces? false, :auto-reload? false}},
   :dev
   {:dependencies
    [[ring-mock "0.1.5"]
     [ring/ring-devel "1.3.0"]
     [pjstadig/humane-test-output "0.6.0"]],
    :injections
    [(require 'pjstadig.humane-test-output)
     (pjstadig.humane-test-output/activate!)],
    :env {:dev true}}}
  :jvm-opts
  ["-server"]
  :dependencies
  [[selmer "0.6.9"]
   [prone "0.4.0"]
   [log4j
    "1.2.17"
    :exclusions
    [javax.mail/mail
     javax.jms/jms
     com.sun.jdmk/jmxtools
     com.sun.jmx/jmxri]]
   [lib-noir "0.8.6"]
   [com.taoensso/timbre "3.2.1"]
   [markdown-clj "0.9.47"]
   [noir-exception "0.2.2"]
   [im.chit/cronj "1.0.1"]
   [environ "0.5.0"]
   [korma "0.3.3"]
   [org.clojure/clojure "1.6.0"]
   [ring-server "0.3.1"]
   [postgresql/postgresql "9.1-901-1.jdbc4"]
   [com.taoensso/tower "2.0.2"]
   [ragtime "0.3.6"]]
  :repl-options
  {:init-ns guestbook2.repl}
  :min-lein-version "2.0.0")