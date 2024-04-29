/**
 * CS 320: Software Test Automation & QA
 * Michael Crevier
 * Date: 04/14/24
 * Project: Project One
 * 
 * Project Description:
 * Develop a mobile application for a customer, focusing on delivering contact services. 
 * The contact service enables adding, updating, and deleting contacts within the application. 
 * In-memory data structures are used for contact storage, and JUnit tests are employed for verification.
 */

package contactservice;

//Importing necessary classes for testing
import org.junit.jupiter.api.Test;

//Importing static methods from Assertions class
import static org.junit.jupiter.api.Assertions.*;

/**
 * Unit tests for the Contact class.
 */
public class ContactTest {

    /**
     * Tests creating a valid contact object.
     */
    @Test
    public void testValidContact() {
        // Create a valid contact object
        Contact contact = new Contact("MAXPOWER", "Homer", "Simpson", "3215553226", "742 Evergreen Terrace");
        // Check if the contact ID is set correctly
        assertEquals("MAXPOWER", contact.getContactId());
        // Check if the first name is set correctly
        assertEquals("Homer", contact.getFirstName());
        // Check if the last name is set correctly
        assertEquals("Simpson", contact.getLastName());
        // Check if the phone number is set correctly
        assertEquals("3215553226", contact.getPhone());
        // Check if the address is set correctly
        assertEquals("742 Evergreen Terrace", contact.getAddress());
    }


    /**
     * Tests creating a contact with an invalid contact ID (too long).
     */
    @Test
    public void testContactIdTooLong() {
        assertThrows(IllegalArgumentException.class, () -> new Contact("REMBRANDTQEINSTEIN", "Homer", "Simpson", "3215553226", "742 Evergreen Terrace"));
    }

    /**
     * Tests creating a contact with an invalid first name (too long).
     */
    @Test
    public void testFirstNameTooLong() {
        assertThrows(IllegalArgumentException.class, () -> new Contact("MAXPOWER", "HomerIsTooLong", "Simpson", "3215553226", "742 Evergreen Terrace"));
    }

    /**
     * Tests creating a contact with an invalid last name (too long).
     */
    @Test
    public void testLastNameTooLong() {
        assertThrows(IllegalArgumentException.class, () -> new Contact("MAXPOWER", "Homer", "SimpsonIsTooLong", "3215553226", "742 Evergreen Terrace"));
    }

    /**
     * Tests creating a contact with an invalid phone number (not exactly 10 digits or contains non-digit characters).
     */
    @Test
    public void testPhoneNumberNot10Digits() {
        // Test too short phone number
        assertThrows(IllegalArgumentException.class, () -> new Contact("MAXPOWER", "Homer", "Simpson", "215553226", "742 Evergreen Terrace"));
        // Test too long phone number
        assertThrows(IllegalArgumentException.class, () -> new Contact("MAXPOWER", "Homer", "Simpson", "03215553226", "742 Evergreen Terrace"));
        // Test phone number containing non-digit characters
        assertThrows(IllegalArgumentException.class, () -> new Contact("MAXPOWER", "Homer", "Simpson", "ABC5553226", "742 Evergreen Terrace"));
    }


    /**
     * Tests creating a contact with an invalid address (too long).
     */
    @Test
    public void testAddressTooLong() {
        assertThrows(IllegalArgumentException.class, () -> new Contact("MAXPOWER", "Homer", "Simpson", "3215553226", "742 Evergreen Terrace Springfield USA"));
    }

    /**
     * Tests creating a contact with a null contact ID.
     */
    @Test
    public void testContactIdCannotBeNull() {
        assertThrows(IllegalArgumentException.class, () -> new Contact(null, "Homer", "Simpson", "3215553226", "742 Evergreen Terrace"));
    }

    /**
     * Tests creating a contact with a null first name.
     */
    @Test
    public void testFirstNameCannotBeNull() {
        assertThrows(IllegalArgumentException.class, () -> new Contact("MAXPOWER", null, "Simpson", "3215553226", "742 Evergreen Terrace"));
    }

    /**
     * Tests creating a contact with a null last name.
     */
    @Test
    public void testLastNameCannotBeNull() {
        assertThrows(IllegalArgumentException.class, () -> new Contact("MAXPOWER", "Homer", null, "3215553226", "742 Evergreen Terrace"));
    }

    /**
     * Tests creating a contact with a null phone number.
     */
    @Test
    public void testPhoneCannotBeNull() {
        assertThrows(IllegalArgumentException.class, () -> new Contact("MAXPOWER", "Homer", "Simpson", null, "742 Evergreen Terrace"));
    }

    /**
     * Tests creating a contact with a null address.
     */
    @Test
    public void testAddressCannotBeNull() {
        assertThrows(IllegalArgumentException.class, () -> new Contact("MAXPOWER", "Homer", "Simpson", "3215553226", null));
    }

    /**
     * Tests that attempting to update the contact ID throws an IllegalStateException.
     */
    @Test
    public void testContactIdCannotBeUpdated() {
        // Create a new contact
        Contact contact = new Contact("MAXPOWER", "Homer", "Simpson", "3215553226", "742 Evergreen Terrace");
        // Attempt to update the contact ID, should throw an IllegalStateException
        assertThrows(IllegalStateException.class, () -> contact.setContactId("REMBRANDTQEINSTEIN"));
        // Attempt to set the contact ID to null, should throw an IllegalStateException
        assertThrows(IllegalStateException.class, () -> contact.setContactId(null));
    }

    /**
     * Tests updating the first name of a contact.
     */
    @Test
    public void testUpdateFirstName() {
        // Create a new contact
        Contact contact = new Contact("MAXPOWER", "Homer", "Simpson", "3215553226", "742 Evergreen Terrace");
        // Update the first name
        contact.setFirstName("Bart");
        // Check if the first name is updated correctly
        assertEquals("Bart", contact.getFirstName());
        // Attempt to set an invalid first name (too long), should throw an IllegalArgumentException
        assertThrows(IllegalArgumentException.class, () -> contact.setFirstName("BartSimpson"));
    }

    /**
     * Tests updating the last name of a contact.
     */
    @Test
    public void testUpdateLastName() {
        // Create a new contact
        Contact contact = new Contact("MAXPOWER", "Homer", "Simpson", "3215553226", "742 Evergreen Terrace");
        // Update the last name
        contact.setLastName("Flanders");
        // Check if the last name is updated correctly
        assertEquals("Flanders", contact.getLastName());
        // Attempt to set an invalid last name (too long), should throw an IllegalArgumentException
        assertThrows(IllegalArgumentException.class, () -> contact.setLastName("HomerFlanders"));
    }

}
