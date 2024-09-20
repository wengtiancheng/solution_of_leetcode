class lc3281 {
    public int maxPossibleScore(int[] start, int d) {
        start = sort(start);
        int len = start.length;
        int max_leap = start[1] - start[0];
        int min_leap = start[1] - start[0];
        for(int i = 0; i < len - 1; i++){
            int leap = start[i + 1] - start[i];
            if(leap < min_leap){
                min_leap = leap;
            }
            if(leap > max_leap){
                max_leap = leap;
            }
        }
        int left = min_leap;
        int right = max_leap;
        int mid = (left + right) / 2;
        while(mid > left && mid < right){
            if(judge(start, d, mid)){
                left = mid;
                mid = (right + left) / 2;
            }else{
                right = mid;
                mid = (right + left) / 2;
            }
        }
        return mid;



    }

    public int[] merge(int[] left, int[] right){
        int len1 = left.length;
        int len2 = right.length;
        int len = len1 + len2;
        int[] res = new int[len];
        int i = 0;
        int j = 0;
        int k = 0;
        while(i < len1 && j < len2){
            if(left[i] < right[j]){
                res[k] = left[i];
                i++;
            }else{
                res[k] = right[j];
                j++;
            }
            k++;
        }
        while(i < len1){
            res[k] = left[i];
            i++;
            k++;
        }
        while(j < len2){
            res[k] = right[j];
            j++;
            k++;
        }
        return res;


    }
    public int[] sort(int num[]){
        int len = num.length;
        if(len < 2){
            return num;
        }else{
            int mid = len / 2;
            int[] left = new int[mid];
            int[] right = new int[len - mid];
            for(int i = 0; i < mid; i++){
                left[i] = num[i];
            }
            for(int i = mid; i < len; i++){
                right[i - mid] = num[i];
            }
            return merge(sort(left), sort(right));

        }
    }
    boolean judge(int[] start, int d, int leap){
        int len = start.length;
        int before = start[0];
        int after = 0;
        for(int i = 1; i < len; i++){
            after = before + leap;
            if(after > start[i] + leap){
                return false;
            }else if(after >= start[i] && after <= start[i] +leap){
                before = after;
            }else{
                before = start[i];
            }
        }
        return true;

    }
}