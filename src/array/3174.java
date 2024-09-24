package array;

class Soution {
    public String clearDigits(String s) {
        int len = s.length();
        int[] tmp = new int[len];
        for(int  i = 0; i < len; i++){
            if(s.charAt(i) <= 57 && s.charAt(i) >= 48){
                tmp[i] = 1;
                for(int j = i; j >= 0; j--){
                    if(tmp[j] == 0){
                        tmp[j] = 1;
                        break;
                    }
                }
            }
        }
        StringBuilder sb = new StringBuilder();
        for(int k = 0; k < len; k++){
            if(tmp[k] == 0){
                sb.append(s.charAt(k));
            }
        }
        return sb.toString();

    }
}