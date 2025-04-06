package concurrency.racecondition.synchronization;

public class SynchronizedExchanger {

    protected Object object;

    public synchronized Object getObject() {
        return object;
    }

    public synchronized void setObject(Object object) {
        this.object = object;
    }

    public synchronized Object getObj() {
        synchronized (this) {
            return object;
        }
    }

    public synchronized void setObj(Object object) {
        synchronized (this) {
            this.object = object;
        }
    }
}
