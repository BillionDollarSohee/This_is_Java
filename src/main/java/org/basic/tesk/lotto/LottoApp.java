package org.basic.tesk.lotto;

public class LottoApp {
    public static void main(String[] args) {
        Lotto lotto = new Lotto();
        lotto.bubbleSort(lotto.pickSixRandomNumbers());
        lotto.printRandNum();
        lotto.promotionDrawing();
    }
}
