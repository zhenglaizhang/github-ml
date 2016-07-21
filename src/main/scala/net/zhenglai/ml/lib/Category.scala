package net.zhenglai.ml.lib

/**
  * Created by Zhenglai on 7/21/16.
  */
private[zhenglai] object Category {
  def id[A]: A ⇒ A = a ⇒ a

  def compose[A, B, C](g: B ⇒ C, f: A ⇒ B): A ⇒ C =
    g compose f // Function.compose, f(g(x))
}
