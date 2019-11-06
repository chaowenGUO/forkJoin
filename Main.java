class SumTask extends java.util.concurrent.RecursiveTask<Long>
{
    private final java.util.List<Long> list;
    private final int start, end;

    public SumTask(java.util.List<Long> list, int start, int end)
    {
        this.list = list;
        this.start = start;
        this.end = end;
    }

    @Override
    protected Long compute()
    {
        if (end - start <= 100) return java.util.stream.IntStream.range(start, end).mapToLong(this.list::get).sum();
        final var middle = (end + start) / 2;
        final var sumTask = java.util.List.of(new SumTask(this.list, start, middle), new SumTask(this.list, middle, end));
        return this.invokeAll(sumTask).stream().mapToLong($ -> $.join()).sum();
    }
}

public class Main
{
    public static void main(String[] args)
    {
	final var list = java.util.stream.LongStream.range(0, 1600).boxed().collect(java.util.stream.Collectors.toList());
        final var pool = java.util.concurrent.ForkJoinPool.commonPool();
        final var task = new SumTask(list, 0, list.size());
        final var startTime = System.currentTimeMillis();
        final var result = pool.invoke(task);
        final var endTime = System.currentTimeMillis();
        System.out.println("result: " + result + " in " + (endTime - startTime) + " ms");
    }
}

//apt-get install openjdk-14-jre openjdk-14-jdk-headless
