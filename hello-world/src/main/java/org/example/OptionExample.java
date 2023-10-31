package org.example;

import java.util.Optional;

public class OptionExample {

    public static void main(String[] args) {
        Optional<Integer> optional = Optional.of(1).orElse(200).describeConstable();
        System.out.println(optional.get());
    }
}
