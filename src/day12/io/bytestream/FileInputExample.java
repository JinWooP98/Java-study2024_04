package day12.io.bytestream;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import static day12.io.FileExample.ROOT_PATH;


// 바이트 기반 출력 스트림 예제 : 영상, 이미지, 텍스트 등 모든 데이터 출력가능
public class FileInputExample {



    public static void main(String[] args) {

        try (FileInputStream fis = new FileInputStream(ROOT_PATH + "/hello/pet.txt")) {
            int data = 0;// 세이브파일 로드 명령

            while((data = fis.read()) != -1) {

                // 아스키코드를 문자로 출력
                System.out.write(data);
            }
            // 출력 버퍼 비우기
            System.out.flush();

        } catch (FileNotFoundException e) {
            System.out.println("해당 경로를 찾을 수 없습니다.");
        } catch (IOException e) {
            System.out.println("출력 시스템에 장애가 발생했습니다.");
        }


    }

}
