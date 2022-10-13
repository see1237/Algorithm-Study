// 해시

import java.util.HashMap;

class Solution {
    public String solution(String[] participant, String[] completion) {
        String answer = "";
        HashMap<String, Integer> map = new HashMap<>();
        // key: Participant / Value: Count
        for(String player : participant) {
            // getOrDefault(Object key, V DefaultValue)
            // -> Key에 해당하는 Value가 있으면 가져오고, 아닐 경우 defaultValue로 지정하여 사용하겠다는 의미
            map.put(player, map.getOrDefault(player, 0) + 1);
        }
        for(String player : completion) {
            map.put(player, map.get(player) - 1);
        }
        for(String key : map.keySet()) {
            if(map.get(key) != 0) {
                answer = key;
                break;
            }
        }
        return answer;
    }
}