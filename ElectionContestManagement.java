import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

// Immutable Voter class
final class Voter {
    private final String name;
    private final String id;

    public Voter(String name, String id) {
        this.name = name;
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public String getId() {
        return id;
    }
}

// Generic Response class
class Response<T> {
    private T data;

    public Response(T data) {
        this.data = data;
    }

    public T getData() {
        return data;
    }
}

// Single Responsibility Principle - VoterRegistrationService class
class VoterRegistrationService {
    private List<Voter> registeredVoters = new ArrayList<>();

    public void registerVoter(Voter voter) {
        validateVoter(voter);
        saveVoter(voter);
        notifyVoter(voter);
    }

    private void validateVoter(Voter voter) {
        // Validation logic here
    }

    private void saveVoter(Voter voter) {
        registeredVoters.add(voter);
    }

    private void notifyVoter(Voter voter) {
        System.out.println("Voter " + voter.getName() + " has been registered.");
    }
}

// Example of using concurrency with ExecutorService
class VotingProcess {
    public void startVoting() {
        ExecutorService executor = Executors.newFixedThreadPool(10);
        for (int i = 0; i < 10; i++) {
            executor.submit(() -> {
                // Simulated task
                System.out.println("Processing vote in thread " + Thread.currentThread().getName());
            });
        }
        executor.shutdown();
    }
}

// Example of recursion
class FactorialCalculator {
    public int factorial(int n) {
        if (n <= 1) return 1;
        else return n * factorial(n - 1);
    }
}

// Example of exception handling
class ElectionException extends Exception {
    public ElectionException(String message) {
        super(message);
    }
}

// Main class to demonstrate the features
public class ElectionContestManagement {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Collecting user input first to avoid confusion with concurrent output
        System.out.print("Enter voter name: ");
        String name = scanner.nextLine();
        System.out.print("Enter voter ID: ");
        String id = scanner.nextLine();
        Voter voter = new Voter(name, id);

        System.out.print("Enter response message: ");
        String message = scanner.nextLine();
        Response<String> response = new Response<>(message);

        System.out.print("Enter a number to calculate its factorial: ");
        int number = scanner.nextInt();

        // Displaying collected input information
        System.out.println("Voter Name: " + voter.getName());
        System.out.println("Voter ID: " + voter.getId());
        System.out.println("Response: " + response.getData());

        // Recursion demonstration
        FactorialCalculator calculator = new FactorialCalculator();
        System.out.println("Factorial of " + number + ": " + calculator.factorial(number));

        // Refactored VoterRegistrationService
        VoterRegistrationService registrationService = new VoterRegistrationService();
        registrationService.registerVoter(voter);

        // Concurrency demonstration
        System.out.println("Starting voting process...");
        VotingProcess votingProcess = new VotingProcess();
        votingProcess.startVoting();

        scanner.close();
    }
}
