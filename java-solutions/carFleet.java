class Solution {
    public int carFleet(int target, int[] position, int[] speed) {
        Stack<Double> stack = new Stack<>();
        double[][] cars = new double[position.length][2];

        for(int i = 0; i < position.length; i++)
        {
            int spd = speed[i];
            int pos = position[i];
            double t = (target - (double)pos) / (double)spd;

            cars[i][0] = pos;
            cars[i][1] = t;
        }

        Arrays.sort(cars, (a, b) -> Double.compare(b[0], a[0]));

        for(int i = 0; i < cars.length; i++)
        {
            double t = cars[i][1];

            if(stack.isEmpty())
            {
                stack.push(t);
                continue;
            }
            if(t < stack.peek())
            {
                continue;
            }
            if(t > stack.peek())
            {
                stack.push(t);
            }
        }

        return stack.size();
    }
}
