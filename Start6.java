public class Start6 extends Thread {
    static int share;

    public static void main(String[] args) {
        Start6 t1 = new Start6();
        Start6 t2 = new Start6();

        // run을 직접 호출하면, 새로운 스레드 생성되지 않고, 메인 스레드에서 실행됨
        t1.start();
        t2.start();
    }

    /*
        Thread가 구현한 Runnable 인터페이스의 추상 메서드
        Thread가 실행될 때 JVM에 의해 자동으로 호출됨
        run() 메서드가 종료되면 해당 스레드도 종료됨
        예외 처리가 필요한 경우 run() 메서드 내부에서 처리해야 함
     */
    @Override
    public void run() {
        for (int count = 0; count < 10; ++count) {
            System.out.println(share++);
            try {
                sleep(1000);
            } catch (InterruptedException e) {}
        }
    }
}
