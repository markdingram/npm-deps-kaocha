(ns npm-deps.core
  (:require [cljs.build.api :as b]
            [kaocha.repl :as r]
            [cljs.repl :as repl]
            [cljs.repl.node :as node]))

(defn build []
  (println "Building")
  (b/build "src"
           {:optimizations :none
            :main          'cljs-test.core
            :verbose       true
            :target        :nodejs
            :npm-deps      {:left-pad "1.1.3"}
            :install-deps  true
            :output-to     "main.js"}))


(defn test []
  (println "Testing")
  (r/run :unit-cljs))

(defn repl []
  (repl/repl* (node/repl-env)
              {:output-dir     ".cljs_node_repl_xxx"
               :optimizations  :none
               :npm-deps       {:left-pad "1.1.3"}
               :install-deps   true
               :cache-analysis true
               :source-map     true}))
