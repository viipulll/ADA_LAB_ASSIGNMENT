class factorial{
     static int count=0;
    static int fact(int n){
        if(n==0||n==1){
            count++;
            return 1;
        }
        count++;
        return n*fact(n-1);
    }
    public static void main(String[] args) {
        int num=5;
        System.out.println("Factorial of "+num+" is : "+fact(num));
        System.out.println("Number of step to solve this problem : "+(count));
    }
}