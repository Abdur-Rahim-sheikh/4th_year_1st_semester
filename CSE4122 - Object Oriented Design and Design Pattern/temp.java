public  class temp{

    public static void main(String[] args){
        helper cc = new helper();
        cc.permutation("abir");
    }
}

class helper{
    public void permutation(String str) {
        permutation(str, "");
    }
    public void permutation(String str, String prefix){
        if (str.length() == 0) {
            System.out.println(prefix);
        } 
        else {
            for (int i= 0; i < str.length(); i++) {
                System.out.println(str.substring(0,i) + " ^^^ " + str.substring(i+1));
                String rem = str.substring(0, i) + str.substring(i + 1);
                permutation(rem, prefix + str.charAt(i));
            }
        }
    }
}

