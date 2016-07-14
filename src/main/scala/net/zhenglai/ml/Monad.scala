package net.zhenglai.ml

/**
  * Created by Zhenglai on 7/14/16.
  */
object Monad {

  trait Monad[M[_]] {
    def apply[T](a: T): M[T]

    def flatMap[T, U](m: M[T])(f: T ⇒ M[U]): M[U]
  }

}
