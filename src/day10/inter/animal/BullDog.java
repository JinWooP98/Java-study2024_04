package day10.inter.animal;

// 인터페이스는 다중 상속을 할 수 있음
public class BullDog implements Pet, Aggressive{

    @Override
    public void handle() {

    }

    @Override
    public boolean inject() {
        return false;
    }

    @Override
    public void hunt(Pet pet) {

    }

    @Override
    public void violent() {

    }

    // 사냥 기능

    // 난폭함

    // 애완동물로 키울 수 있음
}
