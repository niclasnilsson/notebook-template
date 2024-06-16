;; # Example Notebook
;;
;; This is a paragraph.

^{:nextjournal.clerk/visibility {:code :hide}}
(ns example
  {:clj-kondo/ignore [:missing-docstring
                      :namespace-name-mismatch
                      :redefined-var]
   :nextjournal.clerk/visibility {:result :show}
   :nextjournal.clerk/toc true})


;; ## Code example

;; Here is some code:

(map inc (range 100))


