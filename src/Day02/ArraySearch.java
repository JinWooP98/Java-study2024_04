package Day02;

public class ArraySearch {
    public static void main(String[] args) {

        String[] foods = {"라면", "김밥", "치킨", "파스타"};

        String target = "치킨";

        int index = -1;
        for (int i = 0; i < foods.length; i++) {
            if(target.equals(foods[i])) {
                index = i;
                break;
            }
        }

    }
}
