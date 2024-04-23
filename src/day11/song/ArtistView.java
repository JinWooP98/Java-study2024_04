package day11.song;

import util.SimpleInput;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;

public class ArtistView {

    private static ArtistRepository repository = new ArtistRepository();
    private static final Scanner sc = new Scanner(System.in);

    // 프로그램 실행
    public static void start() {
        while(true) {
            String menuNum = menu();
            switch (menuNum) {
                case "1":
                    inputArtist();
                    break;
                case "2":
                    searchArtistInfo();
                    break;
                case "3":
                    System.out.println("프로그램이 종료됩니다.");
                    return;
                default:
                    System.out.println("메뉴 번호를 정확히 입력해 주세요.");
                    break;
            }

        }
    }

    public static String menu() {
        System.out.println("\n******** 음악 관리 프로그램 ********");
        System.out.printf("# 현재 등록된 가수: %d명\n", repository.getArtistMap().size());
        System.out.println("# 1. 노래 등록하기");
        System.out.println("# 2. 노래 정보 검색");
        System.out.println("# 3. 프로그램 종료");
        System.out.println("==============================");
        System.out.print(">> ");
        String menuNumber = sc.nextLine();

        return menuNumber;
    }

    public static void inputArtist() {
        System.out.println("\n# 노래 등록을 시작합니다.");
        System.out.print("- 가수명: ");
        String singer = sc.nextLine();
        System.out.print("- 노래명: ");
        String song = sc.nextLine();
        if(repository.getArtistMap().containsKey(singer)) {
            if( !repository.getArtistMap().get(singer).getSongList().contains(song)) {
                repository.getArtistMap().get(singer).getSongList().add(song);
                System.out.printf("%s님의 노래목록에 %s곡이 추가되었습니다.\n", singer, song);
            } else  {
                System.out.printf("[%s]곡은 이미 등록된 노래입니다.\n", song);
            }
        } else {
            Artist artist = new Artist(singer, song);
            repository.addArtist(artist);
            System.out.printf("# %s님이 신규 등록 되었습니다.\n ", singer);
        }

    }

    public static void searchArtistInfo() {
        System.out.println("\n# 검색할 가수명을 입력하세요.");
        String inputArtistName = SimpleInput.input("- 가수명: ");
        if(!repository.getArtistMap().containsKey(inputArtistName)) {
            System.out.println("\n해당 가수는 등록되지 않았습니다.");
            return;
        } else {
            System.out.printf("\n# %s님의 노래목록\n", inputArtistName);
            System.out.println("====================");
            int count = 1;
            Set<String> nowSongList = repository.getArtistMap().get(inputArtistName).getSongList();
            for (String song : nowSongList) {
                System.out.printf("* %d. %s\n", count, song);
                count++;
            }

        }

    }



}
