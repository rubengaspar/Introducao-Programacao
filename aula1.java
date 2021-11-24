package intro_prog.aula02;

class Exercises {
    // - - IGNORAR ESTA FUNÇÃO --
    public static void main(String[] args) {
        System.out.println(gcd(252, 105));
    }

    // Pre A
    static int max(int a, int b) {
        if (a >= b) {
            return a;
        }
        return b;
    }

    // Pre B
    static boolean isMultiple(int n, int multiple) {
        int division = n / multiple;
        return division * multiple == n;
    }

    // A
    static int abs(int n) {
        if (n >= 0) {
            return n;
        }
        return -n;
    }

    // B
    static int divide(int n, int divisor) {
        int result = 0;
        while (n >= divisor) {
            n -= divisor;
            ++result;
        }
        return result;
    }

    // C
    static int powerOfTwo(int pow) {
        int result = 1;
        while (pow-- > 0) {
            result *= 2;
        }
        return result;
    }

    // D
    static int sumOfNaturalsUpTo(int n) {
        int i = 1;
        int sum = 0;
        while (i <= n) {
            sum += i++;
        }
        return sum;
    }

    // E
    static int sumOfEvenNumbersBetween(int a, int b) {
        int sum = 0;
        if (a % 2 == 1) {
            ++a;
        }
        while (a <= b) {
            sum += a;
            a += 2;
        }
        return sum;
    }

    // F
    static int firstDigit(int n) {
        while (n / 10 != 0) {
            n /= 10;
        }
        return n;
    }

    // G
    static int fibonacci(int n) {
        if (n == 0 || n == 1) {
            return n;
        }
        int a = 1;
        int b = 0;
        while (n > 1) {
            int temp = a + b;
            b = a;
            a = temp;
            --n;
        }
        return a;
    }

    // Extra A
    static int gcd(int m, int n) {
        while (m != n) {
            if (m > n) {
                m -= n;
            } else {
                n -= m;
            }
        }
        return m;
    }
}
