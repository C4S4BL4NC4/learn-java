package dev.lpa;

import java.util.*;

public class Main {

    public static void main(String[] args) {


        // Populate a list

        Card[] cardArray = new Card[13];
        Card aceOfHearts = Card.getFaceCard(Card.Suit.HEART, 'A');
        Arrays.fill(cardArray, aceOfHearts);
        Card.printDeck(Arrays.asList(cardArray), "Aces of Hearts", 1);

        List<Card> acesOfHeart = Collections.nCopies(13, aceOfHearts);
        Card.printDeck(acesOfHeart, "Aces of Hearts", 1);

        Card kingOfClubs = Card.getFaceCard(Card.Suit.CLUB, 'K');
        List<Card> kingsOfClubs = Collections.nCopies(13, kingOfClubs);
        Card.printDeck(kingsOfClubs, "Kings of Clubs", 1);

        List<Card> cards = new ArrayList<>(52);
        Collections.addAll(cards, cardArray);
        Collections.addAll(cards, cardArray);
        Card.printDeck(cards, "Card collection with king of clubs added", 2);

        // In order to copy list must be filled first (cant copy into an empty list)
        Collections.copy(cards, kingsOfClubs);
        Card.printDeck(cards, "Card Collection with Kings copied", 2);

        // copyOf() returns a true copy and an unmodifiable list.
        cards = List.copyOf(kingsOfClubs);
        Card.printDeck(cards, "List Copy of Kings", 1);

        // Shuffle a collection
        List<Card> deck = Card.getStandardDeck();
        Collections.shuffle(deck);
        Card.printDeck(deck, "Shuffled Deck", 4);

        // Reverse order
        Collections.reverse(deck);
        Card.printDeck(deck, "Reverse ordered Deck", 4);

        // Sorting with comparator
        var sortingAlgo = Comparator.comparing(Card::rank).thenComparing(Card::suit);
        Collections.sort(deck, sortingAlgo);
        Card.printDeck(deck, "Sorted with comparartor rank, suit (lowest to highest)", 13);

        Collections.reverse(deck);
        Card.printDeck(deck, "Sorted  rank, suit (Highest to Lowest)", 13);

        // Sublist from existing list
        List<Card> kings = new ArrayList<>(deck.subList(4, 8));
        Card.printDeck(kings, "Kings in last deck", 1);
        List<Card> tens = new ArrayList<>(deck.subList(16, 20));
        Card.printDeck(tens, "Tens in last deck", 1);

        // Index of a sublist
//        Collections.shuffle(deck); // After shuffling the line 63 code returns -1 (not found) order matters!
        int indexOfSubList = Collections.indexOfSubList(deck, tens);
        System.out.println("indexOfSubList (tens of deck) = " + indexOfSubList);
        System.out.println("deck.containsAll(tens) = " + deck.containsAll(tens));


        // Disjoint returns true if two lists have nothing in common and false if they do
        boolean disjoint = Collections.disjoint(deck, tens);
        System.out.println("disjoint tens in deck = " + disjoint);

        boolean disjoint2 = Collections.disjoint(kings, tens);
        System.out.println("disjoint kings in tens = " + disjoint2);

        // binary search list needs to be sorted before binary searched***
        // use indexOf() if list is small and unsorted - use binarySearch() on a sorted list with large amount of entries
        deck.sort(sortingAlgo);
        Card tenOfHearts = Card.getNumericCard(Card.Suit.HEART, 10);
        int foundIndex = Collections.binarySearch(deck, tenOfHearts, sortingAlgo);
        System.out.println("foundIndex = " + foundIndex);
        System.out.println("deck.indexOf(tenOfHearts) = " + deck.indexOf(tenOfHearts));
        System.out.println(deck.get(foundIndex));

        Card tenOfClubs = Card.getNumericCard(Card.Suit.CLUB, 10);
        Collections.replaceAll(deck, tenOfClubs, tenOfHearts);
        Card.printDeck(deck.subList(32, 36), "Tens row", 1);
        Collections.replaceAll(deck, tenOfHearts, tenOfClubs);
        Card.printDeck(deck.subList(32, 36), "Tens row", 1);

        if (Collections.replaceAll(deck, tenOfHearts, tenOfClubs)) {
            System.out.println("Tens of hearts replaces with tens of clubs");
        } else {
            System.out.println("No tens of hearts found in the list");
        }

        System.out.println("Tens of Clubs Card Frequency= " + Collections.frequency(deck, tenOfClubs));

        System.out.println("Best Card = " + Collections.max(deck, sortingAlgo));
        System.out.println("Worst Card = " + Collections.min(deck, sortingAlgo));

        var sortBySuitAlgo = Comparator.comparing(Card::suit).thenComparing(Card::rank);
        deck.sort(sortBySuitAlgo);
        Card.printDeck(deck, "Sorted by suit, rank", 4);

        // List rotate (shift to right side)
        List<Card> copied = new ArrayList<>(deck.subList(0, 13));
        Collections.rotate(copied, 2);
        System.out.println("UnRotated = " + deck.subList(0, 13));
        System.out.println("Rotated = " + 2 + ": " + copied);

        Collections.rotate(copied, -4); // originalPosition - 2 (left shift by 2)
        System.out.println("UnRotated = " + deck.subList(0, 13));
        System.out.println("Rotated = " + -2 + ": " + copied);

        copied = new ArrayList<>(deck.subList(0, 13));
        Collections.reverse(copied);
        System.out.println("Using reverse: " + copied);

        
    }
}
