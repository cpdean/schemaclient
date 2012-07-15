(ns schemaclient.models.db
    (require
    [clojure.java.jdbc :as sql]))

(def db (System/getenv "DATABASE_URL"))

(defn query
    "Executes the sql-string, returning a vector of maps as the results"
    [sql-string]
    (sql/with-connection db
        (sql/with-query-results r
            [sql-string]
            (into [] r))))

(defn planets
    "returns list of all planets"
    []
    (query "select * from planets limit 20"))

(defn my-player
    "returns map of current player data"
    []
    (first
        (query "SELECT * FROM my_player")))
