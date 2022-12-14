
package javaapptictac;


public class ThreadTwo implements Runnable {
    
    private Object monitor;
    private Thread thread;
    
    public Thread getThread() {
        return thread;
    }

    public ThreadTwo(Object monitor) {
        this.monitor = monitor;
        thread = new Thread(this);
    }

    @Override
    public void run() {
        try {
            Thread.sleep(1);
            for (int i = 0; i < JavaAppTicTac.num; i++) {
                System.out.println(2);
                synchronized (monitor) {
                    monitor.notify();
                    if(i < JavaAppTicTac.num - 1)
                        monitor.wait();
                }
            }
        }
        catch (InterruptedException e) {e.printStackTrace();}
    } 
    
}
