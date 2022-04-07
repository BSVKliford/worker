package ru.netology.worker;

public class Worker {
    private OnTaskDoneListener callback;
    private OnTaskErrorListener errorCallback;

    public Worker(OnTaskDoneListener callback) {
        this.callback = callback;
    }

    public Worker(OnTaskErrorListener errorCallback) {
        this.errorCallback = errorCallback;
    }

    public void start() {
        OnTaskErrorListener errorListener = System.out::println;
        Worker workerError = new Worker(errorListener);
        for (int i = 0; i < 100; i++) {
            if (i == 33) {
                workerError.setErrorCallback(i);
                continue;
            }
            callback.onDone("Task " + i + " is done");
        }
    }

    public void setErrorCallback(int i) {
        errorCallback.onError("Task " + i + " is error");
    }
}
