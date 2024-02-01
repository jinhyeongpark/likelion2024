package likelion;

import java.io.File;
import java.io.IOException;
import java.util.Arrays;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Lotto {
    //파일 주소를 받아 로또 번호를 정수 배열로 반환
    public static int[] getFile(String fileName) {
        int lottoNums[] = new int[7]; //7자리 정수 배열 생성
        int i = 0; //카운터
        try {
            Scanner sc = new Scanner(new File(fileName)); //파일 스트림 읽기

            while (sc.hasNext()) {
                lottoNums[i++] = sc.nextInt();
            }
            sc.close();
        } catch (Exception e) {
            System.out.println(e);
        }
        return lottoNums; //배열 반환
    }
    //내 로또 번호를 입력하고 결과 출력받기
    public static void inputMyNums(int[] lottoNums) {
        Scanner sc = new Scanner(System.in);

        int myNums[] = new int[7]; //내 7자리 번호를 저장할 배열

        for (int k = 0; k < 7; k++) {
            try {
                myNums[k] = sc.nextInt(); 
            } catch (InputMismatchException e) {
                System.out.println("정수만 입력해주세요"); //정수가 아닌 경우
                sc.next(); //버퍼 제거
                k--; //카운터 하나 줄임
            }
        }
        int cnt = 0;
        for (int j = 0; j < 6; j++) {
            if (myNums[j] == lottoNums[j]) cnt++; //6번째 번호까지의 매칭 저장
        }
        boolean bonus = ((myNums[6] == lottoNums[6]) ? true : false); //보너스 번호 유무 저장

        switch (cnt) { //등수 출력
            case (6):
                System.out.println("1등");
                break;
            case (5):
                if (bonus) {
                    System.out.println("2등");
                    break;
                } else {
                    System.out.println("3등");
                    break;
                }
            case (4):
                System.out.println("4등");
                break;
            case (3):
                System.out.println("5등");
                break;
            default:
                System.out.println("꽝");
        }
    }

    public static void main(String[] args) {
        inputMyNums(getFile("C:\\Users\\jinhy\\OneDrive\\바탕 화면\\로또 번호.txt"));

    }
}
