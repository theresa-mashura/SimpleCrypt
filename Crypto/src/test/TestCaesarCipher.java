import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class TestCaesarCipher {

    @Test
    public void testCryptShift7() {
        // Given
        CaesarCipher c = new CaesarCipher(7);
        String given = "It's the most wonderful time of the year!";
        String expected = "Pa'z aol tvza dvuklymbs aptl vm aol flhy!";

        // When
        String actual = c.crypt(given);

        // Then
        Assert.assertEquals(expected, actual);
    }


    @Test
    public void testDeCryptShift7() {
        // Given
        CaesarCipher c = new CaesarCipher(7);
        String given = "It's the most wonderful time of the year!";
        String expected = "Pa'z aol tvza dvuklymbs aptl vm aol flhy!";

        // When
        String crypt = c.crypt(given);
        String actual = c.decryptCaesar(crypt);

        // Then
        Assert.assertEquals(given, actual);
    }


    @Test
    public void testCryptShift25() {
        // Given
        CaesarCipher c = new CaesarCipher(25);
        String given = "It's the most wonderful time of the year!";
        String expected = "Hs'r sgd lnrs vnmcdqetk shld ne sgd xdzq!";

        // When
        String actual = c.crypt(given);

        // Then
        Assert.assertEquals(expected, actual);
    }


    @Test
    public void testDeCryptShift25() {
        // Given
        CaesarCipher c = new CaesarCipher(25);
        String given = "It's the most wonderful time of the year!";
        String expected = "Hs'r sgd lnrs vnmcdqetk shld ne sgd xdzq!";

        // When
        String crypt = c.crypt(given);
        String actual = c.decryptCaesar(crypt);

        // Then
        Assert.assertEquals(given, actual);
    }


    @Test
    public void testReadSonnetFile() {
        // Given
        CaesarCipher c = new CaesarCipher(25);

        // When
        String sonnet = c.readFile("sonnet18.txt");
        String actualCrypt = c.crypt(sonnet);
        String actualDeCrypt = c.decryptCaesar(actualCrypt);


        // Then
        Assert.assertEquals(sonnet, actualDeCrypt);
    }

    @Test
    public void testWriteSonnetFile() {
        // Given
        CaesarCipher c = new CaesarCipher(25);

        // When

        // Read Sonnet File, Encrypt it, & write to new .enc file
        String givenSonnet = c.readFile("sonnet18.txt");
        String sonnetEncr = c.crypt(givenSonnet);
        c.writeToNewFile("sonnet18Shift25.enc", sonnetEncr);

        // Read encrypted sonnet, decrypt, & make sure they are the same
        String readEncr = c.readFile("sonnet18Shift25.enc");
        String finalDecrSonnet = c.decryptCaesar(readEncr);
        c.writeToNewFile("sonnet18EncrypedThenDecryptedShift25.txt", finalDecrSonnet);


        // Then
        Assert.assertEquals(givenSonnet, finalDecrSonnet);
    }
}




