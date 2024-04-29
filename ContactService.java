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

//Importing HashMap and Map classes from the java.util package to use them for managing contacts in the ContactService class.
import java.util.HashMap;
import java.util.Map;

/**
 * Represents a service for managing contacts.
 */
public class ContactService {
    private final Map<String, Contact> contacts;

    /**
     * Constructs a new ContactService object with an empty map of contacts.
     */
    public ContactService() {
        contacts = new HashMap<>();
    }

    /**
     * Adds a new contact to the service.
     *
     * @param contact The contact to be added.
     * @throws IllegalArgumentException if a contact with the same ID already exists.
     */
    public void addContact(Contact contact) {
        // Retrieve the contact ID of the given contact
        String contactId = contact.getContactId();
        // Check if the contact ID already exists in the map
        if (contacts.containsKey(contactId)) {
            // Throw an exception if a contact with the same ID already exists
            throw new IllegalArgumentException("Contact with ID " + contactId + " already exists");
        }
        // Add the contact to the map using its contact ID as the key
        contacts.put(contactId, contact);
    }

    /**
     * Deletes a contact from the service based on the contact ID.
     *
     * @param contactId The ID of the contact to be deleted.
     * @throws IllegalArgumentException if no contact with the given ID exists.
     */
    public void deleteContact(String contactId) {
        // Check if the contact ID exists in the map
        if (!contacts.containsKey(contactId)) {
            // Throw an exception if no contact with the given ID exists
            throw new IllegalArgumentException("Contact with ID " + contactId + " does not exist");
        }
        // Remove the contact from the map using its contact ID as the key
        contacts.remove(contactId);
    }

    /**
     * Updates the first name of a contact based on the contact ID.
     *
     * @param contactId The ID of the contact whose first name is to be updated.
     * @param firstName The new first name.
     * @throws IllegalArgumentException if no contact with the given ID exists or if the new first name is invalid.
     */
    public void updateFirstName(String contactId, String firstName) {
        // Retrieve the contact from the service or throw an exception if it doesn't exist
        Contact contact = getContactOrThrow(contactId);
        // Set the new first name for the contact
        contact.setFirstName(firstName);
    }

    /**
     * Updates the last name of a contact based on the contact ID.
     *
     * @param contactId The ID of the contact whose last name is to be updated.
     * @param lastName  The new last name.
     * @throws IllegalArgumentException if no contact with the given ID exists or if the new last name is invalid.
     */
    public void updateLastName(String contactId, String lastName) {
        // Retrieve the contact from the service or throw an exception if it doesn't exist
        Contact contact = getContactOrThrow(contactId);
        // Set the new last name for the contact
        contact.setLastName(lastName);
    }

    /**
     * Updates the phone number of a contact based on the contact ID.
     *
     * @param contactId The ID of the contact whose phone number is to be updated.
     * @param phone     The new phone number.
     * @throws IllegalArgumentException if no contact with the given ID exists or if the new phone number is invalid.
     */
    public void updatePhone(String contactId, String phone) {
        // Retrieve the contact from the service or throw an exception if it doesn't exist
        Contact contact = getContactOrThrow(contactId);
        // Set the new phone number for the contact
        contact.setPhone(phone);
    }

    /**
     * Updates the address of a contact based on the contact ID.
     *
     * @param contactId The ID of the contact whose address is to be updated.
     * @param address   The new address.
     * @throws IllegalArgumentException if no contact with the given ID exists or if the new address is invalid.
     */
    public void updateAddress(String contactId, String address) {
        // Retrieve the contact from the service or throw an exception if it doesn't exist
        Contact contact = getContactOrThrow(contactId);
        // Set the new address for the contact
        contact.setAddress(address);
    }

    /**
     * Retrieves the number of contacts in the service.
     *
     * @return The number of contacts.
     */
    public int getContactCount() {
        // Return the size of the contacts map
        return contacts.size();
    }

    /**
     * Checks if a contact with the given ID exists in the service.
     *
     * @param contactId The ID of the contact to check.
     * @return true if the contact exists, false otherwise.
     */
    public boolean containsContact(String contactId) {
        // Check if the contacts map contains the given contact ID
        return contacts.containsKey(contactId);
    }

    /**
     * Retrieves a contact from the service based on the contact ID.
     *
     * @param contactId The ID of the contact to be retrieved.
     * @return The contact object.
     * @throws IllegalArgumentException if no contact with the given ID exists.
     */
    private Contact getContactOrThrow(String contactId) {
        // If the contacts map does not contain the contact ID, throw an exception
        if (!contacts.containsKey(contactId)) {
            throw new IllegalArgumentException("Contact with ID " + contactId + " does not exist");
        }
        // Otherwise, retrieve and return the contact associated with the contact ID
        return contacts.get(contactId);
    }
}