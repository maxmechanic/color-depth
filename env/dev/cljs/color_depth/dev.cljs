(ns ^:figwheel-no-load color-depth.dev
  (:require
    [color-depth.core :as core]
    [devtools.core :as devtools]))


(enable-console-print!)

(devtools/install!)

(core/init!)
