package org.example;


import java.util.List;
import java.util.Scanner;

public class App {
  public static void main(String[] args) {
    TodoList todo = new TodoList();
    Scanner sc = new Scanner(System.in);

    while (true) {
      System.out.println("\n--- TODO MENU ---");
      System.out.println("1) Add task");
      System.out.println("2) Complete task");
      System.out.println("3) Show all");
      System.out.println("4) Show complete");
      System.out.println("5) Show incomplete");
      System.out.println("6) Clear list");
      System.out.println("0) Exit");

      int choice = readInt(sc, "Choose: ");

      if (choice == 0) {
        System.out.println("Goodbye!");
        break;
      }

      switch (choice) {
        case 1:
          System.out.print("Enter task description: ");
          String desc = sc.nextLine();
          try {
            int id = todo.add(desc);
            System.out.println("Added task with ID " + id);
          } catch (IllegalArgumentException e) {
            System.out.println("Error: " + e.getMessage());
          }
          break;

        case 2:
          int id = readInt(sc, "Enter task ID to complete: ");
          boolean ok = todo.complete(id);
          System.out.println(ok ? "Task completed." : "Error: No task found with that ID.");
          break;

        case 3:
          printList("All Tasks", todo.all());
          break;

        case 4:
          printList("Completed Tasks", todo.complete());
          break;

        case 5:
          printList("Incomplete Tasks", todo.incomplete());
          break;

        case 6:
          todo.clear();
          System.out.println("List cleared.");
          break;

        default:
          System.out.println("Invalid menu choice. Try again.");
      }
    }

    sc.close();
  }

  private static int readInt(Scanner sc, String prompt) {
    while (true) {
      System.out.print(prompt);
      String line = sc.nextLine().trim();
      try {
        return Integer.parseInt(line);
      } catch (NumberFormatException e) {
        System.out.println("Error: Please enter a valid whole number.");
      }
    }
  }

  private static void printList(String title, List<Task> items) {
    System.out.println("\n--- " + title + " ---");
    if (items.isEmpty()) {
      System.out.println("(none)");
      return;
    }
    for (Task t : items) {
      System.out.println(t);
    }
  }
}
