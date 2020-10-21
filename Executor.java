public class Executor
{
    public static void main(final String[] args) throws Exception
    {
        final var executor = java.util.concurrent.Executors.newFixedThreadPool(Runtime.getRuntime().availableProcessors());
        System.out.println(executor.submit(() -> 1).get());
	    executor.shutdown();
    }
}    
