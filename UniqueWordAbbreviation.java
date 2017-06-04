public class ValidWordAbbr {
    
    Map<String, Set<String>> map;

    public ValidWordAbbr(String[] dictionary) {
        map = new HashMap<>();
        for(String str : dictionary) {
            String abbr = "";
            if(str.length() <= 2) abbr = str;
            else abbr = str.charAt(0) + Integer.toString(str.length() - 2) + str.charAt(str.length() - 1);
            if(!map.containsKey(abbr)) map.put(abbr, new HashSet<>());
            map.get(abbr).add(str);
        }
    }
    
    public boolean isUnique(String word) {
        String abbr = "";
        if(word.length() <= 2) abbr = word;
        else abbr = word.charAt(0) + Integer.toString(word.length() - 2) + word.charAt(word.length() - 1);
        return !map.containsKey(abbr) || (map.get(abbr).size() == 1 && map.get(abbr).contains(word));
    }
}

/**
 * Your ValidWordAbbr object will be instantiated and called as such:
 * ValidWordAbbr obj = new ValidWordAbbr(dictionary);
 * boolean param_1 = obj.isUnique(word);
 */