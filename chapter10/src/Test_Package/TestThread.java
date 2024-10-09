package Test_Package;

public class TestThread {

   public static void main(String args[]) 
   {
	  MultiThreading R1 = new MultiThreading( "Thread-1");
      R1.start();
      
      MultiThreading R2 = new MultiThreading( "Thread-2");
      R2.start();
   }
}