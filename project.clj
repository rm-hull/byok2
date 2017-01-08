(defproject rm-hull/byok2 "0.1.0"
  :description "Next-gen BYOK"
  :url "https://github.com/rm-hull/byok2"
  :license {
    :name "The MIT License (MIT)"
    :url "http://opensource.org/licenses/MIT"}
  :dependencies [
    [rm-hull/jasentaa "0.2.3"]]
  :scm {:url "git@github.com:rm-hull/byok2.git"}
  :vcs :git
  :source-paths ["src"]
  :jar-exclusions [#"(?:^|/).git"]
  :codox {
    :source-paths ["src"]
    :output-path "doc/api"
    :source-uri "http://github.com/rm-hull/byok2/blob/master/{filepath}#L{line}"
    :themes [:default [:google-analytics {:tracking-code "UA-39680853-6" }]]}
  :min-lein-version "2.6.1"
  :profiles {
    :dev {
      :global-vars {*warn-on-reflection* true}
      :plugins [
        [lein-codox "0.10.2"]
        [lein-cljfmt "0.5.6"]
        [lein-cloverage "1.0.9"]]
      :dependencies [
        [org.clojure/clojure "1.8.0"]
        [google-analytics-codox-theme "0.1.0"]]}})

