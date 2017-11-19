(ns color-depth.prod
  (:require
    [color-depth.core :as core]))

;;ignore println statements in prod
(set! *print-fn* (fn [& _]))

(core/init!)
