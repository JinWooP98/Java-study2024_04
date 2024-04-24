package day12.io.textstream;

// 텍스트 기반 스트림: 텍스트 입츌력에 특화된 스트림으로 2바이트 이상 데이터를 처리 가능

import day12.io.FileExample;
import util.SimpleInput;

import java.io.BufferedReader;
import java.io.FileWriter;

// 바이트 기반 스트림 조상 : OutputStream, InputStream
// 텍스트 기반 스트림 조상 : Writer, Reader
public class FileWriterExample {

    public static void main(String[] args) {

        String targetPath = FileExample.ROOT_PATH + "/hello/hobby.txt";

        // true의 경우 입력값을 저장할 때 원래 있던 내용을 없애지 않고 거기에 추가하는 형식이 된다.
        try (FileWriter fw = new FileWriter(targetPath, true)) {

            String hobby = SimpleInput.input("취미를 입력하세요!!\n>>");
            String outputMessage = String.format("내 취미는 %s입니다.\n", hobby);

            // 파일 생성 명령
            fw.write(outputMessage);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
