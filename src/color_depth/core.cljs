(ns color-depth.core
  (:require
   [reagent.core :as r]
   [clojure.string :as string]
   [goog.string :as googstring]
   [goog.string.format]
   [goog.color :as color]))

(defn update-color [state updated-color]
  (try
    (let [new-color (color/parse updated-color)]
      (swap! state merge {:color (.-hex new-color)
                          :valid-color? true
                          :color-input updated-color}))
    (catch js/Object e (swap! state merge {:valid-color? false
                                           :color-input updated-color}))))

(defn format-table [color]
  [:table {:style {:background-color "rgba(255,255,255,0.45)"
                   :padding "1rem"
                   :font-size "1.35rem"}}
   [:thead
    [:th]
    [:th]]
   [:tbody
    [:tr
     [:td [:pre "hex:"]]
     [:td
      [:pre color]]]
    [:tr
     [:td [:pre "rgb:"]]
     [:td
      [:pre (string/join ", " (color/hexToRgb color))]]]
    [:tr
     [:td [:pre "rgb:"]]
     [:td
      [:pre (string/join ", " (map #(googstring/format "%.2f" (/ % 255)) (color/hexToRgb color)))]]]
    [:tr
     [:td [:pre "hsv:"]]
     [:td
      [:pre (string/join ", " (color/hexToHsv color))]]]
    [:tr
     [:td [:pre "hsl:"]]
     [:td
      [:pre (string/join ", "  (color/hexToHsl color))]]]]])

(defn color-facts [color]
  [format-table color])

(defn color-input [state]
  (let [color-input (:color-input @state)
        handle-change (partial update-color state)]
    [:input {:type "text"
             :value color-input
             :placeholder "enter color name/hex/rgb"
             :style {:margin "5rem"
                     :padding "0.5rem"
                     :font-size "120%"}
             :on-change #(-> % .-target .-value (handle-change))}]))

(defn root [state]
  (let [state (r/atom {:color-input ""})]
    (fn []
      [:div {:style {:position "absolute"
                     :width "100%"
                     :height "100%"
                     :top 0
                     :left 0
                     :display "flex"
                     :flex-direction "column"
                     :align-items "center"
                     :background-color (if (:valid-color? @state)
                                         (:color @state)
                                         "transparent")}}
       [color-input state]
       (if (:valid-color? @state)
         [color-facts (:color @state)])])))

(defn mount-root []
  (r/render [root] (.getElementById js/document "app")))

(defn init! []
  (mount-root))
