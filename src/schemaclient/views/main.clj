(ns schemaclient.views.main
  (:require [schemaclient.views.common :as common]
            [schemaclient.models.db :as db])
  (:use
      hiccup.core
      [noir.core :only [defpage]]))

(defn table-header
    [colnames]
    [:tr
        (map (fn [n] [:th n]) colnames)])

(defn table-row
    [colnames data-map]
    [:tr
        (map (fn [n] [:td (data-map n)]) colnames)])

(defn expand-to-table
 [table-data]
 (let [colnames (keys (first table-data))]
     (html
        [:table {:class "data-table"}
            (table-header colnames)
            (map (fn [row] (table-row colnames row))
                 table-data)])))

(defpage "/" []
         (common/layout
           [:p "Welcome to schemaclient"]
           [:p "This is an example of how to build your own schemaverse client using Noir on Clojure"]
           ))

(defpage "/planets" []
    (common/layout
        (let [planets (db/planets)]
        (list
        [:h1 (format "Here are the first %s planets"(count planets))]
        (expand-to-table planets)))))

(defpage "/player" []
    (common/layout
    [:h1 "Player Details"]
    (let [p (db/my-player)]
        (list [:p "Player name: " ((first p) :username)]
              (expand-to-table p)))))

