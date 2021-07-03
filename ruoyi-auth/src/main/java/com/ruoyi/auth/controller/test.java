package com.ruoyi.auth.controller;

public class test {

    public static void main(String[] args) {

        System.out.println(findPeak(new int[]{-200,-100,1,4,0}));
        int sum = 754;
        int resu = getnum(sum);
        String aba = "ABABAAABAB";
//        int resu = getMaxLength(aba);
        System.out.println(resu);
        //1.部⻔优化
        mustTeam(5*12);
//        //方法2
//        func isStepSum2 (stepSum int)bool {
//            global111:=getGlobal111(stepSum)
//            for global111 > 0 {
//                quotient:=stepSum / global111  //商
//                remainder:=stepSum % global111 //余数
//                if quotient >= 10 {
//                    return false
//                }
//                global111 /= 10
//                stepSum = remainder
//            }
//            return true
//        }
    }
    //发现规律 4月一循环
    static void mustTeam(int months)
    {
        if (months<0)
        {
            return;
        }
        int temp = months % 4;
        int must = 0;
        String team = "";
        int[] m1=new int[] { 7, 8, 6, 5 };
        int[] m2 = new int[] { 8, 5, 7, 6 };
        int[] m3 = new int[] { 5, 6, 8, 7 };
        int[] m4 = new int[] { 6, 7, 5, 8 };
        switch (temp)
        {
            case 1:
                team = "B";
                must = 8;
                break;
            case 2:
                team = "A";
                must = 8;
                break;
            case 3:
                team = "C";
                must = 8;
                break;
            case 0:
                team = "D";
                must = 8;
                break;
            default:
                break;
        }
        System.out.println(team+"队"+must);

    }
    public static int getnum (int sum) {
        int ans = 1;
        int anstemp = 11;
        for (;anstemp <= sum;) {
            ans = anstemp;
            anstemp *= 10;
            anstemp++;
        }
        int result = 0;
        for (;ans > 0;) {
            int quotient =sum / ans ; //商
            int remainder =sum % ans ; //余数
            if (quotient >= 10) {
                return -1;
            }
            result =result*10+ quotient;
            ans /= 10;
            sum = remainder;
        }
        return result;
//        return ans
//        String sumstr = String.valueOf(sum);
//        int sumlenth = sumstr.length();
//        String onestr = "";
//        for (int i = 0;i < sumlenth; i++) {
//            onestr += "1";
//        }
//        int one = Integer.parseInt(onestr);

    }
    public static char[] lenForStr (char[] ch) {
        char[] nech = new char[ch.length];
        for(int i=0;i<nech.length;i++){
            char item = ch[i];
            nech[i] = item;
        }
//        nech = ch;
        if(ch[0] != ch[ch.length-1]) {
            for(int i=0;i<nech.length-1;i++){
                nech[i] = ch[i+1];
            }
            nech[ch.length-1] = ch[0];
        }
        if(nech[0] != nech[nech.length-1]) {
            nech = lenForStr (nech);
        }
        return nech;
    }
    public static  int getMaxLength(String str){
        int result=0;
        int temp=1;
        int strlenth = str.length();
        char[] ch=str.toCharArray();
        ch = lenForStr (ch);
//        if(ch[0] != ch[strlenth]) {
//            char[] nech = new char[ch.length];
//            for(int i=0;i<nech.length-1;i++){
//                nech[i] = ch[i+1];
//            }
//            nech[strlenth] = ch[0];
//        }
        for(int i=0;i<ch.length-1;i++){
            if(ch[i]!=ch[i+1] ){
                temp++;
            }else {
                temp = 1;
            }
            if(temp>result){
                result=temp;
            }

        }
        return result;
    }


        public static boolean isUp(int[] array, int m){
            return array[m - 1] < array[m] && array[m] < array[m + 1];
        }

        public static int findPeak(int[] array){
            if(array == null || array.length <= 2)
                return -1;
            int mark = 0;
            if(array[0] > array[1])
                mark = -1;
            else
                mark = 1;
            int start = 0, end = array.length - 1;
            while(start <= end){
                int m = (start + end) / 2;
                if(m == 0 || m == array.length - 1)
                    return -1;
                if((array[m - 1] > array[m] && array[m + 1] > array[m]) || (array[m - 1] < array[m] && array[m + 1] < array[m])){
                    return m;
                }
                //往左边
                if((isUp(array, m) && mark < 0) || (!isUp(array, m) && mark > 0)){
                    end = m - 1;
                }else{//右边
                    start = m + 1;
                }
            }
            return -1;
        }

}
