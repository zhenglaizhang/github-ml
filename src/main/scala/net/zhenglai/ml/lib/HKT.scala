package net.zhenglai.ml.lib

/**
  * Created by Zhenglai on 7/21/16.
  */

/*
Higher Kinded Types (HKT).

This feature allows us to write a library that works with a much wider array of classes,


Type constructors

Essentially what HKT gives us is the ability to generalize across type constructors – where a type constructor is anything that has a type parameter.
For instance List[_]* is not a type, the underscore is a hole into which another type may be plugged, constructing a complete type. List[String] and List[Int] being examples of complete (or distinct) types.

Kinds
Now that we have a type constructor we can think of several different kinds of them, classified by how many type parameters they take
List[_] – that take a single param have the kind: (* -> *), This says: given one type, produce another.
Something that takes two parameters, say Map[_, _], or Function1[_, _] has the kind: (* -> * -> *)

You can have kinds that are themselves parameterized by higher kinded types.
e.g. covariant functor: Functor[F[_]], it has the kind: ((* -> *) -> *)
For instance given a type constructor like List produce the final type Functor[List]


Utility
Say we have some standard pattern for our data-structures where we want to be able to consistently apply an operation of the same shape.
Functors are a nice example, the covariant functor allows us to take a box holding things of type A, and a function of A => B and get back a box holding things of type B.

  */

trait Function[F[_]] {
  def map[A, B](fa: F[A])(f: A ⇒ B): F[B]
}

import java.util.{List ⇒ JL}


class HKT {

}
