public class Main {
    public static void main(String[] args) {
        int numRolls = 4;
        int[] newRolls = roll(numRolls);
        for(int i = 0 ; i < numRolls ; i++){
            System.out.println(newRolls[i]);
        }

        containsDuplicates(newRolls);

        double average = avg(newRolls);
        System.out.println(average);

        int[][] weeklyMonthTemperatures = {
                {66, 64, 58, 65, 71, 57, 60},
                {57, 65, 65, 70, 72, 65, 51},
                {55, 54, 60, 53, 59, 57, 61},
                {65, 56, 55, 52, 55, 62, 57}
        };

        int[] lowestAvgArr = lowestAvg(weeklyMonthTemperatures);
        for(int i = 0 ; i < lowestAvgArr.length ; i++){
            System.out.println(lowestAvgArr[i]);
        }
    }



    public static int[] roll(int n){
        int min = 1 ;
        int max = 6 ;

        int[] myRolls;
        myRolls = new int[n];
        for(int i = 0 ; i<n ; i++){
            myRolls[i]= (int)Math.floor(Math.random()*(max-min+1)+min);
//            System.out.println(myRolls[i]);
        }

//        System.out.println("out of method");
        return myRolls;
    }

    public static boolean containsDuplicates(int[] arr){
        for(int i = 0 ; i < arr.length ; i++){
            for(int j = i + 1 ; j < arr.length ; j++){
                if(arr[i] == arr[j])
                {
                    System.out.println("true");
                    return true ;
                }

            }
        }
        System.out.println("false");
        return false ;
    }

    public static double avg(int[] arr){
        double sum = 0 ;
        for(int i = 0 ; i < arr.length ; i++){
            sum = sum + arr[i];
//            System.out.println(sum);
        }
        return sum/arr.length;
    }

    public static int[] lowestAvg(int[][] arr){
        double sum = 0 ;
        double average = 0;

        double firstSum = 0;
        double firstAvg = 0;

        int index1 = 0 ;

        int[] lowestAvgArr;
        for(int i = 0 ; i < arr[0].length ; i++){
            firstSum = firstSum + arr[0][i];
            firstAvg = firstSum/arr[0].length;
        }
//        System.out.println("first average = " + firstAvg);

        double lowestAverage = firstAvg ;
        for(int i = 0 ; i < arr.length ; i++){
            for(int j = 0 ; j < arr[i].length ; j++){
                sum = sum + arr[i][j];
//                System.out.println(sum);
                average = sum/arr[i].length;
            }
            if(average<lowestAverage){
                lowestAverage=average;
                index1=i;
//                System.out.println("lowest avg = " + lowestAverage);
            }
//            System.out.println("average = " + average);
            sum=0;
            average=0;
        }
        lowestAvgArr=arr[index1];
        return lowestAvgArr;
    }

}