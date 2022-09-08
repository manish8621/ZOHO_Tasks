public class PatternX {
    public static void main(String[] args) {
        String str = "PROGRAM";
        for(int i = 0;i<str.length();i++)
     
        {
            for(int j=0;j<str.length();j++)
            {
                if(i==j)
                    System.out.print(str.charAt(i));
                else if(str.length()-1-i==j)
                    System.out.print(str.charAt(str.length()-1-i));
                else System.out.print(" ");
            }
            System.out.println();
        }
    }
}
