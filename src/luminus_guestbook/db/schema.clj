(ns luminus-guestbook.db.schema
  (:require [clojure.java.jdbc :as sql]
            [noir.io :as io]))

(def db-store "site.db")

(def db-spec {:classname "org.h2.Driver"
              :subprotocol "h2"
              :subname (str (io/resource-path) db-store)
              :user "sa"
              :password ""
              :make-pool? true
              :naming {:keys clojure.string/lower-case
                       :fields clojure.string/upper-case}})
(defn initialized?
  "checks to see if the database schema is present"
  []
  (.exists (new java.io.File (str (io/resource-path) db-store ".h2.db"))))

(defn create-guestbook-table []
  (sql/db-do-commands
    db-spec
    (sql/create-table-ddl
      :guestbook
      [:id "integer primary key auto_increment"]
      [:timestamp :timestamp]
      [:name "varchar(30)"]
      [:message "varchar(200)"]))
  (sql/db-do-prepared
    db-spec
    "create index timestamp_index on guestbook(timestamp)"))

(defn create-tables
  "creates the database tables used by the application"
  []
  (create-guestbook-table))
