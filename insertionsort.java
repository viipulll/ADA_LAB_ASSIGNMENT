class fibonacci {
    static int count=0;
    static int fibo(int n){
        if(n==0||n==1) { 
            count++;
            return n;

        }
        count++;
        return fibo(n-1)+fibo(n-2);
    }
    public static void main(String[] args) {
        int n=7;
        System.out.println("Fibonacci series till : "+n);
        for(int i=0;i<n;i++){
            // count++;
            System.out.print(fibo(i)+" ");
        }
        System.out.println("\n Number of step to solve this problem : "+(count));
    }
}
 