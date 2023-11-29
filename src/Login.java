import java.util.Scanner;

public class Login {
	public static String GenerateEmail(String etunimi, String sukunimi, String verkkotunnus) 
	{
	    // Muuntaa etunimen ja sukunimen pieniksi kirjaimiksi ja muodostaa sähköpostiosoitteen
	    String email = etunimi.toLowerCase() + "." + sukunimi.toLowerCase() + "@" + verkkotunnus;

	    // Korvaa ä, ö ja å kirjaimet a, o ja a vastaavasti
	    email = email.replace("ä", "a").replace("ö", "o").replace("å", "a");

	    return email;
	}
    public static String GenerateUsername(String etunimi, String sukunimi) 
    {
        // Ota etunimestä 4 ensimmäistä merkkiä ja sukunimestä 4 viimeistä merkkiä
        String etuNimiSubstring = etunimi.substring(0, Math.min(etunimi.length(), 4));
        String sukuNimiSubstring = sukunimi.substring(Math.max(sukunimi.length() - 4, 0), sukunimi.length());
        
        // Yhdistä ne käyttäjänimeksi ja muunna pieniksi kirjaimiksi
        String username = etuNimiSubstring.toLowerCase() + sukuNimiSubstring.toLowerCase();
        
        return username;
    }
	public static void main(String[] args) 
	{
		Scanner scanner = new Scanner(System.in);
		
		
		// Kysy kayttajalta etunimi
		System.out.println("Anna etunimesi: ");
		String etuNimi = scanner.nextLine();
		
		// Kysy kayttajalta sukunimi
		System.out.println("Anna sukunimesi: ");
		String sukuNimi = scanner.nextLine();
		
		// Kysy yrityksen verkkotunnus
		System.out.println("Anna yrityksesi verkkotunnus (esim: yritys.fi)");
		String verkkoTunnus = scanner.nextLine();
		
		// Tarkistetaan, että mikään tieto ei ole tyhjä
		if (etuNimi == "" || sukuNimi == "" || verkkoTunnus == "")
		{
			System.out.println("Virhe! Jokin tiedoista puuttui.");
		}
		// Jos vaaditut tiedot on annettu, muodostetaan sähköpostiosoite ja käyttäjänimi annetuista tiedoista
		else
		{
			String mail = GenerateEmail (etuNimi, sukuNimi, verkkoTunnus);
			String userName = GenerateUsername (etuNimi, sukuNimi);
			
			System.out.println("Sähköposti: " + mail);
			System.out.println("Käyttäjä: " + userName);
		}

	}

}
