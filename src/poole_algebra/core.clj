(ns poole-algebra.core
 (:require [clojure.math.numeric-tower :as math])) 

(defn vec-add 
    "Adds any number of vectors and returns a resultant vector."
    [& v]
    (vec (reduce #(map + % %2) v)))

(defn scalar-mult 
    "Scalar multiplies vector v with c and returns a vector."
    [c v]
    (vec (map #(* c %) v)))

(defn neg 
    "Returns the negative of the vector."
    {:doc/format :markdown}
    [v]
    (map - v))

(defn dot-prod 
    "Returns the dot product of the vectors."
    [& v]
    (reduce + (reduce #(map * % %2) v)))

(defn vec-len 
    "Returns the length of the vector v."
    [v]
    (math/sqrt (dot-prod v v)))

(defn norm 
    "Returns unit vector of v."
    [v]
    (map #(/ % (vec-len v)) v))

(defn distance 
    "Returns the distance between u and v."
    [u v]
    (vec-len (vec-add u (neg v))))

(defn vec-angle 
    "Returns the angle in degrees between vector u and v."
    [u v]
    (* (/ 180 Math/PI) 
       (Math/acos (/ (dot-prod u v) 
                  (* (vec-len u) (vec-len v))))))



