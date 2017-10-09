(ns combination.umbrellas-tests
  (:require [clojure.test :refer :all]
            [combination.umbrellas :refer [get-min-umbrellas]]))

;;; Try with invalid arguments

(deftest get-min-from-empty-umbrellas-test
   (is (= -1 (get-min-umbrellas 1 []))))

(deftest get-min-with-zero-people-test
  (is (= -1 (get-min-umbrellas 0 [1]))))

(deftest get-min-with-negative-people-test
  (is (= -1 (get-min-umbrellas -1 [1]))))

(deftest get-min-with-negative-umbrellas-test
  (is (= -1 (get-min-umbrellas 1 [-1])))
  (is (= -1 (get-min-umbrellas 1 [1 -2])))
  (is (= -1 (get-min-umbrellas 2 [-3 2]))))

(deftest get-min-with-umbrellas-contained-zero-test
  (is (= -1 (get-min-umbrellas 1 [0])))
  (is (= -1 (get-min-umbrellas 1 [1 0]))))


;;; One umbrella

(deftest one-umbrella-with-same-people-size-test
  (is (= 1 (get-min-umbrellas 1     [1])))
  (is (= 1 (get-min-umbrellas 2     [2])))
  (is (= 1 (get-min-umbrellas 10    [10])))
  (is (= 1 (get-min-umbrellas 10000 [10000]))))

(deftest one-umbrella-bigger-than-people-size-test
  (is (= -1 (get-min-umbrellas 1     [2])))
  (is (= -1 (get-min-umbrellas 2     [3])))
  (is (= -1 (get-min-umbrellas 10    [11])))
  (is (= -1 (get-min-umbrellas 10000 [10001]))))

(deftest one-umbrella-smaller-than-people-size-and-fits-test
  (is (= 2 (get-min-umbrellas 2 [1])))
  (is (= 3 (get-min-umbrellas 3 [1])))
  (is (= 4 (get-min-umbrellas 4 [1])))
  (is (= 2 (get-min-umbrellas 4 [2])))
  (is (= 6 (get-min-umbrellas 6 [1])))
  (is (= 3 (get-min-umbrellas 6 [2])))
  (is (= 2 (get-min-umbrellas 6 [3]))))

(deftest one-umbrella-smaller-than-people-size-but-not-fits-test
  (is (= -1 (get-min-umbrellas 3   [2])))
  (is (= -1 (get-min-umbrellas 4   [3])))
  (is (= -1 (get-min-umbrellas 5   [2])))
  (is (= -1 (get-min-umbrellas 5   [3])))
  (is (= -1 (get-min-umbrellas 6   [4])))
  (is (= -1 (get-min-umbrellas 6   [5])))
  (is (= -1 (get-min-umbrellas 100 [99]))))


;;; Two umbrellas

(deftest two-umbrellas-but-no-solution-test
  (is (= -1 (get-min-umbrellas 1 [2 3])))
  (is (= -1 (get-min-umbrellas 3 [2 4])))
  (is (= -1 (get-min-umbrellas 7 [4 5]))))

(deftest two-umbrellas-one-fits-test
  (is (= 1 (get-min-umbrellas 1 [1 2])))
  (is (= 2 (get-min-umbrellas 2 [1 3])))
  (is (= 6 (get-min-umbrellas 6 [1 7])))
  (is (= 2 (get-min-umbrellas 6 [4 2])))
  (is (= 2 (get-min-umbrellas 6 [3 5])))
  (is (= 1 (get-min-umbrellas 6 [5 6]))))

(deftest two-umbrellas-both-fit-test
  (is (= 2 (get-min-umbrellas 3  [1 2])))
  (is (= 3 (get-min-umbrellas 5  [1 2])))
  (is (= 3 (get-min-umbrellas 5  [1 3])))
  (is (= 2 (get-min-umbrellas 6  [2 4])))
  (is (= 5 (get-min-umbrellas 12 [8 1]))))


;;; Three umbrellas

(deftest three-umbrellas-but-no-solution-test
  (is (= -1 (get-min-umbrellas 1  [2 3 4])))
  (is (= -1 (get-min-umbrellas 7  [2 4 6])))
  (is (= -1 (get-min-umbrellas 5  [2 4 6]))))

(deftest three-umbrellas-one-fits-test
  (is (= 1 (get-min-umbrellas 1 [1 2 3])))
  (is (= 2 (get-min-umbrellas 2 [1 3 4])))
  (is (= 1 (get-min-umbrellas 3 [2 3 4])))
  (is (= 4 (get-min-umbrellas 8 [2 5 9])))
  (is (= 3 (get-min-umbrellas 9 [3 7 8]))))

(deftest three-umbrellas-two-fits-test
  (is (= 1 (get-min-umbrellas 2  [1 2 3])))
  (is (= 2 (get-min-umbrellas 4  [1 2 5])))
  (is (= 1 (get-min-umbrellas 5  [1 5 7])))
  (is (= 2 (get-min-umbrellas 8  [2 4 9])))
  (is (= 2 (get-min-umbrellas 12 [4 6 11]))))

(deftest three-umbrellas-all-fits-test
  (is (= 1 (get-min-umbrellas 3  [1 2 3])))
  (is (= 2 (get-min-umbrellas 4  [1 2 3])))
  (is (= 2 (get-min-umbrellas 5  [1 2 3])))
  (is (= 2 (get-min-umbrellas 6  [1 2 3])))
  (is (= 2 (get-min-umbrellas 12 [2 6 8]))))



