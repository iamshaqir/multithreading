package concurrency.reentrance;


/**
 * synchronized blocks/methods in java are reentrant i.e., if a Java thread enters a synchronized block/method it locks
 * the block/method on current monitor object, the same thread can enter other synchronized blocks/methods on the same
 * monitor object.
 */
public class SyncReentrant {

    public synchronized void outer() {
        inner();
    }

    public synchronized void inner() {
        // do something and call other method
    }
}
