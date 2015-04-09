(ns poole-algebra.core
 (:require [clojure.math.numeric-tower :as math])) 

(defn vec-add [& v]
"Adds any number of vectors and returns a resultant vector."
    (vec (reduce #(map + % %2) v)))

(defn scalar-mult [c v]
"Scalar multiplies vector v with c and returns a vector."
    (vec (map #(* c %) v)))

(defn neg [v]
"Returns the negative of the vector."
    (map - v))

(defn dot-prod [& v]
"Returns the dot product of the vectors."
    (reduce + (reduce #(map * % %2) v)))

(defn vec-len [v]
"Returns the length of the vector v."
    (math/sqrt (dot-prod v v)))

(defn norm [v]
"Returns unit vector of v."
    (map #(/ % (vec-len v)) v))

(defn distance [u v]
"Returns the distance between u and v."
    (vec-len (vec-add u (neg v))))

(defn vec-angle [u v]
"Returns the angle in degrees between vector u and v."
    (* (/ 180 Math/PI) 
       (Math/acos (/ (dot-prod u v) 
                  (* (vec-len u) (vec-len v))))))



