(ns four-clojure.solutions)

;; #20 Write a function which returns the second to last element from a sequence.
#(nth % (- (count %) 2))
#(second (reverse %))

;; #21 Write a function which returns the Nth element from a sequence.
#(last (take (+ %2 1) %1))

;; #22 Write a function which returns the total number of elements in a sequence.
#(reduce (fn [c number] (inc c)) 0 %)

;; #23 Write a function which reverses a sequence.
#(reduce (fn [initial x] (conj initial x)) '() %)

;; #24 Write a function which returns the sum of a sequence of numbers.
#(apply + %)

;; #25 Write a function which returns only the odd numbers from a sequence.
(fn [s] (filter #(> (rem % 2) 0) s))

;; #26 Write a function which returns the first X fibonacci numbers.
#(take % ((fn fib[x y] (cons x (lazy-seq (fib y (+ x y))))) 1 1))

;; #27 Write a function which returns true if the given sequence is a palindrome.
#(= (seq %) (reverse %))

;; #28 Write a function which flattens a sequence.
(fn flat [[x & xr]]
  (cond
    (nil? x) '()
    (coll? x) (concat (flat x) (flat xr))
    :else (cons x (flat xr))))

;; #29 Write a function which takes a string and returns a new string containing only the capital letters.
(fn [txt]
  (clojure.string/join "" (filter (fn [ch] (Character/isUpperCase ch)) txt)))
#(reduce str (re-seq #"[A-Z]" %))

;; #30 Write a function which removes consecutive duplicates from a sequence.
#(reverse
   (reduce
     (fn [initial a]
       (if (not= a (first initial))
         (conj initial a)
         initial))
     '() %))

;; #31 Write a function which packs consecutive duplicates into sub-lists.
#(partition-by identity %)

;; #32 Write a function which duplicates each element of a sequence.
#(reverse
   (reduce
     (fn [initial a]
       (cons a (cons a initial)))
     '()
     %))

;; #33 Write a function which replicates each element of a sequence a variable number of times.
(fn [s n]
  (reduce
    (fn [result x]
      (concat result (replicate n x)))
    '()
    s))

;; #34 Write a function which creates a list of all integers in a given range.
(fn [a b] (take (- b a) (iterate inc a)))


;; #38 Write a function which takes a variable number of parameters and returns the maximum value.
(fn [x & xs] (reduce #(if (< %1 %2) %2 %1) x xs))   ;; O(N)

(fn [& xs] (last (sort xs)))                        ;; O(logN)

;; #39 Write a function which takes two sequences and returns the first item from each, then the second item from each, then the third, etc.
(fn [a b]
  (let [size (min (count a) (count b))]
    (loop [n 0 r '()]
      (if (< n size)
        (recur
          (inc n)
          (cons (get b n) (cons (get a n) r)))
        (reverse r)))))

(fn [a b] (mapcat vector a b))
