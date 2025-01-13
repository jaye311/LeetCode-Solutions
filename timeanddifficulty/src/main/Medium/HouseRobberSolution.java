public class HouseRobberSolution {
    public static void main(String[] args) {
        HouseRobberSolution a=new HouseRobberSolution();
        int[] nums={2,3,2};
        System.out.println(a.rob(nums));
    }
    public int rob(int[] nums) {
        int sumTotal=0;
        int i=1;
        while(i<nums.length-1){
            int sum1=nums[i-1]+nums[i+1];
            int sum2=nums[i];
            if(sum2>sum1){
                sumTotal+=sum2;
                i+=3;
            }
            else{
                sumTotal+=sum1;
                i+=2;
            }
        }
        /*int sumTotal2=nums[0];
        for(int i=3;i<nums.length-1;i+=2){
            int sum1=nums[i-1]+nums[i+1];
            int sum2=nums[i];
            if(sum2>sum1)
                sumTotal2+=sum2;
            else
                sumTotal2+=sum1;
        }
        if(sumTotal>sumTotal2)*/
            return sumTotal;
        //return sumTotal2;
    }
}
