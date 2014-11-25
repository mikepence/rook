(defproject io.aviso/rook "0.1.18-SNAPSHOT"
            :description "Sane, smart, fast, Clojure web services"
            :url "http://howardlewisship.com/io.aviso/documentation/rook"
            :license {:name "Apache Sofware License 2.0"
                      :url  "http://www.apache.org/licenses/LICENSE-2.0.html"}
            :profiles {:dev
                        {:dependencies [[ring-mock "0.1.5"]
                                        [io.aviso/pretty "0.1.12"]
                                        [clj-http "1.0.1"]
                                        [speclj "3.1.0"]
                                        [log4j "1.2.17"]]}}
            ;; List "resolved" dependencies first, which occur when there are conflicts.
            ;; We pin down the version we want, then exclude anyone who disagrees.
            :dependencies [[org.clojure/clojure "1.6.0"]
                           [io.aviso/toolchest "0.1.1"]
                           [cheshire "5.3.1"]
                           [potemkin "0.3.11"]
                           [org.clojure/tools.reader "0.8.5"]
                           [org.clojure/core.async "0.1.346.0-17112a-alpha"]
                           [org.clojure/tools.logging "0.3.0"]
                           [io.aviso/tracker "0.1.2"]
                           [ring "1.3.1" :exclusions [org.clojure/tools.reader]]
                           [medley "0.5.3" :exclusions [com.keminglabs/cljx org.clojure/clojure]]
                           [ring-middleware-format "0.4.0" :excludes [cheshire]]
                           [prismatic/schema "0.3.3" :exclusions [potemkin]]
                           [metosin/ring-swagger "0.14.0" :optional true :exclusions [org.clojure/clojure]]
                           [metosin/ring-swagger-ui "2.0.17" :optional true]]
            :plugins [[speclj "3.1.0"]
                      [lein-shell "0.4.0"]]
            :shell {:commands {"scp" {:dir "doc"}}}
            :aliases {"deploy-doc" ["shell"
                                    "scp" "-r" "." "hlship_howardlewisship@ssh.phx.nearlyfreespeech.net:io.aviso/rook"]
                      "release"    ["do"
                                    "clean,"
                                    "spec,",
                                    "doc,"
                                    "deploy-doc,"
                                    "deploy" "clojars"]}
            :test-paths ["spec"]
            :codox {:src-dir-uri               "https://github.com/AvisoNovate/rook/blob/master/"
                    :src-linenum-anchor-prefix "L"
                    :defaults                  {:doc/format :markdown}})
