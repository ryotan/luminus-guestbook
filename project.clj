(defproject
  luminus-guestbook
  "0.1.0-SNAPSHOT"
  :description
  "FIXME: write description"
  :ring
  {:handler luminus-guestbook.handler/app,
   :init luminus-guestbook.handler/init,
   :destroy luminus-guestbook.handler/destroy}
  :plugins
  [[lein-ring "0.8.10"] [lein-environ "0.5.0"]]
  :url
  "http://example.com/FIXME"
  :profiles
  {:uberjar {:aot :all},
   :production
   {:ring
    {:open-browser? false, :stacktraces? false, :auto-reload? false}},
   :dev
   {:dependencies [[ring-mock "0.1.5"] [ring/ring-devel "1.2.2"]],
    :env {:dev true}}}
  :dependencies
  [[log4j
    "1.2.17"
    :exclusions
    [javax.mail/mail
     javax.jms/jms
     com.sun.jdmk/jmxtools
     com.sun.jmx/jmxri]]
   [lib-noir "0.8.3"]
   [com.taoensso/timbre "3.2.1"]
   [korma "0.3.1"]
   [com.h2database/h2 "1.3.175"]
   [markdown-clj "0.9.44"]
   [environ "0.5.0"]
   [selmer "0.6.6"]
   [org.clojure/clojure "1.6.0"]
   [ring-server "0.3.1"]
   [com.taoensso/tower "2.0.2"]]
  :repl-options
  {:init-ns luminus-guestbook.repl}
  :min-lein-version "2.0.0")