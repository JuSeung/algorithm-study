package codingTest;


import java.util.ArrayList;
import java.util.List;

/*
* 문제 상의,하의 색상을 동일한 걸 사면 할인 한 가격으로 계산 해준다.
*
*
*
* */
class Solution1 {
    private List<String> topColors = new ArrayList<>();
    private List<String> pantsColors = new ArrayList<>();
    private List<String> sameClothsColors = new ArrayList<>();

    public static void main(String[] args) {
        String[] colors1 = new String[] {"RG", "WR", "BW", "GG"};
		String[] colors2 = new String[] {"RG", "WR", "BW", "GG"};
		String[] colors3 = new String[] {"BW", "RY", "BY"};
		String[] colors4 = new String[] {"YW", "RY", "WG", "BW"};
        int[] prices = new int[] {2000, 6000};
        Solution1 solution = new Solution1();
        solution.clothsDivision(colors1);
        solution.sameCloths();
        int result = solution.getPrice(prices);
        System.out.println(result);
    }


    // 상의, 하의를 나눈다.
    private void clothsDivision(String[] colors) {
        for (String color : colors) {
            String top = String.valueOf(color.charAt(0));
            String pants = String.valueOf(color.charAt(1));
            topColors.add(top);
            pantsColors.add(pants);
        }
    }

    private void sameCloths() {
        List<Integer> bottomIndex = new ArrayList<>();
        for (String topColor : topColors) {
            int index = 0;
            for (String pantsColor : pantsColors) {
                if (topColor.equals(pantsColor) && !bottomIndex.contains(index)) {
                    sameClothsColors.add(topColor + pantsColor);
                    break;
                }
                index ++;
            }
        }
    }

    private int getPrice(int[] prices) {
        int dcPirce = prices[0];
        int price = prices[1];
        int sameCnt = sameClothsColors.size();
        int diffCnt = topColors.size() - sameCnt;
        return (dcPirce * sameCnt) + (price * diffCnt);
    }

}
