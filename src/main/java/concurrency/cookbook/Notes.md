## Synchronizing a block of code with a lock

Java provides a mechanism for synchronizing blocks of code. It's a more powerful
and flexible mechanism than the synchronized keyword. It's based on the Lock (of the
java.util.concurrent.locks package) interface and classes that implement it (as
ReentrantLock). This mechanism presents some advantages, which are as follows:
- The Lock interface provides additional functionalities over the synchronized
  keyword. One of the new functionalities is implemented by the tryLock()
  method. This method tries to get control of the lock, and if it can't, because it's
  used by another thread, it returns false.
- The ReadWriteLock interface allows a separation of read and write operations
  with multiple readers and only one modifier.
- The constructor of the ReentrantLock class admits a boolean parameter named fair;
  this parameter allows you to control its behavior. The false value is the default value and it's called the non-fair mode. In this mode, if some threads are waiting for a lock and the lock has to select one of these threads to get access to the critical section, it randomly selects anyone of them. The true value is called the fair mode. In this mode, if some threads are waiting for a lock and the lock has to select one to get access to a critical section, it selects the thread that has been waiting for the longest period of time. Take into account that the behavior explained previously is only used in the lock() and unlock() methods. As the tryLock() method doesn't put the thread to sleep if the Lock interface is used, the fair  attribute doesn't affect its functionality.