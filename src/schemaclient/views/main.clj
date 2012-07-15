(ns schemaclient.views.main
  (:require [schemaclient.views.common :as common]
            [schemaclient.models.db :as db])
  (:use
      hiccup.core
      [noir.core :only [defpage]]))

(defpage "/" []
         (common/layout
           [:p "Welcome to schemaclient"]
           [:p "This is an example of how to build your own schemaverse client using Noir on Clojure"]
           ))

(defpage "/planets" []
    (common/layout
        [:h1 "Here be planets"]
        [:ul
            (for [x (db/planets)]
                [:li x
                    (x :name)])]))

(defpage "/player" []
    (common/layout
    [:h1 "Player Details"]
    (let [p (db/my-player)]
        (list [:p "Player name: " (p :username)]
              [:p "Data dump:"]))))

