package net.zhenglai.ml.lib

/**
  * Created by Zhenglai on 7/17/16.
  */
object CollectionExt {
  List(1, 2, 3, 5) map { i ⇒ println(i); i + 1 }

  List(1, 2, 3, 5).view map { i ⇒ println(i); i + 1 }

}
