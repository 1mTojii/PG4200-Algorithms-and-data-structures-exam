/*
    class for the functions used to calculate the time it takes to execute algorithms.
    uses System.nanoTime().
 */
public class Timer {
    private long startTime;
    private long endTime;

    /*
    Starts time measurement
     */

    public void start() {
        startTime = System.nanoTime();
    }
    /*
    Stops time measurement.
     */
    public void end() {
        endTime = System.nanoTime();
    }
    /*
     * Returns the time used in nanoseconds (ns).
     * Fastest/smallest number for small code blocks.
     * You must run start() and stop() first!
     * @return
     */

    public long getElapsedTime() {
        return endTime - startTime;
    }
    /*
     * Returns the time used in milliseconds.
     * 1/1,000,000 of nanoseconds.
     * You must run start() and stop() first
     * @return
     */
    public double durationMillis() {
        return (double) ((endTime - startTime) / 1_000_000);
    }


}
