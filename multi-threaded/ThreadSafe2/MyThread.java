package ThreadSafe2;

public class MyThread implements Runnable {

    int ticket = 0;

    @Override
    public void run() {

        while (true) {
            try {
                Thread.sleep(10);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }

                if (extracted()) break;
        }
    }

//    快捷键是ctrl+alt+m，但是我不知道为什么按了没反应，选项里提升的也是这个，所以我是选中之后手动选择提取的
    private synchronized boolean extracted() {
        if (ticket == 100) {
            return true;
        }else {
            ticket++;
            System.out.println(Thread.currentThread().getName() + "在卖第: " + ticket + "张");
        }
        return false;
    }
}