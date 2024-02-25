import java.util.HashMap;

public class Frequency_Tracker_2671 {
    HashMap<Integer, Integer> map;
    HashMap<Integer, Integer > freq;
    public Frequency_Tracker_2671() {
        map=new HashMap<>();
        freq=new HashMap<>();
    }

    public void add(int number) {
        if(map.get(number)==null){
            map.put(number,1);
            freq.put(1,freq.getOrDefault(1,0)+1);
        }
        else{
            int val=map.get(number);
            map.put(number, val+1);
            if(freq.get(val)==1){
                freq.remove(val);
            }
            else{
                freq.put(val,freq.get(val) -1 );
            }
            freq.put(val+1, freq.getOrDefault(val+1,0)+1);
        }

    }

    public void deleteOne(int number) {
        if(map.get(number) != null){
            if(map.get(number)==1){
                if(freq.get(1)==1){
                    freq.remove(1);
                }
                else{
                    freq.put(1, freq.get(1)-1);
                }
                map.remove(number);
            }
            else{
                int val=map.get(number);
                map.put(number, val-1);
                if(freq.get(val)==1){
                    freq.remove(val);
                }
                else{
                    freq.put(val, freq.get(val)-1);
                }
                freq.put(val-1, freq.getOrDefault(val-1,0)+1);
            }
        }
    }
    public boolean hasFrequency(int frequency) {
        return freq.get(frequency) != null;

    }

    public static void main(String[] args) {
        Frequency_Tracker_2671 tracker = new Frequency_Tracker_2671();
        System.out.println(tracker.hasFrequency(1)); // false
        tracker.add(3);
        System.out.println(tracker.hasFrequency(1)); // true
        System.out.println(tracker.hasFrequency(1)); // true
        tracker.add(6);
        tracker.add(2);
        tracker.add(6);
        tracker.deleteOne(6);
        tracker.deleteOne(6);
        System.out.println(tracker.hasFrequency(6)); // false
        tracker.add(2);
        System.out.println(tracker.hasFrequency(2)); // true
        System.out.println(tracker.hasFrequency(1)); // true
    }
}

/*
FrequencyTracker"
,"hasFrequency"
,"add",
"hasFrequency",
"hasFrequency",
"add",
"add",
"add"
,"deleteOne",
"deleteOne",
"hasFrequency"
,"add"
,"hasFrequency"
,"hasFrequency"]

 */
