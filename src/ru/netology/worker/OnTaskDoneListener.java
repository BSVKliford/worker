package ru.netology.worker;

@FunctionalInterface
public interface OnTaskDoneListener {
    void onDone(String result);
}
