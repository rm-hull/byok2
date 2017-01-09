(ns forth.stack)

(def push cons)

(defmacro defstackop
  "Creates a function that takes a stack, extracts the given operands from
  the stack and applies the body, pushing the result(s) back onto the stack"
  ([operator operands body]
   `(defstackop ~operator "" ~operands ~body))

  ([operator doc operands body]
   `(defn ~(symbol operator) ~doc [~'stack]
      (let [[~@operands & ~'stack] ~'stack]
        (if-not (and ~@operands)
          (throw (RuntimeException. "Stack Underflow"))
          (if-let [r# ~body]
            (flatten (push r# ~'stack))
            ~'stack))))))
