public class Executor
{
    public static void main(final String[] args) throws Exception
    {
        final var fixed = java.util.concurrent.Executors.newFixedThreadPool(Runtime.getRuntime().availableProcessors());
        System.out.println(fixed.submit(() -> 1).get());
	fixed.shutdown();
	/*final var scheduled = java.util.concurrent.Executors.newSingleThreadScheduledExecutor();
	scheduled.setContinueExistingPeriodicTasksAfterShutdownPolicy(true);
        scheduled.scheduleAtFixedRate(() -> System.out.println("fuck"), 0, 5, java.util.concurrent.TimeUnit.SECONDS);
	scheduled.shutdown();*/
	ScheduledThreadPoolExecutor executor = new ScheduledThreadPoolExecutor(1);
        executor.setContinueExistingPeriodicTasksAfterShutdownPolicy(true);
        executor.scheduleAtFixedRate(() -> System.out.println("Hello, World!"), 0L, 1L, TimeUnit.SECONDS);
        executor.shutdown();
    }
}    
