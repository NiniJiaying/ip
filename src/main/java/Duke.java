import java.util.*;
import java.io.*;

public class Duke {
    public static void main(String[] args) {
        ArrayList<Task> tasks = new ArrayList<>();
        Scanner in = new Scanner(System.in);
        System.out.println("    ____________________________________________________________");
        System.out.println("     Hello! I'm Duke");
        System.out.println("     What can I do for you?");
        System.out.println("    ____________________________________________________________");
        System.out.println("Enter a command:");
        String commands = in.nextLine();
        int taskCount = 0;
        while(!commands.equals("bye")) {
            if(commands.equals("list")) {
                System.out.println("    ____________________________________________________________");
                System.out.println("     Here are the tasks in your list:");
                int i = 1;
                for(Task s : tasks) {
                    if(s != null) {
                        System.out.println("     " + i + "." + s.toString());
                        i++;
                    } else {
                        break;
                    }
                }
                System.out.println("    ____________________________________________________________");
            } else if(commands.split(" ")[0].equals("done")) {
                int n = Integer.parseInt(commands.split(" ")[1]);
                tasks.get(n-1).markAsDone();
                System.out.println("    ____________________________________________________________");
                System.out.println("     Nice! I've marked this task as done:");
                System.out.println("       " + tasks.get(n-1).toString());
                System.out.println("    ____________________________________________________________");
            } else if(commands.split(" ")[0].equals("todo")) {
                int iend = commands.indexOf(" ");
                tasks.add(new ToDo(taskCount+1, commands.substring(iend+1)));
                try{
                    tasks.get(taskCount).addTask(taskCount+1);
                    taskCount++;
                } catch(DukeException e){
                    System.out.println("    ____________________________________________________________");
                    System.out.println(e.getMessage());
                    System.out.println("    ____________________________________________________________");
                }
            } else if(commands.split(" ")[0].equals("deadline")) {
                try{
                    int iend1 = commands.indexOf(" ");
                    int iend = commands.indexOf("/");
                    String subString1= commands.substring(iend1+1 , iend);
                    String subString2= commands.substring(iend+4);
                    tasks.add(new Deadline(taskCount+1, subString1, subString2));
                    tasks.get(taskCount).addTask(taskCount+1);
                    taskCount++;
                }
                catch(DukeException e){
                    System.out.println("    ____________________________________________________________");
                    System.out.println(e.getMessage());
                    System.out.println("    ____________________________________________________________");
                }
                catch(StringIndexOutOfBoundsException e){
                    System.out.println("    ____________________________________________________________");
                    System.out.println("     ☹ OOPS!!! The due date of a deadline cannot be empty. (Format: /by + date)");
                    System.out.println("    ____________________________________________________________");
                }
            } else if(commands.split(" ")[0].equals("event")) {
                try{
                    int iend1 = commands.indexOf(" ");
                    int iend = commands.indexOf("/");
                    String subString1= commands.substring(iend1+1 , iend);
                    String subString2= commands.substring(iend+4);
                    tasks.add(new Event(taskCount+1, subString1, subString2));
                    tasks.get(taskCount).addTask(taskCount+1);
                    taskCount++;
                } catch(DukeException e){
                    System.out.println("    ____________________________________________________________");
                    System.out.println(e.getMessage());
                    System.out.println("    ____________________________________________________________");
                }
                catch(StringIndexOutOfBoundsException e){
                    System.out.println("    ____________________________________________________________");
                    System.out.println("     ☹ OOPS!!! The start and end date of an event cannot be empty.(Format: /at + duration)");
                    System.out.println("    ____________________________________________________________");
                }
            } else if(commands.split(" ")[0].equals("delete")) {
                int n = Integer.parseInt(commands.split(" ")[1]);
                tasks.remove(n-1);
                System.out.println("    ____________________________________________________________");
                System.out.println("     Noted. I've removed this task:");
                System.out.println("       " + tasks.get(n-1).toString());
                System.out.println("     Now you have " + (taskCount-1) + " tasks in the list.");
                System.out.println("    ____________________________________________________________");
            }else {
                System.out.println("    ____________________________________________________________");
                System.out.println("     ☹ OOPS!!! I'm sorry, but I don't know what that means :-(");
                System.out.println("    ____________________________________________________________");
            }
            System.out.println("Enter a command:");
            commands = in.nextLine();
        }
        System.out.println("    ____________________________________________________________");
        System.out.println("     Bye. Hope to see you again soon!");
        System.out.println("    ____________________________________________________________");

    }
}
