package net.zhenglai.ml

import net.zhenglai.ml.Alias.{DblMatrix, DblVector, DVector}

/**
  * Created by Zhenglai on 7/14/16.
  */
object Conv {
  implicit def vectorT2DblVector[T <% Double](vt: DVector[T]): DblVector = vt map (_.toDouble)

  implicit def double2DblVector(x: Double): DblVector = Array[Double](x)

  implicit def dblPair2DblVector(x: (Double, Double)): DblVector = Array[Double](x._1, x._2)

  implicit def dblPairs2DblRows(x: (Double, Double)): DblMatrix = Array[Array[Double]]((x._1, x._2))
}
