package AdrienArdraRamadhanJSleepMN;


public class ThreadingObject extends Thread{
    public ThreadingObject(String name) {
        super.setName(name);
        this.start();
    }
    public void run(){
        System.out.println(super.getName() + " is running");
        System.out.println("Id Thread " + super.getId());
    }
}