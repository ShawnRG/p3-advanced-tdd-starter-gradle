package be.kdg.tdd.integratie;

import be.kdg.tdd.FavoriteService;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:testcontext.xml"})
public class TestBasicUserManagement {
    @Autowired
    private FavoriteService favoriteService;

    @Before
    public void setup() {
        favoriteService.addUser("root", "rootpasswd", "validUsername", "validPassword");
    }

    @After
    public void tearDown() {
        favoriteService.removeUser("root", "rootpasswd", "validUsername", "validPassword");
    }

    @Test
    public void testLoginSuccess() {
        boolean success = favoriteService.checkLogin("validUsername", "validPassword");
        Assert.assertTrue("login with right username/password combination should work", success);
    }

    @Test
    public void testLoginFailure() {
        boolean success = favoriteService.checkLogin("wrongUsername", "wrongPassword");
        Assert.assertFalse("login with wrong username/password combination should fail", success);
        success = favoriteService.checkLogin("wrongUsername", "validPassword");
        Assert.assertFalse("login with wrong username should fail", success);
        success = favoriteService.checkLogin("validUsername", "wrongPassword");
        Assert.assertFalse("login with wrong password should fail", success);
    }

    @Test
    public void testLoginSuccesOtherUser() {
        favoriteService.addUser("root", "rootpasswd", "otherUsername", "otherUsernamesPassword");
        boolean success = favoriteService.checkLogin("otherUsername", "otherUsernamesPassword");
        Assert.assertTrue("login with right username/password combination should work", success);
        favoriteService.removeUser("root", "rootpasswd", "otherUsername", "otherUsernamesPassword");
    }

    @Test
    public void testAddUserNormal() {
        boolean success = favoriteService.checkLogin("username", "password");
        Assert.assertFalse("login with non-existing user should not work", success);
        favoriteService.addUser("root", "rootpasswd", "username", "password");
        success = favoriteService.checkLogin("username", "password");
        Assert.assertTrue("login with new defined user should work", success);
        favoriteService.removeUser("root", "rootpasswd", "username", "password");
    }

    @Test
    public void testAddUserWithWrongCredentials() {
        favoriteService.addUser("wrong root", "wrong password", "user", "pass");
        boolean success = favoriteService.checkLogin("user", "pass");
        Assert.assertFalse("only root with password rootpasswd can add a user", success);
        favoriteService.addUser("root", "wrong passwd", "user", "pass");
        success = favoriteService.checkLogin("user", "pass");
        Assert.assertFalse("only root with password rootpasswd can add a user", success);
        favoriteService.addUser("root", "rootpasswd", "user", "pass");
        success = favoriteService.checkLogin("user", "pass");
        Assert.assertTrue("only root with password rootpasswd can add a user", success);
        favoriteService.removeUser("root", "rootpasswd", "user", "pass");
    }

    @Test
    public void testAddUserAsNormalUser() {
        favoriteService.addUser("username", "password", "user", "pass");
        boolean success = favoriteService.checkLogin("user", "pass");
        Assert.assertFalse("a normal user should not be able to add another user", success);
        favoriteService.removeUser("username", "password", "user", "pass");
    }

    @Test
    public void testRemoveNormal() {
        favoriteService.removeUser("root", "rootpasswd", "validUsername", "validPassword");
        boolean success = favoriteService.checkLogin("validUsername", "validPassword");
        Assert.assertFalse("user was not removed", success);
    }

    @Test
    public void testRemoveWithWrongCredentials() {
        favoriteService.removeUser("root", "wrongRootpasswd", "validUsername", "validPassword");
        boolean success = favoriteService.checkLogin("validUsername", "validPassword");
        Assert.assertTrue("user can only be removed by root", success);
        favoriteService.removeUser("wrongRoot", "rootpasswd", "validUsername", "validPassword");
        success = favoriteService.checkLogin("validUsername", "validPassword");
        Assert.assertTrue("user can only be removed by root", success);
    }

    @Test
    public void testLoginAsRoot() {
        boolean success = favoriteService.checkLogin("root", "rootpasswd");
        Assert.assertTrue("root user should be available", success);
    }
/*
 */
}
