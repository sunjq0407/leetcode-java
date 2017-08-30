class PhoneDirectory {
    
    Queue<Integer> q;
    Set<Integer> set;

    /** Initialize your data structure here
        @param maxNumbers - The maximum numbers that can be stored in the phone directory. */
    public PhoneDirectory(int maxNumbers) {
        q = new LinkedList<>(IntStream.range(0, maxNumbers)
                .boxed().collect(Collectors.toList()));
        set = new HashSet<>(q);
    }
    
    /** Provide a number which is not assigned to anyone.
        @return - Return an available number. Return -1 if none is available. */
    public int get() {
        if(q.isEmpty()) {
            return -1;
        }
        int ret = q.poll();
        set.remove(ret);
        return ret;
    }
    
    /** Check if a number is available or not. */
    public boolean check(int number) {
        return set.contains(number);
    }
    
    /** Recycle or release a number. */
    public void release(int number) {
        if(set.add(number)) {
            q.offer(number);
        }
    }
}

/**
 * Your PhoneDirectory object will be instantiated and called as such:
 * PhoneDirectory obj = new PhoneDirectory(maxNumbers);
 * int param_1 = obj.get();
 * boolean param_2 = obj.check(number);
 * obj.release(number);
 */