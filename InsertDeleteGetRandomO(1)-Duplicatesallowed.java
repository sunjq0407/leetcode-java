class RandomizedCollection {
    
    List<Integer> list;
    Map<Integer, Set<Integer>> map;
    Random rand;

    /** Initialize your data structure here. */
    public RandomizedCollection() {
        list = new ArrayList<>();
        map = new HashMap<>();
        rand = new Random();
    }
    
    /** Inserts a value to the collection. Returns true if the collection did not already contain the specified element. */
    public boolean insert(int val) {
        list.add(val);
        if(map.containsKey(val)) {
            map.get(val).add(list.size() - 1);
            return false;
        }
        Set<Integer> set = new HashSet<>();
        set.add(list.size() - 1);
        map.put(val, set);
        return true;
    }
    
    /** Removes a value from the collection. Returns true if the collection contained the specified element. */
    public boolean remove(int val) {
        if(!map.containsKey(val)) {
            return false;
        }
        int idxToRemove = map.get(val).iterator().next();
	    map.get(val).remove(idxToRemove);
	    if (idxToRemove < list.size() - 1 ) {
	       int last = list.get(list.size() - 1);
	       list.set(idxToRemove , last);
	       map.get(last).remove(list.size() - 1);
	       map.get(last).add(idxToRemove);
	    }
	    list.remove(list.size() - 1);
	    if (map.get(val).isEmpty()) {
            map.remove(val);
        }
        return true;
    }
    
    /** Get a random element from the collection. */
    public int getRandom() {
        return list.get(rand.nextInt(list.size()));
    }
}

/**
 * Your RandomizedCollection object will be instantiated and called as such:
 * RandomizedCollection obj = new RandomizedCollection();
 * boolean param_1 = obj.insert(val);
 * boolean param_2 = obj.remove(val);
 * int param_3 = obj.getRandom();
 */