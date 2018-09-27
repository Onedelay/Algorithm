package programmers.level2;

import java.util.Arrays;
import java.util.HashMap;
import java.util.regex.Pattern;

// 레벨 2 : 전화번호부
public class P42577 {

    // 해시 문제라길래 해시로 풀었는데, 이렇게 푼사람 아무도 안보인다.....ㅠㅠ
    // 그리고 굳이 해시 안써도 될 것 같은데...?
    public boolean solution(String[] phone_book) {
        // phone_book 초기화
        HashMap<Integer, String> hashMap = new HashMap<>();
        for (int i = 0; i < phone_book.length; i++) {
            hashMap.put(i, phone_book[i].replaceAll("\\s", ""));
        }

        /* 정규표현식
         * ^ : 문자열의 시작
         * () : 한 문자로 취급
         * $ : 문자열의 끝
         * + : 앞의 문자열이 하나 이상 있는지 */
        for (int i = 0; i < hashMap.size(); i++) {
            Pattern p = Pattern.compile("^(" + hashMap.get(i) + ")+");

            for (int j = 0; j < hashMap.size(); j++) {
                if (j != i) {
                    if (p.matcher(hashMap.get(j)).find()) return false;
                }
            }
        }

        return true;
    }

    // 해시 안쓴 개선 버전ㅠㅠ 진작 이걸로 할걸
    public boolean solution_(String[] phone_book) {

        for (int i = 0; i < phone_book.length; i++) {
            Pattern p = Pattern.compile("^(" + phone_book[i] + ")+");

            for (int j = 0; j < phone_book.length; j++) {
                if (j != i) {
                    if (p.matcher(phone_book[j]).find()) return false;
                }
            }
        }

        return true;
    }

    // 새로 알게된 startWith : 문자열이 주어진 접두표현을 가지고 시작하는지 확인. 접두표현 가지고 시작한다면 true
    public boolean solution1(String[] phoneBook) {
        for (int i = 0; i < phoneBook.length - 1; i++) {
            for (int j = i + 1; j < phoneBook.length; j++) {
                if (phoneBook[i].startsWith(phoneBook[j])) {
                    return false;
                }
                if (phoneBook[j].startsWith(phoneBook[i])) {
                    return false;
                }
            }
        }
        return true;
    }

    // Arrays
    public boolean solution2(String[] phoneBook) {
        Arrays.sort(phoneBook); // 짧은것부터 긴 순으로 정렬되겠지?
        for (int i = 0; i < phoneBook.length; i++) {
            for (int j = i + 1; j < phoneBook.length; j++) {
                if (phoneBook[j].contains(phoneBook[i])) {
                    return false;
                }
            }
        }
        return true;
    }
}
