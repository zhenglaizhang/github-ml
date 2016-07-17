package net.zhenglai.ml.lib

/**
  * Created by Zhenglai on 7/17/16.
  */
object Slider {
  val x = Seq(1, 2, 3, 4, 5, 6, 7)
  Nil.head
  x.head
  x.tail
  x.tails
  x.sum
  x.tails map (_.take(2)) filter (_.length > 1) map (_.sum) toList

  x.sliding(3).map(_.sum).toList

  x.tails.foreach(println)
  x.sliding(3).foreach(println)

  val errorcodes = Map(
    0 → "SUCCESS",
    1 → "ERROR",
    2 → "FATAL"
  ).withDefaultValue("INFO")
  List(1, 2) map errorcodes
  errorcodes(4)
  /*
  *
scala>   x.tails.foreach(println)
List(1, 2, 3, 4, 5, 6)
List(2, 3, 4, 5, 6)
List(3, 4, 5, 6)
List(4, 5, 6)
List(5, 6)
List(6)
List()
  * */

  (1 to 100) filter (2 to 4).toSet
}

object ImmutableCollections {
  // Vector
  // List
  // Stream


  // eagerly evaluated
  val x1 = 1 :: 2 :: 3 :: Nil
  val x2 = Nil.::(3).::(2).::(1)


  // Stream
  // -> Lazy persistent collection
  // -> Could represent an infinite sequence without overflowing memory
  // -> Cache computed values allowing backtracking
  // -> A stream is composed of cons cells and empty streams
  // -> A stream stores `function objects` that can be used to compute the head element and the tail (rest of Stream)
  List("a", "b", "c") zip (Stream from 1)

  val s = 1 #:: {
    println("HI")
    2
  } #:: {
    println("BAI")
    3
  } #:: Stream.empty
  // s: scala.collection.immutable.Stream[Int] = Stream(1, ?)
  s(0)
  s(1)
  s(2)
  s(3)
  s
  // scala>   s
  //  res24: scala.collection.immutable.Stream[Int] = Stream(1, 2, 3)

  // TraversableView
  // avoid perform work until necessary while allowing memory to be reclaimed
  val
}
