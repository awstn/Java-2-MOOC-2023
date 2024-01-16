import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Hand implements Comparable<Hand>{
    private List<Card> hand;
    
    public Hand(){
        this.hand = new ArrayList<>();
    }
    
    public void add(Card card){
        this.hand.add(card);
    }
    
    public void print(){
        this.hand.stream().forEach(card -> System.out.println(card));
    }
    
    public void sort(){
        Collections.sort(hand);
    }
    
    public void sortBySuit(){
        Collections.sort(hand, new BySuitInValueOrder());
    }
    
    public int value(){
        int sum = 0;
        for (Card i : hand){
            sum += i.getValue();
        }
        
        return sum;
    }
    
    
    @Override
    public int compareTo(Hand compare){
        return this.value() - compare.value();
        
        
    }
    
}

/*
import java.util.ArrayList;

import java.util.Collections;

import java.util.List;

 

public class Hand implements Comparable<Hand> {

 

    private List<Card> cards;

 

    public Hand() {

        this.cards = new ArrayList<>();

    }

 

    public void add(Card kortti) {

        cards.add(kortti);

    }

 

    public void print() {

        for (Card card : cards) {

            System.out.println(card);

        }

    }

 

    public void sort() {

        Collections.sort(cards);

    }

 

    public void sortBySuit() {

        Collections.sort(cards, new BySuitInValueOrder());

    }

 

    private int sumOfValues() {

        int sum = 0;

 

        for (Card card : cards) {

            sum += card.getValue();

        }

 

        return sum;

    }

 

    @Override

    public int compareTo(Hand hand) {

        return this.sumOfValues() - hand.sumOfValues();

    }

}
*/