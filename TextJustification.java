public class Solution {
    public List<String> fullJustify(String[] words, int maxWidth) {
        List<String> ret = new ArrayList<>();
        if(words.length == 0 || (words.length == 1 && words[0].equals(""))) {
            StringBuilder sb = new StringBuilder();
            for(int i = 0; i < maxWidth; i++) sb.append(' ');
            ret.add(sb.toString());
            return ret;
        }
        int idx = 0;
        int lineLen = 0;
        List<String> list = new ArrayList<>();
        for(String str : words) {
            if(lineLen + str.length() > maxWidth) {
                addOneLine(list, ret, lineLen, maxWidth);
                lineLen = 0;
                list.clear();
            }
            list.add(str);
            lineLen += str.length() + 1;
        }
        if(list.size() != 0) {
            StringBuilder sb = new StringBuilder();
            for(String str : list) sb.append(str + ' ');
            sb.deleteCharAt(sb.length() - 1);
            while(sb.length() < maxWidth) sb.append(' ');
            ret.add(sb.toString());
        }
        return ret;
    }
    
    private void addOneLine(List<String> list, List<String> ret, int lineLen, int maxWidth) {
        StringBuilder sb = new StringBuilder();
        if(list.size() == 1) {
            sb.append(list.get(0));
            while(sb.length() < maxWidth) sb.append(' ');
            ret.add(sb.toString());
            return;
        }
        int blankNum = list.size() - 1;
        int spaceNum = maxWidth - lineLen + list.size();
        int num = spaceNum / blankNum;
        int pivot = spaceNum % blankNum;
        for(int i = 0; i < list.size() - 1; i++) {
            sb.append(list.get(i));
            for(int j = 0; j < (i < pivot ? num+1 : num); j++) sb.append(' ');
        }
        sb.append(list.get(list.size() - 1));
        ret.add(sb.toString());
    }
}