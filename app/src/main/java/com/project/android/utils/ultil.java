package com.project.android.utils;

public  class ultil {

    public static String intToVND(int iput){
        String inPut =Integer.toString(iput);
        String rsl = "VND";
        char[] charrr = inPut.toCharArray() ;
        int count = 0;
        for(int i=charrr.length-1;i>=0 ; i--){
            count++;
            rsl =  charrr[i] +rsl ;
            if(count%3 ==0  && count < charrr.length) {
                rsl =  '.' +rsl ;
            }
        }
        return rsl;
    }

}
