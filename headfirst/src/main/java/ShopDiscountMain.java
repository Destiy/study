import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author wy
 * @date 2020/11/18
 */
public class ShopDiscountMain {

    public static void main(String[] args) {

        List<Coupon> coupons = new ArrayList<>();
        coupons.add(new Coupon(50, 1));
        coupons.add(new Coupon(3, 10));

//        fo
        ShopDiscountMain shopDiscountMain = new ShopDiscountMain();
        shopDiscountMain.shopDiscount(80, coupons);
    }

    static class Coupon {
        // 抵扣金额
        private Integer price;
        // 优惠券数量
        private Integer num;

        public Coupon(Integer price, Integer num) {
            this.price = price;
            this.num = num;
        }
    }

    /**
     * 计算商品优惠
     *
     * @param price      商品价格
     * @param couponList 优惠券列表
     */
    public void shopDiscount(Integer price, List<Coupon> couponList) {
        int[] dp = new int[price + 1];
        int[][] path = new int[100][price + 1];
        int k = 0;
        for (Coupon coupon : couponList) {
            k++;
            for (int i = 0; i < coupon.num; i++) {
                for (int j = price; j >= coupon.price; j--) {
                    dp[j] = Math.max(dp[j], dp[j - coupon.price] + coupon.price);
                }
                for (int i1 = 0; i1 < dp.length; i1++) {
                    System.out.print(dp[i1] + " ");
                }
                    System.out.println("");
            }
            for (int j = 0; j < price; j++) {path[k][j] = dp[j];}
        }
//        int pos = price;
//        for (int i = couponList.size() - 1; i >= 0; i--) {
//
//        }
//        log（lengh）
        System.out.println(dp[price]);
    }
}


