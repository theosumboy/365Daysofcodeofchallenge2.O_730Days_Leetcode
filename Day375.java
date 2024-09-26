class MyCalendar {
    private TreeMap<Integer, Integer> startEndMp = null; 
    public MyCalendar() {
        startEndMp = new TreeMap<>();
    }
    
    public boolean book(int start, int end) {
        var closerFromRight = startEndMp.ceilingEntry(start);
        var closerFromLeft = startEndMp.floorEntry(start); 
        if(closerFromRight != null && end > closerFromRight.getKey()){
            return false;
        }
        if(closerFromLeft != null && start < closerFromLeft.getValue()){
            return false;
        }
        startEndMp.put(start, end);
        return true;
    }
}
