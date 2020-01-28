package edu.eci.arsw.primefinder;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class ControlThread extends Thread{
    private int thread = 3;
    private int numbers = 30000000;
    private int division = numbers/thread;

    private PrimeFinderThread process[];
    private BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
    public ControlThread(){
        this.process = new PrimeFinderThread[thread];
        int i;
        for(i=0; i<thread;i++){
            PrimeFinderThread primeFinderThread = new PrimeFinderThread(division*i,(i+1)*division);
            process[i]=primeFinderThread;
        }
    }

    @Override
    public void run(){
        boolean running = true;
        for(int i=0;i<thread;i++){
            process[i].start();
        }
        do{
            running = false;
            try{
                Thread.sleep(5000);
                //pause();
            }catch (InterruptedException e){
                e.printStackTrace();
            }
            for(int i=0;i<thread;i++){
                System.out.println("Thread: "+ (i+1) +" Number of primes : " + process[i].getPrimes().size());
                running=running || process[i].running();
            }
            try{
                bufferedReader.readLine();
            } catch (IOException e) {
                e.printStackTrace();
            }
            continuar();

        }while(running);

    }
    private void continuar() {
        for(PrimeFinderThread e:process) {
            e.Resume();
        }
    }

    public void play() {
        process.notifyAll();
    }

    public void pause() {
        for(PrimeFinderThread e:process) {
            e.pause();
        }
    }
}
