package day10.abs;

public class Main {

    public static void main(String[] args) {



        Dog myDog = new Dog();
        Dog myDog2 = new Dog();
        Dog myDog3 = new Dog();
        Cat myCat = new Cat();

        Pet[] petList = {myDog, myDog2, myDog3, myCat};

        for (Pet pet : petList) {
            pet.eat();
        }
    }
}
