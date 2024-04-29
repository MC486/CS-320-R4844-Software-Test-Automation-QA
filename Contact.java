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

/**
 * Represents a contact with a unique ID, first name, last name, phone number, and address.
 */
public class Contact {
    private final String contactId; // Unique ID of the contact
    private String firstName; // First name of the contact
    private String lastName; // Last name of the contact
    private String phone; // Phone number of the contact
    private String address; // Address of the contact

    /**
     * Constructs a new Contact object with the specified parameters.
     *
     * @param contactId The unique ID of the contact (cannot be null or longer than 10 characters).
     * @param firstName The first name of the contact (cannot be null or longer than 10 characters).
     * @param lastName  The last name of the contact (cannot be null or longer than 10 characters).
     * @param phone     The phone number of the contact (must be exactly 10 digits and cannot be null).
     * @param address   The address of the contact (cannot be null or longer than 30 characters).
     * @throws IllegalArgumentException if any of the parameters are invalid.
     */
    public Contact(String contactId, String firstName, String lastName, String phone, String address) {
        // Validate input parameters
        validateContactId(contactId); // Validate contact ID
        validateFirstName(firstName); // Validate first name
        validateLastName(lastName); // Validate last name
        validatePhone(phone); // Validate phone number
        validateAddress(address); // Validate address

        // Assign validated values to instance variables
        this.contactId = contactId;
        this.firstName = firstName;
        this.lastName = lastName;
        this.phone = phone;
        this.address = address;
    }

    /**
     * Returns the unique ID of the contact.
     *
     * @return The contact ID.
     */
    public String getContactId() {
        return contactId; // Return the contact ID
    }

    /**
     * Returns the first name of the contact.
     *
     * @return The first name.
     */
    public String getFirstName() {
        return firstName; // Return the first name
    }

    /**
     * Sets the first name of the contact.
     *
     * @param firstName The new first name (cannot be null or longer than 10 characters).
     * @throws IllegalArgumentException if the first name is invalid.
     */
    public void setFirstName(String firstName) {
        validateFirstName(firstName); // Validate the new first name
        this.firstName = firstName; // Set the first name
    }

    /**
     * Returns the last name of the contact.
     *
     * @return The last name.
     */
    public String getLastName() {
        return lastName; // Return the last name
    }

    /**
     * Sets the last name of the contact.
     *
     * @param lastName The new last name (cannot be null or longer than 10 characters).
     * @throws IllegalArgumentException if the last name is invalid.
     */
    public void setLastName(String lastName) {
        validateLastName(lastName); // Validate the new last name
        this.lastName = lastName; // Set the last name
    }

    /**
     * Returns the phone number of the contact.
     *
     * @return The phone number.
     */
    public String getPhone() {
        return phone; // Return the phone number
    }

    /**
     * Sets the phone number of the contact.
     *
     * @param phone The new phone number (must be exactly 10 digits and cannot be null).
     * @throws IllegalArgumentException if the phone number is invalid.
     */
    public void setPhone(String phone) {
        validatePhone(phone); // Validate the new phone number
        this.phone = phone; // Set the phone number
    }

    /**
     * Returns the address of the contact.
     *
     * @return The address.
     */
    public String getAddress() {
        return address; // Return the address
    }

    /**
     * Sets the address of the contact.
     *
     * @param address The new address (cannot be null or longer than 30 characters).
     * @throws IllegalArgumentException if the address is invalid.
     */
    public void setAddress(String address) {
        validateAddress(address); // Validate the new address
        this.address = address; // Set the address
    }

    /**
     * Throws an IllegalStateException since the contact ID cannot be updated or set to null.
     *
     * @throws IllegalStateException if an attempt is made to update or set the contact ID to null.
     */
    public void setContactId(String contactId) {
        // Contact ID cannot be updated or set to null, so throw an IllegalStateException
        throw new IllegalStateException("Contact ID cannot be updated or set to null");
    }

    /**
     * Validates the contact ID.
     *
     * @param contactId The contact ID to validate.
     * @throws IllegalArgumentException if the contact ID is null or longer than 10 characters.
     */
    private void validateContactId(String contactId) {
        // Check if the contact ID is null or longer than 10 characters
        if (contactId == null || contactId.length() > 10) {
            throw new IllegalArgumentException("Invalid contact ID");
        }
    }

    /**
     * Validates the first name.
     *
     * @param firstName The first name to validate.
     * @throws IllegalArgumentException if the first name is null or longer than 10 characters.
     */
    private void validateFirstName(String firstName) {
        // Check if the first name is null or longer than 10 characters
        if (firstName == null || firstName.length() > 10) {
            throw new IllegalArgumentException("Invalid first name");
        }
    }

    /**
     * Validates the last name.
     *
     * @param lastName The last name to validate.
     * @throws IllegalArgumentException if the last name is null or longer than 10 characters.
     */
    private void validateLastName(String lastName) {
        // Check if the last name is null or longer than 10 characters
        if (lastName == null || lastName.length() > 10) {
            throw new IllegalArgumentException("Invalid last name");
        }
    }

    /**
     * Validates the phone number.
     *
     * @param phone The phone number to validate.
     * @throws IllegalArgumentException if the phone number is null, not exactly 10 digits, or contains non-digit characters.
     */
    private void validatePhone(String phone) {
        // Check if the phone number is null or not exactly 10 digits
        if (phone == null || phone.length() != 10) {
            throw new IllegalArgumentException("Phone number must be exactly 10 digits");
        }

        // Check if the phone number contains non-digit characters
        for (char c : phone.toCharArray()) {
            if (!Character.isDigit(c)) {
                throw new IllegalArgumentException("Phone number must contain only digits");
            }
        }
    }

    /**
     * Validates the address.
     *
     * @param address The address to validate.
     * @throws IllegalArgumentException if the address is null or longer than 30 characters.
     */
    private void validateAddress(String address) {
    	// Check if address is null or more than 30 characters
        if (address == null || address.length() > 30) {
            throw new IllegalArgumentException("Invalid address");
        }
    }
}