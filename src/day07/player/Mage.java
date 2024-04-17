package day07.player;

public class Mage extends Player{


    int mana;

    public Mage(String nickname) {
        this.nickname = nickname;
        this.level = 1;
        this.hp = 50;
        this.mana = 100;
    }



    public void thunderbolt(Mage... targets) {

    }

    public void showStatus() {
        super.showStatus();
        System.out.println("# mana: " + this.mana);
    }
}
