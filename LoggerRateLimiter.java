public class Logger {
    
    private class Log {
        String m;
        int t;
        public Log(String m, int t) {
            this.m = m;
            this.t = t;
        }
    }
    
    private static final int LOG_LAST_TIME = 10;
    LinkedList<Log> logList;
    Set<String> messageSet;

    /** Initialize your data structure here. */
    public Logger() {
        logList = new LinkedList<>();
        messageSet = new HashSet<>();
    }
    
    /** Returns true if the message should be printed in the given timestamp, otherwise returns false.
        If this method returns false, the message will not be printed.
        The timestamp is in seconds granularity. */
    public boolean shouldPrintMessage(int timestamp, String message) {
        while(!logList.isEmpty()) {
            if(logList.peek().t <= timestamp - LOG_LAST_TIME) {
                messageSet.remove(logList.poll().m);
            } else {
                break;
            }
        }
        if(messageSet.contains(message)) {
            return false;
        }
        logList.offer(new Log(message, timestamp));
        messageSet.add(message);
        return true;
    }
}

/**
 * Your Logger object will be instantiated and called as such:
 * Logger obj = new Logger();
 * boolean param_1 = obj.shouldPrintMessage(timestamp,message);
 */