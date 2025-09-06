package concurrency.cookbook.chapter01;

public class Calculator implements Runnable {
    @Override
    public void run() {
        long current = 1L, maximum = 20000L, primeNumbers = 0L;
        System.out.printf("Thread '%s': START\n",
                Thread.currentThread().getName());
        while (current <= maximum) {
            if (isPrime(current)) primeNumbers++;
            current++;
        }
        System.out.printf("Thread '%s': END. Number of Primes: %d\n",
                Thread.currentThread().getName(), primeNumbers);

    }

    private boolean isPrime(long number) {
        if (number <= 1L) return false;
        if (number == 2L) return true;
        if (number % 2 == 0) return false;

        for (int i = 3; i <= Math.sqrt(number); i += 2) {
            if (number % i == 0) return false;
        }
        return true;
    }
}
