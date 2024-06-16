(ns user
  (:require
    [clojure.edn :as edn]
    [clojure.java.io :as io]
    [clojure.string :as str]
    [nextjournal.clerk :as clerk]))


(def config-path "notebook.edn")


(def default-config
  {:browse? false                                    
   :watch-paths ["notebook"]                        
   :show-filter-fn #(str/starts-with? % "notebook")
   :port 7777})


(def config
  (let [config
        (when (.exists (io/file config-path))
          (edn/read-string (slurp config-path)))]
    (merge default-config config)))


;; start Clerk's built-in webserver on the defined port
(clerk/serve! config)


;; Build a html file from the given notebook notebooks.
;; See the docstring for more options.
(comment
  (clerk/build! {:paths ["notebook/*"]
                 :out-path "public"}))

