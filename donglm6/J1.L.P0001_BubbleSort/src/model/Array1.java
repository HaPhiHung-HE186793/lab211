package model;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Array1 {
    private List<Integer> array;
    public Array1(int number) throws Exception {
        if(number <=0){
            throw new Exception("Must > 0");
        }
        Random random = new Random();
        array = new ArrayList<>(number);
        for( int i =0;i < array.length ; i++){
            array[i] = random.nextInt(number);
        }
    }

    public List<Integer> bubbleSort(){
        for(int i = 0;array.length-i > 0; i++){
            for(int j = i+1; j<array.length-i ;j++){
                if(array[i]>array[j]){
                    int k =array[i];
                    array[i] =array[j];
                    array[j] = k;
                }
            }
        }
        return array;
    }
}
