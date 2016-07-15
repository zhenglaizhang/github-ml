package net.zhenglai.ml.lib

/**
  * Created by Zhenglai on 7/15/16.
  */
object Processor {

  class Preprocessor {
    type B <: Traversable[Int]

    def sum(b: B) = b.foldLeft(0)(_ + _)


  }

  val ListPreprocessor = new Preprocessor {
    type B = List[Int]
  }

  val SetPreprocessor = new Preprocessor {
    type B = Set[Int]
  }

  ListPreprocessor.sum(List(12, 2, 3))
  SetPreprocessor.sum(Set(12, 2, 3))
}


