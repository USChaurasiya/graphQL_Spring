package com.uma.graphql.demo.query;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Component;

import com.uma.graphql.demo.dto.Person;

import io.leangen.graphql.annotations.GraphQLArgument;
import io.leangen.graphql.annotations.GraphQLQuery;

@Component
public class PersonQuery {
	 /**
     * Hello world greeting.
     *
     * Invoke with:
     * {greeting(Person: {firstName: "John", lastName: "Doe"})}
     *
     * @param person Person to greet
     * @return Informal hello string
     */
    @GraphQLQuery(name = "greeting")
    public String getGreeting(@GraphQLArgument(name = "Person", description = "Person to greet.")
                              final Person person){
        return "Hello "+ person.getFirstName()+" "+person.getLastName()+"!";
    }


    /**
     * Hello world polite greeting.
     *
     * Invoke with:
     * {greeting(Customer: {firstName: "John", lastName: "Doe", title: MR})}
     *
     * @param customer Customer to greet politely
     * @return Informal hello string
     */
  /*  @GraphQLQuery(name = "greeting")
    public String getGreeting(@GraphQLArgument(name = "Customer", description = "Customer to greet.")
                              final Customer customer){
        return "Hello "+ customer.getPersonalTitle()+" "+customer.getLastName()+"!";
    }
*/

    /**
     * Getting first N elements of a mock list of users
     *
     * Invoke with:
     * {firstNPersons(count: 5) {firstName, lastName}}
     *
     * @param count max number of elements
     * @return first persons
     */
    @GraphQLQuery(name = "firstNPersons")
    public List<Person> getFirstNPersons(@GraphQLArgument(name = "count") int count){
        List<Person> result = new ArrayList<>();

        Person p1 = new Person();
        p1.setFirstName("Uma Shankar");
        p1.setLastName("Jaiswal");
        result.add(p1);

        Person p2 = new Person();
        p2.setFirstName("Hamid");
        p2.setLastName("Noori");
        result.add(p2);
        
        Person p3 = new Person();
        p3.setFirstName("Anuj");
        p3.setLastName("Sachan");
        result.add(p3);
        
        Person p4 = new Person();
        p4.setFirstName("Amit");
        p4.setLastName("Sharma");
        result.add(p4);
        
      /*  Person p5 = new Person();
        p5.setFirstName("Khan");
        p5.setLastName("Suhail");
        result.add(p5);
        
        Person p6 = new Person();
        p6.setFirstName("Himanshu");
        p6.setLastName("Gautam");
        result.add(p6);*/

        return result.stream().limit(count).collect(Collectors.toList());
    }
}
