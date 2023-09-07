package edu.eci.cvds.tdd.registry;

import org.junit.Assert;
import org.junit.Test;

public class RegistryTest {
    private Registry registry = new Registry();

    @Test
    public void shouldBeADeadPerson() {
        // Arrange
        Person person = new Person("juan jose", 001, 15, Gender.UNIDENTIFIED, false);
        // Act
        RegisterResult result = registry.registerVoter(person);
        // Assert
        Assert.assertEquals(RegisterResult.DEAD, result);
    }

    @Test
    public void shouldBeUnderagePersonAndValidAgeRange() {
        // Arrange
        Person person = new Person("sebastian", 002, 14, Gender.UNIDENTIFIED, true);
        // Act
        RegisterResult result = registry.registerVoter(person);
        // Assert
        Assert.assertEquals(RegisterResult.UNDERAGE, result);
    }

    @Test
    public void shouldRegisterWhenValidAge() {
        // Arrange
        Person person = new Person("sebastian", 002, 19, Gender.UNIDENTIFIED, true);
        // Act
        RegisterResult result = registry.registerVoter(person);
        // Assert
        Assert.assertEquals(RegisterResult.VALID, result);
    }

    @Test
    public void shouldBeInvalidAgeWhenAgeIsNegative() {
        // Arrange
        Person person = new Person("juan jose", 001, -18, Gender.UNIDENTIFIED, true);
        // Act
        RegisterResult result = registry.registerVoter(person);
        // Assert
        Assert.assertEquals(RegisterResult.INVALID_AGE, result);
    }

    @Test
    public void shouldBeDuplicatedWhenAlreadyExistsID() {
        // Arrange
        Person person1 = new Person("juan jose", 001, 20, Gender.UNIDENTIFIED, true);
        Person person2 = new Person("sebastian", 001, 20, Gender.UNIDENTIFIED, true);
        // Act
        registry.registerVoter(person1);
        RegisterResult result = registry.registerVoter(person2);
        // Assert
        Assert.assertEquals(RegisterResult.DUPLICATED, result);
    }
}
