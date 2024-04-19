package day07.player;

public class Mage extends Player{


    int mana;

    public Mage(String nickname) {
        super(nickname);
        this.mana = 100;
    }

    public  int damage () {
        return (int)(Math.random() * 6 + 10);
    }


    public void thunderbolt(Player... targets) {
        System.out.println("======================================");
        System.out.printf("# %s님 썬더볼트 시전!!!\n", this.nickname);
        System.out.println("======================================");
        for (Player target : targets) {
            if(target != this) {
                int damage = damage();
                target.hp -= damage;
                System.out.printf("%s님이 %d의 피해를 입었습니다.(남은 체력: %d)\n", target.nickname, damage, target.hp);
            }
        }
    }

    public void showStatus() {
        super.showStatus();
        System.out.println("# mana: " + this.mana);
    }
}
