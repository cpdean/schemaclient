(ns schemaclient.views.common
  (:use [noir.core :only [defpartial]]
        [hiccup.page-helpers :only [include-css html5]]))

(defpartial nav-link
    [url text]
    [:li [:a {:href url} text]])

(defpartial navigation []
    [:ul {:id "navigation"}
        (nav-link "/planets" "Planets")
        (nav-link "/player" "Player Details")])
        
(defpartial layout [& content]
            (html5
              [:head
               [:title "schemaclient"]
               (include-css "/css/reset.css")]
              [:body
               [:div#wrapper
               (navigation)
                content]]))
