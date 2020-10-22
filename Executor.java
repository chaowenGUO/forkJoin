public class Executor
{
    public static void main(final String[] args) throws Exception
    {
        final var fixed = java.util.concurrent.Executors.newFixedThreadPool(Runtime.getRuntime().availableProcessors());
        System.out.println(fixed.submit(() -> 1).get());
	fixed.shutdown();
	final var scheduled = java.util.concurrent.Executors.newSingleThreadScheduledExecutor();
        scheduled.scheduleAtFixedRate(() -> System.out.println("fuck"), 0, 5, TimeUnit.SECONDS);
	scheduled.shutdown();
    }
}    
