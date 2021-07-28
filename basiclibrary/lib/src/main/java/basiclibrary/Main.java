import java.util.HashSet;
import java.util.ArrayList;
import java.util.List;
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

        System.out.println("\n\nLAB02\n\n");
        analyze(weeklyMonthTemperatures);
        System.out.println("\n\n");

        List<String> votes = new ArrayList<>();
        votes.add("Bush");
        votes.add("Bush");
        votes.add("Bush");
        votes.add("Shrub");
        votes.add("Hedge");
        votes.add("Shrub");
        votes.add("Bush");
        votes.add("Hedge");
        votes.add("Bush");

        tally(votes);
        String winner = tally(votes);
        System.out.println(winner + " received the most votes!");
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

    public static String analyze(int[][] arr){
        int min = arr[0][0];
        int max = arr[0][0];
        for(int i = 0 ; i<arr.length ; i++){
            for(int j = 0 ; j< arr[i].length ; j++){
                if(min>=arr[i][j]){
                    min=arr[i][j];
                }
                else if (max<=arr[i][j]){
                    max=arr[i][j];
                }
            }
        }
//        System.out.println("min = " + min + " max = " + max);

        HashSet<Integer>set = new HashSet<Integer>();
        for(int i = 0 ; i<arr.length ; i++){
            for(int j = 0 ; j< arr[i].length ; j++){
                set.add(arr[i][j]);
            }
        }
//        System.out.println(set);

        String str = "High : " + max + "\n" + "Low : " + min ;
        for(int i = min ; i < max ; i++){
            if(set.contains(i)){
            }
            else{
                str = str.concat("\n"+"Never saw temperature: " + i);
            }
        }
        System.out.println(str);
        return str;
    }

    public static String tally(List<String> votes){
//        System.out.println(votes);
        HashSet<String>set = new HashSet<String>();
        for(int i = 0 ; i < votes.size() ;i++){
            set.add(votes.get(i));
        }
//        System.out.println(set);
        Object voters[] = new Object[set.size()];
        int counters[] = new int[set.size()];
        for(int i = 0 ; i< counters.length ;i++){
            counters[i]=0;
        }
//        for(int i = 0 ; i< counters.length ;i++){
//            System.out.println(counters[i]);
//        }
        voters = set.toArray();
//        for(int i =0 ; i< voters.length ;i++){
//            System.out.println(voters[i]);
//        }

//        System.out.println(votes.size());
//        for(int i = 0 ; i< counters.length ;i++){
//            System.out.println(counters[i]);
//        }

        for(int i = 0 ; i < votes.size() ; i++){
            for(int j = 0 ; j < voters.length ; j++){
                if(votes.get(i)==voters[j]){
                    counters[j]++;
                }
            }
        }
//        for(int i = 0 ; i< counters.length ;i++){
//            System.out.println(counters[i]);
//        }

        int index = 0;
        int highestVote = 0;

        for(int i = 0 ; i< counters.length ;i++){
            if(highestVote<counters[i]){
                index=i;
                highestVote=counters[i];
            }

        }

        String winner = voters[index].toString();
//        System.out.println(winner);
        return winner;
    }

}