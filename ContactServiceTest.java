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

// Importing necessary classes for testing
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

// Importing static methods from Assertions class
import static org.junit.jupiter.api.Assertions.*;

/**
 * Unit tests for the ContactService class.
 */
public class ContactServiceTest {
    private ContactService contactService;

    /**
     * Sets up the ContactService instance before each test.
     */
    @BeforeEach
    public void setUp() {
        // Create a new instance of ContactService before each test
        contactService = new ContactService();
    }

    /**
     * Tests adding a new contact to the service.
     */
    @Test
    public void testAddContact() {
        // Create a new contact
        Contact contact = new Contact("MAXPOWER", "Homer", "Simpson", "3215553226", "742 Evergreen Terrace");
        // Add the contact to the contact service
        contactService.addContact(contact);
        // Assert that the contact count is incremented
        assertEquals(1, contactService.getContactCount());
        // Assert that trying to add the same contact again throws IllegalArgumentException
        assertThrows(IllegalArgumentException.class, () -> contactService.addContact(contact));
    }

    /**
     * Tests deleting a contact from the service.
     */
    @Test
    public void testDeleteContact() {
        // Create a new contact
        Contact contact = new Contact("MAXPOWER", "Homer", "Simpson", "3215553226", "742 Evergreen Terrace");
        // Add the contact to the contact service
        contactService.addContact(contact);
        // Delete the contact from the contact service
        contactService.deleteContact("MAXPOWER");
        // Assert that the contact count is decremented
        assertEquals(0, contactService.getContactCount());
        // Assert that trying to delete the same contact again throws IllegalArgumentException
        assertThrows(IllegalArgumentException.class, () -> contactService.deleteContact("MAXPOWER"));
        // Attempt to delete a non-existent contact and verify that it throws IllegalArgumentException
        assertThrows(IllegalArgumentException.class, () -> contactService.deleteContact("NON_EXISTENT_CONTACT"));
    }

    /**
     * Tests updating the first name of a contact.
     */
    @Test
    public void testUpdateFirstName() {
        // Create a new contact
        Contact contact = new Contact("MAXPOWER", "Homer", "Simpson", "3215553226", "742 Evergreen Terrace");
        // Add the contact to the contact service
        contactService.addContact(contact);
        // Update the first name of the contact
        contactService.updateFirstName("MAXPOWER", "Bart");
        // Assert that the contact service contains the updated contact
        assertTrue(contactService.containsContact("MAXPOWER"));
        // Assert that the first name of the contact is updated
        assertEquals("Bart", contact.getFirstName());
        // Assert that trying to update the first name of a non-existing contact throws IllegalArgumentException
        assertThrows(IllegalArgumentException.class, () -> contactService.updateFirstName("REMBRANDTQEINSTEIN", "Bart"));
    }

    /**
     * Tests updating the last name of a contact.
     */
    @Test
    public void testUpdateLastName() {
        // Create a new contact
        Contact contact = new Contact("MAXPOWER", "Homer", "Simpson", "3215553226", "742 Evergreen Terrace");
        // Add the contact to the contact service
        contactService.addContact(contact);
        // Update the last name of the contact
        contactService.updateLastName("MAXPOWER", "Flanders");
        // Assert that the contact service contains the updated contact
        assertTrue(contactService.containsContact("MAXPOWER"));
        // Assert that the last name of the contact is updated
        assertEquals("Flanders", contact.getLastName());
        // Assert that trying to update the last name of a non-existing contact throws IllegalArgumentException
        assertThrows(IllegalArgumentException.class, () -> contactService.updateLastName("REMBRANDTQEINSTEIN", "Flanders"));
    }

    /**
     * Tests updating the phone number of a contact.
     */
    @Test
    public void testUpdatePhone() {
        // Create a new contact
        Contact contact = new Contact("MAXPOWER", "Homer", "Simpson", "3215553226", "742 Evergreen Terrace");
        // Add the contact to the contact service
        contactService.addContact(contact);
        // Update the phone number of the contact
        contactService.updatePhone("MAXPOWER", "1235553226");
        // Assert that the contact service contains the updated contact
        assertTrue(contactService.containsContact("MAXPOWER"));
        // Assert that the phone number of the contact is updated
        assertEquals("1235553226", contact.getPhone());
        // Assert that trying to update the phone number of a non-existing contact throws IllegalArgumentException
        assertThrows(IllegalArgumentException.class, () -> contactService.updatePhone("REMBRANDTQEINSTEIN", "1235553226"));
    }

    /**
     * Tests updating the address of a contact.
     */
    @Test
    public void testUpdateAddress() {
        // Create a new contact
        Contact contact = new Contact("MAXPOWER", "Homer", "Simpson", "3215553226", "742 Evergreen Terrace");
        // Add the contact to the contact service
        contactService.addContact(contact);
        // Update the address of the contact
        contactService.updateAddress("MAXPOWER", "123 Sesame Street");
        // Assert that the contact service contains the updated contact
        assertTrue(contactService.containsContact("MAXPOWER"));
        // Assert that the address of the contact is updated
        assertEquals("123 Sesame Street", contact.getAddress());
        // Assert that trying to update the address of a non-existing contact throws IllegalArgumentException
        assertThrows(IllegalArgumentException.class, () -> contactService.updateAddress("REMBRANDTQEINSTEIN", "123 Sesame Street"));
    }
}
