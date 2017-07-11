public class Solution {
    public List<String> generateAbbreviations(String word) {
        List<String> list = new ArrayList<>();
        if(word.length() == 0) {
            list.add("");
            return list;
        }
        for(char c : word.toCharArray()) {
            if(list.size() == 0) {
                list.add("1");
                list.add(c + "");
                continue;
            }
            List<String> cur = new ArrayList<>();
            for(String str : list) {
                if(Character.isDigit(str.charAt(str.length() - 1))) {
                    int i = str.length() - 1;
                    for(; i >= 0; i--)
                        if(!Character.isDigit(str.charAt(i))) break;
                    String prefix = "";
                    if(i >= 0) prefix = str.substring(0, i + 1);
                    int cnt = Integer.parseInt(str.substring(i + 1)) + 1;
                    cur.add(prefix + cnt);
                    cur.add(str + c);
                } else {
                    cur.add(str + "1");
                    cur.add(str + c);
                }
            }
            list = cur;
        }
        return list;
    }
}