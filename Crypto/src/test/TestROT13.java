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

    @Test
    public void testReadSonnetFile() {
        // Given
        ROT13 r = new ROT13();

        // When
        String sonnet = r.readFile("sonnet18.txt");
        String actualCrypt = r.crypt(sonnet);
        String actualDeCrypt = r.crypt(actualCrypt);


        // Then
        Assert.assertEquals(sonnet, actualDeCrypt);
    }

    @Test
    public void testWriteSonnetFile() {
        // Given
        ROT13 r = new ROT13();

        // When

        // Read Sonnet File, Encrypt it, & write to new .enc file
        String givenSonnet = r.readFile("sonnet18.txt");
        String sonnetEncr = r.crypt(givenSonnet);
        r.writeToNewFile("sonnet18.enc", sonnetEncr);

        // Read encrypted sonnet, decrypt, & make sure they are the same
        String readEncr = r.readFile("sonnet18.enc");
        String finalDecrSonnet = r.crypt(readEncr);
        r.writeToNewFile("sonnet18EncrypedThenDecrypted.txt", finalDecrSonnet);


        // Then
        Assert.assertEquals(givenSonnet, finalDecrSonnet);
    }
}
