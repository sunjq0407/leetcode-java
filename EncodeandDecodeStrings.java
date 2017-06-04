public class Codec {

    // Encodes a list of strings to a single string.
    public String encode(List<String> strs) {
        StringBuilder sb = new StringBuilder();
        for(String str : strs)
            sb.append(str.length() + "/" + str);
        return sb.toString();
    }

    // Decodes a single string to a list of strings.
    public List<String> decode(String s) {
        List<String> ret = new ArrayList<>();
        int i = 0;
        while(i < s.length()) {
            int slash = s.indexOf('/', i);
            int len = Integer.parseInt(s.substring(i, slash));
            ret.add(s.substring(slash + 1, slash + len + 1));
            i = slash + len + 1;
        }
        return ret;
    }
}

// Your Codec object will be instantiated and called as such:
// Codec codec = new Codec();
// codec.decode(codec.encode(strs));