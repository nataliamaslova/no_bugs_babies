package org.example.tasklist;

/**
 * Список дел с приоритетами
 *
 * Создайте класс Task с полями для описания задачи и ее приоритета.
 * В классе TaskManager испольщуйте ArrayList<Task> для хранения
 * списка задач.
 * Реализуйте методы для добавления задачи в список, удаления задачи
 * из списка и сортировки списка задач по приоритету перед выводом.
 */
public class Main {
    public static void main(String[] args) {
        TaskManager taskManager = new TaskManager();
        Task task1 = new Task("Java Core", 4);
        Task task2 = new Task("WTF", 2);
        Task task3 = new Task("Java Babies", 3);
        Task task4 = new Task("CV", 1);

        taskManager.addTask(task1);
        taskManager.addTask(task2);
        taskManager.addTask(task3);
        taskManager.addTask(task4);
        System.out.println(taskManager.getTasks());

        taskManager.sortTasksByPriority(taskManager.getTasks());
        System.out.println(taskManager.getTasks());

        taskManager.removeTask(task1);
        System.out.println(taskManager.getTasks());
    }
}
