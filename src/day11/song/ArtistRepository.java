package day11.song;

import java.util.*;

// 가수객ㅊ체 여러개를 관리 (조회, 수정, 삭제, 생성, 탐색, 정렬...)
public class ArtistRepository {

    // 가수들을 담을 자료구조 선언
    // key: 가수이름, value: 가수 객체(가수명, 노래리스트)
    private Map<String, Artist> artistMap = new HashMap<>();

    // 가수 정보 생성
    public void addArtist(Artist artist) {
        artistMap.put(artist.getArtistName(), artist);
    }
    // 가수 정보 탐색

    public Map<String, Artist> getArtistMap() {
        return artistMap;
    }

}