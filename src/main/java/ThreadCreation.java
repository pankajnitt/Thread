public class ThreadCreation {

    public static void main (String args[]){
        ThreadCreation threadCreation = new ThreadCreation();
        threadCreation.execute();
    }

     private void execute(){
        Thread.currentThread().setName("Main Thread");
        Thread t1 = new MyThread1("t1");
        Thread t2 = new Thread(new MyRunnable(), "t2");
        Runnable runnable =  new MyRunnable1();
        System.out.println("inside execute Thread id  : "+  Thread.currentThread().getName());
        // will create a new thread
        t1.start();
        // will create a new thread
        t2.start();

        // will use same thread as execute function
         System.out.println("executing run");
        runnable.run();
        // this will cause exception , you can perform start operation again ,
         //http://cdncontribute.geeksforgeeks.org/wp-content/uploads/thread.jpg
        //t2.start();
    }

    public class MyThread1 extends Thread{

        MyThread1(String s){
            super(s);
        }
        @Override
        public void run (){
            System.out.println("inside MyThread1 Thread id  : "+  Thread.currentThread().getName());
        }
    }

    public class MyRunnable implements Runnable{

        public void run (){
            System.out.println("inside MyRunnable Thread id  : " +  Thread.currentThread().getName());
        }
    }
    public class MyRunnable1 implements Runnable{

        public void run (){
            System.out.println("inside MyRunnable1 Thread id  : " +  Thread.currentThread().getName());
        }
    }
}
