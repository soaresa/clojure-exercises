(ns four-clojure.solutions)

;; #20 Write a function which returns the second to last element from a sequence.
#(nth %1 (- (count %1) 2))
#(second (reverse %1))

;; #21 Write a function which returns the Nth element from a sequence.
#(last (take (+ %2 1) %1))

;; #22 Write a function which returns the total number of elements in a sequence.
#(reduce (fn [c number] (inc c)) 0 %1)

;; #23 Write a function which reverses a sequence.
#(reduce (fn [initial x] (conj initial x)) '() %1)

;; #24 Write a function which returns the sum of a sequence of numbers.
#(apply + %1)

;; #25 Write a function which returns only the odd numbers from a sequence.
(fn [s] (filter #(> (rem %1 2) 0) s))
