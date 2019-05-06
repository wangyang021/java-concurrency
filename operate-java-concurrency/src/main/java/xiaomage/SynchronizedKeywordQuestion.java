package xiaomage;

public class SynchronizedKeywordQuestion {

    public static void main(String[] args) {

    }

    private static void synchronizedBlock() {
        synchronized (SynchronizedKeywordQuestion.class) {
        }
    }

    private synchronized static void synchronizedMethod() {
    }
}
