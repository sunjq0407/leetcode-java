class Solution {
    public boolean validUtf8(int[] data) {
        int remains = 0;
        for(int i = 0; i < data.length; i++) {
            int utf = data[i];
            if(utf > 255) {
                return false;
            }
            if((utf & 0b10000000) == 0) {
                remains = 0;
            } else if((utf & 0b11100000) == 0b11000000) {
                remains = 1;
            } else if((utf & 0b11110000) == 0b11100000) {
                remains = 2;
            } else if((utf & 0b11111000) == 0b11110000) {
                remains = 3;
            } else {
                System.out.println("1");
                return false;
            }
            for(int j = 1; j <= remains; j++) {
                if(i + j >= data.length || (data[i + j] & 0b11000000) != 0b10000000) {
                    return false;
                }
            }
            i += remains;
        }
        return true;
    }
}