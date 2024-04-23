package day11.song;

import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

// 1개의 가수 정보
public class Artist {

    private String artistName; // 가수명
    private Set<String> songList; // 노래목록

    // 생성자
    Artist (String artistName, String song) {
        this.artistName = artistName;
        this.songList = new HashSet<>();
        this.songList.add(song);

    }

    //setter, getter

    public void setArtistName(String artistName) {
        this.artistName = artistName;
    }

    public void setSongList(Set<String> songList) {
        this.songList = songList;
    }

    public String getArtistName() {
        return artistName;
    }

    public Set<String> getSongList() {
        return songList;
    }

    public void addSongList (String song) {
        songList.add(song);
    }

    // ...
}
