package edu.eci.arsw.primefinder;

public class Operation extends Thread{
    private int thread = 3;
    private int numbers = 30000000;
    private int division = numbers/thread;

    private PrimeFinderThread process[];

    public Operation (){
        this.process = new PrimeFinderThread[thread];
        int i;
        for(i=0; i<thread-1;i++){
            PrimeFinderThread primeFinderThread = new PrimeFinderThread(division*i,(i+1)*division);
            process[i]=primeFinderThread;
        }
        process[i]= new PrimeFinderThread(i*division,numbers);
    }

    @Override
    public void run(){
        for(int i=0;i<thread;i++){
            process[i].start();
        }
    }
}
