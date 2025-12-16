package logistics.util;

public class PerformanceMonitor {
    private long startTime;
    private long startMemory;

    public void start() {
        Runtime runtime = Runtime.getRuntime();
        runtime.gc();
        startMemory = runtime.totalMemory() - runtime.freeMemory();
        startTime = System.nanoTime();
    }

    public void stop(){
        long endTime = System.nanoTime();
        Runtime runtime = Runtime.getRuntime();
        long endMemory = runtime.totalMemory() - runtime.freeMemory();

        double timeMs = (endTime - startTime) / 1_000_000.0;
        double memoryMB = (endMemory - startMemory) / (1024.0 * 1024.0);

        System.out.println("Tempo de execução: " + timeMs + " ms");
        System.out.println("Memória utilizada: " + memoryMB + " MB");
    }
}