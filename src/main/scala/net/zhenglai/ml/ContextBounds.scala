package net.zhenglai.ml

/**
  * Created by Zhenglai on 7/14/16.
  */
object ContextBounds {
  require(true, "I should never be printed")

  // Type class pattern, a pattern of code that emulates the functionality provided by Haskell type classes,
  //  this pattern implements an alternative to inheritance by making functionality available through a sort of implicit adapter pattern.

  // client type should has Int as upper bound
  // introduces constraints on the client to inherit from simple types and to deal with covariance and contravariance for container types
  class MyClassInt[T <: Int]


  // A context bound describes an implicit value, instead of view bound's implicit conversion.
  // It is used to declare that for some type A, there is an implicit value of type B[A] available.
  // def f[A : B](a: A) = g(a) // where g requires an implicit value of type B[A]
  def f[A: ClassManifest](n: Int) = new Array[A](n)

  // An Array initialization on a parameterized type requires a ClassManifest to be available,

  def f[A: Ordering](a: A, b: A) = implicitly[Ordering[A]].compare(a, b)

  //  implicitly is used to retrive the implicit value we want, one of type Ordering[A], which class defines the method compare(a: A, b: A): Int.


  // client type should has Double as upper bound
  class MyClassDouble[T <: Double]

}
