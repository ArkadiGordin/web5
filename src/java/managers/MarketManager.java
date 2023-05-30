/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package managers;

import entity.Market;

/**
 *
 * @author user
 */
public class MarketManager {
    public Market marketCashEveryTime(int summaProduct){
        Market market = new Market();
        market.setCashMarket(summaProduct);
        return market;
    }

    public Market createMarketList() {
        int summaProduct = ManagerPurchase.totalSumma;
        return marketCashEveryTime(summaProduct);
    }

    public void marketCashList(Market[] markets) {
        int sum = 0;
        for (Market market : markets) {
            sum = sum + market.getCashMarket();
        }
        System.out.print("Общая прибыль магазина: " + sum);

        System.out.println();
    }

}

    

