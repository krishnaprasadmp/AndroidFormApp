Person Activity
The first or main activity collects the basic information about a person. This activity’s view will
look like a basic form. The information we will collect is:
First (given) name
Family (last) name
Age
Email
Phone
Birthdate
Country and state(providence)
For each of the first six items (first name, last name, age, email and phone) use a text field to
allow the user to enter the data. In each text field the appropriate keyboard needs to be used.
The keyboard should not hide the text field the user is entering. All items need a label indicating
what information they contain (first name, last name, etc). All items are on a separate line.
For the birthdate use the date picker, not the date picker dialog. This will not fit on the current
activity. So on the birthdate line add a button labeled “Set”. When tapped the button takes the
user to a different activity/view - the date activity/view. When the user returns from the date activity
after selecting a date that date should be shown. If the user does not select a date or
cancels the date activity then no change is made to the date information shown. The user
should not be able to edit the date information in the user activity view. They can only do that
when they go to the date activity/view.
For the country and state we will also use a separate activity. Like the birthdate there is a set
button on the country & state line which takes the user to the country/state view where the user
can select a country and a state. When the user returns from the country/state view the result
is displayed. If the user does not select anything in the country/state view then no change is
made to the country/state data.
Finally there is a done button. When the done button is pressed the user information is saved.
When the app is killed and restarted the saved data is displayed in this activity.
Date Activity
The date activity has a date picker date where the user can select a date using either year,
month, and day spinners or a CalendarView. It also has a cancel button and a done button.
When the done button is selected the date in the date picker is returned to the Person Activity,
the view goes to the Person Activity and the date activity is destroyed. Make sure that the the
app goes to the previous user active and does not create a new Person Activity. When the
cancel button is selected the operation is cancelled and like the done button the app goes back
to the Person Activity
Country/State Activity
This activity has a list fragment, a done button and a cancel button. The done button and cancel
button act like the buttons in the Date activity. The list contains the of countries given below.
The user can select one item in the list. When they select a country they then see a list of
state(providences) which they can select. You can either display the list of states in the same
view or in a different view. In any case both lists need to use a list fragment.
