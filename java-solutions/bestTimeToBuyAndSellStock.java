class Solution {
    public int maxProfit(int[] prices) {
        //given an array of prices
        //we want to get the largest buy / sell difference to turn the most profit
        //we can only buy and sell once
        //we want to return the profit
        //we do not need to buy / sell

        //iterate through the array right to left
        //capture the last lowest price
        //look for the highest price
        //if last lowest - highest is greater than the last profit calculated, replace it

        int lowestPrice = 101;
        int highestPrice = -1;
        int currentProfit = 0;

        for(int i = 0; i < prices.length; i++)
        {
            if(prices[i] < lowestPrice)
            {
                lowestPrice = prices[i];
                highestPrice = -1;
            }
            else if(prices[i] > highestPrice)
                highestPrice = prices[i];
            
            if(highestPrice - lowestPrice > currentProfit && highestPrice != -1 && lowestPrice != 101)
                currentProfit = highestPrice - lowestPrice;

            System.out.println(highestPrice + " " + lowestPrice + " " + currentProfit);
        }
        
        return currentProfit;
    }
}
