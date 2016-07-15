package net.zhenglai.ml.lib

/**
  * Created by Zhenglai on 7/15/16.
  */
object Def {
  // high-kinded type alias(type constructor) for callbacks
  // Function1[T, Unit]

  type Callback[T] = T ⇒ Unit
  type Callbacks[T] = List[Callback[T]]

  val x: Callback[Int] = y ⇒ println(y + 2)
  x(1)

  def foo[M[_]](f: M[Int]) = f

  foo[Callback](x)

  //  foo[Function1](x)
  //  <console>:16: error: Function1 takes two type parameters, expected: one
  //    foo[Function1](x)
}
