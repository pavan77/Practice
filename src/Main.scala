
import scala.collection.mutable.ListBuffer
import java.util.concurrent.Executors
import scala.io.Source
import java.net.URL
import java.io.FileOutputStream
import java.io.BufferedOutputStream
import java.io.File
import scala.concurrent.Future
import scala.concurrent._
import ExecutionContext.Implicits.global
import scala.util.Success
import javax.imageio
import javax.imageio.ImageIO
import java.io.IOException
import java.awt.image.BufferedImage

object Main extends App {

  //case class A(i: Int) {
  //val time = System.currentTimeMillis()
  //}

  //val pool: Option[GenericObjectPool[A]] = None

  /* class LockProvider {

    var rLocks = 0

    def readLockTaken = rLocks == 0
    var writeLockTaken = false
    def getLock(lType: Char) = this.synchronized {
      if (lType == 'R') {
        while (writeLockTaken) wait
        rLocks = rLocks + 1
      } else {
        while (readLockTaken || writeLockTaken) wait
        writeLockTaken = true
      }
      notify
    }

    def releaselock(lType: Char) = this.synchronized {
      if (lType == 'R') {
        rLocks = rLocks - 1
      } else {
        writeLockTaken = false
      }
      notify
    }

  }

  class HelloPrinter(i: Int) extends Thread {
    override def run = {
      println("Hello from " + i)
    }
  }

  //  startPrinting
  def startPrinting = {
    val ra = (1 to 50)
    ra.foreach(i => {
      val newThread = new HelloPrinter(i)
      newThread.start()
      newThread.join()
    })
  }

  //  println(getPermutations("aa"))

  //abc

  def getPermutations(s: String): List[String] = {
    def position(s: String, c: Char) = {
      val ra = -1 to s.length - 1
      ra.map { i =>
        println(i)
        s.substring(0, i + 1) + c + s.substring(i + 1)
      }.toList
    }
    if (s.length() <= 0) List()
    else if (s.length() == 1) List(s)
    else {
      val firstChar = s.charAt(0)
      val subPerms = getPermutations(s.substring(1))
      subPerms.map(st => {
        position(st, firstChar)
      }).flatten
    }
  }

  //  new DeadLockCreator().create

  val a = Executors.newFixedThreadPool(2)

  //  a.execute(command)

  //closures

  var pp = 10
  def changeValue = pp = 100

  val func = (i: Int) => {
    i + pp
  }

  println(func(1))

  changeValue

  println(pp + " " + func(1))

  class A(i: Int) {

    class B(p: String) {
      def append = p + i
    }
  }

  val r = 1 to 1500
  val distinctSet = ListBuffer[String]()
  r.foreach(i => {
    val newI = System.currentTimeMillis() + i
    if (!distinctSet.contains(newI))
      distinctSet.+=:("2" + newI)
  })
  distinctSet.foreach(println)
  println(distinctSet.size)*/

  def printlnAll(l: List[Int], k: Int): Unit = {
    //println(l)
    if (l.length == k) {
      println(l)
    }
    for (i <- 0 to l.length - 1) {
      if (l(i) > 1) {
        printlnAll(l.slice(0, i) ++ List(l(i) - 1, l(i) - 1) ++ l.slice(i + 1, l.length), k)
      }
    }
  }
  //  printlnAll(List(4, 3, 1), 10)

  //  def miniFunc(num: Int) {
  //    val myArray = Array.fill(num)(0.0)
  //    for (i <- 0 until num)
  //      myArray(i) = i * 2
  //  }

  /*def get(i: Int, m: Map[Int, List[Int]]): List[List[Int]] = {
    val lo = m.get(i)
    if (!lo.isDefined) List(List(i))
    else {
      lo.get.flatMap { n =>
        List(i) +: get(n, m)
      }
    }
  }

  val m = Map(0 -> List(1, 2), 1 -> List(3, 5), 3 -> List(4, 6))

  print(get(0, m)) */

  downloadImages

  println(sys.props("user.dir"))

  def downloadImages = {

    Source.fromFile("/home/administrator/Desktop/bgimages.txt").getLines().foreach(s => {
      try {
        downloadImage(s, None, "/home/administrator/Desktop/BackgroundImages")
        println(s)
      } catch {
        case e: Exception => e.printStackTrace()
      }
    })
  }

  /* def downloadFile(urlPath: String, localFileName: Option[String], folderName: String) = {
    println("downloading file" + urlPath)
    new File(folderName).mkdir()
    val url = new URL(urlPath)
    val bufferedSource = Source.fromURL(url)
    val fileName = url.getFile()
    val destName = localFileName.getOrElse(folderName + "/" + fileName.substring(fileName.lastIndexOf("/")).substring(1))
    val is = url.openStream()
    val bos = new BufferedOutputStream(new FileOutputStream(destName))
    val b = new Array[Byte](10)
    while ((is.read(b) != -1)) {
      bos.write(b)
    }
    is.close()
    bos.close()
  }*/

