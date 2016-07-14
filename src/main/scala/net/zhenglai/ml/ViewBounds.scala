package net.zhenglai.ml

/**
  * Created by Zhenglai on 7/14/16.
  */
object ViewBounds {

  // enable the use of some type A as if it were some type B
  //  def f[A <% B](a: A) = a.bMethod
  // So A should have an implicit conversion to B available,

  // def f[A <% Ordered[A]](a: A, b: A) = if (a < b) a else b
  // one can convert A into an Ordered[A], and because Ordered[A] defines the method <(other: A): Boolean,
  // I can use the expression a < b.
  // view bounds are deprecated, you should avoid them

  def foo[T <% Int](x: T): Int = x

  //  foo:[T] (x: T) ( implicit evidence$1: T => Int) Int

  implicit def a[T](n: T) = n match {
    case x: String ⇒ x.toInt
  }

  foo("12")

  // 12

  class MyClassFloat[T <% Double]

  implicit def T2Double[T](t: T): Double = ???

}
