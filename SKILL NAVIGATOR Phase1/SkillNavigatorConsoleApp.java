import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

class Candidate {
    String name;
    String email;
    String degree;
    String specialization;
    String phoneNumber;
    List<String> certifications;
    String internshipDetails;
    List<String> coursesCompleted;
    String linkedInProfile;
    String githubProfile;
    List<String> programmingLanguages;

    Candidate(String name, String email, String degree, String specialization, String phoneNumber,
              List<String> certifications, String internshipDetails, List<String> coursesCompleted,
              String linkedInProfile, String githubProfile, List<String> programmingLanguages) {
        this.name = name;
        this.email = email;
        this.degree = degree;
        this.specialization = specialization;
        this.phoneNumber = phoneNumber;
        this.certifications = certifications;
        this.internshipDetails = internshipDetails;
        this.coursesCompleted = coursesCompleted;
        this.linkedInProfile = linkedInProfile;
        this.githubProfile = githubProfile;
        this.programmingLanguages = programmingLanguages;
    }

    @Override
    public String toString() {
        return "Candidate{" +
                "name='" + name + '\'' +
                ", email='" + email + '\'' +
                ", degree='" + degree + '\'' +
                ", specialization='" + specialization + '\'' +
                ", phoneNumber='" + phoneNumber + '\'' +
                ", certifications=" + certifications +
                ", internshipDetails='" + internshipDetails + '\'' +
                ", coursesCompleted=" + coursesCompleted +
                ", linkedInProfile='" + linkedInProfile + '\'' +
                ", githubProfile='" + githubProfile + '\'' +
                ", programmingLanguages=" + programmingLanguages +
                '}';
    }
}

public class SkillNavigatorConsoleApp {

    private static List<Candidate> candidates = new ArrayList<>();
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        while (true) {
            System.out.println("Skill Navigator Application");
            System.out.println("1. Add Candidate");
            System.out.println("2. View Candidates");
            System.out.println("3. Batch Allocation");
            System.out.println("4. Exit");

            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline

            switch (choice) {
                case 1:
                    addCandidate();
                    break;
                case 2:
                    viewCandidates();
                    break;
                case 3:
                    allocateBatches();
                    break;
                case 4:
                    System.out.println("Exiting...");
                    return;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }

    private static void addCandidate() {
        System.out.println("Enter candidate details:");

        System.out.print("Name: ");
        String name = scanner.nextLine();

        System.out.print("Email: ");
        String email = scanner.nextLine();

        System.out.print("Degree: ");
        String degree = scanner.nextLine();

        System.out.print("Specialization: ");
        String specialization = scanner.nextLine();

        System.out.print("Phone Number: ");
        String phoneNumber = scanner.nextLine();

        System.out.print("Internship Details: ");
        String internshipDetails = scanner.nextLine();

        System.out.print("LinkedIn Profile: ");
        String linkedInProfile = scanner.nextLine();

        System.out.print("GitHub Profile: ");
        String githubProfile = scanner.nextLine();

        List<String> certifications = new ArrayList<>();
        System.out.println("Enter certifications (type 'done' when finished):");
        while (true) {
            String cert = scanner.nextLine();
            if (cert.equalsIgnoreCase("done")) break;
            certifications.add(cert);
        }

        List<String> coursesCompleted = new ArrayList<>();
        System.out.println("Enter courses completed (type 'done' when finished):");
        while (true) {
            String course = scanner.nextLine();
            if (course.equalsIgnoreCase("done")) break;
            coursesCompleted.add(course);
        }

        List<String> programmingLanguages = new ArrayList<>();
        System.out.println("Enter programming languages known (type 'done' when finished):");
        while (true) {
            String lang = scanner.nextLine();
            if (lang.equalsIgnoreCase("done")) break;
            programmingLanguages.add(lang);
        }

        Candidate candidate = new Candidate(name, email, degree, specialization, phoneNumber,
                certifications, internshipDetails, coursesCompleted, linkedInProfile, githubProfile, programmingLanguages);
        candidates.add(candidate);

        System.out.println("Candidate added successfully.");
    }

    private static void viewCandidates() {
        if (candidates.isEmpty()) {
            System.out.println("No candidates to display.");
        } else {
            for (Candidate candidate : candidates) {
                System.out.println(candidate);
            }
        }
    }

    private static void allocateBatches() {
        System.out.println("Allocating candidates to batches based on certifications...");

        for (Candidate candidate : candidates) {
            if (candidate.certifications.contains("AWS") || candidate.certifications.contains("Java")) {
                System.out.println(candidate.name + " allocated to Java Batch.");
            } else if (candidate.certifications.contains("Azure") || candidate.certifications.contains(".NET")) {
                System.out.println(candidate.name + " allocated to .NET Batch.");
            } else if (candidate.certifications.contains("Python")) {
                System.out.println(candidate.name + " allocated to Data Engineering Batch.");
            } else {
                System.out.println(candidate.name + " does not meet batch criteria.");
            }
        }
    }
}
