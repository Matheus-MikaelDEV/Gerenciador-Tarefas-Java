package application;

import entities.Tasks;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import java.util.*;

public class Program {
    public static void main(String[] args) {
        Locale.setDefault(Locale.US);
        Scanner sc = new Scanner(System.in);

        System.out.println("-Gerenciador de Tarefas-");

        int option = 0;

        List<Tasks> tasks = new ArrayList<Tasks>();

        do {
            System.out.println("Menu:");
            System.out.println("1 - Cadastrar Tarefa\n2 - Listar Tarefas\n3 -Tarefas vencidas\n4 - Tarefas do dia\n5 - Sair");
            System.out.print("Escolha uma opção: ");
            option = sc.nextInt();
            sc.nextLine();

            switch (option) {
                case 1:
                    System.out.println("-Cadastrar Tarefa-");
                    System.out.print("Digite o nome da tarefa: ");
                    String name = sc.nextLine();
                    System.out.print("Digite a descrição da tarefa: ");
                    String description = sc.nextLine();
                    System.out.print("Digite a data limite (dd/MM/yyyy): ");
                    String dateInput = sc.nextLine();
                    System.out.print("Digite a prioridade (1-5): ");
                    int priority = sc.nextInt();
                    sc.nextLine();

                    tasks.add(new Tasks(name, description, LocalDate.parse(dateInput, DateTimeFormatter.ofPattern("dd/MM/yyyy")), priority));
                    System.out.println("Tarefa cadastrada com sucesso!");

                    Collections.sort(tasks, Comparator.comparing(Tasks::getLimitDate));
                    break;
                case 2:
                    System.out.println("-Listar Tarefas-");
                    if (tasks.isEmpty()) {
                        System.out.println("Nenhuma tarefa registrada.");
                    } else {
                        for (Tasks task : tasks) {
                            System.out.println("Nome: " + task.getName());
                            System.out.println("Descrição: " + task.getDescription());
                            System.out.println("Data Limite: " + task.getLimitDate().format(DateTimeFormatter.ofPattern("dd/MM/yyyy")));
                            System.out.println("Prioridade: " + task.getPriority());
                            System.out.println("-----------------------------");
                        }
                    }
                    break;
                case 3:
                    System.out.println("-Tarefas vencidas-");
                    if (tasks.isEmpty()) {
                        System.out.println("Nenhuma tarefa registrada.");
                    } else {
                        LocalDate today = LocalDate.now();

                        for (Tasks task : tasks) {
                            if (task.getLimitDate().isBefore(today)) {
                                System.out.println("Nome: " + task.getName());
                                System.out.println("Descrição: " + task.getDescription());
                                System.out.println("Data: " + task.getLimitDate().format(DateTimeFormatter.ofPattern("dd/MM/yyyy")));
                                System.out.println("Prioridade: " + task.getPriority());
                                System.out.println("Atraso: " + task.getDelay() + " dias.");
                                System.out.println("-----------------------------");
                            }
                        }
                    }
                    break;
                case 4:
                    System.out.println("-Tarefas do dia-");
                    if (tasks.isEmpty()) {
                        System.out.println("Nenhuma tarefa registrada.");
                    } else {
                        LocalDate today = LocalDate.now();
                        for (Tasks task : tasks) {
                            if (task.getLimitDate().equals(today)) {
                                System.out.println("Nome: " + task.getName());
                                System.out.println("Descriço: " + task.getDescription());
                                System.out.println("Data: " + task.getLimitDate().format(DateTimeFormatter.ofPattern("dd/MM/yyyy")));
                                System.out.println("Prioridade: " + task.getPriority());
                                System.out.println("-----------------------------");
                            }
                        }
                    }
                    break;
                case 5:
                    System.out.println("Saindo do programa...");
                    break;
            }
        } while (option != 5);
    }
}