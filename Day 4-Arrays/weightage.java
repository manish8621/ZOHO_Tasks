public class weightage {
    public static void main(String[] args) {
        int numbers[] = {49,36,8,10,12};
        NumberWithWeightage[] numObjs=new NumberWithWeightage[numbers.length];
        
        //initialization and weightage calculation done in constructor
        for (int i=0;i<numbers.length;i++)
            numObjs[i] = new NumberWithWeightage(numbers[i]);
        
        //sort
        for (int i = 0; i < numObjs.length/2;i++)
            for (int j = 0; j < numObjs.length-1; j++)
                if(numObjs[j].getWeightage() < numObjs[j+1].getWeightage())
                {
                    //swap
                    NumberWithWeightage temp = numObjs[j];
                    numObjs[j] = numObjs[j+1];
                    numObjs[j+1] = temp;
                }
        //print result
        for (NumberWithWeightage obj : numObjs)
            System.out.print(obj+" ");
    }
}
class NumberWithWeightage
{
    int number,weightage;
    NumberWithWeightage(int number)
    {
        this.number = number;
        this.weightage = calculateWeightage(number);
    }
    private int calculateWeightage(int num) {
        int weight=0;
        if(Math.sqrt(num)%1==0)
            weight+=5;
        if(num%4 == 0 && num%6 == 0)
            weight+=4;
        if(num%2==0)
            weight+=3;
        return weight;
    }
    public int getNum()
    {
        return number;
    }
    
    public int getWeightage()
    {
        return weightage;
    }
    @Override
    public String toString()
    {
        return "("+getNum()+","+getWeightage()+")";
    }

}
