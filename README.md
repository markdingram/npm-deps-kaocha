# npm-deps-kaocha

## Usage

Trying to run a test with a dep from npm-deps:

```
#kaocha/v1
    {:bindings        {kaocha.type.cljs/*debug* true}
     :capture-output? false
     :tests           [{:id                    :unit-cljs
                        :type                  :kaocha.type/cljs
                        :cljs/compiler-options {:verbose      true
                                                :install-deps true
                                                :npm-deps     {:left-pad "1.1.3"}}
                        :source-paths          ["src"]
                        :test-paths            ["test"]}]}
```

Fails with:

````
$ clj -A:test

...

Caused by: clojure.lang.ExceptionInfo: No such namespace: left-pad, could not locate left_pad.cljs, left_pad.cljc, or JavaScript source providing "left-pad" (Pleas
e check that namespaces with dashes use underscores in the ClojureScript file name) in file /Users/mark/.ghq/github.com/markdingram/npm-deps-kaocha/src/npm_deps/co
re.cljs
{:tag :cljs/analysis-error}
 at cljs.analyzer$error.invokeStatic (analyzer.cljc:751)
    cljs.analyzer$error.invoke (analyzer.cljc:747)
    cljs.analyzer$error.invokeStatic (analyzer.cljc:749)
    cljs.analyzer$error.invoke (analyzer.cljc:747)
    cljs.analyzer$analyze_deps.invokeStatic (analyzer.cljc:2567)
    cljs.analyzer$analyze_deps.invoke (analyzer.cljc:2541)
    cljs.analyzer$ns_side_effects.invokeStatic (analyzer.cljc:3993)
    cljs.analyzer$ns_side_effects.invoke (analyzer.cljc:3988)
    cljs.analyzer$analyze_STAR_$fn__2657.invoke (analyzer.cljc:4112)
    ...
    cljs.analyzer$analyze_STAR_.invokeStatic (analyzer.cljc:4112)
    cljs.analyzer$analyze_STAR_.invoke (analyzer.cljc:4102)
    cljs.analyzer$analyze.invokeStatic (analyzer.cljc:4131)
    cljs.analyzer$analyze.invoke (analyzer.cljc:4114)
    cljs.analyzer$analyze_file$fn__2777.invoke (analyzer.cljc:4634)
    cljs.analyzer$analyze_file.invokeStatic (analyzer.cljc:4629)
    cljs.analyzer$analyze_file.invoke (analyzer.cljc:4587)
    cljs.analyzer$analyze_file.invokeStatic (analyzer.cljc:4651)
    cljs.analyzer$analyze_file.invoke (analyzer.cljc:4587)
    cljs.analyzer$analyze_file.invokeStatic (analyzer.cljc:4601)
    cljs.analyzer$analyze_file.invoke (analyzer.cljc:4587)
    cljs.analyzer$analyze_deps.invokeStatic (analyzer.cljc:2565)
    cljs.analyzer$analyze_deps.invoke (analyzer.cljc:2541)
    cljs.analyzer$ns_side_effects.invokeStatic (analyzer.cljc:3993)
    cljs.analyzer$ns_side_effects.invoke (analyzer.cljc:3988)
    cljs.analyzer$analyze_STAR_$fn__2657.invoke (analyzer.cljc:4112)
    ...
    cljs.analyzer$analyze_STAR_.invokeStatic (analyzer.cljc:4112)
    cljs.analyzer$analyze_STAR_.invoke (analyzer.cljc:4102)
    cljs.analyzer$analyze.invokeStatic (analyzer.cljc:4131)
    cljs.analyzer$analyze.invoke (analyzer.cljc:4114)
    cljs.analyzer$analyze_file$fn__2777.invoke (analyzer.cljc:4634)
    cljs.analyzer$analyze_file.invokeStatic (analyzer.cljc:4629)
    cljs.analyzer$analyze_file.invoke (analyzer.cljc:4587)
    cljs.analyzer$analyze_file.invokeStatic (analyzer.cljc:4651)
    cljs.analyzer$analyze_file.invoke (analyzer.cljc:4587)
    cljs.analyzer$analyze_file.invokeStatic (analyzer.cljc:4601)
    cljs.analyzer$analyze_file.invoke (analyzer.cljc:4587)
    cljs.analyzer$analyze_file.invokeStatic (analyzer.cljc:4597)
    cljs.analyzer$analyze_file.invoke (analyzer.cljc:4587)
    kaocha.type.cljs$eval6662$fn__6663.invoke (cljs.clj:97)
    ...
    kaocha.testable$load.invokeStatic (testable.clj:77)
    kaocha.testable$load.invoke (testable.clj:64)
````

Adding precompile & the necessary :main cljs compiler option moves further, but fails in repl startup


