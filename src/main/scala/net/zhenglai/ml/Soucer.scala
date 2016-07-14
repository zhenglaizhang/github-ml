package net.zhenglai.ml

import net.zhenglai.ml.Alias.XYTSeries

import scala.io.Source

/**
  * Created by Zhenglai on 7/14/16.
  */
object Soucer {

  val CSV_DELIM = ","

  def transform(cols: Array[Array[String]]) = ???

  def load(fileName: String): Option[XYTSeries] = {
    val src = Source.fromFile(fileName);
    val cols =  src.getLines.map(_.split(CSV_DELIM)).drop(1).toArray
    val data = transform(cols)

    // TODO try-finally-try or scala ARM
    src.close
    Some(data)
  }

  def download(url: String, local: String) = {
    // http://finance.yahoo.com/d/quotes.csv?s=CSCO&
  }
}
