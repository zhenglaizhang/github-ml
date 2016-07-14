package net.zhenglai.ml

/**
  * Created by Zhenglai on 7/14/16.
  */
object Monoid {

  // binary operation on a dataset T with the property of
  //  closure
  //  identify operation
  //  associativity     => ts1 + (ts2 + ts3) = (ts1 + ts2) + ts3
  trait Monoid[T] {
    def zero: T

    def op(a: T, b: T): T
  }

}
