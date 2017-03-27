public class Solution {
    public int compareVersion(String version1, String version2) {
        int id1 = 0;
        int id2 = 0;
        while(id1 < version1.length() || id2 < version2.length()) {
            int v1 = 0;
            int v2 = 0;
            while(id1 < version1.length() && version1.charAt(id1) != '.')
                v1 = v1 * 10 + version1.charAt(id1++) - '0';
            while(id2 < version2.length() && version2.charAt(id2) != '.')
                v2 = v2 * 10 + version2.charAt(id2++) - '0';
            if(v1 > v2) return 1;
            if(v1 < v2) return -1;
            id1++;
            id2++;
        }
        return 0;
    }
}