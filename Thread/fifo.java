import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

public class fifo {
    public static void main(String[] args) {
        BlockingQueue<String> q=new ArrayBlockingQueue<>(4);
        //producer

        Thread producer=new Thread(()->{
            try{
                for(int i=1;i<=10;i++){
                    String a="data"+i;
                    q.put(a);
                    System.out.println("Producer Produced :"+a);
                    Thread.sleep(1200);

                }

            }
            catch(InterruptedException e){
                Thread.currentThread().interrupt();

            } 
        });

        Thread consumer=new Thread(()->{
            try{
                while(true){
                    String data=q.take();
                    System.out.println("consumer consumed : "+data);
                    Thread.sleep(1000);
                    if(data.equals("data10")){
                        break;
                    }
                }

            }
            catch(InterruptedException e){
                Thread.currentThread().interrupt();
            }
        });

        producer.start();
        consumer.start();
    }
    
}
