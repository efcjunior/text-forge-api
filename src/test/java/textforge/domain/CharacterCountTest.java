package textforge.domain;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.HashMap;
import java.util.Map;

import org.junit.jupiter.api.Test;

public class CharacterCountTest {

    @Test
    public void testCountCharacters_EmptyString() {
        String text = "";
        Map<Character, Integer> expected = new HashMap<>();
        assertEquals(expected, CharacterCount.countCharacters(text));
    }

    @Test
    public void testCountCharacters_SingleCharacter() {
        String text = "a";
        Map<Character, Integer> expected = new HashMap<>();
        expected.put('a', 1);
        assertEquals(expected, CharacterCount.countCharacters(text));
    }

    @Test
    public void testCountCharacters_MultipleCharacters() {
        String text = "banana";
        Map<Character, Integer> expected = new HashMap<>();
        expected.put('b', 1);
        expected.put('a', 3);
        expected.put('n', 2);
        assertEquals(expected, CharacterCount.countCharacters(text));
    }

    @Test
    public void testCountCharacters_RepeatedCharacters() {
        String text = "hello world";
        Map<Character, Integer> expected = new HashMap<>();
        expected.put('h', 1);
        expected.put('e', 1);
        expected.put('l', 3);
        expected.put('o', 2);
        expected.put(' ', 1);
        expected.put('w', 1);
        expected.put('r', 1);
        expected.put('d', 1);
        assertEquals(expected, CharacterCount.countCharacters(text));
    }

    @Test
    public void testCountCharacters_NullString() {
        String text = null;
        Map<Character, Integer> expected = new HashMap<>();
        assertEquals(expected, CharacterCount.countCharacters(text));
    }
}
