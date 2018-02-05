import org.apache.spark.{SparkConf, SparkContext}

object Main {

  def main(args: Array[String]): Unit = {
    print("Hello, world!")

    val conf = new SparkConf().setAppName("SparkJoins").setMaster("spark://anyconnect-cert-468022.ten.thomsonreuters.com:7077")
    val sc = new SparkContext(conf)
    val textFile = sc.textFile("hdfs://...")
//    val textFile =

  }

}