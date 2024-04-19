package day09.poly.practice1;

// 서브 클래스 Processor
class Processor extends ComputerPart {

    public Processor(String partName, double partPrice) {
        super(partName, partPrice);
    }

    @Override
    public void describePart() {
        System.out.println("Processor: " + partName + ", Price: " + partPrice);
    }
}
