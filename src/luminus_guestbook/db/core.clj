(ns luminus-guestbook.db.core
  (:use korma.core
        [korma.db :only (defdb)])
  (:require [luminus-guestbook.db.schema :as schema]))

(defdb db schema/db-spec)

(defentity guestbook)

(defn create-user [user]
  (insert users
          (values user)))

(defn update-user [id first-name last-name email]
  (update users
  (set-fields {:first_name first-name
               :last_name last-name
               :email email})
  (where {:id id})))

(defn get-user [id]
  (first (select users
                 (where {:id id})
                 (limit 1))))

(defn save-message
  [name message]
  (insert guestbook
          (values {:name name
                   :messge message
                   :timestamp (new java.util.Date)})))

(defn get-messages
  []
  (select guestbook))
