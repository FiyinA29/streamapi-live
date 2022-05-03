package org.examples.streamapi._3;


import org.examples.streamapi.model.Person;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.examples.streamapi.TestUtil.PEOPLE;
import static org.examples.streamapi.model.Person.Gender.FEMALE;
import static org.examples.streamapi.model.Person.Gender.UNKNOWN;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class MapTest {

    @Test
    void mapPersonObjectsToStrings_comments() {
        List<String> names = PEOPLE
                .stream()
                .map(
                        (person) -> {
                            return person.getName();
                        }
                )
                .toList();
        // Certainly not the best way to check the returned list, but it will do for this case ;)
        assertEquals("Alec", names.get(0));
        assertEquals("Alivia", names.get(19));
        assertEquals(20, names.size());
    }

    @Test
    void mapPersonObjectsToStrings() {

        List<String> names = PEOPLE
                .stream()
                /*
                    The syntax can get even crazier - but this is just a syntax sugar!
                    It's the same as in the first example, so use the extended (the most obvious version)
                    and then use IntelliJ to get to the most straightforward ( at the beginning, the craziest) syntax.
                 */
                //Double colon is known as method reference - refers to an existing method by name
                //Replaces person -> person.getName()
                .map(Person::getName)
                .toList();

        assertEquals("Alec", names.get(0));
        assertEquals("Alivia", names.get(19));
        assertEquals(20, names.size());
    }
/*
    Time for some practice:
     - map to List<Integers> (age)
     - map to List<String> (lastName)
     - map to List<Person.GENDER>

     extras: map List<Person> to List<PersonDTO>
 */

    @Test
    void mapPersonObjectsToIntegerAge(){
        List<Integer> age = PEOPLE

                .stream()
                .map(Person::getAge)
                .toList();

        assertEquals(16, age.get(5));
        assertEquals(22, age.get(13));
        assertEquals(20, age.size());
    }

    @Test
    void mapPersonObjectsToStringLastName(){
        List<String> lastName = PEOPLE

                .stream()
                .map(Person::getLastName)
                .toList();

        assertEquals("Halliday", lastName.get(2));
        assertEquals("Jarvis", lastName.get(16));
        assertEquals(20, lastName.size());
    }


    @Test
    void mapPersonObjectsToGender(){
        List<Person.Gender> gender = PEOPLE

                .stream()
                .map(Person::getGender)
                .toList();

        assertEquals(FEMALE, gender.get(7));
        assertEquals(UNKNOWN, gender.get(14));
        assertEquals(20, gender.size());
    }

    // To map List<Person> to List<PersonDTO>: Go to TestUtil.java, and change List<Person> to List<PersonDTO>.
    // Then instantiate the all 20 objects with 'new PersonDTO( name, lastName).
}





