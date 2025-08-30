package javaLeetcodeSolutions;

import java.util.HashMap;

class topKFrequentElementsSolution {
    public int[] topKFrequent(int[] nums, int k) {
        HashMap<Integer, Integer> frequencyMap = new HashMap<>();

        for(int i : nums)
        {
            if(frequencyMap.get(i) != null)
                frequencyMap.put(i, frequencyMap.get(i) + 1);
            else
                frequencyMap.put(i, 1);
        }

        List<Integer>[] buckets = new List[nums.length+1];
        for (int i = 0; i < buckets.length; i++) {
            buckets[i] = new ArrayList<>();
        }
        for (Map.Entry<Integer, Integer> entry : frequencyMap.entrySet()) {
            buckets[entry.getValue()].add(entry.getKey());
        }

        int retIndex = 0;
        int[] retArray = new int[k];
        for(int i = buckets.length - 1; i > 0; i--)
        {
            Collections.sort(buckets[i], Collections.reverseOrder());

            for(int j : buckets[i])
            {
                retArray[retIndex++] = j;
                if(retIndex == k)
                    return retArray;
            }
        }


        return retArray;
    }
}
