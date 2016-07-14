package net.zhenglai.ml

/**
  * Created by Zhenglai on 7/14/16.
  */

// common (primitive) type alias
object Alias {
  type XY = (Double, Double)

  type XYTSeries = Array[(Double, Double)]

  type DMatrix[T] = Array[Array[T]]

  type DVector[T] = Array[T]

  type DblMatrix = DMatrix[Double]

  type DblVector = DVector[Double]
}
