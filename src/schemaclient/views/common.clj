(ns schemaclient.views.common
  (:use [noir.core :only [defpartial]]
        [hiccup.page-helpers :only [include-css html5]]))

(defpartial nav-link
    [url text]
    [:li [:a {:href url} text]])

(def nav-links
{
     "/planets" "Planets"
     "/player" "Player Details"
     "/actions" "Actions..."
})

(defpartial navigation []
    [:ul {:id "navigation"}
        (for [[k v] nav-links] (nav-link k v))])
        
(defpartial layout [& content]
            (html5
              [:head
               [:title "schemaclient"]
               (include-css "/css/reset.css")
               (include-css "/css/style.css")]
              [:body
               [:div#wrapper
               (navigation)
                content]]))
