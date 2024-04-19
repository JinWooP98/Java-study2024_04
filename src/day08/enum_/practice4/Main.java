package day08.enum_.practice4;

// TeamRole enum: 팀원의 역할을 정의하고 각 역할에 따른 설명을 제공
enum TeamRole {
    LEADER("Manages the team and coordinates."),
    DEVELOPER("Develops the software."),
    DESIGNER("Designs the user interface."),
    TESTER("Tests the software for bugs.");

    private final String description;

    TeamRole (String description) {
        this.description = description;
    }

    public String getDescription() {
        return description;
    }
}

// TeamMember class: 팀원의 이름과 역할을 관리
class TeamMember {
    private final String name;
    private final TeamRole role;

    public TeamMember(String name, TeamRole role) {
        this.name = name;
        this.role = role;
    }

    public void assignTask() {
        System.out.println(this.name + " is assigned to " + this.role.getDescription());
    }
}

// Main class: 팀원 생성과 작업 할당을 시뮬레이션
public class Main {
    public static void main(String[] args) {
        TeamMember alice = new TeamMember("Alice", TeamRole.DEVELOPER);
        TeamMember bob = new TeamMember("Bob", TeamRole.DESIGNER);
        TeamMember charlie = new TeamMember("Charlie", TeamRole.LEADER);
        TeamMember david = new TeamMember("David", TeamRole.TESTER);

        alice.assignTask(); // Alice is assigned to Develops the software.
        bob.assignTask();   // Bob is assigned to Designs the user interface.
        charlie.assignTask(); // Charlie is assigned to Manages the team and coordinates.
        david.assignTask();  // David is assigned to Tests the software for bugs.
    }
}
