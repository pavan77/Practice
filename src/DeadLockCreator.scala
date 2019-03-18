

class DeadLockCreator {

  val resource1 = 1
  val resource2 = 2

  def lockResource1: Unit = {
    resource1.synchronized {
      println(Thread.currentThread().getName + " Acquired lock on resource1)")
      println("Trying to Acquire lock on resource2")
      Thread.sleep(3000)
      lockResource2
    }
  }
  def lockResource2 = {
    resource2.synchronized {
      println(Thread.currentThread().getName + " Acquired lock on resource2)")
      println("Trying to Acquire lock on resource1)")
      Thread.sleep(3000)
      lockResource1
    }
    ""
  }
  def create = {

    val t1 = new Thread(new Runnable {
      def run = {
        lockResource1
      }
    }, "1")

    val t2 = new Thread(new Runnable {
      def run = {
        lockResource2
      }
    }, "2")

    t1.start
    t2.start
    
    t1.join(10000)

  }
}
