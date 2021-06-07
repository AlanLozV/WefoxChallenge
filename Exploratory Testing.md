# Exploratory Testing

## Principal Functionality
**Booking** a hotel room

## Involved Functionalities
**Search** functionality, **modify** search, **results** page, **customer information** page, **booking confirmation** and **payment**.

## Scenarios
 1. Book a hotel as a guest or registered customer by using the detailed search box.
 2. Book a hotel as a guest or registered customer after modifying the initial search criteria.
 3. Book a hotel as a guest or registered customer by using related or featured hotels section.
 
## Behaviour
The site behaves almost as I expected. The main functionalities that allow the user to book a hotel room, meet the minimum requirements for the correct execution and interaction by the user and allow him/her to successfully complete a booking. 

## Bugs
 On the customer’s personal information section, fields do not have a **minimum or maximum number of characters validation**.  Therefore, it is possible to enter any type and length of information. In addition, clicking on the “Confirm Booking” button does not show in a visible way if there are errors in the fields and this could generate a bad experience for the user because they will not be able to know what information is incorrect or why they cannot complete their booking.

Also, when you navigate back from this page to the hotel's details page, the button "Book Now" is disabled although the room is selected and this requires an action from the user: Select again a room and try clicking again the button. This action may cause an error from the user.

## Improvements
 - Add a button to **reset filters** in search results.
 - If no results are shown with the search criteria entered by the user, it would show **recommended or related hotels** on the results page.
 - Of course, add **validations to the fields** on the customer's personal information page.
 - The **payment functionality** could be added with the customer's personal information allowing the user to decide if he/she wants to pay now or pay at arrival. As this information is important for the booking process, I think it would enhance the user's experience in the site.

## Walkthrough
The first scenario describes the common action when you log on to the booking site and start a **booking process**.  Regardless of whether the user is registered or not, what you are looking for is the happy path that involves **searching** for a hotel, **getting** search results, **choosing** the hotel of choice, **analyzing** details and rates as well as available rooms, **entering** customer information and **confirming** the reservation.

The second scenario involves a **modification** of the initial search criteria by the user, something that is usually common when **comparing** prices or **looking** for season offers. After modifying the initial search criteria, the booking process would continue in a similar way as the first scenario.

The third scenario is less common but is just as important. Here, the user **does not perform a detailed search**.  He/She navigates to the section showing **recommended or featured hotels** and starts the booking process from this point.

Considering that the functionality of booking a room is being evaluated, the first thing I validated was that the information shown matched the search criteria entered by the user (location, dates and guests).  Then I checked that the hotel had rooms available for the dates and number of guests indicated.  To supplement, I checked that enough details and information about the hotel were shown in addition to the pictures.
 Finally, I verified that the elements with which the user interacts, will work properly.

## Risks Mitigation
The main risk would be the traffic of users entering to consult or search for reservations before and during holidays or vacations.

Another risk would be that the personal and sensitive information shared by the user would not be properly protected.

 It could also be considered as a risk that the information shown is not accurate by generating overcatch and showing rooms available for reservation even when they are already sold out.
