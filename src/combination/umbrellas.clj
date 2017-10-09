(ns combination.umbrellas
  (:require [schema.core :as s :include-macros true]))

;;;; Umbrellas Combination Problem

;;; Given a vector of positive integers with umbrellas sizes (umbrellas)
;;; and a number of people (n), calculate the minimum number of umbrellas
;;; to cover exactly n people. If there's no solution it must return -1.

;;; Examples:
;;; {:n 1, :umbrellas [1]}    => 1
;;; {:n 4, :umbrellas [1]}    => 4
;;; {:n 4, :umbrellas [2]}    => 2
;;; {:n 4, :umbrellas [1 2]}  => 2
;;; {:n 4, :umbrellas [2 4]}  => 1
;;; {:n 4, :umbrellas [5]}    => -1
;;; {:n 4, :umbrellas [3]}    => -1

(defn- calc-min-umbrellas
  ([n umbrellas] (calc-min-umbrellas n umbrellas 0 (inc n)))
  ([n umbrellas count minimum]
   (reduce
     (fn [minimum umbrella]
       (let [residual (- n umbrella)
             count (inc count)]
         (cond
           ;; found a solution
           (= residual 0) count

           ;; keep finding solution but prune possible worst solutions
           (and (> residual 0) (> minimum count))
           (calc-min-umbrellas residual umbrellas count minimum)

           ;; no solution found
           :else minimum)))
     minimum
     umbrellas)))

(s/defn get-min-umbrellas :- s/Int
  [n         :- s/Int
   umbrellas :- [s/Int]]
  (if (or (neg? n)
          (empty? umbrellas)
          (some #(not (pos? %)) umbrellas))
    -1
    (let [result (calc-min-umbrellas n umbrellas)]
      (if (> result n)
        -1
        result))))
