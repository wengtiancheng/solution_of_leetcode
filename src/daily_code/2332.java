package daily_code;

import java.util.Arrays;

class lc2332 {
    public int latestTimeCatchTheBus(int[] buses, int[] passengers, int capacity) {
        Arrays.sort(buses);
        Arrays.sort(passengers);
        int p_bus = 0;
        int p_pass = 0;
        int count = 0;
        for(p_bus = 0; p_bus < buses.length; p_bus++){
            for(count = 0; count < capacity && p_pass < passengers.length && passengers[p_pass] <= buses[p_bus]; count++){
                p_pass++;
            }
        }

        int res = count == capacity ? passengers[p_pass - 1] : buses[buses.length - 1];
        int j = p_pass - 1;
        while(j >= 0 && res == passengers[j]){
            j--;
            res--;
        }
        return res;

    }
}