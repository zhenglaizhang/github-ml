package net.zhenglai.ml.lib

import scala.collection.GenTraversableOnce

/**
  * Created by Zhenglai on 7/15/16.
  */
object Print {

  class ColPrinter {
    type B <: GenTraversableOnce[String]

    def print(col: B) = col foreach { e ⇒
      Predef print "$e "
    }

    def println(col: B) = {
      this print col
      Predef println
    }
  }

  // TODO
  // anonymous subclass of ColPrinter, stabalize type B
  val ColFilePrinter = new ColPrinter {
    type B = List[String]
  }

}