````
clj -A:test --config-file tests-precompile.edn
Installing Node.js dependencies
Options passed to ClojureScript compiler: {:output-dir "out", :closure-warnings {:check-types :off, :check-variables :off}, :closure-defines {"kaocha.type.cljs.log_level" "DEBUG", "kaocha.type.cljs.root_log_level" "DEBUG", "cljs.core._STAR_target_STAR_" "nodejs"}, :ups-libs nil, :cache-analysis true, :closure-module-roots [], :install-deps true, :optimizations :none, :ups-foreign-libs [], :verbose true, :aot-cache false, :ignore-js-module-exts [".css"], :preamble ["cljs/imul.js"], :ups-externs nil, :opts-cache "cljsc_opts.edn", :source-map true, :cache-analysis-format :transit, :target :nodejs, :main npm_deps.main, :emit-constants nil, :npm-deps {:left-pad "1.1.3"}}
Copying jar:file:/Users/mark/.m2/repository/org/clojure/clojurescript/1.10.520/clojurescript-1.10.520.jar!/cljs/nodejs.cljs to out/cljs/nodejs.cljs
Reading analysis cache for jar:file:/Users/mark/.m2/repository/org/clojure/clojurescript/1.10.520/clojurescript-1.10.520.jar!/cljs/core.cljs
Copying jar:file:/Users/mark/.m2/repository/org/clojure/clojurescript/1.10.520/clojurescript-1.10.520.jar!/cljs/nodejs.cljs to out/cljs/nodejs.cljs
Copying jar:file:/Users/mark/.m2/repository/org/clojure/clojurescript/1.10.520/clojurescript-1.10.520.jar!/cljs/nodejscli.cljs to out/cljs/nodejscli.cljs
Copying jar:file:/Users/mark/.m2/repository/org/clojure/clojurescript/1.10.520/clojurescript-1.10.520.jar!/cljs/nodejscli.cljs to out/cljs/nodejscli.cljs
Reading analysis cache for jar:file:/Users/mark/.m2/repository/org/clojure/clojurescript/1.10.520/clojurescript-1.10.520.jar!/clojure/string.cljs
Reading analysis cache for jar:file:/Users/mark/.m2/repository/org/clojure/clojurescript/1.10.520/clojurescript-1.10.520.jar!/cljs/pprint.cljs
Reading analysis cache for jar:file:/Users/mark/.m2/repository/org/clojure/clojurescript/1.10.520/clojurescript-1.10.520.jar!/cljs/test.cljs
Reading analysis cache for file:/Users/mark/.ghq/github.com/markdingram/npm-deps-kaocha/src/npm_deps/core.cljs
Reading analysis cache for test/cljs/npm_deps/core_test.cljs
[#:cljs{:compiler-options {:output-dir out, :closure-warnings {:check-types :off, :check-variables :off}, :closure-defines {kaocha.type.cljs.log_level DEBUG, kaocha.type.cljs.root_log_level DEBUG, cljs.core._STAR_target_STAR_ nodejs}, :ups-libs nil, :cache-analysis true, :closure-module-roots [], :install-deps true, :optimizations :none, :ups-foreign-libs [], :verbose true, :aot-cache false, :ignore-js-module-exts [.css], :preamble [cljs/imul.js], :ups-externs nil, :opts-cache cljsc_opts.edn, :source-map true, :cache-analysis-format :transit, :target :nodejs, :main npm_deps.main, :emit-constants nil, :npm-deps {:left-pad 1.1.3}}}
EVAL:  (require (quote kaocha.cljs.websocket-client) (quote kaocha.cljs.run))
EVAL:  :require-websocket-client-done7288
:cljs/err -> {:val "ReferenceError: cljs is not defined\n    at Socket.<anonymous> ([stdin]:89:28)\n    at Socket.emit (events.js:210:5)\n    at Socket.EventEmitter.emit (domain.js:476:20)\n    at addChunk (_stream_readable.js:308:12)\n    at readableAddChunk (_stream_readable.js:285:13)\n    at Socket.Readable.push (_stream_readable.js:223:10)\n    at TCP.onStreamRead (internal/stream_base_commons.js:182:23)\n", :type :cljs/err}
ReferenceError: cljs is not defined
    at Socket.<anonymous> ([stdin]:89:28)
    at Socket.emit (events.js:210:5)
    at Socket.EventEmitter.emit (domain.js:476:20)
    at addChunk (_stream_readable.js:308:12)
    at readableAddChunk (_stream_readable.js:285:13)
    at Socket.Readable.push (_stream_readable.js:223:10)
    at TCP.onStreamRead (internal/stream_base_commons.js:182:23)

EVAL:  :cljs/quit
E]
````

There's also a deadlock around of `cljs.repl.node/lock` here see [threads.txt](threads.txt)


It all works fine if a change is made to kaocha-cljs to `(dissoc copts :main)` prior to starting the REPL.


## License

Copyright © 2019 FIXME

This program and the accompanying materials are made available under the
terms of the Eclipse Public License 2.0 which is available at
http://www.eclipse.org/legal/epl-2.0.

This Source Code may also be made available under the following Secondary
Licenses when the conditions for such availability set forth in the Eclipse
Public License, v. 2.0 are satisfied: GNU General Public License as published by
the Free Software Foundation, either version 2 of the License, or (at your
option) any later version, with the GNU Classpath Exception which is available
at https://www.gnu.org/software/classpath/license.html.