  def downloadImage(urlPath: String, localFileName: Option[String], folderName: String) = {
    var image: BufferedImage = null;
    try {
      new File(folderName).mkdir()
      val url = new URL(urlPath);

      val fileName = url.getFile()
      val destName = localFileName.getOrElse(folderName + "/" + fileName.substring(fileName.lastIndexOf("/")).substring(1))

      // read the url
      image = ImageIO.read(url);

      // for jpg
      ImageIO.write(image, "jpg", new File(destName));

    } catch {
      case e: IOException =>
        e.printStackTrace();
    }
  }

  /* val tup = (1, "2")

  val map = Map(1 -> "pavan", 2 -> "jc")
  map.get(1)

  class Channel(var id: Long, var name: String, var icon: String)

  val c1 = new Channel(1, "a", "/img1")

  println(tup._1)*/

  /*  val f1 = Future {
    Thread.sleep(5000)
    1
  }

  val f2 = Future {
    Thread.sleep(3000)
    2
  }

  def time = System.currentTimeMillis()

  val startTIme = time

  val p = for {
    n <- f2
    m <- f2
  } yield n + m

   val p2 = f1.flatMap(x => {
    f2
  })

   p.onComplete {
    case Success(x) => {
      println("xxxxxxxxx")
    }

    case _ => {
    }
  }

  p.onComplete {
    case Success(x) => {
      println(time - startTIme)
    }

    case _ => {
    }
  }

  Thread.sleep(100000)*/

  /* val fruit = "apples" :: ("oranges" :: ("pears" :: Nil))

  List.tabulate(1, 1)(_ + _)

  val f = (i: Double) => { Math.sqrt(i) }

  val pf: PartialFunction[Double, Double] = {
    case d: Double if d > 0 => Math.sqrt(d)
  }

  val positive: PartialFunction[Int, Int] = {
    case x if x >= 0 => x
  }

  val odd: PartialFunction[Int, Boolean] = {
    case x if x % 2 == 1 => true
  }

  val even: PartialFunction[Int, Boolean] = {
    case x if x % 2 == 0 => true
  }

  val evenCheck: PartialFunction[Int, Boolean] = positive andThen even

  val oddCheck: PartialFunction[Int, Boolean] = positive andThen odd

  //  println(evenCheck(3))

  val someRef: String = null

  def foo(n: Int, v: Int) =
    for (
      i <- 0 until n;
      j <- 0 until n if i + j == v
    ) yield (i, j)

  def innerLoopTest = {

    for (
      i <- 0 to 10;
      j <- 0 to i
    ) {
      println(i * j)
    }

  }

  //  innerLoopTest

  val l = for (
    x <- List(1, 2);
    y <- List(3, 4);
    z <- List(10, 20)
  ) yield (x + y + z)

  //  println(l.sum)

    println(List(4.0, 16, -8).collect(pf).map(_.toInt))

  println(List(4.0, 16, -8).map(f).map(_.toInt))

  //chanining partial functions

  val range = Math.pow(2, 24).toInt

  for (i <- 1 to range) {
    println(i)
  }
  println(System.currentTimeMillis() - time)

   object Foo {
    def unapply(x: Int): Option[String] =
      if (x == 0) Some("Hello, World") else None
  }

  class MyClass(arg: Int) {
    var i = 100
    i = i + 1
    def apply(n: String) = {
      n
      i += 1
      println(i)
    }
  }
  object MyClass {
   // def apply(s: String): MyClass = new MyClass(s)
  }

  // val mI = new MyClass("s")

  val op1 = Some(2)
  val op2 = Some(3)
  val op3 = Some(2)
  val op4 = Some(3)

  val i = for {
    i1 <- op1
    i2 <- op2
    i3 <- op3
    i4 <- op4
  } yield i1
*/

  abstract class Bean(x: Int, y: String)

  class ABean(x: Int, y: String, z: String) extends Bean(x, y)

  case class Stream(url: String, id: Long, cType: String)

  trait Handler {
    def getStreams: List[Stream]
  }

  class DotcomHandler extends Handler {

    def getStreams = {
      //connect to db
      List(Stream("u1", 1, "live"))
    }
  }

  class DotinHandler extends Handler {

    def getStreams = {
      //read from csv
      List(Stream("u2", 1, "live"))
    }
  }

  class MobitelHandler extends Handler {
    def getStreams = {
      //read from json
      List()
    }
  }

  class Monitor(handler: Handler) {

    def monitor() = {
      val list = handler.getStreams
      list.foreach(s => {
        //http get(s.url)
      })
    }
  }

  def main() = {

    //read config
    //if(type == 'yupptv.com')
    new Monitor(new DotcomHandler).monitor()
    //else if(type = 'yupptv.in'
    new Monitor(new DotinHandler).monitor()

  }

  val f = Future { "a" }

  val pp = f.recover {
    case e: Exception => ""
  }

}
