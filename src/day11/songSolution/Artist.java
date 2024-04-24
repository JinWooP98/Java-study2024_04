package day11.songSolution;

import java.io.Serializable;
import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

// 1개의 가수 정보
public class Artist implements Serializable {

    private String artistName; // 가수명
    private Set<String> songList; // 노래목록

    // 생성자
    Artist (String artistName) {
        this.artistName = artistName;
        this.songList = new HashSet<>();
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
        return this.songList;
    }

    public boolean addSongList (String song) {
        boolean falg = this.songList.add(song);
        return falg;
    }

    // ...
}
