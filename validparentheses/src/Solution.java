public class Solution {
    public boolean isValid(String s) {
        if (s.length() == 0 || s.length()%2 != 0) return false;
        char[] str = s.toCharArray();
        String recent = "";
        int countA = 0, countB = 0, countC = 0;
        for (int i=0; i<str.length; i++) {
            if(str[i] == '(') {
                countA ++;
                recent += "A";
            }
            if(str[i] == '[') {
                countB ++;
                recent += "B";
            }
            if(str[i] == '{') {
                countC ++;
                recent += "C";
            }
            if(str[i] == ')') {
                if (--countA<0) return false;
                if (recent.charAt(recent.length()-1)!='A')
                    return false;
                recent = recent.substring(0, recent.length()-1);
            }
            if(str[i] == ']') {
                if (--countB<0) return false;
                if (recent.charAt(recent.length()-1)!='B')
                    return false;
                recent = recent.substring(0, recent.length()-1);
            }
            if(str[i] == '}') {
                if (--countC<0) return false;
                if (recent.charAt(recent.length()-1)!='C')
                    return false;
                recent = recent.substring(0, recent.length()-1);
            }
        }
        if (countA!=0||countB!=0||countC!=0) return false;
        return true;
    }
}