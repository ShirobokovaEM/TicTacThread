
package javaapptictac;

public class ThreadOne  extends Thread {
    
    private Object monitor;

    public ThreadOne(Object monitor) {
        this.monitor = monitor;
    }
    
    public void run () {
        try{
            for (int i = 0; i < JavaAppTicTac.num; i++) {
                System.out.print(1 + " - ");
                synchronized (monitor) {
                    monitor.notify();
                    if(i < JavaAppTicTac.num - 1)
                        monitor.wait();
                }
            }
        }
        catch(InterruptedException e) {e.printStackTrace();}
    }
    
}
