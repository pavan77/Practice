
import scala.collection.mutable.ListBuffer

object Main extends App {

  //case class A(i: Int) {
    //val time = System.currentTimeMillis()
  //}

  //val pool: Option[GenericObjectPool[A]] = None

  class LockProvider {

    var rLocks = 0

    def readLockTaken = rLocks == 0
    var writeLockTaken = false
    def getLock(lType: Char) =
      this.synchronized {
        if (lType == 'R') {
          if (writeLockTaken) wait
          rLocks = rLocks + 1
        } else {
          if (readLockTaken || writeLockTaken) wait
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

  startPrinting
  def startPrinting = {
    val ra = (1 to 50)
    ra.foreach(i => {
      val newThread = new HelloPrinter(i)
      newThread.start()
      newThread.join()
    })
  }

  println(getPermutations("aa"))

  def position(s: String, c: Char) = {
    val ra = -1 to s.length - 1
    ra.map { i =>
      println(i)
      s.substring(0, i + 1) + c + s.substring(i + 1)
    }.toList
  }

  //abc

  def getPermutations(s: String): List[String] = {
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

}
