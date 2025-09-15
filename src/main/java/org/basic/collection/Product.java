package org.basic.collection;

class Product{  //extends Object
    int price;
    int bonuspoint;
    //Product() {	}
    Product(int price) {
        this.price = price;
        this.bonuspoint = (int)(this.price/10.0);
    }

}

class KtTv extends Product{
    KtTv(){
        super(500);
    }

    //Object 재정의
    @Override
    public String toString() {
        return "KtTv";
    }
}

class Audio extends Product{
    Audio(){
        super(100);
    }

    @Override
    public String toString() {
        return "Audio";
    }
}

class NoteBook extends Product{
    NoteBook(){
        super(150);
    }

    @Override
    public String toString() {
        return "NoteBook";
    }
}
