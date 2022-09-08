
class grand_children
{
static final int FATHER = 1;
static final int CHILD = 0;
    
    public static void main(String[] args) {
        String fam_info[][] = {{"luke","shaw"},{"whyne","rooney"},{"rooney","ronaldo"},{"shaw","rooney"}};
        String target = "ronaldo";
        int count =0;
        for (int i = 0; i < fam_info.length; i++) {
            //find father
            if(fam_info[i][FATHER].equals(target))
                for (int j = 0; j < fam_info.length; j++) {
                    //find daughter
                    if(fam_info[j][FATHER].equals(fam_info[i][CHILD]))
                        count++;
                }
        }
        System.out.println("grand children : "+count);
    }
}