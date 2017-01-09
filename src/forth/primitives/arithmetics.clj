(ns forth.primitives.arithmetics
  (:require [forth.stack :refer [defstackop]]))

(defstackop +
  "(x1 x2 -- x3) Adds x1 and x2, leaves result in x3"
  [x1 x2]
  (+ x1 x2))

(defstackop -
  "(x1 x2 -- x3) Subtracts x2 from x1, leaves result in x3"
  [x1 x2]
  (- x1 x2))

(defstackop *
  "(x1 x2 -- x3) Multiplies x1 with x2, leaves result in x3"
  [x1 x2]
  (* x1 x2))

(defstackop /
  "(x1 x2 -- x3) Divides x1 by x2, leaves result in x3"
  [x1 x2]
  (/ x1 x2))

(defstackop "1+"
  "(x1 -- x2) Increments x1 by 1"
  [x1]
  (inc x1))

(defstackop "1-"
  "(x1 -- x2) Decrements x1 by 1"
  [x1]
  (dec x1))

(defstackop "2+"
  "(x1 -- x2) Increments x1 by 2"
  [x1]
  (+ x1 2))

(defstackop "2-"
  "(x1 -- x2) Decrements x1 by 1"
  [x1]
  (dec x1))

(defstackop "2*"
  "(x1 -- x2) Multiply x1 by 2"
  [x1]
  (* x1 2))

(defstackop "2_SLASH_"
  "(x1 -- x2) Divide x1 by 2"
  [x1]
  (quot x1 2))

(defstackop ABS
  "( n -- u ) Return absolute value of n."
  [n]
  (if (pos? n) n (- n)))

(defstackop NEGATE
  "( n1 -- n2 ) Change sign of n1."
  [n1]
  (- n1))

(defstackop MIN
  "( n1 n2 -- n3 ) Return the lesser of the two signed numbers n1 and n2."
  [n1 n2]
  (min n1 n2))

(defstackop MAX
  "( n1 n2 -- n3 ) Return the greater of the two signed numbers n1 and n2."
  [n1 n2]
  (max n1 n2))

(defstackop MOD
  "( n1 n2 -- n3 ) Calculates and returns remainder of division n1/n2."
  [n1 n2]
  (mod n1 n2))

(defstackop "_SLASH_MOD"
  "( n1 n2 -- n-rem n-quot ) Calculates and returns remainder and quotient of division n1/n2."
  [n1 n2]
  [(mod n1 n2) (quot n1 n2)])

(defstackop "*_SLASH_"
  "( n1 n2 n3 -- n4 ) Multiplies then divides (n1 x n2) / n3."
  [n1 n2 n3]
  (quot (* n1 n2) n3))

(defstackop "*_SLASH_MOD"
  "( n1 n2 n3 -- n4 n5 ) Multiplies then divides (n1 x n2) / n3, returning the remainder n n4 and quotient in n5."
  [n1 n2 n3]
  (quot (* n1 n2) n3))

