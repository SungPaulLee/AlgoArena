import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

class SharedObject {
    int data;

    public SharedObject(int data)
    {
        this.data = data;
    }

    synchronized void increaseUpto10000()
    {
        for(int i = 0; i < 10000; i++)
        {
            data++;
            System.out.println("data increased to : " + data);
        }
    }

    public int getData ()
    {
        return data;
    }

    public void setData(int data)
    {
        this.data = data;
    }
}
public class ThreadExperiment {

    public static void main(String[] args)
    {
        SharedObject obj = new SharedObject(0);
        ExecutorService service = Executors.newFixedThreadPool(Runtime.getRuntime().availableProcessors());
        Runnable r1 = new Runnable() {
            @Override
            public void run() {
                obj.increaseUpto10000();
            }
        };

        Runnable r2 = new Runnable() {
            @Override
            public void run() {
                for(int i = 0; i < 1000; i++)
                {
                    int d = obj.getData();
                    System.out.println("data read : " + d);
                    obj.setData(0);
                    System.out.println("data is initialized to 0");
                }
            }
        };

        service.execute(r1);
        service.execute(r2);

        service.shutdown();
    }

}




