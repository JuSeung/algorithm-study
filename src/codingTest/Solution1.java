package codingTest;



/*
* 문제 상의,하의 색상을 동일한 걸 사면 할인 한 가격으로 계산 해준다.
*
*
*
* */
class Solution1 {

    public static void main(String[] args) {
        String[] colors1 = new String[] {"RG", "WR", "BW", "GG"};
		String[] colors2 = new String[] {"RG", "WR", "BW", "GG"};
		String[] colors3 = new String[] {"BW", "RY", "BY"};
		String[] colors4 = new String[] {"YW", "RY", "WG", "BW"};
        int[] prices = new int[] {2000, 6000};
        Solution1 solution = new Solution1();
        int result = solution.clothsDivision(colors1, prices[0], prices[1]);
        System.out.println(result);
    }


    // 상의, 하의를 나눈다.
    private int clothsDivision(String[] colors, int price, int dcPrice) {
        int totalPrice = 0;
        for (String color : colors) {
            char top = color.charAt(0);
            char pants = color.charAt(1);
            if (top == pants) {
                totalPrice += dcPrice;
            } else {
                totalPrice += price;
            }
        }
        return totalPrice;
    }

}
