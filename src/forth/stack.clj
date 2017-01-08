(ns forth.stack)


(defmacro defstackop
  ([operator operands body]
   `(defstackop ~operator "" ~operands ~body))

  ([operator doc operands body]
  `(defn ~operator ~doc [~'stack]
    (let [[~@operands & ~'stack] ~'stack]
      (if-not (and ~@operands)
        (throw (RuntimeException. "Stack Underflow"))
        (if-let [r# ~body]
          (flatten (cons r# ~'stack))
          ~'stack))))))

(def push cons)

(def drop next)

(macroexpand-1 '(defstackop add "" [a b] (+ a b)))

(defstackop add
  "(x1 x2 -- x3) Adds x1 and x2, leaves result in x3"
  [x1 x2]
  (+ x1 x2))

(defstackop mul
  "(x1 x2 -- x3) Multiplies x1 with x2, leaves result in x3"
  [x1 x2]
  (* x1 x2))

(defstackop dotS
  [] (println stack))

(defstackop dot
  [x] (println x))


(defstackop dup [a] [a a])

(defstackop slashmod [a b] [(mod a b) (quot a b)])

(dup nil)

(->>
  nil
  (push 5)
  (push 3)
  (add))

(->>
  nil
  (push 5)
  (dup)
  (mul)
  (dot))

(->>
   nil
  (push 12)
  (push 5)
  (slashmod))