import org.junit.Assert;
import org.junit.Test;

public class TestROT13 {

    @Test
    public void testCryptShift13() {
        // Given
        ROT13 r = new ROT13();
        String original = "Hello!";

        // When
        String actual = r.crypt(r.crypt(original));

        // Then
        Assert.assertEquals(original, actual);
    }

    @Test
    public void testCryptShift17() {
        // Given
        ROT13 r = new ROT13('e', 'v');
        String original = "Rose are red, violets are blue...";
        String expected = "Ifjv riv ivu, mzfcvkj riv sclv...";

        // When
        String actual = r.crypt(original);

        // Then
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void testCryptShift3() {
        // Given
        ROT13 r = new ROT13('a', 'd');
        String original = "It's the most wonderful time of the year!";
        String expected = "Lw'v wkh prvw zrqghuixo wlph ri wkh bhdu!";

        // When
        String actual = r.crypt(original);

        // Then
        Assert.assertEquals(expected, actual);
    }
}
