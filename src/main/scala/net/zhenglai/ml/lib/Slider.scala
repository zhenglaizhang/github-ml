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
