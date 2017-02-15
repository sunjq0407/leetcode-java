public class Solution {
    public String simplifyPath(String path) {
        List<String> list = new ArrayList<>();
        int idx = 0;
        while(idx < path.length()) {
            StringBuilder sb = new StringBuilder();
            sb.append('/');
            for(idx++; idx < path.length(); idx++) {
                if(path.charAt(idx) == '/') break;
                sb.append(path.charAt(idx));
            }
            String str = sb.toString();
            if(str.equals("/.") || str.equals("/")) continue;
            else if(str.equals("/..")) {
                if(list.size() > 0) list.remove(list.size() - 1);
            }
            else list.add(str);
        }
        StringBuilder sb = new StringBuilder();
        for(String str : list) sb.append(str);
        String ret = sb.toString();
        if(ret.equals("")) return "/";
        return ret;
    }
}