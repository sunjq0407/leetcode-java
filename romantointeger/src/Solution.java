public class Solution {
    public int romanToInt(String s) {
        char[] str = s.toCharArray();
        int thousands = 0, hundreds = 0,
            tens = 0, ones = 0;
        int i = 0;
        while (str[i] == 'M') {
            thousands ++;
            if (++i == str.length)
                return thousands*1000;
        }//thousands end
        while (str[i] == 'C') {
            hundreds ++;
            if (++i == str.length)
                return thousands*1000 + hundreds*100;
            if (str[i] == 'D') {
                hundreds = 4;
                if (++i == str.length)
                    return thousands*1000 + hundreds*100;
            }
            if (str[i] == 'M') {
                hundreds = 9;
                if (++i == str.length)
                    return thousands*1000 + hundreds*100;
            }
        }
        if (str[i] == 'D') {
            hundreds += 5;
            if (++i == str.length)
                return thousands*1000 + hundreds*100;
            while (str[i] == 'C') {
                hundreds ++;
                if (++i == str.length)
                    return thousands*1000 + hundreds*100;
            }
        }//hundreds end
        while (str[i] == 'X') {
            tens ++;
            if (++i == str.length)
                return thousands*1000 + hundreds*100 + tens*10;
            if (str[i] == 'L') {
                tens = 4;
                if (++i == str.length)
                    return thousands*1000 + hundreds*100 + tens*10;
            }
            if (str[i] == 'C') {
                tens = 9;
                if (++i == str.length)
                    return thousands*1000 + hundreds*100 + tens*10;
            }
        }
        if (str[i] == 'L') {
            tens += 5;
            if (++i == str.length)
                return thousands*1000 + hundreds*100 + tens*10;
            while (str[i] == 'X') {
                tens ++;
                if (++i == str.length)
                    return thousands*1000 + hundreds*100 + tens*10;
            }
        }//tens end
        while (str[i] == 'I') {
            ones ++;
            if (++i == str.length)
                return thousands*1000 + hundreds*100 + tens*10 + ones;
            if (str[i] == 'V') {
                ones = 4;
                if (++i == str.length)
                return thousands*1000 + hundreds*100 + tens*10 + ones;
            }
            if (str[i] == 'X') {
                ones = 9;
                if (++i == str.length)
                    return thousands*1000 + hundreds*100 + tens*10 + ones;
            }
        }
        if (str[i] == 'V') {
            ones += 5;
            if (++i == str.length)
                return thousands*1000 + hundreds*100 + tens*10 + ones;
            while (str[i] == 'I') {
                ones ++;
                if (++i == str.length)
                    return thousands*1000 + hundreds*100 + tens*10 + ones;
            }
        }//ones end
        return thousands*1000 + hundreds*100 + tens*10 + ones;
    }
}