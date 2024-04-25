class myMonitor {

    private int nexInOrder;

    public myMonitor() {

        nexInOrder = 0;
    }

    public synchronized void waitForMyTurn (int treadNum){
        while (treadNum > nexInOrder){
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public synchronized void imDone(){
        nexInOrder++;
        notifyAll();
    }
}