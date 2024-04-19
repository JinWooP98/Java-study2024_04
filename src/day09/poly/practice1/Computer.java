package day09.poly.practice1;

// 부품 관리 클래스 Computer
class Computer {
    private ComputerPart[] parts;

    public Computer() {
        this.parts = new ComputerPart[0];
    }

    public void addPart(ComputerPart part) {
        // ComputerPart[] 에 부품 추가
        ComputerPart[] temp = new ComputerPart[this.parts.length + 1];
        for (int i = 0; i < this.parts.length ; i++) {
            temp[i] = this.parts[i];
        }
        temp[temp.length - 1] = part;
        this.parts = temp;
    }

    public void showParts() {
        // 모든 부품 정보 출력
        for (ComputerPart part : parts) {
//            System.out.printf("부품 이름 : %s , 부품 가격 : %.1f\n", part.partName, part.partPrice);
            part.describePart();
        }
    }
}
