package day08.enum_;

// enum: 열거형 - 상수를 모아 놓은 클래스
public enum PizzaStatus {

    ORDERED("주문 완료", 5), READY("준비 완료", 20), DELIVERED("배달 완료", 30);

    private String description;
    private int timeToSetup;

    PizzaStatus(String description, int timeToSetup) {
        this.description = description;
        this.timeToSetup = timeToSetup;
    }

    public String getDescription() {
        return description;
    }

    public int getTimeToSetup() {
        return timeToSetup;
    }
}
