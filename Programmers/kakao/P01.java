package programmers.kakao;

import java.util.ArrayList;
import java.util.HashMap;

// 오픈채팅방
public class P01 {
    public String[] solution(String[] record) {
        ArrayList<String> arrayList = new ArrayList<>();
        HashMap<String, String> hashMap = new HashMap<>();

        for (String str : record) {
            String[] temp = str.split(" ");
            String type = temp[0];
            String uid = temp[1];

            if (type.equals("Enter") || type.equals("Change")) {
                String name = temp[2];
                hashMap.put(uid, name);
            }
        }

        for (String aRecord : record) {
            String[] temp = aRecord.split(" ");
            String type = temp[0];
            String uid = temp[1];
            String name = hashMap.get(uid);

            if (type.equals("Enter")) {
                arrayList.add(name + "님이 들어왔습니다.");
            } else if (type.equals("Leave")) {
                arrayList.add(name + "님이 나갔습니다.");
            }
        }

        String[] answer = new String[arrayList.size()];
        arrayList.toArray(answer);

        return answer;
    }
}
