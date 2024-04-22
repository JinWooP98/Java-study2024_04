package day10.inter.animal;

// extends 와 implement 동시 사용 가능, extends가 Animal 앞에 와야 한다.
public class Rabbit extends Animal implements Pet, Wild{

    @Override
    public void handle() {

    }

    @Override
    public boolean inject() {
        return false;
    }

    @Override
    public void violent() {

    }

    // 사냥기능은 X

    // 난폭한 성격

    // 애완동물로 키우기 가능
}
