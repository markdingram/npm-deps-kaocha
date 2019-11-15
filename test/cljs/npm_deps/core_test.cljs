(ns npm-deps.core-test
  (:require [cljs.test :refer-macros [deftest is testing run-tests]]
            [npm-deps.core :as c]))

(deftest a-test
  (testing "Pad 42"
    (is (= (c/pad-me) "00042"))))
