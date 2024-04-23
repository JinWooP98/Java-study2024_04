package day11.songSolution;



import java.util.*;

// 가수객ㅊ체 여러개를 관리 (조회, 수정, 삭제, 생성, 탐색, 정렬...)
public class ArtistRepository {

    // 가수들을 담을 자료구조 선언
    // key: 가수이름, value: 가수 객체(가수명, 노래리스트)
    private Map<String, Artist> artistMap = new HashMap<>();

    // 가수 정보 생성

    // 가수 정보 탐색


    public int count() {
        return artistMap.size();
    }

    public boolean isRegitered(String artistName) {
        return artistMap.containsKey(artistName);
    }

    public void addNewArtist(String artistName, String songName) {
        Artist newArtist = new Artist(artistName);
        // 첫번째 노래 songList에 추가
        newArtist.addSongList(songName);
        this.artistMap.put(artistName, newArtist);
    }

    public boolean addNewSong(String artistName, String songName) {
        // map에서 기존 가수 정보를 가져와본다.
        Artist foundArtist = this.artistMap.get(artistName);
        // 이 가수의 노래리스트에 새노래를 추가해준다.
        return foundArtist.addSongList(songName);
    }

    public Set<String> getSongList(String artistName) {
        Artist foundArtist = artistMap.get(artistName);

        return foundArtist.getSongList();
    }
}