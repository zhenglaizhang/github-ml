package net.zhenglai.ml.lib

/**
  * Created by Zhenglai on 7/17/16.
  */
object Generator {

  // vs def
  val fibs = {
    def f(a: Int, b: Int): Stream[Int] = a #:: f(b, a + b)
    f(0, 1)
  }

  fibs
  fibs drop 3 take 5 toList

  fibs

  // TODO
  val fibs2 = new Traversable[Int] {
    override def foreach[U](f: (Int) ⇒ U): Unit = {
      def next(a: Int, b: Int): Unit = {
        f(a)
        next(b, a + b)
      }

      next(0, 1)
    }

  } view

  // view is a collection that lazily evaluated operations
  // scala.collection.TraversableView[Int,Traversable[Int]] = TraversableView(...)

  fibs2 drop 3 take 5 toList

}
