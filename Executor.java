public class Executor
{
    public static void main(final String[] args)
    {
        final var executor = java.util.concurrent.Executors.newFixedThreadPool(Runtime.getRuntime().availableProcessors());
    }
}    
